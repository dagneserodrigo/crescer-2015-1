package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Ator;
import filmator.model.Filme;

@Component
public class AtorDao {
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserir(Ator ator){
		jdbcTemplate.update("INSERT INTO Ator (Nome, Informacao, Imagem) VALUES (?, ?, ?)", ator.getNome(), ator.getInformacao(), ator.getImagem());
	}

	public List<Ator> buscaTodosAtores(){
		return jdbcTemplate.query("SELECT IDAtor, Nome, Informacao, Imagem FROM Ator", (ResultSet rs, int rowNum) -> {
			Ator ator = new Ator();
			ator.setIdAtor(rs.getInt("IDAtor"));
			ator.setNome(rs.getString("Nome"));
			ator.setInformacao(rs.getString("Informacao"));
			ator.setImagem(rs.getString("Imagem"));
			return ator;
		});	
	}
	
	public List<Ator> buscaAtorPeloNome(String nome) {
		return jdbcTemplate.query("SELECT Nome, Informacao, Imagem FROM Ator WHERE Nome LIKE ? or Nome LIKE ?", new String[]{nome.toLowerCase() + "%", nome.toUpperCase() + "%"} , (ResultSet rs, int rowNum) -> {
			Ator ator = new Ator();
			ator.setNome(rs.getString("Nome"));
			ator.setInformacao(rs.getString("Informacao"));
			ator.setImagem(rs.getString("Imagem"));
			return ator;
		});
	}
	
	public List<Ator> buscaAtoresDestaques() {
		return jdbcTemplate.query("SELECT Nome, Informacao, Imagem FROM Ator LIMIT 3", (ResultSet rs, int rowNum) -> {
			Ator ator = new Ator();
			ator.setNome(rs.getString("Nome"));
			ator.setInformacao(rs.getString("Informacao"));
			ator.setImagem(rs.getString("Imagem"));
			return ator;
		});
	}
	
	public Ator buscaAtorPeloId(int idAtor) {
		return jdbcTemplate.queryForObject("SELECT IDAtor, Nome, Informacao, Imagem FROM Ator WHERE IDAtor = ?", new Integer[]{idAtor} , (ResultSet rs, int rowNum) -> {
			Ator ator = new Ator();
			ator.setIdAtor(rs.getInt("IDAtor"));
			ator.setNome(rs.getString("Nome"));
			ator.setInformacao(rs.getString("Informacao"));
			ator.setImagem(rs.getString("Imagem"));
			return ator;
		});
	}

	public void excluirAtor(int idAtor) {
		jdbcTemplate.update("DELETE FROM Ator WHERE IDAtor = ?", idAtor);
	}
	
	public void atualizarAtor(Ator ator) {
		jdbcTemplate.update("UPDATE Ator SET Nome = ?, Informacao = ?, Imagem = ? WHERE IDAtor = ?", 
									ator.getNome(), ator.getInformacao(), ator.getImagem(), ator.getIdAtor());
	}
}
