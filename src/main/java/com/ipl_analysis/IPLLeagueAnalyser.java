package com.ipl_analysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.csvbuildernew.CSVBuilderException;
import com.csvbuildernew.CSVBuilderFactory;
import com.csvbuildernew.ICSVBuilder;
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

}
