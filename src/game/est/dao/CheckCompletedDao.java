package game.est.dao;

import java.sql.SQLException;

public interface CheckCompletedDao {
	public String checkCompleted(int game_id) throws SQLException;

}
