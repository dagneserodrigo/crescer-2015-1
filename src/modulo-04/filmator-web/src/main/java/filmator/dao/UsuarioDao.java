package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Usuario;

@Component
public class UsuarioDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
	public Usuario existeUsuario(String login, String senha) {
		List<Usuario> usuarios = jdbcTemplate.query("SELECT IDUsuario, Login FROM Usuario WHERE Login = ? AND Senha = ?", (ResultSet rs, int rowNum) -> {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("IDUsuario"));
			usuario.setLogin(rs.getString("Login"));
			return usuario;
		},  login, senha);

		if( usuarios.size() >= 1 ){
			return usuarios.get(0);
		}
		
		return null;
	}
	
	public boolean usuarioEstaLogado(HttpSession session) {
		if(session.getAttribute("usuarioLogado") == null){
			return false;
		}
		return true;
	}
	
	public void inserir(Usuario usuario) {
		jdbcTemplate.update("INSERT INTO Usuario (Login, Senha) VALUES (?, ?)", usuario.getLogin(), usuario.getSenha());
	}
	
	public void excluirUsuario(int idUsuario) {
		jdbcTemplate.update("DELETE FROM Usuario WHERE IDUsuario = ?", idUsuario);
	}
	
	public void atualizarUsuario(Usuario usuario) {
		jdbcTemplate.update("UPDATE Usuario SET Login = ?, Senha = ? WHERE IDUsuario = ?", 
				usuario.getLogin(), usuario.getSenha(), usuario.getIdUsuario());
	}
	
	public List<Usuario> buscaTodosUsuarios(){
		return jdbcTemplate.query("SELECT IDUsuario, Login FROM Usuario", (ResultSet rs, int rowNum) -> {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("IDUsuario"));
			usuario.setLogin(rs.getString("Login"));
			return usuario;
		});	
	}
	
	public Usuario buscaUsuarioPeloId(int idUsuario) {
		return jdbcTemplate.queryForObject("SELECT IDUsuario, Login FROM Usuario WHERE IDUsuario = ?", new Integer[]{idUsuario} , (ResultSet rs, int rowNum) -> {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("IDUsuario"));
			usuario.setLogin(rs.getString("Login"));
			return usuario;
		});
	}

}
