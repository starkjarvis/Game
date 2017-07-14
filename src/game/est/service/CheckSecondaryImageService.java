package game.est.service;

import java.sql.SQLException;

public interface CheckSecondaryImageService {
	
	public int[] checkSecondaryImage(int game_id) throws SQLException;

}
