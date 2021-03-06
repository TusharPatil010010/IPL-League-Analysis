package com.ipl_analysis.POJO;

import com.opencsv.bean.CsvBindByName;

public class CSVMostWkts {

	@CsvBindByName(column = "Player")
	public String playerName;

	@CsvBindByName(column = "Mat")
	public int matches;

	@CsvBindByName(column = "Inns")
	public int innings;

	@CsvBindByName(column = "Ov")
	public double oversBowled;

	@CsvBindByName(column = "Runs")
	public int runs;

	@CsvBindByName(column = "Wkts")
	public int wickets;

	@CsvBindByName(column = "Avg")
	public double bowlingAvg;

	@CsvBindByName(column = "Econ")
	public double economy;

	@CsvBindByName(column = "SR")
	public double strikeRate;

	@CsvBindByName(column = "4w")
	public int fourWkts;

	@CsvBindByName(column = "5w")
	public int fiveWkts;

	@Override
	public String toString() {
		return "CSVMostWkts [playerName=" + playerName + ", matches=" + matches + ", innings=" + innings + ", over="
				+ oversBowled + ", runs=" + runs + ", wickets=" + wickets + ", avg=" + bowlingAvg + ", economy="
				+ economy + ", strikeRate=" + strikeRate + ", fourWkts=" + fourWkts + ", fiveWkts=" + fiveWkts + "]";
	}

}