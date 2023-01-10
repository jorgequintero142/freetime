package com.jorge.junit.calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.Date;

import org.junit.Test;

public class AssertTest {

	// Este test debe fallar
	@Test(timeout = 100)
	public void testDate() {
		Date d1 = new Date();
		Date d2 = new Date();
		assertEquals(d1, d2);
	}

	@Test(expected = NullPointerException.class)
	public void nullPointerExpected() {
		String test = null;
		assertEquals("Jorge", test.toString());
	}

	// Este test es exitoso
	@Test
	public void testSame() {
		String s1 = "Hola";
		String s2 = "Hola";
		assertEquals(s1, s2);
	}

	// Este test es exitoso
	@Test
	public void testNotSame() {
		String s1 = new String("Hola");
		String s2 = new String("Hola");
		assertNotSame(s1, s2);
	}
}
