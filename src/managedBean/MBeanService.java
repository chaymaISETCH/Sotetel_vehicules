package managedBean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personnel;
import model.Service;
import model.Vehicule;

public class MBeanService {

	
	
	
	
	
	
	
	

	
	public MBeanService() {
		
	}


//*************************************************
	
	
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

		em.persist(e);
	    em.getTransaction().commit();
	    System.out.print("gd service ajout");
	
		
		return "";
	}

//*****************************************************************
	
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
	//*************************************
public String mod(Service s) {
		
		System.out.println("mod"+s.getService());
		return"";
		
		
	}
	
}