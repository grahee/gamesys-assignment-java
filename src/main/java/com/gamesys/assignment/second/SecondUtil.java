package com.gamesys.assignment.second;

import java.util.List;

public class SecondUtil {

	private final double Y = 1000;

	/**
	 * @param series
	 * @return
	 * @throws InvalidSeriesException
	 */
	public double getSpecial(List<Double> series) throws InvalidSeriesException {
		if (series.size() < 3) {
			throw new InvalidSeriesException();
		}
		return series.get(series.size() - 3);
	}

	/**
	 * @param approximateNumberSeed
	 * @param series
	 * @return
	 * @throws InvalidApproximateNumberSeedException
	 */
	public double getApproximate(double approximateNumberSeed, List<Double> series)
			throws InvalidApproximateNumberSeedException {
		if (approximateNumberSeed == 0) {
			throw new InvalidApproximateNumberSeedException();
		}

		double approximate = Y / approximateNumberSeed;

		return selectFromSeries(approximate, series);
	}

	private double selectFromSeries(double approximate, List<Double> series) {
		double delta = Double.MAX_VALUE;
		double cache = 0;
		for (Double number : series) {
			double diff = Math.abs(approximate - number);
			if (delta > diff) {
				delta = diff;
				cache = number;
			} else {
				return cache;
			}
		}
		return cache;
	}
}
