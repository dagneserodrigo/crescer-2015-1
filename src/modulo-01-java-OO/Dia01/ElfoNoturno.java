
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author Rodrigo Dagnese
 */
public class ElfoNoturno extends Elfo
{
    /**
     * Cria um elfo noturno informando nome e quantidade de flechas.
     * 
     * @param nome Nome a ser dado para o Elfo Noturno.
     * @param flechas Quantidades de flechas do Elfo Noturno.
     */
    public ElfoNoturno( String nome, int flechas ){
        super( nome, flechas );
    }
    
    /**
     * Cria um elfo noturno informando nome.
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    public ElfoNoturno(String nome) {
        super( nome);
    }
    
    public void atirarFlecha(Orc umOrc) {
        super.atirarFlecha( umOrc );
        experiencia += 2;
        vida -= (int)(vida * 0.05);
    }
}
