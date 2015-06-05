package filmator.dao;

import java.sql.ResultSet;
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
		jdbcTemplate.update("INSERT INTO Filme (Nome, Genero, AnoLancamento, Sinopse, Imagem) VALUES (?, ?, ?, ?, ?)",
						filme.getNome(), filme.getGenero().name(), filme.getAnoLancamento(), filme.getSinopse(), filme.getImagem());
	}
	

	public List<Filme> buscaTodosFilmesPorUsuario(int idUsuario){
		return jdbcTemplate.query("SELECT f.IDFilme, f.Nome, f.Genero, f.AnoLancamento, f.Sinopse, f.Imagem, a.nota	FROM Filme f left join Avaliacao a on f.IDFilme = a.IDFilme AND a.IDUsuario = ?;", new Integer[] {idUsuario}, (ResultSet rs, int rowNum) -> {
			Filme filme = new Filme();
			filme.setIdFilme(rs.getInt("IDFilme"));
			filme.setNome(rs.getString("Nome"));
			filme.setGenero(Genero.valueOf(rs.getString("Genero")));
			filme.setAnoLancamento(rs.getInt("AnoLancamento"));
			filme.setSinopse(rs.getString("Sinopse"));
			filme.setImagem(rs.getString("Imagem"));
			filme.setNota(rs.getDouble("Nota"));
			return filme;
		});	
	}
	
	public List<Filme> buscaTodosFilmes(){
		return jdbcTemplate.query("SELECT f.IDFilme, f.Nome, f.Genero, f.AnoLancamento, f.Sinopse, f.Imagem, SUM(a.nota) as Nota FROM Filme f left join Avaliacao a on f.IDFilme = a.IDFilme group by f.IDFilme, f.Nome, f.Genero, f.AnoLancamento, f.Sinopse, f.Imagem;", (ResultSet rs, int rowNum) -> {
			Filme filme = new Filme();
			filme.setIdFilme(rs.getInt("IDFilme"));
			filme.setNome(rs.getString("Nome"));
			filme.setGenero(Genero.valueOf(rs.getString("Genero")));
			filme.setAnoLancamento(rs.getInt("AnoLancamento"));
			filme.setSinopse(rs.getString("Sinopse"));
			filme.setImagem(rs.getString("Imagem"));
			filme.setNota(calculaMedia(rs.getInt("Nota")));
			return filme;
		});	
	}
	
	public List<Filme> buscaFilmePeloNome(String nome) {
		return jdbcTemplate.query("SELECT f.IDFilme, f.Nome, f.Genero, f.AnoLancamento, f.Sinopse, f.Imagem, AVG(a.nota) as Nota FROM Filme f left join Avaliacao a on f.IDFilme = a.IDFilme WHERE UPPER(Nome) LIKE UPPER(?) group by f.IDFilme, f.Nome, f.Genero, f.AnoLancamento, f.Sinopse, f.Imagem;", (ResultSet rs, int rowNum) -> {
			Filme filme = new Filme();
			filme.setNome(rs.getString("Nome"));
			filme.setGenero(Genero.valueOf(rs.getString("Genero")));
			filme.setAnoLancamento(rs.getInt("AnoLancamento"));
			filme.setSinopse(rs.getString("Sinopse"));
			filme.setImagem(rs.getString("Imagem"));
			filme.setNota(calculaMedia(rs.getInt("Nota")));
			return filme;
		}, "%" + nome.toUpperCase() + "%");
	}
	
	private double calculaMedia(double nota) {
		int usuarios = numeroDeUsuarios();
		if(usuarios != 0){
			return  Math.round((nota/usuarios) * 2.0) / 2.0;
		}
		return  Math.round(nota) / 2.0;
	}
	
	public List<Filme> buscaFilmesDestaques() {
		return jdbcTemplate.query("select * from (SELECT f.IDFilme, f.Nome, f.Genero, f.AnoLancamento, f.Sinopse, f.Imagem, avg(a.nota) as Nota FROM Filme f left join Avaliacao a on f.IDFilme = a.IDFilme  group by f.IDFilme, f.Nome, f.Genero, f.AnoLancamento, f.Sinopse, f.Imagem) as Nota order by Nota DESC LIMIT 3;", (ResultSet rs, int rowNum) -> {
			Filme filme = new Filme();
			filme.setNome(rs.getString("Nome"));
			filme.setGenero(Genero.valueOf(rs.getString("Genero")));
			filme.setAnoLancamento(rs.getInt("AnoLancamento"));
			filme.setSinopse(rs.getString("Sinopse"));
			filme.setImagem(rs.getString("Imagem"));
			filme.setNota(rs.getDouble("Nota"));
			return filme;
		});
	}
	
	public void excluirFilme(int idFilme) {
		jdbcTemplate.update("DELETE FROM Avaliacao WHERE idFilme = ?", idFilme);
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
	
	public int numeroDeUsuarios(){
		return jdbcTemplate.queryForObject(
				"SELECT COUNT(1) FROM Usuario", Integer.class);
	}
}
 