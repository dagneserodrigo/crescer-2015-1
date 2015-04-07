
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
    public void elfoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        Elfo elfo = new Elfo("um nome qualquer");
        // Assert
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc("Orc");
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 1;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc("Orc");
        // Act
        elfo.atirarFlecha(orc);
        String resultadoObtido = elfo.toString();
        // Assert
        String resultadoEsperado = "Legolas possui 41 flechas e 1 nível de experiência.";
        
        assertEquals(resultadoEsperado, resultadoObtido);
        
    }
    
    @Test
    public void elfoToStringRetornaInformacaoAposAtirarVariasFlechas() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc oneOrc   = new Orc("Orc");
        Orc twoOrc   = new Orc("Orc");
        Orc threeOrc = new Orc("Orc");
        Orc fourOrc  = new Orc("Orc");
        Orc fiveOrc  = new Orc("Orc");
        Orc sixOrc   = new Orc("Orc");
        Orc sevenOrc = new Orc("Orc");
        Orc eigthOrc = new Orc("Orc");
        Orc nineOrc  = new Orc("Orc");
        Orc tenOrc   = new Orc("Orc");
        // Act
        elfo.atirarFlecha(oneOrc);
        elfo.atirarFlecha(twoOrc);
        elfo.atirarFlecha(threeOrc);
        elfo.atirarFlecha(fourOrc);
        elfo.atirarFlecha(fiveOrc);
        elfo.atirarFlecha(sixOrc);
        elfo.atirarFlecha(sevenOrc);
        elfo.atirarFlecha(eigthOrc);
        elfo.atirarFlecha(nineOrc);
        elfo.atirarFlecha(tenOrc);
        
        String resultadoObtido = elfo.toString();
        // Assert
        String resultadoEsperado = "Legolas possui 32 flechas e 10 níveis de experiência.";
        
        assertEquals(resultadoEsperado, resultadoObtido);
        
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas", 4);
        Orc orc = new Orc("Orc");
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 5;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoToStringPadrao() {
        // Arrange
        Elfo elfo = new Elfo("Faustão");
        String resultadoEsperado = "Faustão possui 42 flechas e 0 níveis de experiência.";
        // Act
        String resultadoObtido = elfo.toString();
        // Assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }  
}
