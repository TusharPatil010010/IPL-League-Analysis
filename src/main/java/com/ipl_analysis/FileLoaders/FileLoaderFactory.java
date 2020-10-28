package com.ipl_analysis.FileLoaders;

import com.ipl_analysis.*;

public class FileLoaderFactory {
	public static CsvFileLoader getAdapter(PlayerType playerType) throws IPLLeagueAnalyserException {
		switch (playerType) {
		case BATSMAN:
			return new BatsmenFileLoader();
		case BOWLER:
			return new BowlerFileLoader();
		default:
			throw new IPLLeagueAnalyserException("Incorrect Country entered",
					IPLLeagueAnalyserException.ExceptionType.INCORRECT_PLAYER_TYPE);
		}
	}
}