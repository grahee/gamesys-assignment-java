package com.gamesys.assignment.first.test;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import com.gamesys.assignment.Assignment;
import com.gamesys.assignment.first.FirstUtil;
import com.gamesys.assignment.first.InvalidFirstNumberException;

public class FirstUtilTest {

	private final double TOLERANCE = Assignment.TOLERANCE;

	private FirstUtil firstUtil = new FirstUtil();

	@Before
	public void init() {
		BasicConfigurator.configure();
	}

	@Test
	public void getFirstNumberTest() throws InvalidFirstNumberException {
		assertEquals(-0.7799999999999999, firstUtil.getFirstNumber(-1), TOLERANCE);
		assertEquals(0.4, firstUtil.getFirstNumber(0), TOLERANCE);
		assertEquals(1.62, firstUtil.getFirstNumber(1), TOLERANCE);
	}

	@Test
	public void getGrowthRateTest() throws InvalidFirstNumberException {
		assertEquals(2.5, firstUtil.getGrowthRate(1.62, 5062.5), TOLERANCE);
	}

	@Test
	public void getNextNumberTest() {
		assertEquals(4.05, firstUtil.getNextNumber(1.62, 2.5, 1), TOLERANCE);
		assertEquals(6.561, firstUtil.getNextNumber(1.62, 2.5, 2), TOLERANCE);
		assertEquals(10.62882, firstUtil.getNextNumber(1.62, 2.5, 3), TOLERANCE);
		assertEquals(17.2186884, firstUtil.getNextNumber(1.62, 2.5, 4), TOLERANCE);
	}

	@Test(expected = InvalidFirstNumberException.class)
	public void getFirstNumber_InvalidFirstNumberTest_A() throws InvalidFirstNumberException {
		double value = -30 - (4 * Math.sqrt(55));
		firstUtil.getFirstNumber(value);
	}

	@Test(expected = InvalidFirstNumberException.class)
	public void getFirstNumber_InvalidFirstNumberTest_B() throws InvalidFirstNumberException {
		double value = (4 * Math.sqrt(55)) - 30;
		firstUtil.getFirstNumber(value);
	}
}
