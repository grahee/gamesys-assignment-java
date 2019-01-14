package com.gamesys.assignment.second;

public class InvalidApproximateNumberSeedException extends Exception {

	private static final long serialVersionUID = -1654985323652570141L;

	@Override
	public String getMessage() {
		return "Approximate Number Seed cannot be zero.";
	}
}
