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

		// 6/45�� ����, 5/40�� ���� ����
		System.out.println("���� ������ �ִ� ���ڸ� �Է��ϼ���");
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer number = Integer.parseInt(st.nextToken());
		Integer range = Integer.parseInt(st.nextToken());
		
		// �ζ� �ӽ� ����
		Machine machine = new Machine(range, number);
		
		// ��÷ ��ȣ ����
		Lottery fromMachine = machine.autoGenerate();
		
		// �ڵ�����, �������� ����
		System.out.println("1. auto / 2. manual");
		String input = br.readLine();

		// �� �ζ� ��ȣ ����
		Lottery mine = null;
		if(input.equals("1")) {
			mine = machine.autoGenerate();
		} else if(input.equals("2")) {
			mine = machine.manualGenerate();
		}
		mine.check(fromMachine);
		
		System.out.println("�� ��ȣ: " + mine.getNumbers().toString());
		
		// ������ �ٸ� �����ڵ��� ��
		Integer totalUser = (int)(Math.random() * 1000);
		
		// ������ �ٸ� �����ڵ��� ��ȣ ����
		List<Lottery> others = new ArrayList<>();
		for(int i=0; i<totalUser; i++) {
			others.add(machine.autoGenerate());
		}
		
		// �� ����� �ο� ����
		Integer[] ranks = new Integer[number+1];
		Arrays.fill(ranks, 0);
		
		for(Lottery other: others) {
			other.check(fromMachine);
			ranks[other.getRank()]++;
		}
		
		ResultDto result = new ResultDto(totalUser, ranks);
		
		Bank bank = new Bank(result);
		
		// �� ��� Ȯ��
		System.out.println("��÷ ��ȣ: " + fromMachine.getNumbers());
		System.out.println("���� ����: " + mine.getRank());
		
	}

}