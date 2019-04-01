package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.*;
import model.CarteCarburant;
import model.Vehicule;
import model.Assurance;

public class CompagnieDao implements DaoInterface<Compagnie>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompagnieDao() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
	}

	EntityManagerFactory emf = null;  
	EntityManager em = null;

	@Override
	public int supp(Compagnie t) {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		 Compagnie v = em.find(Compagnie.class, t.getNum());
	em.remove(v);
	
	em.getTransaction().commit();
	return 0;
	}

	@Override
	public int mod(Compagnie t) {
		try {

			em.merge(t);
			
		    em.getTransaction().commit();
		}
		  
		    catch (Exception e) {
		    	System.out.println("exppptttionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
	return 0;	    }
		    return 1;
	}

	@Override
	public int ajout(Compagnie t) {

		try {
			em.persist(t);
		    em.getTransaction().commit();
		    
		}
		  
		    catch (Exception e) {
	return 0;	    }
		    return 1;
	}

	@Override
	public List<Compagnie> liste() {
	
		List<Compagnie>	l=em.createNamedQuery("Compagnie.findAll",Compagnie.class).getResultList();
		if(l==null)
		return null;
	    return l;
	}

}
