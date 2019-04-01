package managedBean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.context.RequestContext;

import model.AffectationService;
import model.AffectationServicePK;
import model.Service;
import model.Vehicule;

public class MBService implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public MBService() {
		// TODO Auto-generated constructor stub
	}

	
	

	
	Service e = new Service();
	
	
	public Service getE() {
		return e;
	}


	public void setE(Service e) {
		this.e = e;
	}
	
	
	EntityManagerFactory emf = null;  
	EntityManager em = null;
//**********************************************************
	

	
	public String ajout()
	{
		System.out.print("hiiiiiiiiii service ajout");
	


		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		 List<Vehicule> lV = new ArrayList<Vehicule>();
			 



		em.persist(e);
	    em.getTransaction().commit();
	
	   
	    System.out.print("gd service ajout");
	
		
		return "";
	}

//*****************************************************************
	
	
	public String ajout2()
	{
		System.out.print("hiiiiiiiiii service ajout");
	


		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		
		 List<Vehicule> lV = new ArrayList<Vehicule>();
			 



	
	    for(int i = 0 ;i<lMat.size();i++) {
	    	
	    	Vehicule v = new Vehicule();
	    	v.setMatricule(lMat.get(i));
	    	lV.add(v);
	    	 v = em.find(Vehicule.class, lMat.get(i));
	    	 AffectationService aff = new AffectationService();

	    	 AffectationServicePK a = new AffectationServicePK();
	    	 
	    	 a.setMatricule(lMat.get(i));
	    	 a.setSer(e.getService());
	    	 
	    	 aff.setId(a);
	    	 
	    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    		Date date = new Date();
	    		//System.out.println(dateFormat.format(date));
	    	
	    	 
	    	 
	    	 aff.setVehicule(v);
	    	 aff.setService(e);
	    	 em.getTransaction().begin();	 
	    		em.persist(aff);
	    	    em.getTransaction().commit();
	    	 
	    }

	    System.out.print("gd service ajout");
	
		
		return "";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private List<Service> l;


	public List<Service> getL() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		l=em.createNamedQuery("Service.findAll",Service.class).getResultList();
	    em.getTransaction().commit();
	    return l;
	}


	public void setL(List<Service> l) {
		this.l = l;
	}
	
//****************************************************************
	
	private Service selservice;


	public Service getSelservice() {

	    return selservice;
	}


	public void setSelservice(Service l ) {
		this.selservice = l;
	}	
	
	//***********************************
	public String supp(Service s) {
		
		System.out.println("supp"+s.getService());
		
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		 Service v = em.find(Service.class, s.getService());
	em.remove(v);
	em.getTransaction().commit();
		
		
		return "";
		
	
		
	}
	private Service sancien;
	public Service getSancien() {
		return sancien;
	}


	public void setSancien(Service sancien) {
		this.sancien = sancien;
	}


//*************************************
public String mod() {
		
		
		
		
		
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		 Service v = em.find(Service.class, selservice.getService());
	em.remove(sancien);
	em.persist(v);
	em.getTransaction().commit();
		
		
	
		
		return"";
		
		
	}
public String modif()
{System.out.print("hi   modif    "+selservice.getService());
	System.out.print("hi   modif"+sancien.getService());

//********************************************************
	
	try{emf = Persistence.createEntityManagerFactory("sotetel"); 
	em = emf.createEntityManager();   

	

	        em.getTransaction().begin();
	        int m = em.createQuery("update Service  s set s.service='"+selservice.getService()+"',des='"+selservice.getDes()+
	        		"'where s.service='"+sancien.getService()+"'").executeUpdate();

	        em.getTransaction().commit();


	    } catch(Exception e) {
	        System.out.println("" + e);
	    }
	    finally {
	        if(em != null) {
	            em.close();
	        }
	    }	
	
	
	
	
	
	
//***********************************************************
	return "";
	
}






private List<String> lMat;


public List<String> getlMat() {
	
	emf = Persistence.createEntityManagerFactory("sotetel"); 
	em = emf.createEntityManager();  
   lMat =(List<String>) em.createQuery("select matricule from Vehicule").getResultList();
	
	
	
	
	
	
	
	return lMat;
}

public void setlMat(List<String> lMat) {
	this.lMat = lMat;
}







public String modif2()
{
	//System.out.print("hi   modif    "+selservice.getService());
	//System.out.print("hi   modif"+sancien.getService());
	sancien=new Service();
	sancien.setService(selservice.getService()+"");
	RequestContext.getCurrentInstance().update(":f");
	RequestContext context = RequestContext.getCurrentInstance();
	context.execute("PF('carDialog').show();");

	return "";
	
}


}