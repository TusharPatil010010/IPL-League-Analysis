package com.ipl_analysis.FileLoaders;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.csvbuildernew.CSVBuilderException;
import com.csvbuildernew.CSVBuilderFactory;
import com.csvbuildernew.ICSVBuilder;
import com.ipl_analysis.IPLLeagueAnalyserException;
import com.ipl_analysis.POJO.IplPlayer;

public abstract class CsvFileLoader {

	public abstract Map<String, IplPlayer> loadCsv(String[] csvFilePath) throws IPLLeagueAnalyserException;

	Reader reader = null;

	public <E> Iterable<E> getCsvIterable(Class<E> clazz, String csvFilePath) throws IPLLeagueAnalyserException {

		try {
			this.reader = Files.newBufferedReader(Paths
					.get("C:\\Users\\LENOVO\\eclipse-workspace\\ipl_analysis\\src\\main\\resources\\readable.csv"));
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<E> iplIterator = csvBuilder.getCSVFileIterator(reader, clazz);
			Iterable<E> iplIterable = () -> iplIterator;
			return iplIterable;
		} catch (IOException e) {
			throw new IPLLeagueAnalyserException(e.getMessage(),
					IPLLeagueAnalyserException.ExceptionType.FILE_INPUT_ERROR);
		} catch (CSVBuilderException e) {
			throw new IPLLeagueAnalyserException(e.getMessage(),
					IPLLeagueAnalyserException.ExceptionType.CSV_TO_OBJECT_ERROR);
		}
	}

	public void closeReader() throws IOException {
		this.reader.close();
	}

}
