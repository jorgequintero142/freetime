package com.jorge.junit.calculadora;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.jorge.junit.calculadora.calc.Calculadora;

import junit.framework.TestCase;

@RunWith(value = Parameterized.class)
public class MiTestCaseTest extends TestCase {

	private final Calculadora calculadora = new Calculadora();

	private double expected;
	private double a;
	private double b;

	@Parameters
	public static List<Object[]> getData() {
		List<Object[]> data = new ArrayList<Object[]>();
		data.add(new Object[] { 1, 2, 1 });
		data.add(new Object[] { 0, 2, 2 });
		data.add(new Object[] { 2, -2, -4 });
		System.out.println("Llamado");
		return data;
	}

	public MiTestCaseTest(double expected, double a, double b) {
		this.a = a;
		this.b = b;
		this.expected = expected;
	}

	// Este metodo se recomienda
	// extraer de esta clase
	@Test
	public void testSuma() {
		System.out.println("testSuma");
		assertEquals(this.getName() + " -->", 1d, calculadora.suma(101, -100), 0);
	}

	@Test
	public void testResta() {
		System.out.println("testResta");
		assertEquals(this.getName() + "-->", this.expected, calculadora.resta(this.a, this.b), 0);
	}
}