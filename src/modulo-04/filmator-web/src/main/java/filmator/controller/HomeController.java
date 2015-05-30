package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.AtorDao;
import filmator.dao.BannerDao;
import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;

@Controller
public class HomeController {

	@Inject
	private AtorDao atorDao;
	
	@Inject
	private FilmeDao filmeDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Inject
	private BannerDao bannerDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		if(usuarioDao.usuarioEstaLogado(session)) {
			model.addAttribute("usuarioLogado", true);
		}
		model.addAttribute("banners", bannerDao.buscarBannersDestaques());
		model.addAttribute("atores", atorDao.buscaAtoresDestaques());
		model.addAttribute("filmes", filmeDao.buscaFilmesDestaques());
		return "home";
	}
}

