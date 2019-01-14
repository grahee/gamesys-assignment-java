package com.gamesys.assignment.second.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gamesys.assignment.second.InvalidApproximateNumberSeedException;
import com.gamesys.assignment.second.InvalidSeriesException;
import com.gamesys.assignment.second.SecondPart;

public class SecondUtilTest {

	@Test(expected = InvalidSeriesException.class)
	public void getApproximateTest_InvalidSeriesException()
			throws InvalidSeriesException, InvalidApproximateNumberSeedException {
		new SecondPart(1, new ArrayList<>());
	}

	@Test(expected = InvalidApproximateNumberSeedException.class)
	public void getApproximateTest_InvalidApproximateNumberSeedException()
			throws InvalidSeriesException, InvalidApproximateNumberSeedException {
		List<Double> series = new ArrayList<>();
		series.add(1.00);
		series.add(2.00);
		series.add(3.00);
		new SecondPart(0, series);
	}
}
