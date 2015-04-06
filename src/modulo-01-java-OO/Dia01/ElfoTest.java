

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  Rodrigo Dagnese
 */
public class ElfoTest
{
    @Test
    public void nascimentoElfoDefault() {
        Elfo umElfo;
        umElfo = new Elfo("Celeborn");
        
        assertEquals("Celeborn", umElfo.getNome());
        assertEquals(42, umElfo.getFlechas());
        assertEquals(0, umElfo.getExperiencia());
    }
    
    @Test
    public void nascimentoElfoComOutrosDados() {
        Elfo umElfo;
        umElfo = new Elfo("Celeborn", 44);
        
        assertEquals("Celeborn", umElfo.getNome());
        assertEquals(44, umElfo.getFlechas());
        assertEquals(0, umElfo.getExperiencia());
    }
    
    @Test
    public void atiraUmaFlecha() {
        int flechas = 41;
        int experiencia = 1;

        Elfo umElfo;
        umElfo = new Elfo("Celeborn");
        
        Orc umOrc = new Orc();
        
        umElfo.atirarFlecha(umOrc);
        
        int flechasObtidas = umElfo.getFlechas();
        int experienciaObtida = umElfo.getExperiencia();
        
        assertEquals(flechas, flechasObtidas);
        assertEquals(experiencia, experienciaObtida); 
    }
    
    @Test
    public void atiraVariasFlechas() {
        int flechas = 37;
        int experiencia = 5;

        Elfo umElfo;
        umElfo = new Elfo("Celeborn");
        
        Orc orcOne = new Orc();
        Orc orcTwo = new Orc();
        Orc orcThree = new Orc();
        Orc orcFour = new Orc();
        Orc orcFive = new Orc();
        
        umElfo.atirarFlecha(orcOne);
        umElfo.atirarFlecha(orcTwo);
        umElfo.atirarFlecha(orcThree);
        umElfo.atirarFlecha(orcFour);
        umElfo.atirarFlecha(orcFive);

        int flechasObtidas = umElfo.getFlechas();
        int experienciaObtida = umElfo.getExperiencia();
        
        assertEquals(flechas, flechasObtidas);
        assertEquals(experiencia, experienciaObtida); 
    }
}
