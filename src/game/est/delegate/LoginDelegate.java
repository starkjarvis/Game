package game.est.delegate;

import java.sql.SQLException;

import game.est.service.UserService;

public class LoginDelegate
{
		private UserService userService;

		public UserService getUserService()
		{
				return this.userService;
		}

		public void setUserService(UserService userService)
		{
				this.userService = userService;
		}

		public String isValidUser(String username, String password) throws SQLException
    {
		    return userService.isValidUser(username, password);
    }
}
