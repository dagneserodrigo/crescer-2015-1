package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuarioDao;
import filmator.model.Usuario;

@Controller
public class UsuarioController {

	@Inject
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "/usuarioCadastro", method = RequestMethod.GET)
	public String cadastro(Model model, HttpSession session){
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
 		return "usuarioCadastro";
 	}
	
	@RequestMapping(value = "/usuarioCadastro", method = RequestMethod.POST)
	public String inserir(Model model, Usuario usuario, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		if(usuario.getIdUsuario() != null) {
			usuarioDao.atualizarUsuario(usuario);
		} else {
			usuarioDao.inserir(usuario);
		}
		return "redirect:/usuarioLista";
	}
	
	@RequestMapping(value = "/usuarioLista", method = RequestMethod.GET)
	public String usuarioLista(Model model, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
		model.addAttribute("usuarios", usuarioDao.buscaTodosUsuarios());
		return "usuarioLista";
	}
	
	@RequestMapping(value = "/usuarioExcluir", method = RequestMethod.GET)
	public String excluirUsuario(Model model, int idUsuario, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		usuarioDao.excluirUsuario(idUsuario);
		return "redirect:usuarioLista";
	}
	
	@RequestMapping(value = "/usuarioEditar", method = RequestMethod.GET)
	public String editarUsuario(Model model, int idUsuario, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
		model.addAttribute("usuario", usuarioDao.buscaUsuarioPeloId(idUsuario));
		return "usuarioCadastro";
	}
}
