package filmator.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Ator;
import filmator.model.Filme;
import filmator.model.Genero;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
	public void inserir(Filme filme){
		jdbcTemplate.update("INSERT INTO Filme (Nome, Genero, AnoLancamento, Sinopse, Imagem) VALUES (?, ?, ?, ?, ?)",
						filme.getNome(), filme.getGenero().name(), filme.getAnoLancamento(), filme.getSinopse(), filme.getImagem());
	}

	public List<Filme> buscaTodosFilmes(){
		return jdbcTemplate.query("SELECT IDFilme, Nome, Genero, AnoLancamento, Sinopse, Imagem FROM Filme", (ResultSet rs, int rowNum) -> {
			Filme filme = new Filme();
			filme.setIdFilme(rs.getInt("IDFilme"));
			filme.setNome(rs.getString("Nome"));
			filme.setGenero(Genero.valueOf(rs.getString("Genero")));
			filme.setAnoLancamento(rs.getInt("AnoLancamento"));
			filme.setSinopse(rs.getString("Sinopse"));
			filme.setImagem(rs.getString("Imagem"));
			return filme;
		});	
	}
	
	public List<Filme> buscaFilmePeloNome(String nome) {
		return jdbcTemplate.query("SELECT Nome, Genero, AnoLancamento, Sinopse, Imagem FROM Filme WHERE Nome LIKE ? or Nome LIKE ?", new String[]{nome.toLowerCase() + "%", nome.toUpperCase() + "%"} , (ResultSet rs, int rowNum) -> {
			Filme filme = new Filme();
			filme.setNome(rs.getString("Nome"));
			filme.setGenero(Genero.valueOf(rs.getString("Genero")));
			filme.setAnoLancamento(rs.getInt("AnoLancamento"));
			filme.setSinopse(rs.getString("Sinopse"));
			filme.setImagem(rs.getString("Imagem"));
			return filme;
		});
	}
	
	public List<Filme> buscaFilmesDestaques() {
		return jdbcTemplate.query("SELECT Nome, Genero, AnoLancamento, Sinopse, Imagem FROM Filme LIMIT 3", (ResultSet rs, int rowNum) -> {
			Filme filme = new Filme();
			filme.setNome(rs.getString("Nome"));
			filme.setGenero(Genero.valueOf(rs.getString("Genero")));
			filme.setAnoLancamento(rs.getInt("AnoLancamento"));
			filme.setSinopse(rs.getString("Sinopse"));
			filme.setImagem(rs.getString("Imagem"));
			return filme;
		});
	}
	
	public void excluirFilme(int idFilme) {
		jdbcTemplate.update("DELETE FROM Filme WHERE IDFilme = ?", idFilme);
	}
	
	public Filme buscaFilmePeloId(int idFilme) {
		return jdbcTemplate.queryForObject("SELECT IDFilme, Nome, Genero, AnoLancamento, Sinopse, Imagem FROM Filme WHERE IDFilme = ?", new Integer[]{idFilme} , (ResultSet rs, int rowNum) -> {
			Filme filme = new Filme();
			filme.setIdFilme(rs.getInt("IDFilme"));
			filme.setNome(rs.getString("Nome"));
			filme.setGenero(Genero.valueOf(rs.getString("Genero")));
			filme.setAnoLancamento(rs.getInt("AnoLancamento"));
			filme.setSinopse(rs.getString("Sinopse"));
			filme.setImagem(rs.getString("Imagem"));
			return filme;
		});
	}
	
	public void atualizarFilme(Filme filme) {
		jdbcTemplate.update("UPDATE Filme SET Nome = ?, Genero = ?, AnoLancamento = ?, Sinopse = ?, Imagem = ? WHERE IDFilme = ?", 
									filme.getNome(), filme.getGenero().name(), filme.getAnoLancamento(), filme.getSinopse(), filme.getImagem(), filme.getIdFilme());
	}
}
 