package com.ipl_analysis.FileLoaders;

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
		this.bowlerList = analyser.playersList;
	}

	@Override
	public Map<String, IplPlayer> loadCsv(String csvFilePath) throws IPLLeagueAnalyserException {
		try {
			Iterable<CSVMostWkts> csvIterable = super.getCsvIterable(CSVMostWkts.class, csvFilePath);
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
		iplPlayer.bowlingAvg = iplBowlerData.bowlingAvg;
		iplPlayer.bowlerData = iplBowlerData;
	}
}
