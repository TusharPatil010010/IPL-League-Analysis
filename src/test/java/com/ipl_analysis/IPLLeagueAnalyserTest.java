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
	private static final String MOST_RUNS_CSV = "C:\\Users\\LENOVO\\eclipse-workspace\\ipl_analysis\\src\\main\\resources\\MostRuns.csv";
	private static final String MOST_WKTS_CSV = "C:\\Users\\LENOVO\\eclipse-workspace\\ipl_analysis\\src\\main\\resources\\MostWkts.csv";

	@Before
	public void setUp() {
		iplLeagueAnalyser = new IPLLeagueAnalyser();
	}

	/**
	 * TC to check loading of most runs csv
	 */
	@Test
	public void givenFileData_IfMatchNumberOfRecords_ShouldReturnTrue() {

		int count;
		try {
			count = iplLeagueAnalyser.loadDataFromCsv(PlayerType.BATSMAN, MOST_RUNS_CSV);
			assertEquals(100, count);
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}

	}

	/**
	 * TC to check loading of most wkts csv
	 */
	@Test
	public void givenWKTSFileData_IfMatchNumberOfRecords_ShouldReturnTrue() {

		int count;
		try {
			count = iplLeagueAnalyser.loadDataFromCsv(PlayerType.BOWLER, MOST_WKTS_CSV);
			assertEquals(99, count);
		} catch (IPLLeagueAnalyserException e) {
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
		try {
			iplLeagueAnalyser.loadDataFromCsv(PlayerType.BATSMAN, MOST_RUNS_CSV);
			String sortedCensusData = iplLeagueAnalyser.sortBasedOn(MyComparators.CompareBasedOn.AVERAGE);
			CSVMostRuns[] censusCSV = new Gson().fromJson(sortedCensusData, CSVMostRuns[].class);
			assertEquals(83.2, censusCSV[0].avg, 0.0);
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}

	}

	/**
	 * TC to check sorted data by strike rate
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenRunsData_WhenSortedOnSR_ShouldReturnTrue() throws IOException, CSVBuilderException {
		try {
			iplLeagueAnalyser.loadDataFromCsv(PlayerType.BATSMAN, MOST_RUNS_CSV);
			String sortedCSVData = iplLeagueAnalyser.sortBasedOn(MyComparators.CompareBasedOn.STRIKE_RATE);
			CSVMostRuns[] iplCSV = new Gson().fromJson(sortedCSVData, CSVMostRuns[].class);
			assertEquals("Ishant Sharma", iplCSV[0].playerName);
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}

	}

	/**
	 * TC to check sorted data by max boundries
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenBattingCsvFile_AfterSortingBasedOnBoundaries_ShouldReturnFirstBatsman()
			throws IOException, CSVBuilderException {
		try {
			iplLeagueAnalyser.loadDataFromCsv(PlayerType.BATSMAN, MOST_RUNS_CSV);
			String sortBasedOnSixAndFours = iplLeagueAnalyser.sortBasedOn(MyComparators.CompareBasedOn.SIX_AND_FOURS);
			CSVMostRuns[] batsmenArray = new Gson().fromJson(sortBasedOnSixAndFours, CSVMostRuns[].class);
			assertEquals("Andre Russell", batsmenArray[0].playerName);
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}

	}

	/**
	 * TC to check sorting by strike rate and boundries
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenCricketLeagueCsvFile_AfterSortingBySRAndThenWithBoundries_shouldReturnFirstBatsman()
			throws IOException, CSVBuilderException {

		try {
			iplLeagueAnalyser.loadDataFromCsv(PlayerType.BATSMAN, MOST_RUNS_CSV);
			String sortBasedOnAvgAndBoundries = iplLeagueAnalyser
					.sortBasedOn(MyComparators.CompareBasedOn.STRIKE_RATE_WITH_BOUNDRIES);
			CSVMostRuns[] batsmenArray = new Gson().fromJson(sortBasedOnAvgAndBoundries, CSVMostRuns[].class);
			assertEquals("Ishant Sharma", batsmenArray[0].playerName);

		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}

	}

	/**
	 * TC to check the sorting by average and then by strike rate
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenMostRunsCSV_AfterSortingByAvgThenBySR_shouldReturnFirstBatsman()
			throws IOException, CSVBuilderException {

		try {
			iplLeagueAnalyser.loadDataFromCsv(PlayerType.BATSMAN, MOST_RUNS_CSV);
			String sortBasedOnAvg = iplLeagueAnalyser.sortBasedOn(MyComparators.CompareBasedOn.AVG_THEN_SR);
			CSVMostRuns[] batsmenArray = new Gson().fromJson(sortBasedOnAvg, CSVMostRuns[].class);
			assertEquals("MS Dhoni", batsmenArray[0].playerName);
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}

	}

	/**
	 * TC to check the sorting by runs and then average
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenMostRunsCSV_AfterSortingByRunsThenAvg_shouldReturnFirstBatsman()
			throws IOException, CSVBuilderException {

		try {
			iplLeagueAnalyser.loadDataFromCsv(PlayerType.BATSMAN, MOST_RUNS_CSV);
			String sortBasedOnAvg = iplLeagueAnalyser.sortBasedOn(MyComparators.CompareBasedOn.RUNS_THEN_AVG);
			CSVMostRuns[] batsmenArray = new Gson().fromJson(sortBasedOnAvg, CSVMostRuns[].class);
			assertEquals(692, batsmenArray[0].runsScored);

		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}

	}

	/**
	 * UC7 TC to check the sorting by bowling avg
	 */
	@Test
	public void givenMostWktsCsvFile_AfterSortingBasedBowlingAvg_ShouldReturnFirstBowler() {
		try {
			iplLeagueAnalyser.loadDataFromCsv(PlayerType.BOWLER, MOST_WKTS_CSV);
			String sortBasedOnAvg = iplLeagueAnalyser.sortBasedOn(MyComparators.CompareBasedOn.BOWLING_AVG);
			CSVMostWkts[] bowlerArray = new Gson().fromJson(sortBasedOnAvg, CSVMostWkts[].class);
			assertEquals("Krishnappa Gowtham", bowlerArray[0].playerName);
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
	}

	/**
	 * UC8 TC to check the sorting by bowlers strike rate
	 */
	@Test
	public void givenMostWktsCsvFile_AfterSortingBasedBowlingStrikeRate_ShouldReturnFirstBowler() {
		try {
			iplLeagueAnalyser.loadDataFromCsv(PlayerType.BOWLER, MOST_WKTS_CSV);
			String sortBasedOnStrikeRate = iplLeagueAnalyser.sortBasedOn(MyComparators.CompareBasedOn.BOWLING_SR);
			CSVMostWkts[] bowlerArray = new Gson().fromJson(sortBasedOnStrikeRate, CSVMostWkts[].class);
			assertEquals("Krishnappa Gowtham", bowlerArray[0].playerName);
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
	}

	/**
	 * UC9 TC to check the sorting by bowlers economy
	 */
	@Test
	public void givenMostWktsCsvFile_AfterSortingBasedBowlingEconomy_ShouldReturnFirstBowler() {
		try {
			iplLeagueAnalyser.loadDataFromCsv(PlayerType.BOWLER, MOST_WKTS_CSV);
			String sortBasedOnEconomy = iplLeagueAnalyser.sortBasedOn(MyComparators.CompareBasedOn.BOWLING_ECONOMY);
			CSVMostWkts[] bowlerArray = new Gson().fromJson(sortBasedOnEconomy, CSVMostWkts[].class);
			assertEquals("Ben Cutting", bowlerArray[0].playerName);
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
	}

	/**
	 * UC10 TC to check the sorting by bowlers strike rate with 4wickets and
	 * 5wickets
	 */
	@Test
	public void givenMostWktsCsvFile_AfterSortingBasedBowlingSRWith4wand5w_ShouldReturnFirstBowler() {
		try {
			iplLeagueAnalyser.loadDataFromCsv(PlayerType.BOWLER, MOST_WKTS_CSV);
			String sortBasedOnAvgWith4wAnd5w = iplLeagueAnalyser
					.sortBasedOn(MyComparators.CompareBasedOn.BOWLING_AVG_WITH_4W_AND_5W);
			CSVMostWkts[] bowlerArray = new Gson().fromJson(sortBasedOnAvgWith4wAnd5w, CSVMostWkts[].class);
			assertEquals("Umesh Yadav", bowlerArray[0].playerName);
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
	}
}
