package com.jorge.reflection.demo;

import com.jorge.reflection.demo.persona.Persona;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Persona p = new Persona("Jorge", 36);
		System.out.println(p.showInfo());

	}
}
