package filmator.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Genero;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
	public void inserir(Filme filme){
		jdbcTemplate.update("INSERT INTO Filme (Nome, Genero, Ano_lancamento, Sinopse, Imagem) VALUES (?, ?, ?, ?, ?)",
						filme.getNome(), filme.getGenero().name(), filme.getAnoLancamento(), filme.getSinopse(), filme.getImagem());
	}

	public List<Filme> buscaTodosFilmes(){
		return jdbcTemplate.query("SELECT Nome, Genero, Ano_lancamento, Sinopse, Imagem FROM Filme", (ResultSet rs, int rowNum) -> {
			Filme filme = new Filme();
			filme.setNome(rs.getString("Nome"));
			filme.setGenero(Genero.valueOf(rs.getString("Genero")));
			filme.setAnoLancamento(rs.getInt("Ano_lancamento"));
			filme.setSinopse(rs.getString("Sinopse"));
			filme.setImagem(rs.getString("Imagem"));
			return filme;
		});	
	}
	
	public List<Filme> buscaFilmePeloNome(String nome) {
		return jdbcTemplate.query("SELECT Nome, Genero, Ano_lancamento, Sinopse, Imagem FROM Filme WHERE Nome LIKE ? or Nome LIKE ?", new String[]{nome.toLowerCase() + "%", nome.toUpperCase() + "%"} , (ResultSet rs, int rowNum) -> {
			Filme filme = new Filme();
			filme.setNome(rs.getString("Nome"));
			filme.setGenero(Genero.valueOf(rs.getString("Genero")));
			filme.setAnoLancamento(rs.getInt("Ano_lancamento"));
			filme.setSinopse(rs.getString("Sinopse"));
			filme.setImagem(rs.getString("Imagem"));
			return filme;
		});
	}
}
 