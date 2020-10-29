package com.ipl_analysis.POJO;

public class IplPlayer {

    public String playerName;
    public int runsScored;
    public Double averageScore;
    public Double battingStrikeRate;
    public double bowlingStrikeRate;
    public int ballsFaced;
    public int fours;
    public int sixes;
    public double bowlingAverage;
    public CSVMostRuns batsmanData;
    public CSVMostWkts bowlerData;

    public IplPlayer() {
    }

    public IplPlayer(CSVMostRuns batsmanData) {
        this.playerName = batsmanData.playerName;
        this.runsScored = batsmanData.runsScored;
        this.averageScore = batsmanData.avg;
        this.battingStrikeRate = batsmanData.strikeRate;
        this.ballsFaced = batsmanData.ballsFaced;
        this.fours = batsmanData.fours;
        this.sixes = batsmanData.sixes;
        this.batsmanData = batsmanData;
    }

    public IplPlayer(CSVMostWkts iplBowlerData) {
        this.playerName = iplBowlerData.playerName;
        this.bowlingAverage = iplBowlerData.bowlingAvg;
        this.bowlingStrikeRate = iplBowlerData.strikeRate;
        this.bowlerData = iplBowlerData;
    }

    public CSVMostRuns getBatsmanData() {
        return batsmanData;
    }

    public CSVMostWkts getBowlerData() {
         return bowlerData;
    }
}