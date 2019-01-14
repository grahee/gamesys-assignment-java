package com.gamesys.assignment.second;

import java.util.List;

public class SecondPart {

	private final SecondUtil util = new SecondUtil();

	private double special;
	private double approximate;

	public SecondPart(double approximateNumberSeed, List<Double> series)
			throws InvalidSeriesException, InvalidApproximateNumberSeedException {
		special = util.getSpecial(series);
		approximate = util.getApproximate(approximateNumberSeed, series);
	}

	public double getSpecial() {
		return special;
	}

	public double getApproximate() {
		return approximate;
	}
}
