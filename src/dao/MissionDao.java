package dao;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Mission;
public class MissionDao {

	private Statement st;
	private Connexion dao=Connexion.getInstance();
	
	
	

	public int insert(Mission t) {
System.out.println("hiii article dao");
		int res=0;
		try {
			dao.connect();
			st=dao.getCnx().createStatement();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    		Date date = new Date();
    		
			res=st.executeUpdate("insert into mission values(null,'"+t.getDes()+"','"+dateFormat.format(t.getDateDeb())+"',"+t.getDuree()+","+t.getCode()+")");
			System.out.println("inset");
			
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
//****************************************************************
	public int supp(int t) throws SQLException {

		int res=0;
		try {
			dao.connect();
			st=dao.getCnx().createStatement();
			res=st.executeUpdate("delete from intervention where num="+t);
			res=st.executeUpdate("delete from affectation where num_mission="+t);
			res=st.executeUpdate("delete from mission where num="+t);
			
	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		st.close();
		dao.disconnect();
		return res;

	}
	
}
