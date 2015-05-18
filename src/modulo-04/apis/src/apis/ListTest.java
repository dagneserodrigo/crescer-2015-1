package apis;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {
	
	@Test
	public void addTest() throws Exception {
		List<String> lista = new ArrayList<String>();
		lista.add("teste");
		lista.add("teste add");
		String esperado = "teste add";
		
		assertEquals(esperado, lista.get(1));
	}
	
	@Test
	public void containsTest() throws Exception {
		List<String> lista = new ArrayList<String>();
		lista.add("teste");
		
		assertEquals(true, lista.contains("teste"));
	}
	
	@Test
	public void getTest() throws Exception {
		List<String> lista = new ArrayList<String>();
		lista.add("teste");
		String esperado = "teste";
		
		assertEquals(esperado, lista.get(0));
	}
	
	@Test
	public void sizeTest() throws Exception {
		List<String> lista = new ArrayList<String>();
		lista.add("teste");
		
		assertEquals(1, lista.size());
	}
	
	@Test
	public void isEmptyTest() throws Exception {
		List<String> lista = new ArrayList<String>();
		lista.add("teste");
		String esperado = "teste";
		
		assertEquals(false, lista.isEmpty());
	}
	
	@Test
	public void setTest() throws Exception {
		List<String> lista = new ArrayList<String>();
		lista.add("teste");
		lista.add("teste");
		List<String> esperado = new ArrayList<String>();
		esperado.add("teste");
		esperado.add("outroTeste");
		
		lista.set(1, "outroTeste");
		
		assertEquals(esperado, lista);
	}
	
	@Test
	public void indexOfTest() throws Exception {
		List<String> lista = new ArrayList<String>();
		lista.add("teste");
		lista.add("outroTeste");
		int esperado = 1;

		assertEquals(esperado, lista.indexOf("outroTeste"));
	}
}
