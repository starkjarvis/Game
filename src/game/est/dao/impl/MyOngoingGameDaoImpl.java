package game.est.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import game.est.dao.MyOngoingGameDao;

public class MyOngoingGameDaoImpl implements MyOngoingGameDao {

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
	public String myOngoingGame(String username) throws SQLException {
		int game_id=0;
		int i=0;
		String query1="select * from game where username=?";
		PreparedStatement pstmt1 = dataSource.getConnection().prepareStatement(query1);
		pstmt1.setString(1, username);
		ResultSet res1=pstmt1.executeQuery();
		while(res1.next()) {
			game_id=res1.getInt("game_id");
			i++;
		}
		if(i>0)
			return("yes"+"+"+game_id);
		else
			return("no"+"+");
		
	}

}
