package day02;

import java.util.Arrays;

public final class Bank {
	
	private Long[] prizes;
	
	public Bank(ResultDto resultDto) {
		Long total = resultDto.getTotalUser() * 1000 / 2L;
		
		prizes = new Long[resultDto.getRanks().length];
		for(int i=0; i<resultDto.getRanks().length; i++) {
			if(i > 0 && resultDto.getRanks()[i] > 0) {
				prizes[i] = (long) total / resultDto.getRanks()[i];
				total -= prizes[i] * resultDto.getRanks()[i];
			}
		}
	}
	
	@Override
	public String toString() {
		return "Bank [prizes=" + Arrays.toString(prizes) + "]";
	}

	Long getPrize(Lottery myLotto) {
		return prizes[myLotto.getRank()];
	}
}
