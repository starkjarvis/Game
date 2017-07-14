package game.est.service.impl;

import java.sql.SQLException;

import game.est.dao.UserDao;
import game.est.service.UserService;

public class UserServiceImpl implements UserService
{

		private UserDao userDao;

		public UserDao getUserDao()
		{
				return this.userDao;
		}

		public void setUserDao(UserDao userDao)
		{
				this.userDao = userDao;
		}

		@Override
		public String isValidUser(String username, String password) throws SQLException
		{
				return userDao.isValidUser(username, password);
		}

}
