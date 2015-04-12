import java.util.*;
/**
 * Define os objetos ElfoVerde
 * 
 * @author Rodrigo Dagnese
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{
    private int flechas;

    // type initializer
    {
        flechas = 42;
    }
    
    /**
     * Cria objetos ElfoVerde
     * 
     * @param umNome Nome que o elfo verde receberá
     * @param flechas Quantidade inicial de flechas
     */
    public ElfoVerde(String umNome, int flechas) {
        this(umNome);
        // this.nome = nome;
        this.flechas = flechas;
    }
    
    /**
     * Cria um elfo verde informando nome.
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    public ElfoVerde(String nome) {
        super( nome, 0);
    }

    /**
     * Atira uma flecha, perde uma unidade e ganha o dobro de exp.
     * 
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atirarFlecha(Orc umOrc) {
        flechas--;
        experiencia += 2;
        umOrc.recebeAtaque();
    }
    
    /**
     * Adiciona um item ao inventário.
     * 
     * @param item Item a ser adicionado.
     */
    public void adicionarItem(ItemDoInventario item) {
        String itemAtribuido = item.getDescricao().toLowerCase();
        if (itemAtribuido.equals("espada de aço valiriano" )|| itemAtribuido.equals("arco e flecha de vidro"))
            this.itens.add(item);
    }
}
