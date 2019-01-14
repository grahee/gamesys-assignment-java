package com.gamesys.assignment.first;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gamesys.assignment.Assignment;

public class FirstUtil {

	private static final Logger log = LogManager.getLogger(FirstUtil.class);

	public final double TOLERANCE = Assignment.TOLERANCE;

	/**
	 * @param firstNumberSeed
	 * @return firstNumber by a nonlinear function:
	 *         <code>(0.02 * (firstNumberSeed ^ 2)) + (1.2 * firstNumberSeed) + 0.4</code>
	 */
	public double getFirstNumber(double firstNumberSeed) throws InvalidFirstNumberException {
		double firstNumber = (0.02 * Math.pow(firstNumberSeed, 2))
				+ (1.2 * firstNumberSeed)
				+ 0.4;

		if (Math.abs(firstNumber) < TOLERANCE) {
			firstNumber = 0;
		}

		validateFirstNumber(firstNumber);

		log.debug("firstNumberSeed: "
				.concat(String.valueOf(firstNumberSeed))
				.concat(" > firstNumber: ")
				.concat(String.valueOf(firstNumber)));

		return firstNumber;
	}

	/**
	 * @param firstNumber
	 * @param growthRateSeed
	 * @return growthRate by a function:
	 *         <code>growthRateSeed / (firstNumber * 1250)</code>
	 * @throws InvalidFirstNumberException
	 */
	public double getGrowthRate(double firstNumber, double growthRateSeed) throws InvalidFirstNumberException {
		validateFirstNumber(firstNumber);

		double growthRate = growthRateSeed / (firstNumber * 1250);

		log.debug("firstNumber: "
				.concat(String.valueOf(firstNumber))
				.concat(" | growthRateSeed: ")
				.concat(String.valueOf(growthRateSeed))
				.concat(" > growthRate:")
				.concat(String.valueOf(growthRate)));

		return growthRate;
	}

	/**
	 * @param firstNumber
	 * @param growthRate
	 * @param index
	 * @return nextNumber by a function:
	 *         <code>growthRate * (firstNumber ^ index)</code>
	 */
	public double getNextNumber(double firstNumber, double growthRate, int index) {
		double nextNumber = growthRate * Math.pow(firstNumber, index);

		log.debug("firstNumber: "
				.concat(String.valueOf(firstNumber))
				.concat(" | growthRate: ")
				.concat(String.valueOf(growthRate))
				.concat(" | index: ")
				.concat(String.valueOf(index))
				.concat(" > nextNumber: ")
				.concat(String.valueOf(nextNumber)));

		return nextNumber;
	}

	private void validateFirstNumber(double firstNumber) throws InvalidFirstNumberException {
		if (firstNumber == 0) {
			throw new InvalidFirstNumberException();
		}
	}
}
