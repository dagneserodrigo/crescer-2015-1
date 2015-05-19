package test;

import static org.junit.Assert.*;

import org.junit.Test;

import apis.Desafio;

public class DesafioTest {
	@Test
	public void testIndexMaiusculas() throws Exception {
		Desafio desafio = new Desafio();
		
		int[] esperado = new int[5];
		esperado[0] = 0;
		esperado[1] = 2;
		esperado[2] = 4;
		
		assertArrayEquals(esperado, desafio.indiceMaiusculas("TeStE"));
	}
	
	@Test
	public void testIndexMaiusculasComPontuacao() throws Exception {	
		int[] esperado = new int[6];
		esperado[0] = 0;
		esperado[1] = 2;
		esperado[2] = 4;
		
		assertArrayEquals(esperado, indiceMaiusculas("TeStE!"));
	}

}
