package game.est.dao;

import java.sql.SQLException;

/**
 * @author CENTAUR
 * This interface will be used to communicate with the
 * Database
 */
public interface UserDao
{
		public String isValidUser(String username, String password) throws SQLException;
}
