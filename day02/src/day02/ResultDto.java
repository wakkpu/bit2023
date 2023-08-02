package day02;

public final class ResultDto {
	private Integer totalUser;
	private Integer[] ranks;
	
	public ResultDto(Integer totalUser, Integer[] ranks) {
		this.totalUser = totalUser;
		this.ranks = ranks;
	}

	public Integer getTotalUser() {
		return totalUser;
	}
	
	public Integer[] getRanks() {
		return ranks;
	}
}
