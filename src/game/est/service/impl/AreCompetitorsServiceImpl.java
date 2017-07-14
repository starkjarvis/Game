package game.est.service.impl;

import java.sql.SQLException;

import game.est.dao.AreCompetitorsDao;
import game.est.service.AreCompetitorsService;

public class AreCompetitorsServiceImpl implements AreCompetitorsService {

	
	private AreCompetitorsDao areCompetitorsDao;
	
	public AreCompetitorsDao getAreCompetitorsDao() {
		return areCompetitorsDao;
	}

	public void setAreCompetitorsDao(AreCompetitorsDao areCompetitorsDao) {
		this.areCompetitorsDao = areCompetitorsDao;
	}

	@Override
	public String areCompetitors(String username) throws SQLException {
		
		return areCompetitorsDao.areCompetitors(username);
	}

}
