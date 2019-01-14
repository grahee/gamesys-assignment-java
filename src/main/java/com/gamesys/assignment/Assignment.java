package com.gamesys.assignment;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gamesys.assignment.first.FirstPart;
import com.gamesys.assignment.first.InvalidFirstNumberException;
import com.gamesys.assignment.second.InvalidApproximateNumberSeedException;
import com.gamesys.assignment.second.InvalidSeriesException;
import com.gamesys.assignment.second.SecondPart;

public class Assignment {

	private static final Logger log = LogManager.getLogger(Assignment.class);

	public static final double TOLERANCE = 0.00000000000001;

	public static void main(String[] args) {
		BasicConfigurator.configure();

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter First Number Seed:");
		double firstNumberSeed = keyboard.nextDouble();

		System.out.println("Enter Growth Rate Seed:");
		double growthRateSeed = keyboard.nextDouble();

		System.out.println("Enter Approximate Number Seed:");
		double approximateNumberSeed = keyboard.nextDouble();

		System.out.println("Length:");
		int length = keyboard.nextInt();

		FirstPart first;
		try {
			first = new FirstPart(firstNumberSeed, growthRateSeed, length);
		} catch (InvalidFirstNumberException ex) {
			log.error(ex.getMessage());
			return;
		}

		log.info("Series: " + first.getSeries().toString());

		SecondPart second = null;

		try {
			second = new SecondPart(approximateNumberSeed, first.getSeries());
			log.info("Special: " + second.getSpecial());
			log.info("Approximate: " + second.getApproximate());
		} catch (InvalidSeriesException | InvalidApproximateNumberSeedException ex) {
			log.error(ex.getMessage());
		}
	}
}
