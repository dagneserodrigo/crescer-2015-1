package apis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {
	@Test
	public void getTest() throws Exception {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "primeiro elemento");
		map.put(2, "segundo elemento");
		
		String esperado = "segundo elemento";
		
		assertEquals(esperado, map.get(2));
		
	}
	
	@Test
	public void putTest() throws Exception {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "primeiro elemento");
		map.put(2, "segundo elemento");
		Map<Integer, String> esperado = new HashMap<>();
		esperado.put(1, "primeiro elemento");
		esperado.put(2, "segundo elemento");
		
		assertEquals(esperado, map);
		
	}
	
	@Test
	public void containsKeyTest() throws Exception {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "primeiro elemento");
		map.put(2, "segundo elemento");
		
		assertEquals(true, map.containsKey(1));
		
	}
	
	@Test
	public void containsValueTest() throws Exception {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "primeiro elemento");
		map.put(2, "segundo elemento");
		
		assertEquals(true, map.containsValue("segundo elemento"));
		
	}
}
