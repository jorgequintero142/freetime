package com.jorge.reflection.demo.persona;

public class Persona {
	private final String name;
	private int edad;

	public Persona(String name, int edad) {
		this.name = name;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [name=" + name + ", edad=" + edad + "]";
	}

	public String showInfo() {
		return this.toString();
	}
}