package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.CarteCarburant;
import model.Vehicule;
import model.Assurance;

public class AssuranceDao implements DaoInterface<Assurance>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AssuranceDao() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
	}

	EntityManagerFactory emf = null;  
	EntityManager em = null;

	@Override
	public int supp(Assurance t) {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		 Assurance v = em.find(Assurance.class, t.getNum());
	em.remove(v);
	
	em.getTransaction().commit();
	return 0;
	}
	
	
	
	
public int mod(int num,Assurance c) {

		
		
	
		
		try{emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   

		

		        em.getTransaction().begin();
		        int m = em.createQuery("update Assurance  s set s.num="+c.getNum()+",dateDeb='"+c.getDateDeb()+
		        		"' ,dateFin='"+c.getDateFin()+"', type='"+c.getType()+"' where s.num="+num+"").executeUpdate();
em.merge(c);
		        em.getTransaction().commit();


		    } catch(Exception e) {
return 0;		    }
		    finally {
		        if(em != null) {
		            em.close();
		        }
		    }	
		
		
		
		
		
		
		
		
		
		
		return 1;
	}
//**************************************
	
	
//*******************************************************************
	@Override
	public int mod(Assurance t) {
		try {

			em.merge(t);
			em.merge(t.getCompagnie());
		    em.getTransaction().commit();
		}
		  
		    catch (Exception e) {
		    	System.out.println("exppptttionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
	return 0;	    }
		    return 1;
	}

	@Override
	public int ajout(Assurance t) {

		try {
			em.persist(t);
			
		    em.getTransaction().commit();
		    
		}
		  
		    catch (Exception e) {
		    	System.out.println(e.getMessage());
	return 0;	    }
		    return 1;
	}

	@Override
	public List<Assurance> liste() {
	
		List<Assurance>	l=em.createNamedQuery("Assurance.findAll",Assurance.class).getResultList();
		if(l==null)
		return null;
	    return l;
	}

}
