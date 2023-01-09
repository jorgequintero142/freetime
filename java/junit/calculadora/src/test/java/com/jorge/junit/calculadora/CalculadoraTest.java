package com.jorge.junit.calculadora;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jorge.junit.calculadora.calc.Calculadora;

public class CalculadoraTest {
	Calculadora calculadora;

	@Before
	public void setup() {
		calculadora = new Calculadora();
		System.out.println("before..");
	}

	@After
	public void clear() {
		calculadora.clear();
		System.out.println("after..");
	}

	@Test
	public void testSuma() {
		double resultado = calculadora.suma(1, 5);
		double esperado = 6;
		assertEquals(resultado, esperado, 0);
		System.out.println("suma..");
	}

	@Test
	public void testResta() {
		double resultado = calculadora.resta(1, 5);
		double esperado = -4;
		assertEquals(esperado, resultado, 0);
		System.out.println("resta..");
	}

	@Test(expected = IllegalStateException.class)
	public void errorIllegallState() {
		System.out.println("errorIllegallState..");
		calculadora.dividir(1, 0);
	}
	
	@Test
	public void testDividir() {
		System.out.println("dividir2..");
		
		double resultado = calculadora.dividir(8, 4);
		assertEquals(2,resultado, 0);
	}
}