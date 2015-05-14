package filmator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAtor {
	@Test
	public void testeToString() throws Exception {
		Ator ator = new Ator("Ator", 20);
		
		String esperado = "Nome do Ator: Ator idade: 20";
		
		assertEquals(esperado, ator.toString());
	}
}
