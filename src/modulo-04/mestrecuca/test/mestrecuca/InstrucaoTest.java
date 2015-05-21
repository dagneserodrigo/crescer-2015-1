package mestrecuca;

import static org.junit.Assert.*;
import mestrecuca.Instrucao;

import org.junit.Test;

public class InstrucaoTest {
	@Test
	public void criarInstrucao() throws Exception {
		Instrucao modoPreparo = new Instrucao("Desc");
		
		String esperado = "Desc";
		
		assertEquals(esperado, modoPreparo.getInstrucao());
	}
}
