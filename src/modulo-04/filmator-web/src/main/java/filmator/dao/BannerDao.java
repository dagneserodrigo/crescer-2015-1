package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Banner;

@Component
public class BannerDao {
	
	@Inject 
	private JdbcTemplate jdbcTemplate;
	
	public void inserir(Banner banner) {
		jdbcTemplate.update("INSERT INTO Banner (Nome) VALUES (?)", banner.getNome());
	}
	
	public List<Banner> buscarBanners() {
		return jdbcTemplate.query("SELECT IDBanner, Nome FROM Banner", (ResultSet rs, int rowNum) -> {
			Banner banner = new Banner();
			banner.setIdBanner(rs.getInt("IDBanner"));
			banner.setNome(rs.getString("Nome"));
			return banner;
		});
	}
	
	public List<Banner> buscarBannersDestaques() {
		return jdbcTemplate.query("SELECT Nome FROM Banner LIMIT 3", (ResultSet rs, int rowNum) -> {
			Banner banner = new Banner();
			banner.setNome(rs.getString("Nome"));
			return banner;
		});
	}

	public void excluirBanner(int idBanner) {
		jdbcTemplate.update("DELETE FROM Banner WHERE IDBanner = ?", idBanner);
	}
	
	public Banner buscaBannerPeloId(int idBanner) {
		return jdbcTemplate.queryForObject("SELECT IDBanner, Nome FROM Banner WHERE IDBanner = ?", new Integer[]{idBanner} , (ResultSet rs, int rowNum) -> {
			Banner banner = new Banner();
			banner.setIdBanner(rs.getInt("IDBanner"));
			banner.setNome(rs.getString("Nome"));
			return banner;
		});
	}

	public void atualizarBanner(Banner banner) {
		jdbcTemplate.update("UPDATE Banner SET Nome = ? WHERE IDBanner = ?", 
									banner.getNome(), banner.getIdBanner());
	}
}
