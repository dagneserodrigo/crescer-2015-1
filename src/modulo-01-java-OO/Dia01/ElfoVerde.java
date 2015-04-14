import java.util.*;
/**
 * Define os objetos ElfoVerde
 * 
 * @author Rodrigo Dagnese
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{
    /**
     * Cria um elfo verde informando nome.
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    public ElfoVerde( String nome, int flechas ){
        super( nome, flechas );
    }

    public ElfoVerde(String nome) {
        super( nome);
    }

    /**
     * Atira uma flecha, perde uma unidade e ganha o dobro de exp.
     * 
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atirarFlecha(Orc umOrc) {
        super.atirarFlecha(umOrc);
        experiencia++;
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
    
    public String toString() {
        return "Elfo Verde: " + super.toString();
    }
}
