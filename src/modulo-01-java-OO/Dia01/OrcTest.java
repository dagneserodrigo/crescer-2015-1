

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class OrcTest
{
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc("Orc");
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcComNomeMenorQueCincoLetrasRecebeAtaque() {
        Orc umOrc;
        umOrc = new Orc("Orc");
        int esperado = 110;

        umOrc.recebeAtaque();
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
   
    @Test
    public void orcComNomeMenorQueCincoLetrasRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Orc");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();

        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcComNomeMenorQueCincoLetrasRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Orc");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcComNomeMenorQueCincoLetrasRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Orc");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcComNomeMaiorQueCincoLetrasRecebeAtaque() {
        Orc umOrc;
        umOrc = new Orc("NomeOrc");
        int esperado = 100;

        umOrc.recebeAtaque();
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcComNomeMaiorQueCincoLetrasRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("NomeOrc");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();

        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcComNomeMaiorQueCincoLetrasRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("NomeOrc");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcComNomeMaiorQueCincoLetrasRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("NomeOrc");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 0;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcComNomeMenorQueCincoLetrasEStatusDormindoRecebeAtaque() {
         // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Orc");
        // Act
        umOrc.setStatus(Status.DORMINDO);
        umOrc.recebeAtaque();

        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcComNomeMaiorQueCincoLetrasEStatusDormindoRecebeAtaque() {
         // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Sauron");
        // Act
        umOrc.setStatus(Status.DORMINDO);
        umOrc.recebeAtaque();

        // Assert - Verificação
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }

    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc("Orc");
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringComNomeMenorQueCincoLetrasAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc("Orc");
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringComNomeMenorQueCincoLetrasAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Orc");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringComNomeMaiorQueCincoLetrasAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc("NomeOrc");
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringComNomeMatiorQueCincoLetrasAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("NoemOrc");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        // Assert
        String esperado = "Vida atual: 0";
        assertEquals(esperado, resultadoObtido);
    }

    @Test
    public void orcComNomeMenorQueCincoCaracteresEExperienciaParRecebeAtaque() {
        // Arrange
        Orc orc = new Orc("Orc");
        // Act
        orc.setExperiencia(2);
        orc.recebeAtaque();
        
        // Assert
        int vidaEsperada = 110;
        
        assertEquals( vidaEsperada, orc.getVida());
    }
    
    @Test
    public void orcComNomeMaiorQueCincoCaracteresEExperienciaParRecebeAtaque() {
        // Arrange
        Orc orc = new Orc("NomeOrcMaior");
        // Act
        orc.setExperiencia(2);
        orc.recebeAtaque();
        
        // Assert
        int vidaEsperada = 100;
        
        assertEquals( vidaEsperada, orc.getVida());
    }
    
}




