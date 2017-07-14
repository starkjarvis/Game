package game.est.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import game.est.dao.CheckSecondaryImageDao;

public class CheckSecondaryImageDaoImpl implements CheckSecondaryImageDao {

	DataSource dataSource;
	
	public DataSource getDataSource()
	{
			return this.dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
			this.dataSource = dataSource;
	}
	@Override
	public int[] checkSecondaryImage(int game_id) throws SQLException {
		String query1="select * from playgame where game_id=? and completed=?";
		int[] secondary_images=new int[6];
		int i=0;
		PreparedStatement pstmt1 = dataSource.getConnection().prepareStatement(query1);
		pstmt1.setInt(1, game_id);
		pstmt1.setInt(2, 1);
		ResultSet res=pstmt1.executeQuery();
		while(res.next())
		{
			secondary_images[i]=res.getInt("secondary_images_p1");
			i++;
		}
		return secondary_images;
	}

}
