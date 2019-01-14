package com.gamesys.assignment.second.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gamesys.assignment.Assignment;
import com.gamesys.assignment.first.InvalidFirstNumberException;
import com.gamesys.assignment.second.InvalidApproximateNumberSeedException;
import com.gamesys.assignment.second.InvalidSeriesException;
import com.gamesys.assignment.second.SecondPart;

public class SecondPartTest {

	private final double TOLERANCE = Assignment.TOLERANCE;

	@Before
	public void init() {
		BasicConfigurator.configure();
	}

	@Test
	public void secondPartTest()
			throws InvalidFirstNumberException, InvalidSeriesException, InvalidApproximateNumberSeedException {

		List<Double> series = new ArrayList<>();
		series.add(2.5);
		series.add(14.5);
		series.add(34.5);
		series.add(497.75);

		SecondPart part = new SecondPart(1000, series);

		Assert.assertEquals(14.5, part.getSpecial(), TOLERANCE);
		Assert.assertEquals(2.5, part.getApproximate(), TOLERANCE);
	}
}
