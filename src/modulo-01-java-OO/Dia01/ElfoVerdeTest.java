
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoVerdeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoVerdeTest
{
    @Test
    public void atiraUmaFlechaEGanhaDoisDeExperiencia() {
        // Arrange
        ElfoVerde legolas = new ElfoVerde("Legolas");
        int flechasEsperadas = 41;
        int experienciaEsperada = 2;
        // Act
        legolas.atirarFlecha( new Orc("Sauron") );
        // Assert
        assertEquals(flechasEsperadas, legolas.getFlechas());
        assertEquals(experienciaEsperada, legolas.getExperiencia());
    }

    @Test
    public void atiraDuasFlechaEGanhaDoisDeExperiencia() {
        // Arrange
        ElfoVerde legolas = new ElfoVerde("Legolas");
        Orc sauron = new Orc("Sauron");
        int flechasEsperadas = 40;
        int experienciaEsperada = 4;
        // Act
        legolas.atirarFlecha( sauron );
        legolas.atirarFlecha( sauron );
        // Assert
        assertEquals(flechasEsperadas, legolas.getFlechas());
        assertEquals(experienciaEsperada, legolas.getExperiencia());
    }

    @Test
    public void recebeUmItemValido() {
        // Arrange
        ElfoVerde legolas = new ElfoVerde("Legolas");
        
        String resultadoEsperado = "Arco e flecha de vidro";
        // Act
        legolas.adicionarItem(new ItemDoInventario(34, "Arco e flecha de vidro"));
        // Assert
        assertEquals(resultadoEsperado, legolas.getDescricoesItens());
    }

    @Test
    public void recebeOsDoisItensValidos() {
        // Arrange
        ElfoVerde legolas = new ElfoVerde("Legolas");
        
        String resultadoEsperado = "Espada de aço valiriano,Arco e flecha de vidro";
        // Act
        legolas.adicionarItem(new ItemDoInventario(97, "Espada de aço valiriano"));
        legolas.adicionarItem(new ItemDoInventario(1, "Arco e flecha de vidro"));
        // Assert
        assertEquals(resultadoEsperado, legolas.getDescricoesItens());
    }
    
    @Test
    public void recebeUmItemValidoEOutroItemInvalido() {
        // Arrange
        ElfoVerde legolas = new ElfoVerde("Legolas");
        
        String resultadoEsperado = "Espada de aço valiriano";
        // Act
        legolas.adicionarItem(new ItemDoInventario(34, "Espada de aço valiriano"));
        legolas.adicionarItem(new ItemDoInventario(13, "Nerf retaliator"));
        // Assert
        assertEquals(resultadoEsperado, legolas.getDescricoesItens());
    }
    
    @Test
    public void naoRecebeItemValido() {
        // Arrange
        ElfoVerde legolas = new ElfoVerde("Legolas");
        
        String resultadoEsperado = "";
        // Act
        legolas.adicionarItem(new ItemDoInventario(34, "Espada de aço inox"));
        legolas.adicionarItem(new ItemDoInventario(34, "Arco e flecha de plástico"));
        // Assert
        assertEquals(resultadoEsperado, legolas.getDescricoesItens());
    }
}
