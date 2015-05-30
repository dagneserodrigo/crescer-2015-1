package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Avaliacao;
import filmator.model.Banner;

@Component
public class AvaliacaoDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserir(Avaliacao avaliacao) {
		jdbcTemplate.update("INSERT INTO Avaliacao (IDFilme, IDUsuario, Nota) VALUES (?, ?, ?)", avaliacao.getIdFilme(), avaliacao.getIdUsuario(), avaliacao.getNota());
	}
	
	public void atualizarAvaliacao(Avaliacao avaliacao) {
		jdbcTemplate.update("UPDATE Avaliacao SET Nota = ? WHERE IDAvaliacao = ?", 
								avaliacao.getNota(), avaliacao.getIdAvaliacao());
	}
	
	public List<Avaliacao> buscarAvaliacoesPorUsuario(int idUsuario) {
		return jdbcTemplate.query("SELECT IDAvaliacao, IDFilme, IDUsuario, Nota FROM Avaliacao WHERE IDUsuario = ?", new Integer[] {idUsuario}, (ResultSet rs, int rowNum) -> {
			Avaliacao avaliacao = new Avaliacao();
			avaliacao.setIdAvaliacao(rs.getInt("IDAvaliacao"));
			avaliacao.setIdFilme(rs.getInt("IDFilme"));
			avaliacao.setIdUsuario(rs.getInt("IDUsuario"));
			avaliacao.setNota(rs.getInt("Nota"));
			return avaliacao;
		});
	}
	
	
}
