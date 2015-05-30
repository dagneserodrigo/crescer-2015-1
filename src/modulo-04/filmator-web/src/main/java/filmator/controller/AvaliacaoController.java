package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.AvaliacaoDao;
import filmator.dao.UsuarioDao;
import filmator.model.Avaliacao;
import filmator.model.Usuario;

@Controller
public class AvaliacaoController {
	
	@Inject
	private AvaliacaoDao avaliacaoDao;

	@Inject
	private UsuarioDao usuarioDao;
	
	@ResponseBody
	@RequestMapping(value = "/avaliacaoCadastro", method = RequestMethod.POST)
	public String avaliacaoCadastro(Model model, HttpSession session, Avaliacao avaliacao) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		System.out.println(usuario.getIdUsuario());
		avaliacao.setIdUsuario(usuario.getIdUsuario());
		if(avaliacao.getIdAvaliacao() != null) {
			avaliacaoDao.atualizarAvaliacao(avaliacao);
		} else {
			avaliacaoDao.inserir(avaliacao);
		}
		model.addAttribute("usuarioLogado", true);
		return "redirect:/filmeLista";
	}
}
