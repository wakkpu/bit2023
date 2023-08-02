package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Machine {
	private Integer range; // 1 ~ 45
	private Integer number; //  6
	
	public Machine(Integer range, Integer number) {
		this.range = range;
		this.number = number;
	}
	
	// Lottery에 관한 부분인데 Machine에서 관리하는 것이 불편
	// range와 number를 Machine이 관리하기 때문에
	public Lottery autoGenerate() {
		List<Integer> numbers = new ArrayList<>();
		for(int i=1; i<=range; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		return new Lottery(numbers.subList(0, number));
	}
	
	public Lottery manualGenerate() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> lottery = new ArrayList<>();
		System.out.println("번호를 입력해주세요");
		for(int i=0; i<number; i++) {
			lottery.add(Integer.parseInt(br.readLine()));
		}
		return new Lottery(lottery);
	}
}
