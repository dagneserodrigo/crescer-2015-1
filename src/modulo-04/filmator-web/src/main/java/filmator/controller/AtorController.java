package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.AtorDao;
import filmator.dao.UsuarioDao;
import filmator.model.Ator;

@Controller
public class AtorController {

	@Inject
	private AtorDao atorDao;

	@Inject 
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "/atorCadastro", method = RequestMethod.GET)
	public String cadastro(Model model, HttpSession session){
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
 		return "atorCadastro";
 	}
	
	@RequestMapping(value = "/atorCadastro", method = RequestMethod.POST)
	public String inserir(Model model, Ator ator, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		if(ator.getIdAtor() != null) {
			atorDao.atualizarAtor(ator);
		} else {
			atorDao.inserir(ator);
		}
		return "redirect:/atorLista";
	}
	
	@RequestMapping(value = "/atorLista", method = RequestMethod.GET)
	public String atorLista(Model model, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
		model.addAttribute("atores", atorDao.buscaTodosAtores());
		return "atorLista";
	}
	
	@RequestMapping(value = "/atorExcluir", method = RequestMethod.GET)
	public String excluirAtor(Model model, int idAtor, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		atorDao.excluirAtor(idAtor);
		return "redirect:atorLista";
	}
	
	@RequestMapping(value = "/atorEditar", method = RequestMethod.GET)
	public String editarAtor(Model model, int idAtor, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
		model.addAttribute("ator", atorDao.buscaAtorPeloId(idAtor));
		return "atorCadastro";
	}
	
	@RequestMapping(value = "/atores", method = RequestMethod.GET)
	public String atores(Model model, HttpSession session) {
		if(usuarioDao.usuarioEstaLogado(session)) {
			model.addAttribute("usuarioLogado", true);
		}
		model.addAttribute("atores", atorDao.buscaTodosAtores());
		return "atores";
	}
}
