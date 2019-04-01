package managedBean;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import dao.Connexion;
import dao.MissionDao;
import model.Affectation;
import model.AffectationPK;
import model.AffectationService;
import model.AffectationServicePK;
import model.Assurance;
import model.Mission;
import model.Personnel;
import model.Projet;
import model.Vehicule;

public class MBMiss implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public MBMiss(){}
	private Mission miss=new Mission();

	public Mission getMiss() {
		return miss;
	}
	public void setMiss(Mission miss) {
		this.miss = miss;
	}
	//****************************************
	private Mission miss2=new Mission();

	public Mission getMiss2() {
		return miss2;
	}
	public void setMiss2(Mission miss) {
		this.miss2 = miss;
	}
	
	
	
	
	
	
	private List<String> lMat;



	//***********************************
	private List<String> lEmp;




	
	//*********************************
	private Mission m=new Mission();

	public Mission getM() {
		return m;
	}
	public void setM(Mission miss) {
		this.m = miss;
	}
//*********************************************
	   public void onRowSelect(SelectEvent event) {
	    
	    }
	 
	    public void onRowUnselect(UnselectEvent event) {
	     
	    }
//******************************************************
	private Mission mp=new Mission();

	public Mission getMp() {
		return mp;
	}
	public void setMp(Mission miss) {
		this.mp = miss;
	}
	
	
	//*************************************
	EntityManagerFactory emf = null;  
	EntityManager em = null;



		
		public String ajout()
		{
			System.out.print("hiiiiiiiiii mission ajout");
		 	
Projet p =new Projet();
p.setCode(code);
miss.setProjet(p);
			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager();   
			 em.getTransaction().begin();
			 List<Vehicule> lV = new ArrayList<Vehicule>();
				 



			em.persist(miss);
		
		    for(int i = 0 ;i<lMat.size();i++) {
		    	
		    	Vehicule v = new Vehicule();
		    	v.setMatricule(lMat.get(i));
		    	lV.add(v);
		    	 v = em.find(Vehicule.class, lMat.get(i));
		    	 Affectation aff = new Affectation();

		    	 AffectationPK a = new AffectationPK();
		    	 
		    	 a.setMatricule(lMat.get(i));
		    	 aff.setDuree(2+"");
		    	 a.setNumMission(miss.getNum());
		    	 aff.setId(a);
		    	 
		    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		    		Date date = new Date();
		    		//System.out.println(dateFormat.format(date));
		    	
		    	 
		    	 
		    	 aff.setVehicule(v);
		    	
		    	 aff.setMission(miss);
		    		 
		    		em.persist(aff);
		    	  
		    	 
		    }
		    em.getTransaction().commit();
		    System.out.print("gd mission ajout");
		
			
			return "";
		}

	//*****************************************************************

		
		public String mod()
		{
			System.out.print("hiiiiiiiiii mission mod");
			 
			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager();   
			 em.getTransaction().begin();
			 
				 

		
			
			return "";
		}

		
	public String edit() throws SQLException
	{
		MissionDao mdao = new MissionDao();
		mdao.supp(miss2.getNum());
				
		System.out.print("hiiiiiiiiii mission mod");
		 
		 Statement st;
		 Connexion dao=Connexion.getInstance();
		 List<Vehicule> lV = new ArrayList<Vehicule>();
			 
mdao.insert(miss2);
	  
	
	    for(int i = 0 ;i<lMat.size();i++) {
	    	
	    	Vehicule v = new Vehicule();
	    	v.setMatricule(lMat.get(i));
	    	lV.add(v);
	    	 v = em.find(Vehicule.class, lMat.get(i));
	    	 Affectation aff = new Affectation();

	    	 AffectationPK a = new AffectationPK();
	    	 
	    	 a.setMatricule(lMat.get(i));
	    	 aff.setDuree(2+"");
	    	 a.setNumMission(miss2.getNum());
	    	 aff.setId(a);
	    	 
	    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    		Date date = new Date();
	    		//System.out.println(dateFormat.format(date));
	    	
	    	 
	    	 
	    	 aff.setVehicule(v);
	    	
	    	 aff.setMission(miss2);
	    	 
	    	
	    		
	    		
	    		
	    		//****************************************************
	    		
	    		try {
	    			dao.connect();
	    			st=dao.getCnx().createStatement();
	    			
	        		st.executeUpdate("insert into affectation values(null,2,"+miss2.getNum()+",'"+v.getMatricule()+"')");
	    			System.out.println("inset");
	    			
	    	}
	    		catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    	    
	    	 
	    }

	
	    for(int i = 0 ;i<lEmp.size();i++) {
	    	
	    	Personnel v = new Personnel();
	    	v.setLogin(lEmp.get(i));
	    	
	   
	    	
	    		
	    		
	    		
	    		//****************************************************
	    		
	    		try {
	    			dao.connect();
	    			st=dao.getCnx().createStatement();
	    			
	        		st.executeUpdate("insert into intervention values('"+v.getLogin()+"',"+miss2.getNum()+")");
	    			System.out.println("inset");
	    			
	    	}
	    		catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    	    
	    	 
	    }	

		
		return "";
	}
    
    //***********************************************************
	
	
	
	
	private int code;
	//*************************************************
	public String supp(int num) throws SQLException
	{
		MissionDao mdao = new MissionDao();
		mdao.supp(num);
		return "";
		
	}
	
	
	
	public void suppri(int num) {
		try {
		MissionDao mdao = new MissionDao();
		mdao.supp(num);
		}
		catch(SQLException e) {}
		
		
		
	}
	
	//********************************************
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	List<Projet> project = new ArrayList<Projet>();
	public List<Projet> getProject() {
		return ok();
	}
    
    
    
    
    
	public void setProject(List<Projet> l) {
		this.project = ok();
	}
	
	List<Mission> project2 = new ArrayList<Mission>();
	public List<Mission> getProject2() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		project2=em.createNamedQuery("Mission.findAll",Mission.class).getResultList();
return project2;
	}
    
    
    
    
    
	public void setProject2(List<Mission> l) {
	
		
		
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
ll=em.createNamedQuery("Mission.findAll",Mission.class).getResultList();

	}
	
	
	public List<String> ok2() {
		
		System.out.println("okkkk");
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
project=em.createNamedQuery("Projet.findAll",Projet.class).getResultList();
	    em.getTransaction().commit();
	    
for(int i=0;i<project.size();i++)
{
	project2.add(project.get(i).getCode()+"");
}
return project2;
}

	
	
	
	//*******************************************
	
	public List<Projet> ok() {
		
		System.out.println("okkkk");
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
project=em.createNamedQuery("Projet.findAll",Projet.class).getResultList();
	    em.getTransaction().commit();
	    
	  if(project.isEmpty())
		  return null;
		  else
	return project;
	
}
	
	List<Mission> ll = new ArrayList<Mission>();

		public List<Mission> getLl() {
			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager();   
	ll=em.createNamedQuery("Mission.findAll",Mission.class).getResultList();
	return ll;	}
	    
	    
	    
	    
	    
		public void setLl(List<Mission> l) {
			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager();   
	ll=em.createNamedQuery("Mission.findAll",Mission.class).getResultList();

		}
		public List<String> getlMat() {
			return lMat;
		}
		public void setlMat(List<String> lMat) {
			this.lMat = lMat;
		}
		public List<String> getlEmp() {
			return lEmp;
		}
		public void setlEmp(List<String> lEmp) {
			this.lEmp = lEmp;
		}
		

    
    //***********************************************************

}
