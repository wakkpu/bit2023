package day02;

import java.util.List;

public final class Lottery {
	private List<Integer> numbers;
	private Integer rank;
	
	public Lottery(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public Integer getRank() {
		return rank;
	}

	// 로또 번호 대조
	public void check(Lottery lottery) {
		int count = 0;
		for(Integer i: lottery.numbers) {
			for(Integer j: this.numbers) {
				if(i == j) count++;
			}
		}
		this.rank = count;
	}

	@Override
	public String toString() {
		return "Lottery [numbers=" + numbers + ", rank=" + rank + "]";
	}
	
	
}
