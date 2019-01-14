package com.gamesys.assignment.first;

public class InvalidFirstNumberException extends Exception {

	private static final long serialVersionUID = 3425482124744605700L;

	@Override
	public String getMessage() {
		return "First Number cannot be zero.";
	}

}
