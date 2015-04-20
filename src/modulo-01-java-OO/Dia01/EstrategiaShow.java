import java.util.*;

/**
 * Define uma estratégia de ataque.
 * 
 * @author Rodrigo Dagnese
 */
public class EstrategiaShow implements EstrategiaDeAtaque {
    public void atacarOrcs( ArrayList<Elfo> elfos, ArrayList<Orc> orcs ) {

        int quantidadeAtaques = elfos.size() * orcs.size();
        int limiteElfosNoturnos = (int) (quantidadeAtaques * 0.3);
        int quantidadeAtaquesElfosNoturnos = 0;
        
        for( Elfo elfo : elfos) {
            boolean eElfoNoturno = elfo instanceof ElfoNoturno;
            
            if ( eElfoNoturno) {
                if ( quantidadeAtaquesElfosNoturnos >= limiteElfosNoturnos )
                    continue;
                quantidadeAtaquesElfosNoturnos++;
            }

            for (Orc orc : orcs) {
                elfo.atirarFlecha(orc);
            }
        }
    }
}
