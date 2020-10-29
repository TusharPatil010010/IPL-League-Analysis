package com.ipl_analysis.FileLoaders;

import java.io.IOException;
import java.util.Map;
import java.util.stream.StreamSupport;

import com.ipl_analysis.IPLLeagueAnalyser;
import com.ipl_analysis.IPLLeagueAnalyserException;
import com.ipl_analysis.POJO.CSVMostRuns;
import com.ipl_analysis.POJO.IplPlayer;

public class BatsmenFileLoader extends CsvFileLoader {

    IPLLeagueAnalyser analyser = new IPLLeagueAnalyser();
    Map<String, IplPlayer> batsmenList = null;

    public BatsmenFileLoader() {
        this.batsmenList = analyser.playersList;
    }

    @Override
    public Map<String, IplPlayer> loadCsv(String csvFilePath) throws IPLLeagueAnalyserException {
        try {
            Iterable<CSVMostRuns> csvIterable = super.getCsvIterable(CSVMostRuns.class, csvFilePath);
            StreamSupport.stream(csvIterable.spliterator(),false)
                        .forEach(batsmanData -> batsmenList.put(batsmanData.playerName,new IplPlayer(batsmanData)));
            super.closeReader();
            return batsmenList;
        } catch (IPLLeagueAnalyserException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new IPLLeagueAnalyserException(e.getMessage(),
            		IPLLeagueAnalyserException.ExceptionType.CSV_TO_OBJECT_ERROR);
        } catch (IOException e) {
            throw new IPLLeagueAnalyserException("unable to close the reader",IPLLeagueAnalyserException.ExceptionType.READER_PROBLEM);
        }
    }
}
