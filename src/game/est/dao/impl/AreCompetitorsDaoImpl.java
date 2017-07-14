package game.est.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.ui.Model;

import game.est.dao.AreCompetitorsDao;

public class AreCompetitorsDaoImpl implements AreCompetitorsDao {

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
	public String areCompetitors(String username) throws SQLException {
		
		int game_ID=0;
		String player2="";
		String query1="select * from game where email=?";
		PreparedStatement pstmt1 = dataSource.getConnection().prepareStatement(query1);
		pstmt1.setString(1, username);
		ResultSet res1=pstmt1.executeQuery();
		while(res1.next())
		{
			game_ID=res1.getInt("game_id");
		}
		
		String query2="select * from game where game_id=?";
		PreparedStatement pstmt2 = dataSource.getConnection().prepareStatement(query2);
		pstmt2.setInt(1, game_ID);
		ResultSet res2=pstmt2.executeQuery();
		while(res2.next()) {
			player2=res2.getString("username");
		}

		return(player2+"+"+game_ID);
	}

}
