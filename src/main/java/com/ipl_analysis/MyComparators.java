package com.ipl_analysis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ipl_analysis.POJO.IplPlayer;

public class MyComparators {

	public enum CompareBasedOn {
		AVERAGE, STRIKE_RATE, SIX_AND_FOURS, STRIKE_RATE_WITH_BOUNDRIES, AVG_THEN_SR, RUNS_THEN_AVG, BOWLING_AVG,
		BOWLING_SR, BOWLING_ECONOMY, BOWLING_AVG_WITH_4W_AND_5W, BOWLING_SR_WITH_AVG
	}

	Comparator<IplPlayer> strikeRateComparator = Comparator.comparing(iplBatsman -> iplBatsman.battingStrikeRate,
			Comparator.reverseOrder());

	Comparator<IplPlayer> runsAverageComparator = Comparator.comparing(iplBatsman -> iplBatsman.averageScore,
			Comparator.reverseOrder());

	Comparator<IplPlayer> sixesAndFoursComparator = Comparator
			.comparing(iplBatsman -> (iplBatsman.sixes * 6) + (iplBatsman.fours * 4), Comparator.reverseOrder());

	Comparator<IplPlayer> strikeRateWithBoundriesComparator = Comparator
			.comparing(iplBatsman -> ((((iplBatsman.batsmanData.fours * 4) + (iplBatsman.batsmanData.sixes * 6)) * 100)
					/ iplBatsman.batsmanData.ballsFaced), Comparator.reverseOrder());

	Comparator<IplPlayer> avg = Comparator.comparing(iplBatsman -> iplBatsman.averageScore, Comparator.reverseOrder());
	Comparator<IplPlayer> avgWithStrikeRateComparator = avg.thenComparing(iplBatsman -> iplBatsman.battingStrikeRate,
			Comparator.reverseOrder());

	Comparator<IplPlayer> runs = Comparator.comparing(iplBatsman -> iplBatsman.runsScored, Comparator.reverseOrder());
	Comparator<IplPlayer> runsThenAverageComparator = runs.thenComparing(iplBatsman -> iplBatsman.averageScore,
			Comparator.reverseOrder());

	Comparator<IplPlayer> bowlerAvg = Comparator.comparing(iplBowler -> iplBowler.bowlingAverage,
			Comparator.reverseOrder());

	Comparator<IplPlayer> bowlerStrikeRateComparator = Comparator.comparing(iplBowler -> iplBowler.bowlingStrikeRate,
			Comparator.reverseOrder());

	Comparator<IplPlayer> bowlingEconomyComparator = Comparator.comparing(iplBowler -> iplBowler.bowlingEconomy,
			Comparator.reverseOrder());

	Comparator<IplPlayer> bowlingStrikeRateWith4n5WComparator = Comparator.comparing(
			iplBowler -> (((iplBowler.fourWkts * 4) + (iplBowler.fiveWkts * 5)) / iplBowler.ballsBowled),
			Comparator.reverseOrder());

	Comparator<IplPlayer> bowlingSRWithAvg = Comparator
			.comparing(iplBowler -> (iplBowler.bowlingAverage + iplBowler.bowlingStrikeRate));

	public Map<Enum, Comparator<IplPlayer>> comparators = new HashMap<>();

	public MyComparators() {
		this.comparators.put(CompareBasedOn.STRIKE_RATE, this.strikeRateComparator);
		this.comparators.put(CompareBasedOn.AVERAGE, this.runsAverageComparator);
		this.comparators.put(CompareBasedOn.SIX_AND_FOURS, this.sixesAndFoursComparator);
		this.comparators.put(CompareBasedOn.STRIKE_RATE_WITH_BOUNDRIES, this.strikeRateWithBoundriesComparator);
		this.comparators.put(CompareBasedOn.AVG_THEN_SR, this.avgWithStrikeRateComparator);
		this.comparators.put(CompareBasedOn.RUNS_THEN_AVG, this.runsThenAverageComparator);
		this.comparators.put(CompareBasedOn.BOWLING_AVG, this.bowlerAvg);
		this.comparators.put(CompareBasedOn.BOWLING_SR, this.bowlerStrikeRateComparator);
		this.comparators.put(CompareBasedOn.BOWLING_ECONOMY, this.bowlingEconomyComparator);
		this.comparators.put(CompareBasedOn.BOWLING_AVG_WITH_4W_AND_5W, this.bowlingStrikeRateWith4n5WComparator);
		this.comparators.put(CompareBasedOn.BOWLING_SR_WITH_AVG, this.bowlingSRWithAvg);
	}
}
