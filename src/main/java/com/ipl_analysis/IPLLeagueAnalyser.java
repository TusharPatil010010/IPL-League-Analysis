package com.ipl_analysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;

import com.csvbuildernew.CSVBuilderException;
import com.csvbuildernew.CSVBuilderFactory;
import com.csvbuildernew.ICSVBuilder;
import com.google.gson.Gson;
import com.ipl_analysis.FileLoaders.CsvFileLoader;
import com.ipl_analysis.FileLoaders.FileLoaderFactory;
import com.ipl_analysis.POJO.*;

public class IPLLeagueAnalyser {

	private PlayerType playerType;
	public Map<String, IplPlayer> playersList;

	public IPLLeagueAnalyser() {
		this.playersList = new HashMap<>();
	}

	/**
	 * Loads data from CSV
	 * 
	 * @param playerType
	 * @param csvFilePath
	 * @return
	 * @throws IPLLeagueAnalyserException
	 */
	public int loadDataFromCsv(PlayerType playerType, String csvFilePath) throws IPLLeagueAnalyserException {
		this.playerType = playerType;
		CsvFileLoader csvFileLoader = FileLoaderFactory.getAdapter(playerType);
		this.playersList = csvFileLoader.loadCsv(csvFilePath);
		return playersList.size();
	}

	/**
	 * Sorts data based on comparators
	 * 
	 * @param comparingField
	 * @return
	 */
	public String sortBasedOn(MyComparators.CompareBasedOn comparingField) {
		MyComparators compareWith = new MyComparators();
		ArrayList<IplPlayer> sortedList = this.playersList.values().stream()
				.sorted(compareWith.comparators.get(comparingField)).collect(toCollection(ArrayList::new));
		ArrayList sortedDatatoList = new ArrayList<>();
		if (this.playerType.equals(PlayerType.BATSMAN)) {
			for (IplPlayer batsman : sortedList) {
				sortedDatatoList.add(batsman.getBatsmanData());
			}
		}
		if (this.playerType.equals(PlayerType.BOWLER)) {
			for (IplPlayer bowler : sortedList) {
				sortedDatatoList.add(bowler.getBowlerData());
			}
		}
		String sortedString = new Gson().toJson(sortedDatatoList);
		return sortedString;
	}

}
