package com.ipl_analysis;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.ipl_analysis.POJO.*;

public class MyComparators {

	public static Map<Enum, Comparator<CSVMostRuns>> comparators = new HashMap<Enum, Comparator<CSVMostRuns>>() {
		{
			put(IPLLeagueAnalyser.CompareBasedOn.STRIKE_RATE,
					Comparator.comparing(iplBatsmanData -> iplBatsmanData.strikeRate, Comparator.reverseOrder()));
			put(IPLLeagueAnalyser.CompareBasedOn.AVERAGE,
					Comparator.comparing(iplBatsmanData -> iplBatsmanData.avg, Comparator.reverseOrder()));
			put(IPLLeagueAnalyser.CompareBasedOn.SIX_AND_FOURS, this.getSixAndFourComparator());
			put(IPLLeagueAnalyser.CompareBasedOn.STRIKE_RATE_WITH_BOUNDRIES, this.getSixAndFourSRComparator());
			put(IPLLeagueAnalyser.CompareBasedOn.AVG_THEN_SR, this.getAvgWithSRComparator());
			put(IPLLeagueAnalyser.CompareBasedOn.RUNS_THEN_AVG, this.getRunsWithAVGComparator());

		}

		private Comparator<CSVMostRuns> getSixAndFourComparator() {
			return Comparator.comparing(iplBatsmanData -> (iplBatsmanData.fours * 4) + (iplBatsmanData.sixes * 6),
					Comparator.reverseOrder());
		}

		private Comparator<CSVMostRuns> getSixAndFourSRComparator() {
			return Comparator
					.comparing(iplBatsmanData -> ((((iplBatsmanData.fours * 4) + (iplBatsmanData.sixes * 6)) * 100)
							/ iplBatsmanData.ballsFaced), Comparator.reverseOrder());
		}

		private Comparator<CSVMostRuns> getAvgWithSRComparator() {

			Comparator<CSVMostRuns> avg = Comparator.comparing(iplBatsmanData -> iplBatsmanData.avg,
					Comparator.reverseOrder());
			Comparator<CSVMostRuns> getAvgWithSRComparator = avg
					.thenComparing(iplBatsmanData -> iplBatsmanData.strikeRate, Comparator.reverseOrder());
			return getAvgWithSRComparator;
		}

		private Comparator<CSVMostRuns> getRunsWithAVGComparator() {

			Comparator<CSVMostRuns> runs = Comparator.comparing(iplBatsmanData -> iplBatsmanData.runs,
					Comparator.reverseOrder());
			Comparator<CSVMostRuns> getRunsWithAVGComparator = runs.thenComparing(iplBatsmanData -> iplBatsmanData.avg,
					Comparator.reverseOrder());
			return getRunsWithAVGComparator;
		}

	};

}
