package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.CarteCarburant;

public class CarteDao implements DaoInterface<CarteCarburant> {

	public CarteDao() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
	}

	EntityManagerFactory emf = null;  
	EntityManager em = null;
	
	@Override
	public int supp(CarteCarburant t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int mod(CarteCarburant t) {
		// TODO Auto-generated method stub
		return 0;
	}
//**************************************
	public int mod(int num,CarteCarburant c) {

		
		
	
		
		try{emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   

		

		        em.getTransaction().begin();
		        int m = em.createQuery("update CarteCarburant  s set s.num="+c.getNum()+",solde="+c.getSolde()+
		        		"where s.num="+num+"").executeUpdate();
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
	@Override
	public int ajout(CarteCarburant t) {

	try {
		em.persist(t);
	    em.getTransaction().commit();
	}
	  
	    catch (Exception e) {
return 0;	    }
	    return 1;
	}

	@Override
	public List<CarteCarburant> liste() {
		// TODO Auto-generated method stub
		return null;
	}


}
