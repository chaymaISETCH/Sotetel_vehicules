package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personnel;
import model.Service;

public class EmployeDao implements DaoInterface<Personnel>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = null;  
	EntityManager em = null;
	public EmployeDao() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();  		  	}

	@Override
	public int supp(Personnel t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int login(String l,String p) {
		System.out.println("login1"+l+"password"+p);

		try
		{

		Query query = em.createQuery("SELECT u FROM Personnel u WHERE u.login='"+l+"' AND u.motDePasse='"+p+"'");
		if(query.getResultList().size() == 0){
		    return 0;
		}else{
		    return 1;
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			
		}
		return 0;

			
	}
	
	
public Personnel find(String login) {
	Personnel e ;
	 e = em.find(Personnel.class,login);
	 return e;
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//******************************************************
	
	
	
	
	@Override
	public int mod(Personnel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajout(Personnel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Personnel> liste() {
		// TODO Auto-generated method stub
		return null;
	}

}
