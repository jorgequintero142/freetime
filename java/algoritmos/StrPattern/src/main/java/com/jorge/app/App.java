package com.jorge.app;

/**
 * print characters n times receives a 
 * string pattern with format number
 * string... it must print the string 
 * the number of times
 * 
 * i.e the patten 3e1t must print eeet
 */
public class App {
	public static void main(String[] args) {
		String pattern = "3a2bc3qw";
		PrinterPatternStringNTimes obj = new PrinterPatternStringNTimes();
		System.out.println(obj.printCharacterNTimes(pattern));
	}

	
}