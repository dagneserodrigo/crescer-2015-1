import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

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
    public void orcNasceVivo() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        Status esperado = Status.VIVO;
        Status obtido = umOrc.getStatus();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
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
    public void orcFicaFeridoAoReceberAtaque() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        Status esperado = Status.FERIDO;
        Status resultadoObtido = umOrc.getStatus();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
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
    public void orcToStringAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc("Urukhai");
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
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
    public void orcNasceComNomeInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = "Urukhai";    
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeVazioInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = "";   
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeNuloInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = null; 
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcMorreAposDozeFlechadas() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        Status esperado = Status.MORTO;
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
        Status resultadoObtido = umOrc.getStatus();
        // Assert
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoMenorQueZero() {
        Orc orc = new Orc("Tom");
        orc.recebeAtaque();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoEntre0e100() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado
        orc.setExperiencia(1); // ímpar e menor que 2 para poder manter entre 0 e 100
        orc.recebeAtaque();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 1;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueNormal() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado e elevar ao cubo e não estar nos casos acima.
        orc.recebeAtaque();
        
        int vidaEsperada = 100;
        Status statusEsperado = Status.FERIDO;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(statusEsperado, orc.getStatus());
    }
    
    @Test
    public void orcComNomeRecebeNovoItem() {   
        Orc orc = new Orc("Sauron");
        ItemDoInventario item = new ItemDoInventario( 1, "espada" );
        
        orc.adicionarItem( item );
        
        ArrayList<ItemDoInventario> resultadoEsperado = new ArrayList<ItemDoInventario>();
        resultadoEsperado.add( item );
        
        assertEquals( resultadoEsperado, orc.getItens() );
        
    }
    
    @Test
    public void orcSemNomeRecebeNovoItem() {   
        Orc orc = new Orc();
        ItemDoInventario item = new ItemDoInventario( 1, "espada" );
        
        orc.adicionarItem( item );
        
        ArrayList<ItemDoInventario> resultadoEsperado = new ArrayList<ItemDoInventario>();
        resultadoEsperado.add( item );
        
        assertEquals( resultadoEsperado, orc.getItens() );
        
    }
    
    @Test
    public void orcComNomePerdeItem() {   
        Orc orc = new Orc("Sauron");
        ItemDoInventario espada = new ItemDoInventario( 1, "espada" );
        ItemDoInventario lanca = new ItemDoInventario( 1, "lança" );
        
        orc.adicionarItem( espada );
        orc.adicionarItem( lanca );
        
        orc.perderItem( lanca );
        
        ArrayList<ItemDoInventario> resultadoEsperado = new ArrayList<ItemDoInventario>();
        resultadoEsperado.add( espada );
        
        assertEquals( resultadoEsperado, orc.getItens() );
        
    }
    
    @Test
    public void orcSemNomePerdeItem() {   
        Orc orc = new Orc();
        ItemDoInventario espada = new ItemDoInventario( 1, "espada" );
        ItemDoInventario lanca = new ItemDoInventario( 1, "lança" );
        
        orc.adicionarItem( espada );
        orc.adicionarItem( lanca );
        
        orc.perderItem( lanca );
        
        ArrayList<ItemDoInventario> resultadoEsperado = new ArrayList<ItemDoInventario>();
        resultadoEsperado.add( espada );
        
        assertEquals( resultadoEsperado, orc.getItens() );
        
    }
    
    @Test
    public void listaItensDoOrcComDoisItens() {   
        Orc orc = new Orc();
        ItemDoInventario espada = new ItemDoInventario( 1, "espada" );
        ItemDoInventario lanca = new ItemDoInventario( 1, "lança" );
        
        orc.adicionarItem( espada );
        orc.adicionarItem( lanca );
        
        String resultadoEsperado = "espada, lança";
        
        assertEquals( resultadoEsperado, orc.getDescricoesItens() );
        
    }
    
    @Test
    public void listaItensDoOrcQuandoOOrcNaoTemItens() {   
        Orc orc = new Orc();
        
        String resultadoEsperado = "";
        
        assertEquals( resultadoEsperado, orc.getDescricoesItens() );
        
    }
    
    @Test
    public void orcTentarSorteAumenta1000UnidadesDosItens() {   
        // Arrange
        Orc orc = new Orc("orc");
        orc.setStatus(Status.DORMINDO);
        orc.setExperiencia(3);
        orc.adicionarItem( new ItemDoInventario (3, "espada"));
        orc.adicionarItem( new ItemDoInventario (5, "adaga"));
        // Act
        orc.tentarSorte();
        // Assert
        ItemDoInventario espada = orc.getItens().get(0);
        ItemDoInventario adaga = orc.getItens().get(1);
        assertEquals( 1003, espada.getQuantidade());
        assertEquals( 1005, adaga.getQuantidade());        
    }
    
    @Test
    public void orcTentarSorteNaoFazNada() {
        // Arrange
        Orc urukhai = new Orc();
        urukhai.adicionarItem(new ItemDoInventario(3, "Poção de mana"));
        urukhai.adicionarItem(new ItemDoInventario(1, "Poção Lança"));
        // Act
        urukhai.tentarSorte();
        // Assert
        ItemDoInventario pocao = urukhai.getItens().get(0);
        ItemDoInventario lanca = urukhai.getItens().get(1);
        assertEquals(3, pocao.getQuantidade());
        assertEquals(1, lanca.getQuantidade());
    }
    
    @Test
    public void getItemComMaiorQuantidadeSemItens() {
        // Arrange
        Orc sauron = new Orc("Sauron");
        ItemDoInventario itemEsperado = null;
        // Act
        ItemDoInventario itemObtido = sauron.getItemComMaiorQuantidade();
        // Assert
        assertEquals(itemEsperado, itemObtido);
    }
    
    @Test
    public void getItemComMaiorQuantidadeComUmItem() {
        // Arrange
        Orc sauron = new Orc("Sauron");
        sauron.adicionarItem(new ItemDoInventario(5, "Escudo"));
        ItemDoInventario itemEsperado = sauron.getItens().get(0);
        // Act
        ItemDoInventario itemObtido = sauron.getItemComMaiorQuantidade();
        // Assert
        assertEquals(itemEsperado, itemObtido);
    }
    
    @Test
    public void getItemComMaiorQuantidadeComQuantidadesIguais() {
        // Arrange
        Orc sauron = new Orc("Sauron");
        sauron.adicionarItem(new ItemDoInventario(1, "Lança"));
        sauron.adicionarItem(new ItemDoInventario(1, "Escudo"));
        ItemDoInventario itemEsperado = sauron.getItens().get(0);
        // Act
        ItemDoInventario itemObtido = sauron.getItemComMaiorQuantidade();
        // Assert
        assertEquals(itemEsperado, itemObtido);
    }
    
    @Test
    public void getItemComMaiorQuantidadeComQuantidadesDiferentes() {
        // Arrange
        Orc sauron = new Orc("Sauron");
        sauron.adicionarItem(new ItemDoInventario(34, "Lança"));
        sauron.adicionarItem(new ItemDoInventario(10, "Escudo"));
        sauron.adicionarItem(new ItemDoInventario(1000, "Pedras"));
        ItemDoInventario itemEsperado = sauron.getItens().get(2);
        // Act
        ItemDoInventario itemObtido = sauron.getItemComMaiorQuantidade();
        // Assert
        assertEquals(itemEsperado, itemObtido);
    }
    
    @Test
    public void ordenaItensSemItens() {
        // Arrange
        Orc orc = new Orc();
        String resultadoEsperado = "";
        // Act
        orc.ordernarItens();
        // Assert
        assertEquals(resultadoEsperado, orc.getDescricoesItens());
        
    }
    
    @Test
    public void ordenaItensComUmItem() {
        // Arrange
        ItemDoInventario adaga = new ItemDoInventario( 20, "espada" );
        Orc orc = new Orc();
        orc.adicionarItem( adaga );
        
        ArrayList<ItemDoInventario> itensEsperados = new ArrayList<>();
        itensEsperados.add( adaga );
        // Act
        orc.ordernarItens();
        // Assert
        assertEquals(itensEsperados, orc.getItens());
        
    }
    
    @Test
    public void ordenaItensComDoisItens() {
        // Arrange
        ItemDoInventario segundo = new ItemDoInventario( 20, "segundo" );
        ItemDoInventario primeiro = new ItemDoInventario( 4, "primeiro" );
        Orc orc = new Orc();
        orc.adicionarItem( segundo );
        orc.adicionarItem( primeiro );
        
        String itensEsperados = "primeiro, segundo";
        // Act
        orc.ordernarItens();
        // Assert
        assertEquals(itensEsperados, orc.getDescricoesItens());
        
    }
    
    @Test
    public void ordenaItensComTresItensSendoUmNegativo() {
        // Arrange
        ItemDoInventario terceiro = new ItemDoInventario( 20, "terceiro" );
        ItemDoInventario segundo = new ItemDoInventario( 4, "segundo" );
        ItemDoInventario primeiro = new ItemDoInventario( -5, "primeiro" );
        Orc orc = new Orc();
        orc.adicionarItem( terceiro );
        orc.adicionarItem( segundo );
        orc.adicionarItem( primeiro );
        
        String itensEsperados = "primeiro, segundo, terceiro";
        // Act
        orc.ordernarItens();
        // Assert
        assertEquals(itensEsperados, orc.getDescricoesItens());
        
    }
}




