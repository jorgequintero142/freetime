package com.jorge.junit.calculadora;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MiRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MiTestCaseTest.class);
		List<Failure> failure = result.getFailures();
		for (Failure f : failure) {
			System.out.println(f.getMessage());
		}
		System.out.println("Was successful the test?: " + result.wasSuccessful());
	}
}