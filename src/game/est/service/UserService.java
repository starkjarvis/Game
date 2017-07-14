/**
 *
 */
package game.est.service;

import java.sql.SQLException;

/**
 * @author CENTAUR
 *
 */
public interface UserService
{
		public String isValidUser(String username, String password) throws SQLException;
}
