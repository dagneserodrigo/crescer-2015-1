package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class FilmeController {
	private FilmeDao dao = new FilmeDao();

	@RequestMapping(value = "/cadastrarFilme", method = RequestMethod.GET)
	public String cadastro(Model model){
		model.addAttribute("generos", Genero.values());
 		return "filmeCadastro";
 	}

	@RequestMapping(value = "/salvarFilme", method = RequestMethod.POST)
	public String salvarFilme(Filme filme, Model model){
		dao.salvarFilme(filme);
		model.addAttribute("filmes", dao.consultaFilmes());
 		return "filmeConsulta";
 	}
	
	@RequestMapping(value = "/consultarFilme", method = RequestMethod.GET)
	public String consultarFilme(Model model) {
		model.addAttribute("filmes", dao.consultaFilmes());
		return "filmeConsulta";
	}
}
