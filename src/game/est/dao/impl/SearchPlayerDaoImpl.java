package game.est.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import game.est.dao.SearchPlayerDao;

public class SearchPlayerDaoImpl implements SearchPlayerDao {

	DataSource dataSource;
	static int found=1;
	
	public DataSource getDataSource()
	{
			return this.dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
			this.dataSource = dataSource;
	}
	
	@Override
	public String searchPlayer(String username) throws SQLException {
		int my_id=0;
		int i=0;
		
		
		//getting my_id so that I'm not matched with myself
				String query3="select * from login where email=?";
				PreparedStatement pstmt3 = dataSource.getConnection().prepareStatement(query3);
				pstmt3.setString(1, username);
				ResultSet res3=pstmt3.executeQuery();
				while(res3.next())
				{
					my_id=res3.getInt("id");
				}
		
		
		String query1="select id from login where status='online' and playing=0";
		PreparedStatement pstmt1 = dataSource.getConnection().prepareStatement(query1);
		ResultSet res1 = pstmt1.executeQuery();
		while(res1.next()) {
			if(res1.getInt("id")!=my_id) {
				
					i++;
			}
		}
		
		
		int randomNum = 1 + (int)(Math.random() * i);
		if(randomNum==my_id)
			randomNum = 1 + (int)(Math.random() * i);
		
		String query2="select email from login where id=?";
		PreparedStatement pstmt2 = dataSource.getConnection().prepareStatement(query2);
		pstmt2.setInt(1, randomNum);
		ResultSet res2 = pstmt2.executeQuery();
		while(res2.next())
		{	
			username=res2.getString(1);
		}
		
		return username;
		
	}

}
