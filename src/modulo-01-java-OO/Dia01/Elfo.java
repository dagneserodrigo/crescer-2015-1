
/**
 * Define objetos Elfo
 * 
 * @author CWI Software
 */
public class Elfo
{
    // Versão correção do tema!!
    
    private String nome;
    private int flechas, experiencia;

    // type initializer
    {
        flechas = 42;
    }
    
    /**
     * Cria objetos Elfo
     * 
     * @param umNome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    public Elfo(String umNome, int flechas)
    {
        this(umNome);
        // this.nome = nome;
        this.flechas = flechas;
    }
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    /**
     * Atira uma flecha e perde uma unidade.
     * 
     * @param orcAtingido Orc que receberá o ataque.
     */
    public void atirarFlecha(Orc orcAtingido) {
        flechas--;
        experiencia++;
        orcAtingido.recebeFlechada();
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        String textoFlechas =  this.flechas > 1 ? this.flechas + " flechas" : this.flechas + " flecha";
        String textoExperiencia =  this.experiencia == 1 ? this.experiencia + " nível" : this.experiencia + " níveis";
        
        //return  this.nome + " possui " + textoFlechas + " e " + textoExperiencia + " de experiência";
        builder.append(this.nome);
        builder.append(" possui ");
        builder.append(textoFlechas);
        builder.append(" e ");
        builder.append(textoExperiencia);
        builder.append(" de experiência.");
        
        return builder.toString();
        
    }
    
    
    
    
    
    
}
