

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest
{
    @Test
    public void atiraUmaFlechaEGanhaTresDeExperiencia() {
        // Arrange
        ElfoNoturno legolas = new ElfoNoturno("Legolas");
        int flechasEsperadas = 41;
        int experienciaEsperada = 3;
        int vidaEsperada = 95;
        // Act
        legolas.atirarFlecha(new Orc("Sauron"));
        // Assert
        assertEquals(flechasEsperadas, legolas.getFlechas());
        assertEquals(experienciaEsperada, legolas.getExperiencia());
        assertEquals(vidaEsperada, legolas.getVida());
    }
    
    @Test
    public void atiraDuasFlechasGanhaSeisDeExperiencia() {
        // Arrange
        ElfoNoturno legolas = new ElfoNoturno("Legolas");
        Orc sauron = new Orc("Sauron");
        int flechasEsperadas = 40;
        int experienciaEsperada = 6;
        int vidaEsperada = 91;
        // Act
        legolas.atirarFlecha( sauron );
        legolas.atirarFlecha( sauron );
        // Assert
        assertEquals(flechasEsperadas, legolas.getFlechas());
        assertEquals(experienciaEsperada, legolas.getExperiencia());
        assertEquals(vidaEsperada, legolas.getVida());
    }
    
    @Test
    public void atiraCincoFlechasGanhaSeisDeExperiencia() {
        // Arrange
        ElfoNoturno legolas = new ElfoNoturno("Legolas");
        Orc sauron = new Orc("Sauron");
        int flechasEsperadas = 37;
        int experienciaEsperada = 15;
        int vidaEsperada = 79;
        // Act
        legolas.atirarFlecha( sauron );
        legolas.atirarFlecha( sauron );
        legolas.atirarFlecha( sauron );
        legolas.atirarFlecha( sauron );
        legolas.atirarFlecha( sauron );
        // Assert
        assertEquals(flechasEsperadas, legolas.getFlechas());
        assertEquals(experienciaEsperada, legolas.getExperiencia());
        assertEquals(vidaEsperada, legolas.getVida());
    }
}
