package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.CarteCarburant;
import model.Vehicule;
import model.VisiteTechnique;

public class VisiteDao implements DaoInterface<VisiteTechnique>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VisiteDao() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
	}

	EntityManagerFactory emf = null;  
	EntityManager em = null;

	@Override
	public int supp(VisiteTechnique t) {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		 VisiteTechnique v = em.find(VisiteTechnique.class, t.getNum());
	em.remove(v);
	
	em.getTransaction().commit();
	return 0;
	}

	@Override
	public int mod(VisiteTechnique t) {
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
	public int ajout(VisiteTechnique t) {

		try {
			em.persist(t);
		    em.getTransaction().commit();
		}
		  
		    catch (Exception e) {
	return 0;	    }
		    return 1;
	}

	@Override
	public List<VisiteTechnique> liste() {
	
		List<VisiteTechnique>	l=em.createNamedQuery("VisiteTechnique.findAll",VisiteTechnique.class).getResultList();
		if(l==null)
		return null;
	    return l;
	}

}
