import java.util.*;
/**
 * Cria exército de Elfos
 * 
 * @author Rodrigo Dagnese
 */
public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercitoDeElfos = new HashMap<>();
    
    public HashMap<String, Elfo> getExercito() {
        return this.exercitoDeElfos;
    }

    /**
     * Alista um Elfo no exército de Elfos.
     * @param umElfo Elfo a ser alistado.
     */
    public void alistarElfo( Elfo umElfo ) {
        boolean podeAlistar = umElfo instanceof ElfoVerde || umElfo instanceof ElfoNoturno;
        if ( podeAlistar ) {
            exercitoDeElfos.put( umElfo.getNome(), umElfo );
        }
    }
    
    /**
     * Busca Elfo usando HashMap
     * @param nome Nome do Elfo a ser buscado.
     */
    public Elfo buscarElfo( String nome ) {
        return exercitoDeElfos.get(nome);
    }
    
    public HashMap<String, Elfo> buscaElfoPeloStatus( Status status ) {
        HashMap<String, Elfo> elfosComMesmoStatus = new HashMap<>();
        
        for ( Elfo elfoAtual : exercitoDeElfos.values() ) {
           if( elfoAtual.getStatus().equals( status ) ){
               elfosComMesmoStatus.put( elfoAtual.getNome(), elfoAtual );
           }
        }
        /*ArrayList<Elfo> elfosComMesmoStatus = new ArrayList<>();
        for (Elfo elfoAtual : exercitoDeElfos.values()) {
            if(elfoAtual.getStatus().equals(status)) {
                elfosComMesmoStatus.add(elfoAtual);
            }
        }*/
        return elfosComMesmoStatus;
    }
        
}
