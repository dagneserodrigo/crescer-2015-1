package filmator.dao;


import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Avaliacao;

@Component
public class AvaliacaoDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserir(Avaliacao avaliacao) {
		jdbcTemplate.update("INSERT INTO Avaliacao (IDFilme, IDUsuario, Nota) VALUES (?, ?, ?)", avaliacao.getIdFilme(), avaliacao.getIdUsuario(), avaliacao.getNota());
	}
	
	public void atualizarAvaliacao(Avaliacao avaliacao) {
		jdbcTemplate.update("UPDATE Avaliacao SET Nota = ? WHERE IDUsuario = ? AND IDFilme = ?", 
								avaliacao.getNota(), avaliacao.getIdUsuario(), avaliacao.getIdFilme());
	}
	
	public boolean usuarioJaAvaliouOFilme(Avaliacao avaliacao) {
		int result = jdbcTemplate.queryForObject("SELECT count(1) from AVALIACAO WHERE IDUsuario = ? AND IDFilme = ?", new Integer[] {avaliacao.getIdUsuario(), avaliacao.getIdFilme()}, Integer.class);
		if(result < 1) {
			return false;
		}
		return true;
	}
	
	
}
