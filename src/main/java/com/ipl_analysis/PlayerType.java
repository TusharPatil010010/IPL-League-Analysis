package com.ipl_analysis;

import com.ipl_analysis.POJO.AllRounder;
import com.ipl_analysis.POJO.CSVMostRuns;
import com.ipl_analysis.POJO.CSVMostWkts;
import com.ipl_analysis.POJO.IplPlayer;

public enum PlayerType {
	BATSMAN {
		@Override
		public CSVMostRuns getData(IplPlayer iplPlayer) {
			return iplPlayer.batsmanData;
		}
	},
	BOWLER {
		@Override
		public CSVMostWkts getData(IplPlayer iplPlayer) {
			return iplPlayer.bowlerData;
		}
	},
	BOTH {
		@Override
		public AllRounder getData(IplPlayer iplPlayer) {
			return new AllRounder(iplPlayer);
		}
	};

	public abstract Object getData(IplPlayer iplPlayer);

}
