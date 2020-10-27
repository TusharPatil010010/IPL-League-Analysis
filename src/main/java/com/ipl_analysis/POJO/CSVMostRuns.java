package com.ipl_analysis.POJO;

import com.opencsv.bean.CsvBindByName;

public class CSVMostRuns {
	
	@CsvBindByName(column = "Player")
	public String playerName;
	
	@CsvBindByName(column = "Mat")
	public int matches;
	
	@CsvBindByName(column = "Inns")
	public int innings;
	
	@CsvBindByName(column = "NO")
	public int notOut;	
	
	@CsvBindByName(column = "Runs")
	public int runs;
	
	@CsvBindByName(column = "Avg")
	public double avg;
	
	@CsvBindByName(column = "BF")
	public int ballsFaced;
	
	@CsvBindByName(column = "SR")
	public float strikeRate;
	
	@CsvBindByName(column = "100")
	public int hundreds;
	
	@CsvBindByName(column = "50")
	public int fifties;
	
	@CsvBindByName(column = "4s")
	public int fours;
	
	@CsvBindByName(column = "6s")
	public int sixes;

	@Override
	public String toString() {
		return "CSVMostRuns [playerName=" + playerName + ", matches=" + matches + ", innings=" + innings + ", notOut="
				+ notOut + ", runs=" + runs + ", avg=" + avg + ", ballsFaced=" + ballsFaced + ", strikeRate="
				+ strikeRate + ", hundreds=" + hundreds + ", fifties=" + fifties + ", fours=" + fours + ", sixes="
				+ sixes + "]";
	}

}
