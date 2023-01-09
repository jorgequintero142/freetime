package com.jorge.junit.calculadora.calc;

public class Calculadora {

	private double ans;

	public Calculadora() {
		ans = 0;
	}

	public double suma(double a, double b) {
		ans = a + b;
		return ans;
	}

	public double resta(double a, double b) {
		ans = a - b;
		return ans;
	}

	public double suma(double a) {
		ans += a;
		return ans;
	}

	public double resta(double a) {
		ans -= a;
		return ans;
	}

	public double ans() {
		return ans;
	}

	public void clear() {
		ans = 0;
	}

	public double dividir(double a, double b) {
		if (b == 0) {
			throw new IllegalStateException("No es posible dividir por cero.");
		}
		ans = a / b;
		return ans;
	}
}
