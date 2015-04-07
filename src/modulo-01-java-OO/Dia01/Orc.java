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
    private int experiencia;
    private Status status;
    private double numeroGerado;
    
    
    {
        status = Status.VIVO;
        life = 110;
        numeroGerado = 0.0;
    }

    /**
     * Construtor para objetos da classe Orc
     */
    public Orc( String nome) {
        this.nome = nome;
    }

    /**
     * Orc recebe flechada e perde 10 pontos de vida
     */
    public void recebeAtaque()
    {
        double numero = this.gerarNumero();
        
        if( numero < 0 ) {
            this.experiencia += 2;
        } else if ( numero > 0 && numero < 100 ){
            
        } else {
            this.life -= 10;
        }
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
    
    private double gerarNumero() {
        
       if ( this.nome.length() > 5 ) 
            this.numeroGerado += 65.0;
        else
            this.numeroGerado -= 60.0;

       if ( this.life > 30 && this.life < 60 )
           this.numeroGerado = this.numeroGerado * 2;
       else if ( this.life < 20 )
           this.numeroGerado = this.numeroGerado * 3;

       if ( this.status == Status.FUGINDO )
           this.numeroGerado = this.numeroGerado / 2;
       else if( this.status == Status.CACANDO || this.status == Status.DORMINDO)
           this.numeroGerado += 1.0;

       if ( this.experiencia % 2 == 0 )
           this.numeroGerado = Math.pow(this.numeroGerado, 3);
       else if ( this.experiencia % 3 == 0 && this.experiencia > 2 )
           this.numeroGerado = Math.pow(this.numeroGerado, 2);
            
       return this.numeroGerado;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public double getNumeroGerado() {
        return this.numeroGerado;
    }
}
