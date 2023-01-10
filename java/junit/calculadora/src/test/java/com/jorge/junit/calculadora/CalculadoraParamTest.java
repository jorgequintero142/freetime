package com.jorge.junit.calculadora;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.jorge.junit.calculadora.calc.Calculadora;

@RunWith(value = Parameterized.class)
public class CalculadoraParamTest {

	Calculadora calculadora;
	private double a;
	private double b;
	private double expected;

	@Parameters
	public static List<Object[]> getData() {
//		List<Object[]> data = new ArrayList<Object[]>();
//		data.add(new Object[] { 1, 2, 3 });
//		data.add(new Object[] { -1, -4, -5 });
//		data.add(new Object[] { 7, -2, 5 });
//		data.add(new Object[] { -7, 4, -5 });
//		data.add(new Object[] { 6, 2, 8 });

		return Arrays.asList(new Object[] { 0, 5, 5 }, new Object[] { -10, -5, -15 }, new Object[] { 1, 5, 6 },
				new Object[] { 7, -9, -2 });
	}

	public CalculadoraParamTest(double a, double b, double expected) {
		this.a = a;
		this.b = b;
		this.expected = expected;
	}

	@Before
	public void setup() {
		calculadora = new Calculadora();
	}

	@Test
	public void testSuma() {
		double resultado = calculadora.suma(this.a, this.b);
		assertEquals(this.expected, resultado, 0.0);
	}
}