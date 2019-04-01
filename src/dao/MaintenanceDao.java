package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.*;
public class MaintenanceDao implements DaoInterface<Maintenance>{

	public MaintenanceDao() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();	}

	EntityManagerFactory emf = null;  
	EntityManager em = null;
	@Override
	public int supp(Maintenance t) {
		Maintenance v = em.find(Maintenance.class, t.getNum());
		 em.remove(v);

		 em.getTransaction().commit();
		 return 1;
	}

	@Override
	public int mod(Maintenance t) {
	
		em.merge(t);

		 em.getTransaction().commit();		return 0;
	}

	@Override
	public int ajout(Maintenance t) {
em.persist(t);

em.getTransaction().commit();
return 0;
	}

	@Override
	public List<Maintenance> liste() {
		List<Maintenance>	l=em.createNamedQuery("Maintenance.findAll",Maintenance.class).getResultList();
		if(l==null)
		return null;
	    return l;	}
	
	
	
	
	
	public Long stat(String mat,int date) {
		Long m=0L;
	 	try{
    		
    		emf = Persistence.createEntityManagerFactory("sotetel"); 
    		em = emf.createEntityManager();   
    		 em.getTransaction().begin();
    	         m =(Long) em.createQuery("select count(*) from Maintenance where YEAR(date)='"+date+"'").getSingleResult();
    	         	System.out.println("count         "+m+"");


    	    } catch(Exception e) {
    	        System.out.println("leeeeeeeeeeeeeeeeeee" + e);
    	    }
    	    finally {
    	        if(em != null) {
    	            em.close();
    	        }
    	    }
    	
		
		return m;
		
	}

}
