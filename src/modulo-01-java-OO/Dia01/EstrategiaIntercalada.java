import java.util.*;

public class EstrategiaIntercalada implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    public void atacarOrcs( ArrayList<Elfo> elfos, ArrayList<Orc> orcs ) {
        boolean exercitoProporcional;
        int contElfoVerde = 0, contElfoNoturno = 0;
        for ( Elfo elfo : elfos ) {
            if ( elfo instanceof ElfoVerde ) {
                contElfoVerde++;
            } else if ( elfo instanceof ElfoNoturno ) {
                contElfoNoturno++;
            }
        }
        
        exercitoProporcional = contElfoVerde == contElfoNoturno;
        
        if( exercitoProporcional ) {
            this.intercalar( elfos );
            
            for ( Elfo elfo : elfos ) {
                for ( Orc orc : orcs ) {
                    elfo.atirarFlecha(orc);
                }
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemAtaque;
    }
    
    /*private ArrayList<Elfo> ordenaElfos( ArrayList<Elfo> elfos ) {
        boolean posicoesSendoTrocadas = true;
        
        while (posicoesSendoTrocadas) {
            posicoesSendoTrocadas = false;
            for (int j = 0; j < elfos.size() - 1; j++) {
                Elfo elfoAtual = elfos.get(j);
                Elfo elfoProximo = elfos.get(j + 1);
                
                boolean precisaTrocar = elfoAtual instanceof ElfoVerde && elfoProximo instanceof ElfoVerde;
                
                if (precisaTrocar) {
                    elfos.set(j, elfoProximo);
                    elfos.set(j + 1, elfoAtual);
                    posicoesSendoTrocadas = true;
                }
            }
        }*/
        
    private void intercalar(ArrayList<Elfo> elfos) {     
    
        Elfo primeiroElfo = elfos.get(0);
        ordemAtaque.add(primeiroElfo);
        Class classeDoUltimoAdicionado = primeiroElfo.getClass();
        elfos.remove(primeiroElfo);
    
        while (elfos.size() > 0) {
            for (int j = 0; j < elfos.size(); j++) {
                Elfo elfoAtual = elfos.get(j);
                boolean estáIntercalado = elfoAtual.getClass() != classeDoUltimoAdicionado;
                
                if (estáIntercalado) {
                    ordemAtaque.add(elfoAtual);
                    classeDoUltimoAdicionado = elfoAtual.getClass();
                    elfos.remove(elfoAtual);
                }
            }
        }
    }
}
