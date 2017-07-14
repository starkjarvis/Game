package game.est.service.impl;

import java.sql.SQLException;

import game.est.dao.CheckSecondaryImageDao;
import game.est.service.CheckSecondaryImageService;

public class CheckSecondaryImageServiceImpl implements CheckSecondaryImageService {

	private CheckSecondaryImageDao checkSecondaryImageDao;
	public CheckSecondaryImageDao getCheckSecondaryImageDao() {
		return checkSecondaryImageDao;
	}
	public void setCheckSecondaryImageDao(CheckSecondaryImageDao checkSecondaryImageDao) {
		this.checkSecondaryImageDao = checkSecondaryImageDao;
	}
	@Override
	public int[] checkSecondaryImage(int game_id) throws SQLException {
		
		return checkSecondaryImageDao.checkSecondaryImage(game_id);
	}

}
