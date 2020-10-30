package com.ipl_analysis.POJO;

public class IplPlayer {

    public String playerName;
    public int runsScored;
    public Double battingAverage = 0.0;
    public Double battingStrikeRate;
    public double bowlingStrikeRate;
    public int ballsFaced;
    public int fours;
    public int sixes;
    public int fourWkts;
    public int fiveWkts;
    public int ballsBowled;
    public int wickets;
    public double bowlingAverage = 99.0;
    public double bowlingEconomy;
    public CSVMostRuns batsmanData;
    public CSVMostWkts bowlerData;

    public IplPlayer() {
    }

    public IplPlayer(CSVMostRuns batsmanData) {
        this.playerName = batsmanData.playerName;
        this.runsScored = batsmanData.runsScored;
        this.battingAverage = batsmanData.avg;
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
        this.bowlingEconomy = iplBowlerData.economy;
        this.fourWkts = iplBowlerData.fourWkts;
        this.fiveWkts = iplBowlerData.fiveWkts;
        this.wickets = iplBowlerData.wickets;
        this.ballsBowled = (int) (Math.round(iplBowlerData.oversBowled)*6 + (iplBowlerData.oversBowled%6));
        this.bowlerData = iplBowlerData;
    }

    public CSVMostRuns getBatsmanData() {
        return batsmanData;
    }

    public CSVMostWkts getBowlerData() {
         return bowlerData;
    }
}