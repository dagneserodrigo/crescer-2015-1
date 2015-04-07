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
    
    
    {
        status = Status.VIVO;
        life = 110;
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
        if ( this.life > 0 ) {
            double numero = this.gerarNumero();

            if( numero < 0 ) {
                this.experiencia += 2;
            } else if ( numero > 100 ){
                this.status = Status.FERIDO;
                this.life -= 10;
            }
        } else {
            this.status = Status.MORTO;
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
       double numeroGerado = 0.0;

       if ( this.nome.length() > 5 ) 
            numeroGerado += 65.0;
        else
            numeroGerado -= 60.0;

       if ( this.life > 30 && this.life < 60 )
           numeroGerado *= 2;
       else if ( this.life < 20 )
           numeroGerado *= 3;

       if ( this.status == Status.FUGINDO )
           numeroGerado /= 2;
       else if( this.status == Status.CACANDO || this.status == Status.DORMINDO)
           numeroGerado ++;

       if ( this.experiencia % 2 == 0 )
           numeroGerado = Math.pow(numeroGerado, 3);
       else if ( this.experiencia % 3 == 0 && this.experiencia > 2 )
           numeroGerado = Math.pow(numeroGerado, 2);

       return numeroGerado;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    
    /**
     * @param experiencia Experiencia atribuida á um Orc.
     */
    public void setExperiencia( int experiencia ) {
        this.experiencia = experiencia;
    }

}
