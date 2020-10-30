package com.ipl_analysis.FileLoaders;

import java.util.HashMap;
import java.util.Map;

import com.ipl_analysis.IPLLeagueAnalyserException;
import com.ipl_analysis.POJO.IplPlayer;

public class BowlingAndBattingDataLoader extends CsvFileLoader {
	Map<String, IplPlayer> allRounderMap = null;

	public BowlingAndBattingDataLoader() {
		this.allRounderMap = new HashMap<>();
	}

	@Override
	public Map<String, IplPlayer> loadCsv(String... csvFilePath) throws IPLLeagueAnalyserException {
		this.allRounderMap = new BatsmenFileLoader().loadCsv(csvFilePath[0]);
		this.allRounderMap = new BowlerFileLoader(this.allRounderMap).loadCsv(csvFilePath[1]);
		return this.allRounderMap;
	}
}
