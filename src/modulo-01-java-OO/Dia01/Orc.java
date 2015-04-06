/**
 * Escreva a descrição da classe Orc aqui.
 * 
 * @author Rodrigo Dagnese
 * @version (número de versão ou data)
 */
public class Orc
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private int life;
    
    {
        life = 110;
    }

    /**
     * Construtor para objetos da classe Orc
     */
    public Orc(String nome)
    {
        this.nome = nome;
    }

    /**
     * Orc recebe flechada e perde 10 pontos de vida
     */
    public void recebeFlechada()
    {
        this.life -= 10;
    }
}
