package game.est.dao;

import java.sql.SQLException;

public interface CheckSecondaryImageDao {
	
	public int[] checkSecondaryImage(int game_id) throws SQLException;

}
