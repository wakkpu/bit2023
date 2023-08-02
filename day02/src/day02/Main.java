package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 6/45를 할지, 5/40을 할지 선택
		System.out.println("뽑을 갯수와 최대 숫자를 입력하세요");
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer number = Integer.parseInt(st.nextToken());
		Integer range = Integer.parseInt(st.nextToken());
		
		// 로또 머신 생성
		Machine machine = new Machine(range, number);
		
		// 당첨 번호 생성
		Lottery fromMachine = machine.autoGenerate();
		
		// 자동인지, 수동인지 선택
		System.out.println("1. auto / 2. manual");
		String input = br.readLine();

		// 내 로또 번호 생성
		Lottery mine = null;
		if(input.equals("1")) {
			mine = machine.autoGenerate();
		} else if(input.equals("2")) {
			mine = machine.manualGenerate();
		}
		mine.check(fromMachine);
		
		System.out.println("내 번호: " + mine.getNumbers().toString());
		
		// 무작위 다른 참가자들의 수
		Integer totalUser = (int)(Math.random() * 1000);
		
		// 무작위 다른 참가자들의 번호 생성
		List<Lottery> others = new ArrayList<>();
		for(int i=0; i<totalUser; i++) {
			others.add(machine.autoGenerate());
		}
		
		// 각 등수별 인원 산출
		Integer[] ranks = new Integer[number+1];
		Arrays.fill(ranks, 0);
		
		for(Lottery other: others) {
			other.check(fromMachine);
			ranks[other.getRank()]++;
		}
		
		ResultDto result = new ResultDto(totalUser, ranks);
		
		Bank bank = new Bank(result);
		
		// 내 등수 확인
		System.out.println("당첨 번호: " + fromMachine.getNumbers());
		System.out.println("맞춘 갯수: " + mine.getRank());
		
	}

}
