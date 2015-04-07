/**
 * Escreva a descrição da classe Orc aqui.
 * 
 * @author Rodrigo Dagnese
 * @version (número de versão ou data)
 */
public class Orc
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int life;
    
    {
        life = 110;
    }

    /**
     * Construtor para objetos da classe Orc
     */
    public Orc()
    {
    }

    /**
     * Orc recebe flechada e perde 10 pontos de vida
     */
    public void recebeAtaque()
    {
        this.life -= 10;
    }
    
    public int getVida() {
        return this.life;
    }
    
    
    /**
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc. Ex:
     * "Vida atual: 110"
     */
    public String toString() {
        return "Vida atual: " + this.life;
    }
}
