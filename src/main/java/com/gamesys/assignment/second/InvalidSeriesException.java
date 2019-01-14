package com.gamesys.assignment.second;

public class InvalidSeriesException extends Exception {

	private static final long serialVersionUID = -7136593850350927366L;

	@Override
	public String getMessage() {
		return "Series is invalid to run Part 2";
	}
}
