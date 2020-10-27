package com.ipl_analysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import com.csvbuildernew.CSVBuilderException;
import com.csvbuildernew.CSVBuilderFactory;
import com.csvbuildernew.ICSVBuilder;
import com.google.gson.Gson;
import com.ipl_analysis.POJO.*;

public class IPLLeagueAnalyser {

	List<CSVMostRuns> csvRunsList = null;
	List<CSVMostWkts> csvWktsList = null;

	/**
	 * Load batting data
	 * 
	 * @param CSVFile
	 * @return
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	public int loadBattingData(String CSVFile) throws IOException, CSVBuilderException {
		Reader reader = Files.newBufferedReader(Paths.get(CSVFile));
		ICSVBuilder<CSVMostRuns> csvBuilder = CSVBuilderFactory.createCSVBuilder();
		csvRunsList = csvBuilder.getCSVFileList(reader, CSVMostRuns.class);
		return csvRunsList.size();
	}

	/**
	 * Load bowling data
	 * 
	 * @param CSVFile
	 * @return
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	public int loadBowlingData(String CSVFile) throws IOException, CSVBuilderException {
		Reader reader = Files.newBufferedReader(Paths.get(CSVFile));
		ICSVBuilder<CSVMostWkts> csvBuilder = CSVBuilderFactory.createCSVBuilder();
		csvWktsList = csvBuilder.getCSVFileList(reader, CSVMostWkts.class);
		return csvWktsList.size();
	}

	/**
	 * UC1 Sort data by average
	 * 
	 * @return
	 */
	public String getSortedDataByAverage() {
		Comparator<CSVMostRuns> censusComparator = Comparator.comparing(entry -> entry.avg);
		this.sort(csvRunsList, censusComparator);
		String sorted = new Gson().toJson(csvRunsList);
		return sorted;
	}

	private <E> void sort(List<E> cnesusList, Comparator<E> censusComparator) {
		for (int i = 0; i < cnesusList.size(); i++) {
			for (int j = 0; j < cnesusList.size() - i - 1; j++) {
				E census1 = cnesusList.get(j);
				E census2 = cnesusList.get(j + 1);
				if (censusComparator.compare(census1, census2) < 0) {
					cnesusList.set(j, census2);
					cnesusList.set(j + 1, census1);
				}
			}
		}
	}
}
