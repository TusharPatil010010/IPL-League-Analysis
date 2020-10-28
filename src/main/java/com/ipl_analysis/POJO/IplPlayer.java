package com.ipl_analysis.POJO;

public class IplPlayer {

	public String playerName;
	public Double avg;
	public Double bowlingAvg;
	public int ballsFaced;
	public Double strikeRate;
	public int runsScored;
	public int runsGiven;
	public int fours;
	public int sixes;
	public CSVMostRuns batsmanData;
	public CSVMostWkts bowlerData;

	public IplPlayer() {
	}

	public IplPlayer(CSVMostRuns batsmanData) {
		this.playerName = batsmanData.playerName;
		this.avg = batsmanData.avg;
		this.ballsFaced = batsmanData.ballsFaced;
		this.strikeRate = batsmanData.strikeRate;
		this.runsGiven = batsmanData.runs;
		this.fours = batsmanData.fours;
		this.sixes = batsmanData.sixes;
		this.batsmanData = batsmanData;
	}

	public IplPlayer(CSVMostWkts iplBowlerData) {
		this.playerName = iplBowlerData.playerName;
		this.bowlingAvg = iplBowlerData.bowlingAvg;
		this.bowlerData = iplBowlerData;
	}

	public CSVMostRuns getBatsmanData() {
		return batsmanData;
	}

	public CSVMostWkts getBowlerData() {
		return bowlerData;
	}
}