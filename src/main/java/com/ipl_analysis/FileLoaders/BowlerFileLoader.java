package com.ipl_analysis.FileLoaders;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

import com.ipl_analysis.IPLLeagueAnalyser;
import com.ipl_analysis.IPLLeagueAnalyserException;
import com.ipl_analysis.POJO.CSVMostWkts;
import com.ipl_analysis.POJO.IplPlayer;

public class BowlerFileLoader extends CsvFileLoader {

	IPLLeagueAnalyser analyser = new IPLLeagueAnalyser();
	Map<String, IplPlayer> bowlerList = null;

	public BowlerFileLoader() {
		this.bowlerList = new HashMap<>();
	}

	public BowlerFileLoader(Map<String, IplPlayer> allRounderMap) {
		this.bowlerList = allRounderMap;
	}

	@Override
	public Map<String, IplPlayer> loadCsv(String... csvFilePath) throws IPLLeagueAnalyserException {
		try {
			Iterable<CSVMostWkts> csvIterable = super.getCsvIterable(CSVMostWkts.class, csvFilePath[1]);
			StreamSupport.stream(csvIterable.spliterator(), false).forEach(iplBowlerData -> mergeData(iplBowlerData));
			return bowlerList;
		} catch (IPLLeagueAnalyserException e) {
			throw e;
		}
	}

	private void mergeData(CSVMostWkts iplBowlerData) {
		IplPlayer iplPlayer = this.bowlerList.get(iplBowlerData.playerName);
		if (iplPlayer == null) {
			this.bowlerList.put(iplBowlerData.playerName, new IplPlayer(iplBowlerData));
			return;
		}
		iplPlayer.bowlingAverage = iplBowlerData.bowlingAvg;
		iplPlayer.bowlingStrikeRate = iplBowlerData.strikeRate;
		iplPlayer.bowlingEconomy = iplBowlerData.economy;
		iplPlayer.fourWkts = iplBowlerData.fourWkts;
		iplPlayer.fiveWkts = iplBowlerData.fiveWkts;
		iplPlayer.wickets = Math.max(iplPlayer.wickets, iplBowlerData.wickets);
		iplPlayer.ballsBowled = (int) (Math.round(iplBowlerData.oversBowled) * 6
				+ ((iplBowlerData.oversBowled * 10) % 10));
		iplPlayer.bowlerData = iplBowlerData;
	}
}