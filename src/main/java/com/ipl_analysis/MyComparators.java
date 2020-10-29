package com.ipl_analysis;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.ipl_analysis.POJO.IplPlayer;

public class MyComparators {
	
	public enum CompareBasedOn {
		AVERAGE, STRIKE_RATE, SIX_AND_FOURS, STRIKE_RATE_WITH_BOUNDRIES, AVG_THEN_SR, RUNS_THEN_AVG
	, BOWLING_AVG}

	 Comparator<IplPlayer> strikeRateComparator = Comparator.comparing(iplBatsman -> iplBatsman.battingStrikeRate,Comparator.reverseOrder());

    Comparator<IplPlayer> runsAverageComparator = Comparator.comparing(iplBatsman -> iplBatsman.averageScore,Comparator.reverseOrder());

    Comparator<IplPlayer> sixesAndFoursComparator =
            Comparator.comparing(iplBatsman -> (iplBatsman.sixes*6)+(iplBatsman.fours*4)
                    ,Comparator.reverseOrder());

    Comparator<IplPlayer> strikeRateWithBoundriesComparator =
            Comparator.comparing(iplBatsman ->
                    ((((iplBatsman.batsmanData.fours*4)+(iplBatsman.batsmanData.sixes*6))*100)
                            /iplBatsman.batsmanData.ballsFaced), Comparator.reverseOrder());

    Comparator<IplPlayer> avg =Comparator.comparing(iplBatsman -> iplBatsman.averageScore,Comparator.reverseOrder());
    Comparator<IplPlayer> avgWithStrikeRateComparator = avg.thenComparing(iplBatsman -> iplBatsman.battingStrikeRate,Comparator.reverseOrder());

    Comparator<IplPlayer> runs =Comparator.comparing(iplBatsman -> iplBatsman.runsScored,Comparator.reverseOrder());
    Comparator<IplPlayer> runsThenAverageComparator = runs.thenComparing(iplBatsman -> iplBatsman.averageScore,Comparator.reverseOrder());

    Comparator<IplPlayer> bowlerAvg = Comparator.comparing(iplBowler -> iplBowler.bowlingAverage, Comparator.reverseOrder());

    public Map<Enum, Comparator<IplPlayer>> comparators = new HashMap<>();

    public MyComparators() {
        this.comparators.put(CompareBasedOn.STRIKE_RATE,
                this.strikeRateComparator);
        this.comparators.put(CompareBasedOn.AVERAGE,
                this.runsAverageComparator);
        this.comparators.put(CompareBasedOn.SIX_AND_FOURS,
                this.sixesAndFoursComparator);
        this.comparators.put(CompareBasedOn.STRIKE_RATE_WITH_BOUNDRIES,
                this.strikeRateWithBoundriesComparator);
        this.comparators.put(CompareBasedOn.AVG_THEN_SR,
                this.avgWithStrikeRateComparator);
        this.comparators.put(CompareBasedOn.RUNS_THEN_AVG,
                this.runsThenAverageComparator);
        this.comparators.put(CompareBasedOn.BOWLING_AVG,
                this.bowlerAvg);
    }
}


