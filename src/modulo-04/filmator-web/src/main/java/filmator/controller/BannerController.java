package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.BannerDao;
import filmator.dao.UsuarioDao;
import filmator.model.Banner;


@Controller
public class BannerController {
	
	@Inject 
	private BannerDao bannerDao;
	
	@Inject 
	private UsuarioDao usuarioDao;

	@RequestMapping(value = "/bannerCadastro", method = RequestMethod.GET)
	public String cadastro(Model model, HttpSession session){
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
 		return "bannerCadastro";
 	}
	
	@RequestMapping(value = "/bannerCadastro", method = RequestMethod.POST)
	public String inserir(Model model, Banner banner, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		if(banner.getIdBanner() != null) {
			bannerDao.atualizarBanner(banner);
		} else {
			bannerDao.inserir(banner);
		}
		return "redirect:/bannerLista";
	}
	
	@RequestMapping(value = "/bannerLista", method = RequestMethod.GET)
	public String bannerLista(Model model, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
		model.addAttribute("banners", bannerDao.buscarBanners());
		return "bannerLista";
	}
	
	@RequestMapping(value = "/bannerExcluir", method = RequestMethod.GET)
	public String excluirBanner(Model model, int idBanner, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
		return "redirect:bannerLista";
	}
	
	@RequestMapping(value = "/bannerEditar", method = RequestMethod.GET)
	public String editarBanner(Model model, int idBanner, HttpSession session) {
		if(!usuarioDao.usuarioEstaLogado(session)) {
			return "redirect:/login";
		}
		model.addAttribute("usuarioLogado", true);
		model.addAttribute("banner", bannerDao.buscaBannerPeloId(idBanner));
		return "bannerCadastro";
	}
}
