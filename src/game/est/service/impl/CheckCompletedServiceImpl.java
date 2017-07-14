package game.est.service.impl;

import java.sql.SQLException;

import game.est.dao.CheckCompletedDao;
import game.est.service.CheckCompletedService;

public class CheckCompletedServiceImpl implements CheckCompletedService {

	private CheckCompletedDao checkCompletedDao;
	public CheckCompletedDao getCheckCompletedDao() {
		return checkCompletedDao;
	}

	public void setCheckCompletedDao(CheckCompletedDao checkCompletedDao) {
		this.checkCompletedDao = checkCompletedDao;
	}
	@Override
	public String checkCompleted(int game_id) throws SQLException {
		
		return checkCompletedDao.checkCompleted(game_id);
	}

	

}
