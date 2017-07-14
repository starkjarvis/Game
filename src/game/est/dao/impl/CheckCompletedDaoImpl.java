package game.est.dao.impl;

import java.sql.*;

import javax.sql.DataSource;

import game.est.dao.CheckCompletedDao;

public class CheckCompletedDaoImpl implements CheckCompletedDao {
	
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
	public String checkCompleted(int game_id) throws SQLException {
		String query1="select * from playgame where game_id=?";
		int completed=0;
		PreparedStatement pstmt1 = dataSource.getConnection().prepareStatement(query1);
		pstmt1.setInt(1, game_id);
		ResultSet res1=pstmt1.executeQuery();
		while(res1.next())
		{
			completed=res1.getInt("completed");
		}
		System.out.println("Comepleted Stauts: "+completed );
		if(completed!=2)
			return "no";
		else
			return "yes";
	}

	

}
