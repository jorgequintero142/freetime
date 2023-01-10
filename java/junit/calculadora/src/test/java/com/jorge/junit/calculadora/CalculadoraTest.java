package com.jorge.junit.calculadora;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jorge.junit.calculadora.calc.Calculadora;

public class CalculadoraTest {
	static Calculadora calculadora;

	@BeforeClass
	public static void ini() {
		calculadora = new Calculadora();
	}

	@Before
	public void setup() {
		calculadora.clear();
	}

	@Test
	public void testSuma() {
		double resultado = calculadora.suma(1, 5);
		double esperado = 6;
		assertEquals(resultado, esperado, 0);

	}

	@Test
	public void testResta() {
		double resultado = calculadora.resta(1, 5);
		double esperado = -4;
		assertEquals(esperado, resultado, 0);
	}

	@Test(expected = IllegalStateException.class)
	public void errorIllegallState() {
		calculadora.dividir(1, 0);
	}

	@Test
	public void testDividir() {
		double resultado = calculadora.dividir(8, 4);
		assertEquals(2, resultado, 0);
	}
}