package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuarioDao;
import filmator.model.Usuario;

@Controller
public class LoginController {
	@Inject
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
	  return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String efetuaLogin(Usuario usuario, HttpSession session) {
	  if(usuarioDao.existeUsuario(usuario) != null) {
	    session.setAttribute("usuarioLogado", usuario);
	    return "redirect:/";
	  }
	  return "redirect:login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}

}
