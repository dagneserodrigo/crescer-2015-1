

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes integrados entre objetos Elfo e Orc
 *
 * @author  Rodrigo Dagnese
 */
public class TestesIntegrados
{
    @Test
    public void umElfoAtiraEmDoisOrcs() {
        // Arange
        Elfo elfo = new Elfo("Legolas");
        Orc firstOrc = new Orc();
        Orc secondOrc = new Orc();
        // Act
        elfo.atirarFlecha(firstOrc);
        elfo.atirarFlecha(secondOrc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        int vidaEsperadaFirstOrc = 100;
        int vidaEsperadaSecondOrc = 100;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperadaFirstOrc, firstOrc.getVida());
        assertEquals(vidaEsperadaSecondOrc, secondOrc.getVida());        
    }
}
