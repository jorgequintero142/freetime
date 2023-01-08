package com.jorge.app;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple printerPatternStringNTimes.
 */
public class PrinterPatternStringNTimesTest {

	static PrinterPatternStringNTimes printerPatternStringNTimes;

	@BeforeClass
	public static void setup() {
		printerPatternStringNTimes = new PrinterPatternStringNTimes();
	}
	
//	@Before
//	public void setup() {
//		printerPatternStringNTimes = new PrinterPatternStringNTimes();
//	}

	@Test
	public void test1a() {
		assertEquals("Verify 1a", "a", printerPatternStringNTimes.printCharacterNTimes("1a"));
	}

	@Test
	public void test1a2b() {
		assertEquals("Verify 1a2b", "abb", printerPatternStringNTimes.printCharacterNTimes("1a2b"));
	}

	@Test
	public void test3e4t1w() {
		assertEquals("Verify 3e4t1w", "eeettttw", printerPatternStringNTimes.printCharacterNTimes("3e4t1w"));
	}

	@Test
	public void test10e() {
		assertEquals("Verify 10e", "eeeeeeeeee", printerPatternStringNTimes.printCharacterNTimes("10e"));
	}

	@Test
	public void test1z1b() {
		assertEquals("Verify 1z1b", "zb", printerPatternStringNTimes.printCharacterNTimes("1z1b"));
	}

	@Test
	public void test2er4t2yu() {
		assertEquals("Verify 2er4t2yu", "ererttttyuyu", printerPatternStringNTimes.printCharacterNTimes("2er4t2yu"));
	}

	@Test
	public void test5fu0y() {
		assertEquals("Verify 5fu0y", "fufufufufu", printerPatternStringNTimes.printCharacterNTimes("5fu0y"));
	}

	@Test
	public void test0i() {
		assertEquals("Verify 0i", "", printerPatternStringNTimes.printCharacterNTimes("0i"));
	}
}
