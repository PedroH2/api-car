package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.demo.operation.Operation;

//@SpringBootTest
public class JobsApplicationTests {
	@Rule
	public ExpectedException expectedExecption = ExpectedException.none();

	@Test//(expected=Exception.class)
	public void divisaoPorZero() throws Exception {
		expectedExecption.expectMessage("Não é possivel dividir ");
		expectedExecption.expect(Exception.class);
		Operation ope = new Operation();
		ope.div(10, 0);
		assertEquals(1, 1);
	}
	@Test
	public void somaTeste()  {
		Operation ope = new Operation();
		double result = ope.soma(0,95);
	}
	@Test
	public void testeEsperandoExcecaodeDivPorZero(){
		try {
			Operation ope = new Operation();
			ope.div(24, 0);
			fail("Deveria ter lançado uma exceção de div por zero");
		} catch (Exception e) {
			assertEquals("Não é possivel dividir por zero", e.getMessage());
		}
	}
}
