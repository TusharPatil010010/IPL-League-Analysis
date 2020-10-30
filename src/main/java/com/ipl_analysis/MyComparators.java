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
		BOWLING_SR, BOWLING_ECONOMY, BOWLING_AVG_WITH_4W_AND_5W, BOWLING_SR_WITH_AVG, WICKETS_WITH_BOWLING_AVG,
		BEST_BATTING_AND_BOWLING_AVG, BEST_ALL_ROUNDER, MAX_HUNDREDS_WITH_RUNS
	}

	Comparator<IplPlayer> strikeRateComparator = Comparator.comparing(iplBatsman -> iplBatsman.battingStrikeRate,
			Comparator.reverseOrder());

	Comparator<IplPlayer> runsAverageComparator = Comparator.comparing(iplBatsman -> iplBatsman.battingAverage,
			Comparator.reverseOrder());

	Comparator<IplPlayer> sixesAndFoursComparator = Comparator
			.comparing(iplBatsman -> (iplBatsman.sixes * 6) + (iplBatsman.fours * 4), Comparator.reverseOrder());

	Comparator<IplPlayer> strikeRateWithBoundriesComparator = Comparator
			.comparing(iplBatsman -> ((((iplBatsman.batsmanData.fours * 4) + (iplBatsman.batsmanData.sixes * 6)) * 100)
					/ iplBatsman.batsmanData.ballsFaced), Comparator.reverseOrder());

	Comparator<IplPlayer> avg = Comparator.comparing(iplBatsman -> iplBatsman.battingAverage,
			Comparator.reverseOrder());
	Comparator<IplPlayer> avgWithStrikeRateComparator = avg.thenComparing(iplBatsman -> iplBatsman.battingStrikeRate,
			Comparator.reverseOrder());

	Comparator<IplPlayer> runs = Comparator.comparing(iplBatsman -> iplBatsman.runsScored, Comparator.reverseOrder());
	Comparator<IplPlayer> runsThenAverageComparator = runs.thenComparing(iplBatsman -> iplBatsman.battingAverage,
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

	Comparator<IplPlayer> bowlingWktsWithAvg = Comparator
			.comparing(iplBowler -> (iplBowler.wickets / iplBowler.bowlingAverage), Comparator.reverseOrder());

	//We require higher batting average and lower bowling average
	Comparator<IplPlayer> bestAllRounderAvg = Comparator
			.comparing(iplPlayer -> (iplPlayer.battingAverage / iplPlayer.bowlingAverage), Comparator.reverseOrder());

	//multiplication will provide a number to judge all rounder
	Comparator<IplPlayer> bestAllRounderComparator = Comparator
			.comparing(iplPlayer -> (iplPlayer.runsScored * iplPlayer.wickets), Comparator.reverseOrder());

	Comparator<IplPlayer> hundreds = Comparator.comparing(iplBatsman -> iplBatsman.hundreds, Comparator.reverseOrder());
	Comparator<IplPlayer> bestHundredsWithRunsComparator = hundreds
			.thenComparing(iplBatsman -> iplBatsman.battingAverage, Comparator.reverseOrder());

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
		this.comparators.put(CompareBasedOn.WICKETS_WITH_BOWLING_AVG, this.bowlingWktsWithAvg);
		this.comparators.put(CompareBasedOn.BEST_BATTING_AND_BOWLING_AVG, this.bestAllRounderAvg);
		this.comparators.put(CompareBasedOn.BEST_ALL_ROUNDER, this.bestAllRounderComparator);
		this.comparators.put(CompareBasedOn.MAX_HUNDREDS_WITH_RUNS, this.bestHundredsWithRunsComparator);
	}
}
