package com.ipl_analysis;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.csvbuildernew.CSVBuilderException;
import com.google.gson.Gson;
import com.ipl_analysis.POJO.*;

public class IPLLeagueAnalyserTest {
	IPLLeagueAnalyser iplLeagueAnalyser;
	private static final String MOST_RUNS_CSV = "\"C:\\Users\\LENOVO\\eclipse-workspace\\ipl_analysis\\src\\main\\resources\\MostRuns.csv\"";
	private static final String MOST_WKTS_CSV = "\"C:\\Users\\LENOVO\\eclipse-workspace\\ipl_analysis\\src\\main\\resources\\MostWkts.csv\"";

	@Before
	public void setUp() {
		iplLeagueAnalyser = new IPLLeagueAnalyser();
	}

	/**
	 * TC to check loading of most runs csv
	 */
	@Test
	public void givenFileData_IfMatchNumberOfRecords_ShouldReturnTrue() {
		try {
			int count = iplLeagueAnalyser.loadBattingData(MOST_RUNS_CSV);
			assertEquals(101, count);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CSVBuilderException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TC to check loading of most wkts csv
	 */
	@Test
	public void givenWKTSFileData_IfMatchNumberOfRecords_ShouldReturnTrue() {
		try {
			int count = iplLeagueAnalyser.loadBowlingData(MOST_WKTS_CSV);
			assertEquals(99, count);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CSVBuilderException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TC to check sorted data by batting average
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenRunsData_WhenSortedOnAverage_ShouldReturnTrue() throws IOException, CSVBuilderException {
		iplLeagueAnalyser.loadBattingData(MOST_RUNS_CSV);
		String sortedCensusData = iplLeagueAnalyser.getSortedDataByAverage();
		CSVMostRuns[] censusCSV = new Gson().fromJson(sortedCensusData, CSVMostRuns[].class);
		assertEquals(83.2, censusCSV[0].avg, 0.0);
	}
}
