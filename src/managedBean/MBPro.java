package managedBean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.sasl.SaslClient;

import org.primefaces.context.RequestContext;

import model.Mission;
import model.Personnel;
import model.Projet;

public class MBPro implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Projet ancien;
	public Projet getAncien() {
        return selectedPro;
    }
	
	
	
	
	
	
 
    public void setAncien(Projet a) {
        this.ancien = a;
    }
    
    private int i;
    
  public int getI() {
		return i;
	}







	public void setI(int i) {
		this.i = i;
	}







public String showpage() {
	  
	  i=pro.getCode();
	  
	  
	  return "AjoutMission";
  }
    

public MBPro() {
		
	}

	public String cc()
	{
		System.out.print("ccccccccccccc");
		return "";
	
	}	
	
	private Projet proS;

	public Projet getProS() {

		return proS;
	}

	public void setProS(Projet proS) {
		this.proS = proS;
	}

	    
	    
	
	
	private Projet pro = new Projet();
	
public Projet getPro() {

		return pro;
	}

	public void setPro(Projet pro) {
		this.pro = pro;
	}

	
	
	EntityManagerFactory emf = null;  
	EntityManager em = null;

		

  
	
    public String ajout()
	{
		System.out.print("fghjklljhxw");
		
	

		System.out.print(pro.getLib());

		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();

		em.persist(pro);
	    em.getTransaction().commit();

	
		
		return "";
	}
    
    //***********************************************************
    
    
    
    
    
    List<Projet> l = new ArrayList<Projet>();
	public List<Projet> getL() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
l=em.createNamedQuery("Projet.findAll",Projet.class).getResultList();
return l;	}
    
    
    
    
    
	public void setL(List<Projet> l) {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
l=em.createNamedQuery("Projet.findAll",Projet.class).getResultList();

	}

	List<Mission> ll = new ArrayList<Mission>();
	
   /* List<Mission> ll = new ArrayList<Mission>();
	public List<Mission> getLl() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
ll=em.createNamedQuery("Mission.findAll",Mission.class).getResultList();
return ll;	}
    
    
    
    
    
	public void setLl(List<Mission> l) {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
ll=em.createNamedQuery("Mission.findAll",Mission.class).getResultList();

	}*/
	
	
	
	public List<Mission> getLl() {
		return ll;
	}







	public void setLl(List<Mission> ll) {
		this.ll = ll;
	}







	public List<Projet> ok() {
		
		System.out.println("okkkk");
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
l=em.createNamedQuery("Projet.findAll",Projet.class).getResultList();
	    em.getTransaction().commit();
		//System.out.println(l.get(0).getNom());
	    
	  if(l.isEmpty())
		  return null;
		  else
	return l;
	
}
    
    
	
	
	public String supp(int proj)
	{
		
		System.out.println("supp find"+proj);
		
		
	
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		  
		 Projet p = em.find(Projet.class, proj);
em.remove(p);
	    em.getTransaction().commit();
	   
		System.out.println("suuuuuuuuuupppp");
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		    try {
				ec.redirect("ListeProjetV2.xhtml");
			} catch (IOException ee) {
			
			}

		return "";
		
		
		
	}
	//************************************************************
	
	
	
public String edit(int code) {
		
		System.out.println("showwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

		System.out.println("loginnnnnnnnnnnnnn"+code);
	
	
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlg4').show();");
		System.out.println("succés");
		//********************************************************

		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager(); 
		
		
		proS=em.find(Projet.class, code);
		ancien.setCode(proS.getCode());
		System.out.println("NOMMMMMMMMMMMMMMMMMMMMMMMMMM"+proS.getLib());

		 
		
		//**********************************************************
		RequestContext.getCurrentInstance().update("ffff");

		RequestContext.getCurrentInstance().update("ok");
	RequestContext.getCurrentInstance().update("detaill");
	
		
		
		
		return "";
		
		
	}
	
	//*********************************
    
Projet p=new Projet();
    
    //************************************************************
	
	private Projet selectedPro;
	public Projet getSelectedPro() {
        return selectedPro;
    }
 
    public Projet getP() {
		return p;
	}

	public void setP(Projet p) {
		this.p = p;
	}

	public void setSelectedPro(Projet selectedPro) {
        this.selectedPro = selectedPro;
    }
    //**************************************************

    public String modif() {
    	System.out.println("moddddddddddddddddddd"+proS.getCode());
    	System.out.println("moddddddddddddddddddd"+ancien.getCode());
    	try{
    		
    		emf = Persistence.createEntityManagerFactory("sotetel"); 
    		em = emf.createEntityManager();   
    		 em.getTransaction().begin();
    	        int m = em.createQuery("update Projet p set lib='"+proS.getLib()+
    	        	
    	        		"',dateDeb="+proS.getDateDeb()+",duree="+proS.getDuree()+"'where login='"+ancien.getCode()+"'").executeUpdate();

    	        em.getTransaction().commit();


    	    } catch(Exception e) {
    	        System.out.println("leeeeeeeeeeeeeeeeeee" + e);
    	    }
    	    finally {
    	        if(em != null) {
    	            em.close();
    	        }
    	    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	return "";
    	
    	
    }


    
    
    
    
    
}
