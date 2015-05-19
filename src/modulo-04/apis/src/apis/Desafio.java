package apis;

import java.util.ArrayList;

public class Desafio {
	
	public static int[] indiceMaiusculas(String string) {
		List<Integer> posicoes = new ArrayList<>();
		int contPosicoes = 0;
		for (int i = 0; i < string.length(); i++) {
		    char letra = string.charAt(i);
		    if(Character.isUpperCase(letra)) {
		    	posicoes[contPosicoes] = i;
		    	contPosicoes++;
		    }
		}
		
		return posicoes;
	}
}

