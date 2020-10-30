package com.ipl_analysis.POJO;

public class AllRounder {

	public String playerName;
	public int runsScored;
	public Double battingAverage;
	public Double battingStrikeRate;
	public int ballsFaced;
	public int fours;
	public int sixes;
	public double bowlingAverage;
	public double bowlingStrikeRate;
	public double bowlerEconomy;
	public double bowler5Wickets;
	public int wicketsTaken;
	public double bowler4Wickets;
	public int ballsBowled;

	public AllRounder(IplPlayer iplPlayer) {
		this.playerName = iplPlayer.playerName;
		this.runsScored = iplPlayer.runsScored;
		this.battingAverage = iplPlayer.battingAverage;
		this.ballsFaced = iplPlayer.ballsFaced;
		this.battingStrikeRate = iplPlayer.battingStrikeRate;
		this.fours = iplPlayer.fours;
		this.sixes = iplPlayer.sixes;
		this.wicketsTaken = iplPlayer.wickets;
		this.bowlingStrikeRate = iplPlayer.bowlingStrikeRate;
		this.bowlingAverage = iplPlayer.bowlingAverage;
		this.bowlerEconomy = iplPlayer.bowlingEconomy;
		this.bowler5Wickets = iplPlayer.fourWkts;
		this.bowler4Wickets = iplPlayer.fiveWkts;
		this.ballsBowled = iplPlayer.ballsBowled;
	}
}
