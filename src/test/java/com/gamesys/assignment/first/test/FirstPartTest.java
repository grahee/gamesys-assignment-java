package com.gamesys.assignment.first.test;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gamesys.assignment.first.FirstPart;
import com.gamesys.assignment.first.InvalidFirstNumberException;

public class FirstPartTest {

	@Before
	public void init() {
		BasicConfigurator.configure();
	}

	@Test
	public void firstPartTest() throws InvalidFirstNumberException {
		FirstPart part = new FirstPart(1, 5062.5, 5);
		Double[] testArray = { 1.5, 4.0, 6.5, 10.75, 17.25 };
		Assert.assertArrayEquals(testArray, part.getSeries().toArray());
	}

}
