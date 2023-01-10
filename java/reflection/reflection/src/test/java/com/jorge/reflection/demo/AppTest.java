package com.jorge.reflection.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import com.jorge.reflection.demo.persona.Persona;

/**
 * Unit test for simple App.
 */

public class AppTest {

	Persona persona;

	@Test
	public void testModificaNameOk() throws Exception {

		persona = new Persona("Jorge", 36);
		String infoOriginal = persona.toString();
		infoOriginal = infoOriginal.replace("Jorge", "Jorge Quintero");

		Field fieldName = persona.getClass().getDeclaredField("name");
		fieldName.setAccessible(true);
		fieldName.set(persona, "Jorge Quintero");

		assertEquals(infoOriginal, persona.showInfo());
	}

	@Test
	public void testModificaNameFail() throws Exception {

		persona = new Persona("Jorge", 36);
		String infoOriginal = persona.toString();
		infoOriginal = infoOriginal.replace("Jorge", "Jorge A, Quintero");

		Field fieldName = persona.getClass().getDeclaredField("name");
		fieldName.setAccessible(true);
		fieldName.set(persona, "Jorge Quintero");

		assertNotEquals(infoOriginal, persona.showInfo());
	}

	@Test
	public void testThrowsException() {
		persona = new Persona("Jorge", 36);
		assertThrows(NoSuchFieldException.class, () -> {
			persona.getClass().getDeclaredField("namew");
		});
	}
}