package filmator.controller;

import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class FilmeController {
	
	@Inject 
	private FilmeDao filmeDao;

	@RequestMapping(value = "/inserir", method = RequestMethod.GET)
	public String cadastro(Model model){
		model.addAttribute("generos", Genero.values());
 		return "filmeCadastro";
 	}
	
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Model model, Filme filme) {
		filmeDao.inserir(filme);
		model.addAttribute("filmes", filmeDao.buscaTodosFilmes());
		return "filmeConsulta";
	}
	
	@RequestMapping(value = "/consultarFilme", method = RequestMethod.GET)
	public String consultarFilme(Model model) {
		model.addAttribute("filmes", filmeDao.buscaTodosFilmes());
		return "filmeConsulta";
	}
	
	@RequestMapping(value = "/procurar", method = RequestMethod.GET)
	public String procurar(Model model, @RequestParam String nome) {
		model.addAttribute("filmes", filmeDao.buscaFilmePeloNome(nome));
		return "filmeConsulta";
	}
}
