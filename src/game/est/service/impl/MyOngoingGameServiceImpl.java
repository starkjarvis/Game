package game.est.service.impl;

import java.sql.SQLException;

import game.est.dao.MyOngoingGameDao;
import game.est.service.MyOngoingGameService;

public class MyOngoingGameServiceImpl implements MyOngoingGameService {

	private MyOngoingGameDao myOngoingGameDao;
	public MyOngoingGameDao getMyOngoingGameDao() {
		return myOngoingGameDao;
	}
	public void setMyOngoingGameDao(MyOngoingGameDao myOngoingGameDao) {
		this.myOngoingGameDao = myOngoingGameDao;
	}
	@Override
	public String myOngoingGame(String username) throws SQLException {
		// TODO Auto-generated method stub
		return myOngoingGameDao.myOngoingGame(username);
	}
	

}
