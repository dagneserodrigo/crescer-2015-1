import java.util.*;
/**
 * Cria exército de Elfos
 * 
 * @author Rodrigo Dagnese
 */
public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercitoDeElfos = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> porStatus = new HashMap<>();
    private EstrategiaDeAtaque  estrategia = new EstrategiaNormal();
    
    public HashMap<String, Elfo> getExercito() {
        return this.exercitoDeElfos;
    }

    public HashMap<Status, ArrayList<Elfo>> getExercitoPorStatus() {
        return this.porStatus;
    }

    /**
     * Alista um Elfo no exército de Elfos.
     * @param umElfo Elfo a ser alistado.
     */
    public void alistarElfo( Elfo umElfo ) throws NaoPodeAlistarException {
        boolean podeAlistar = umElfo instanceof ElfoVerde || umElfo instanceof ElfoNoturno;
        if ( podeAlistar ) {
            exercitoDeElfos.put( umElfo.getNome(), umElfo );
        } else {
            throw new NaoPodeAlistarException();
        }
    }

    /**
     * Busca Elfo usando HashMap
     * @param nome Nome do Elfo a ser buscado.
     */
    public Elfo buscarElfo( String nome ) {
        return exercitoDeElfos.get(nome);
    }

    /**
     * Agrupa Elfos pelo Status.
     */
    public void agruparElfoPeloStatus() {
        porStatus.clear();
        
        for (Map.Entry<String, Elfo> parChaveValor : exercitoDeElfos.entrySet()) {
            Elfo elfo = parChaveValor.getValue();
            Status status = elfo.getStatus();
            if (porStatus.containsKey(status)) {
                porStatus.get(status).add(elfo);
            } else {
                porStatus.put(status, new ArrayList<>(
                    Arrays.asList(elfo)
                ));
                
            }
            
        }
        
        /*HashMap<String, Elfo> elfosComMesmoStatus = new HashMap<>(); 
        for ( Elfo elfoAtual : exercitoDeElfos.values() ) {
           if( elfoAtual.getStatus().equals( status ) ){
               elfosComMesmoStatus.put( elfoAtual.getNome(), elfoAtual );
           }
        }*/
        /*ArrayList<Elfo> elfosComMesmoStatus = new ArrayList<>();
        for (Elfo elfoAtual : exercitoDeElfos.values()) {
            if(elfoAtual.getStatus().equals(status)) {
                elfosComMesmoStatus.add(elfoAtual);
            }
        }*/
        //return elfosComMesmoStatus;
    }
    /**
     * Busca Elfos pelo Status
     */
    public ArrayList<Elfo> buscarElfoPorStatus(Status status) {
        agruparElfoPeloStatus();
        return porStatus.get( status );
    }
    
    public void atacarHorda( ArrayList<Orc> orcs ) {
        ArrayList<Elfo> elfosQueVaoAtacar = buscarElfoPorStatus(Status.VIVO);
        
        estrategia.atacarOrcs( elfosQueVaoAtacar, orcs );
    }

}
