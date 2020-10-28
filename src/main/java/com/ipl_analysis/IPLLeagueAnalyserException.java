package com.ipl_analysis;

public class IPLLeagueAnalyserException extends Exception {
	public enum ExceptionType {
		FILE_INPUT_ERROR, CSV_TO_OBJECT_ERROR, INCORRECT_PLAYER_TYPE, READER_PROBLEM
	}

	public ExceptionType type;

	public IPLLeagueAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
