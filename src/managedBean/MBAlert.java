package managedBean;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.Connexion;
import model.*;
public class MBAlert {
	
	Timer timer = new Timer();
	private List<Integer>lNum;
	EntityManagerFactory emf = null;  
	EntityManager em = null;
	HttpURLConnection conn;
	String res;
	URL url;
	List<Assurance> l = new ArrayList<Assurance>();
	List<VisiteTechnique> ll = new ArrayList<VisiteTechnique>();
	
	
	public void setLl(List<VisiteTechnique> ll) {
		   Statement st;
			 Connexion dao=Connexion.getInstance();
				try {
	    			dao.connect();
	    			st=dao.getCnx().createStatement();
	    			
	    			ResultSet rs=st.executeQuery("Select * From visite_technique v  where round(DATEDIFF(SYSDATE(),v.date)/365)>0");
	    			
	    			while(rs.next()) {
	    				VisiteTechnique art=new VisiteTechnique();
	    				art.setNum(rs.getInt(1));
	    				art.setDate(rs.getDate(2));
	    				art.setDuree(rs.getInt(3));
	    			
	    		        
	    		        ll.add(art);}
	    			
				
	    			
		    	}
		    		catch(SQLException e) {
		    			e.printStackTrace();
		    		}}
	public List<VisiteTechnique> getLl(){
		

		   Statement st;
			 Connexion dao=Connexion.getInstance();
				try {
	    			dao.connect();
	    			st=dao.getCnx().createStatement();
	    			
	    			ResultSet rs=st.executeQuery("Select * From visite_technique v  where round(DATEDIFF(SYSDATE(),v.date)/365)>0");
	    			
	    			while(rs.next()) {
	    				VisiteTechnique art=new VisiteTechnique();
	    				art.setNum(rs.getInt(1));
	    				art.setDate(rs.getDate(2));
	    				art.setDuree(rs.getInt(3));
	    			
	    		        
	    		        ll.add(art);}
	    			
		    	}
		    		catch(SQLException e) {
		    			e.printStackTrace();
		    		}
		
		
		return ll;}
private int code;


public void setCode(int c) {
	
	
	
	code =ll.size()+l.size();
	
}
	public int getCode() {return ll.size()+l.size();}
	
	
	
	public void setL(List<Assurance> ll) {

		   Statement st;
			 Connexion dao=Connexion.getInstance();
				try {
	    			dao.connect();
	    			st=dao.getCnx().createStatement();
	    			
	    			ResultSet rs2=st.executeQuery("Select * From assurance v where DATEDIFF(v.date_fin,SYSDATE())<=7 and DATEDIFF(v.date_fin,SYSDATE())>=0  order by date_fin ASC");
	    			
	    			while(rs2.next()) {
	    				Assurance art=new Assurance();
	    				art.setNum(rs2.getInt(1));
	    				art.setDateDeb(rs2.getDate(3));
	    				art.setDateFin(rs2.getDate(4));
	    			
	    		        
	    		        l.add(art);}
	    			
	    			
		    	}
		    		catch(SQLException e) {
		    			e.printStackTrace();
		    		}
	    			
				
	    			
		    	}
		    		
	public List<Assurance> getL(){
		

		   Statement st;
			 Connexion dao=Connexion.getInstance();
				try {
	    			dao.connect();
	    			st=dao.getCnx().createStatement();
	    			
	    			ResultSet rs2=st.executeQuery("Select v.num From assurance v where DATEDIFF(v.date_fin,SYSDATE())<=7 and DATEDIFF(v.date_fin,SYSDATE())>=0  order by date_fin ASC");
	    			
	    			while(rs2.next()) {
	    				Assurance art=new Assurance();
	    				art.setNum(rs2.getInt(1));
	    				art.setDateDeb(rs2.getDate(2));
	    				art.setDateFin(rs2.getDate(3));
	    			
	    		        
	    		        l.add(art);}
	    			
	    			
		    	}
		    		catch(SQLException e) {
		    			e.printStackTrace();
		    		}
		
		
		return l;}

	
	
	

	public String onload() { 
	   System.out.println("load pagggggggggggge2");
	   
	   Statement st;
		 Connexion dao=Connexion.getInstance();
			try {
    			dao.connect();
    			st=dao.getCnx().createStatement();
    			
    			ResultSet rs=st.executeQuery("Select * From visite_technique v  where round(DATEDIFF(SYSDATE(),v.date)/365)>0");
    			
    			while(rs.next()) {
    				VisiteTechnique art=new VisiteTechnique();
    				art.setNum(rs.getInt(1));
    				art.setDate(rs.getDate(2));
    				art.setDuree(rs.getInt(3));
    			
    		        
    		        ll.add(art);}
	ResultSet rs2=st.executeQuery("Select v.num From assurance v where DATEDIFF(v.date_fin,SYSDATE())<=7 and DATEDIFF(v.date_fin,SYSDATE())>=0  order by date_fin ASC");
    			
    			while(rs2.next()) {
    				Assurance art=new Assurance();
    				art.setNum(rs.getInt(1));
    				art.setDateDeb(rs.getDate(2));
    				//art.setDuree(rs.getInt(3));
    			
    		        
    		        l.add(art);}
    			
    	}
    		catch(SQLException e) {
    			e.printStackTrace();
    		}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	  	    return "";
	}
	List<Integer> getlNum() {
		return lNum;
	}
	void setlNum(List<Integer> lNum) {
		this.lNum = lNum;
	}
	
	
	
	

}

