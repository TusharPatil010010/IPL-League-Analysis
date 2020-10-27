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
		}
	};

}