import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class ExercitoDeElfosTest
{
    @Test
    public void alistarElfoBaseNãoAlista() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarDoisElfosBaseNãoAlistaNenhum() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Elfo elfo2 = new Elfo("Arwen");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(elfo2);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    @Test
    public void alistarElfoVerdeAlista() {
        // Arrange
        Elfo elfo = new ElfoVerde("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfoNoturnoAlista() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfosVerdesENoturnosAlistaTodos() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo elfo3 = new ElfoVerde("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        exercitoEsperado.put(elfo2.getNome(), elfo2);
        exercitoEsperado.put(elfo3.getNome(), elfo3);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfosVerdesENoturnosAlistaTodosMenosBase() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo elfo3 = new ElfoVerde("Green Legolas");
        Elfo elfoBase = new Elfo("Normal Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        exercitoEsperado.put(elfo2.getNome(), elfo2);
        exercitoEsperado.put(elfo3.getNome(), elfo3);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistarElfo(elfoBase);
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void buscarElfoPeloNomeNãoAlistado() {
        // Arrange
        Elfo esperado = null;
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        Elfo obtido = exercito.buscarElfo("John Elf Doe");
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscarElfoAlistado() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfoVerde(nomeElfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfo(esperado);
        // Act
        Elfo obtido = exercito.buscarElfo(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscarElfoAlistadoComVarios() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfoVerde(nomeElfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfo(esperado);
        exercito.alistarElfo(new ElfoVerde("green elf"));
        exercito.alistarElfo(new ElfoNoturno("Night Elf"));
        // Act
        Elfo obtido = exercito.buscarElfo(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscaElfosPorStatusSemElfos() {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>();
        // Act
        // Assert
        assertEquals( resultadoEsperado, exercito.buscaElfoPeloStatus( Status.VIVO ));
    }
    
    @Test
    public void buscaElfosPorStatusComUmElfo() {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo legolas = new ElfoNoturno("Celeborn");
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(legolas);
        // Act
        exercito.alistarElfo(legolas);
        // Assert
        assertEquals( resultadoEsperado, exercito.buscaElfoPeloStatus( Status.VIVO ));
    }
    
    @Test
    public void buscaElfosPorStatusComDoisElfos() {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo legolas = new ElfoNoturno("Legolas");
        Elfo celeborn = new ElfoVerde("Celeborn");
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(celeborn);
        resultadoEsperado.add(legolas);
        // Act
        exercito.alistarElfo(legolas);
        exercito.alistarElfo(celeborn);
        // Assert
        assertEquals( resultadoEsperado, exercito.buscaElfoPeloStatus( Status.VIVO ));
    }
    
    @Test
    public void buscaElfosPorStatusComVariosElfos() {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo legolas = new ElfoNoturno("Legolas");
        Elfo celeborn = new ElfoVerde("Celeborn");
        Elfo dimitri = new ElfoNoturno("Dimitri");
        Elfo robinHood = new ElfoVerde("Robin Hood");
        Elfo elround = new ElfoNoturno("Elrond");
        ArrayList<Elfo> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(celeborn);
        resultadoEsperado.add(dimitri);
        resultadoEsperado.add(robinHood);
        resultadoEsperado.add(legolas);
        resultadoEsperado.add(elround);
        // Act
        exercito.alistarElfo(legolas);
        exercito.alistarElfo(celeborn);
        exercito.alistarElfo(dimitri);
        exercito.alistarElfo(robinHood);
        exercito.alistarElfo(elround);
        // Assert
        assertEquals( resultadoEsperado, exercito.buscaElfoPeloStatus( Status.VIVO ));
    }
}