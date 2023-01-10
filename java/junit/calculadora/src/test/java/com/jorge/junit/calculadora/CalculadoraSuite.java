package com.jorge.junit.calculadora;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses({ AssertTest.class, CalculadoraTest.class, CalculadoraParamTest.class })
public class CalculadoraSuite {
}