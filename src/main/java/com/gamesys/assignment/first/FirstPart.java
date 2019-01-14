package com.gamesys.assignment.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FirstPart {

	private FirstUtil util = new FirstUtil();

	private List<Double> series = new ArrayList<>();

	public FirstPart(double firstNumberSeed, double growthRateSeed, int length) throws InvalidFirstNumberException {
		if (length > 0) {
			double firstNumber = util.getFirstNumber(firstNumberSeed);
			double growthRate = util.getGrowthRate(firstNumber, growthRateSeed);
			List<Double> rawSeries = getRawSeries(firstNumber, growthRate, length);
			List<Double> roundedSeries = getRoundedSeries(rawSeries);
			series = getUnduplicatedSeries(roundedSeries);
			Collections.sort(series);
		}
	}

	public List<Double> getSeries() {
		return this.series;
	}

	private List<Double> getRawSeries(double firstNumber, double growthRate, int length) {
		List<Double> rawSeries = new ArrayList<>();
		rawSeries.add(firstNumber);
		while (rawSeries.size() < length) {
			rawSeries.add(util.getNextNumber(firstNumber, growthRate, rawSeries.size()));
		}
		return rawSeries;
	}

	private List<Double> getRoundedSeries(List<Double> series) {
		List<Double> roundedSeries = new ArrayList<>();
		for (Double number : series) {
			roundedSeries.add(new Double(Math.round(number * 4) / 4f));
		}
		return roundedSeries;
	}

	private List<Double> getUnduplicatedSeries(List<Double> series) {
		return series.stream().distinct().collect(Collectors.toList());
	}
}
