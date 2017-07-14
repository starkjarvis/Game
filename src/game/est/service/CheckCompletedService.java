package game.est.service;

import java.sql.SQLException;

public interface CheckCompletedService {
	
	public String checkCompleted(int game_id) throws SQLException;

}
