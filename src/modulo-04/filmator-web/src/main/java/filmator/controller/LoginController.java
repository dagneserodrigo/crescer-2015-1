package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public String efetuaLogin(@RequestParam()String login, @RequestParam() String senha, HttpSession session) {
		Usuario usuarioLogado = usuarioDao.existeUsuario(login, senha);
		if(usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);
			return "true";
		}
		return "false";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}

}
