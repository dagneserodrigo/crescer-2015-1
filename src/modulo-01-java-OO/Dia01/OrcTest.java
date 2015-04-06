

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
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaque() {
        Orc umOrc;
        umOrc = new Orc();
        int esperado = 100;

        umOrc.recebeFlechada();
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }

    @Test
    public void orcRecebeVariosAtaques() {
        int resultadoObtido = 0;
        
        Orc umOrc;
        umOrc = new Orc();
        int esperado = (umOrc.getVida() - (5000 * 10));
        
        for(int i = 0; i < 5000; i++) {
            umOrc.recebeFlechada();
            resultadoObtido = umOrc.getVida();
        }
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc();
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringRetornaVidaAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc();
        // Act
        orc.recebeFlechada();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100";
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringRetornaVidaAposReceberVariosAtaques() {
        // Arrange
        Orc orc = new Orc();
        // Act
        orc.recebeFlechada();
        orc.recebeFlechada();
        orc.recebeFlechada();
        orc.recebeFlechada();
        orc.recebeFlechada();
        orc.recebeFlechada();
        orc.recebeFlechada();
        orc.recebeFlechada();
        orc.recebeFlechada();
        orc.recebeFlechada();
        orc.recebeFlechada();
        orc.recebeFlechada();
        
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: -10";
        
        assertEquals(esperado, resultadoObtido);
    }
}





