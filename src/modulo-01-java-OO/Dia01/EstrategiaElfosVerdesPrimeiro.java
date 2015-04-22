import java.util.*;

public class EstrategiaElfosVerdesPrimeiro implements EstrategiaDeAtaque {
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    public void atacarOrcs( ArrayList<Elfo> elfos, ArrayList<Orc> orcs ) {
        this.ordenaElfos( elfos );
        
        for ( Elfo elfo : elfos ) {
            ordemAtaque.add(elfo);
            for ( Orc orc : orcs ) {
                elfo.atirarFlecha(orc);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemAtaque;
    }
    
    private ArrayList<Elfo> ordenaElfos( ArrayList<Elfo> elfos ) {
        boolean posicoesSendoTrocadas = true;
        
        while (posicoesSendoTrocadas) {
            posicoesSendoTrocadas = false;
            for (int j = 0; j < elfos.size() - 1; j++) {
                Elfo elfoAtual = elfos.get(j);
                Elfo elfoProximo = elfos.get(j + 1);
                
                boolean precisaTrocar = 
                    elfoAtual instanceof ElfoNoturno && elfoProximo instanceof ElfoVerde;
                
                if (precisaTrocar) {
                    elfos.set(j, elfoProximo);
                    elfos.set(j + 1, elfoAtual);
                    posicoesSendoTrocadas = true;
                }
            }
        }
        
        return elfos;
    }
}
