import java.util.*;
/**
 * Define uma estratégia de ataque.
 * 
 * Rodrigo Dagnese 
 */
public class EstrategiaNormal implements EstrategiaDeAtaque {
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        System.out.println("Estratégia normal...");
        
        for ( Elfo elfo : elfos ) {
            for ( Orc orc : orcs ) {
                elfo.atirarFlecha(orc);
            }
        }
    }

}
