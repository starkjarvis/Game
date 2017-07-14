package game.est.dao;

import java.sql.SQLException;

public interface SearchPlayerDao {
	
	public String searchPlayer(String username) throws SQLException;

}
