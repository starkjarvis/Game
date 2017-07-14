package game.est.service.impl;

import java.sql.SQLException;

import game.est.dao.SearchPlayerDao;
import game.est.service.SearchPlayerService;

public class SearchPlayerServiceImpl implements SearchPlayerService {
	
	private SearchPlayerDao searchPlayerDao;

	public SearchPlayerDao getSearchPlayerDao() {
		return searchPlayerDao;
	}

	public void setSearchPlayerDao(SearchPlayerDao searchPlayerDao) {
		this.searchPlayerDao = searchPlayerDao;
	}

	@Override
	public String searchPlayer(String username) throws SQLException {
		
		return searchPlayerDao.searchPlayer(username);
	}

}
