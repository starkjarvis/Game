package game.est.service.impl;

import java.sql.SQLException;

import game.est.dao.NextGameDeleteDataDao;
import game.est.service.NextGameDeleteDataService;

public class NextGameDeleteDataServiceImpl implements NextGameDeleteDataService {

	private NextGameDeleteDataDao nextGameDeleteDataDao;
	public NextGameDeleteDataDao getNextGameDeleteDataDao() {
		return nextGameDeleteDataDao;
	}

	public void setNextGameDeleteDataDao(NextGameDeleteDataDao nextGameDeleteDataDao) {
		this.nextGameDeleteDataDao = nextGameDeleteDataDao;
	}
	
	@Override
	public String nextGameDeleteData(int game_id) throws SQLException {
		// TODO Auto-generated method stub
		return nextGameDeleteDataDao.nextGameDeleteData(game_id);
	}

	

}
