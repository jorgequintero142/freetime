package com.jorge.app;

public class PrinterPatternStringNTimes {

	public String printCharacterNTimes(String pattern) {
		String[] characters = pattern.split("[0-9]+");
		String[] digits = pattern.split("[^0-9]+");

		String printed = "";
		// n/2
		for (int i = 0; i < digits.length; i++) {
			int number = Integer.parseInt(digits[i]);
			int x = 0;
			// (nC/2)
			while (x < number) {
				printed += characters[i + 1];
				x++;
			}
		}
		// n^2
		return printed;
	}
}