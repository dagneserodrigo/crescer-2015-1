import java.util.*;
/**
 * 
 * 
 * @author Rodrigo Dagnese
 * @version (a version number or a date)
 */
public interface EstrategiaDeAtaque
{
    void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs);
    
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
}
