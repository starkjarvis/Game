package game.est.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import game.est.dao.NextGameDeleteDataDao;

public class NextGameDeleteDataDaoImpl implements NextGameDeleteDataDao {

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
	public String nextGameDeleteData(int game_id) throws SQLException {
		
	
		String query2="delete from game where game_id=?";
		PreparedStatement ps2=dataSource.getConnection().prepareStatement(query2);
		ps2.setInt(1, game_id);
		ps2.executeUpdate();
		
		
		
		return "ok";
	}

}
