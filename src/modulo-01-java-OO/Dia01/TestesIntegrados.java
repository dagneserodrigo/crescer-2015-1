
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes integrados entre objetos Elfo e Orc.
 *
 * @author  CWI Software
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
        int vidaEsperadaOrc = 100;
        String toStringEsperadoOrc = "Vida atual: 100";
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperadaOrc, firstOrc.getVida());
        assertEquals(vidaEsperadaOrc, secondOrc.getVida());
        assertEquals(toStringEsperadoOrc, firstOrc.toString());
        assertEquals(toStringEsperadoOrc, secondOrc.toString());        
    }

}
