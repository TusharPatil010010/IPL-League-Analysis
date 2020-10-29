package com.ipl_analysis.POJO;

public class IplPlayer {

    public String playerName;
    public int runsScored=0;
    public Double averageScore=0.0;
    public Double battingStrikeRate=0.0;
    public int ballsFaced=0;
    public int fours=0;
    public int sixes=0;
    public double bowlingAverage=99;
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
        this.bowlerData = iplBowlerData;
    }

    public CSVMostRuns getBatsmanData() {
        return batsmanData;
    }

    public CSVMostWkts getBowlerData() {
         return bowlerData;
    }
}