package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class FilmeController {
	
	@Inject 
	private FilmeDao filmeDao;
	
	@Inject 
	private UsuarioDao usuarioDao;

	@RequestMapping(value = "/filmeCadastro", method = RequestMethod.GET)
	public String cadastro(Model model, HttpSession session){
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
		model.addAttribute("generos", Genero.values());
 		return "filmeCadastro";
 	}
	
	@RequestMapping(value = "/filmeCadastro", method = RequestMethod.POST)
	public String inserir(Model model, Filme filme, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		if(filme.getIdFilme() != null) {
			filmeDao.atualizarFilme(filme);
		} else {
			filmeDao.inserir(filme);
		}
		return "redirect:/filmeLista";
	}
	
	@RequestMapping(value = "/filmeLista", method = RequestMethod.GET)
	public String filmeLista(Model model, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
		model.addAttribute("filmes", filmeDao.buscaTodosFilmes());
		return "filmeLista";
	}
	
	@RequestMapping(value = "/filmeExcluir", method = RequestMethod.GET)
	public String excluirFilme(Model model, int idFilme, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		filmeDao.excluirFilme(idFilme);
		return "redirect:filmeLista";
	}
	
	@RequestMapping(value = "/filmeEditar", method = RequestMethod.GET)
	public String editarFilme(Model model, int idFilme, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
		model.addAttribute("filme", filmeDao.buscaFilmePeloId(idFilme));
		model.addAttribute("generos", Genero.values());
		return "filmeCadastro";
	}
	
	@RequestMapping(value = "/filmes", method = RequestMethod.GET)
	public String filmes(Model model, HttpSession session) {
		if(usuarioDao.usuarioEstaLogado(session)) {
			model.addAttribute("usuarioLogado", true);
		}
		model.addAttribute("filmes", filmeDao.buscaTodosFilmes());
		return "filmes";
	}

//	@RequestMapping(value = "/procurar", method = RequestMethod.GET)
//	public String procurar(Model model, @RequestParam String nome) {
//		model.addAttribute("filmes", filmeDao.buscaFilmePeloNome(nome));
//		return "filmeConsulta";
//	}
}
