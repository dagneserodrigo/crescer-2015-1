package apis;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {

	@Test
	public void charAtTest() throws Exception {
		String frase = "teste indexOf";
		char esperado = 't';
		
		assertEquals(esperado, frase.charAt(0));
	}
	
	@Test
	public void startsWithTest() throws Exception {
		String frase = "teste";
		
		assertEquals(true, frase.startsWith("t"));
	}
	
	@Test
	public void endsWithTest() throws Exception {
		String frase = "teste";
		
		assertEquals(true, frase.endsWith("e"));
	}
	
	@Test
	public void containsTest() throws Exception {
		String frase = "teste";
		
		assertEquals(true, frase.contains("est"));
	}
	
	@Test
	public void compareOfTest() throws Exception {
		String frase = "teste";
		int esperado = 0;
		
		int resultado = frase.compareTo("teste");
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void indexOfTest() throws Exception {
		String frase = "teste indexOf";
		int esperado = 0;
		
		assertEquals(esperado, frase.indexOf('t'));
	}
	
	@Test
	public void upperCaseTest() throws Exception {
		String frase = "teste";

		assertEquals("TESTE", frase.toUpperCase());
	}
	
	@Test
	public void lowerCaseTest() throws Exception {
		String frase = "TESTE";

		assertEquals("teste", frase.toLowerCase());
	}
	
	@Test
	public void lengthTest() throws Exception {
		String frase = "teste";

		assertEquals(5, frase.length());
	}
	
	@Test
	public void replaceTest() throws Exception {
		String frase = "aBC";
		String esperado = "ABC";
		
		assertEquals(esperado, frase.replace('a', 'A'));	
	}
	
	@Test
	public void replaceFirstTest() throws Exception {
		String frase = "aBC";
		String esperado = "ABC";
		
		assertEquals(esperado, frase.replaceFirst("a", "A"));	
	}
	
	@Test
	public void splitTest() throws Exception {
		String frase = "ABC";
		String[] esperado = {"A", "B", "C"};
		
		assertArrayEquals(esperado, frase.split(""));
	}

	@Test
	public void trimTest() throws Exception {
		String frase = " A B C ";
		String esperado = "A B C";
		
		assertEquals(esperado, frase.trim());
	}
	
	@Test
	public void subStringTest() throws Exception {
		String frase = "teste";
		String esperado = "est";
		
		assertEquals(esperado, frase.substring(1, 4));
	}
}
