package managedBean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.context.RequestContext;

import dao.EmployeDao;
import model.*;
public class MBEmp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EmployeDao dao = new EmployeDao();
	public MBEmp() {
		
	}
	
	//*************************************
	
	
	//******************************************
	private String login;
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String cc()
	{
		System.out.print("cccccccccccccf"+login+e.getMotDePasse()+"dddd");
		int i = dao.login(login, e.getMotDePasse());

		if(i==0) {
			
			

			System.out.print("noooooo 000000000000000000000");

		}
		
		else {
			return "/IndexRes.xhtml?faces-redirect=true";
						
		}
		
	return"";}
	
	private String log;
	private String mot;

	public String getLog() {
		return log;
	}

	public void setLog(String l) {
		this.log = l;
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String m) {
		this.mot = m;
	}

	public String a()
	{
	
	int i = dao.login(log, mot);
	if(i==0) {
		
		

		  FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage("msg",new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur" ,  "carte n° déjà existante") );
		return "";
		
	}
	
	else
		return "AddCar2.xhtml";
	}	
//*************************************************
	
	
	Personnel e = new Personnel();
	
	
	public Personnel getE() {
		return e;
	}


	public void setE(Personnel e) {
		this.e = e;
	}
	
	
	EntityManagerFactory emf = null;  
	EntityManager em = null;
//**********************************************************
	

	public String change()
	{
		System.out.print("changeeeeeeeeeeeeeee");
	return "";	
	}
	
	
	private String nom_prenomm;
	
	
	
	
	public String getNom_prenomm() {
		Personnel e= dao.find(MBLogin.e.getLogin());
		nom_prenomm=e.getPrenom()+" "+e.getNom();
		return nom_prenomm;
	}

	public void setNom_prenomm(String nom_prenomm) {
		this.nom_prenomm = nom_prenomm;
	}

	public String ajout()
	{
		System.out.print("fghjklljhxw");
		
		/*e.setLogin("chayma01");
		e.setAdresse("edfghjk");
		e.setCin(07474452);
		e.setEmail("rdfghjklm,");
		e.setNom("dfghjklkjh");
		e.setPrenom("wsxdcfgvhbjnk,");
		e.setTel(27035873);
*/
		System.out.print(e.getNom());

		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();

		em.persist(e);
	    em.getTransaction().commit();

	    FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage("msg", new FacesMessage("Employé" ,  "Employé a été ajouté avec succès") );
   
	  
		
		return "";
	}
	
	//***************************************************************************************
	//*************************************************************************************
	
 
 
		
		
		private Personnel empS = new Personnel();
		
	public Personnel getEmpS() {

			return empS;
		}

		public void setEmpS(Personnel empS) {
			this.empS = empS;
		}

		//*************************************************
		public String show(String login) {
			
			System.out.println("showwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

			System.out.println("loginnnnnnnnnnnnnn"+login);
		
		
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlg3').show();");
			System.out.println("succés");
			//********************************************************

			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager(); 
			
			
			empS=em.find(Personnel.class, login);
			
			System.out.println("NOMMMMMMMMMMMMMMMMMMMMMMMMMM"+empS.getNom());

			 
			
			//**********************************************************
			RequestContext.getCurrentInstance().update("fff");

			RequestContext.getCurrentInstance().update("ok");
		RequestContext.getCurrentInstance().update("detail");
		
			
			
			
			return "";
			
			
		}
		
	//*******************************************************************
		
		private Personnel ancien;
		public Personnel getAncien() {
	        return selectedEmp;
	    }
	 
	    public void setAncien(Personnel a) {
	        this.ancien = a;
	    }
		//*****************************************************	
		
	public String edit(String login) {
			
			System.out.println("showwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

			System.out.println("loginnnnnnnnnnnnnn"+login);
		
		
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlg4').show();");
			System.out.println("succés");
			//********************************************************

			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager(); 
			
			
			empS=em.find(Personnel.class, login);
			ancien = new Personnel();
			ancien.setLogin(empS.getLogin());
			System.out.println("NOMMMMMMMMMMMMMMMMMMMMMMMMMM"+empS.getNom());

			 
			
			//**********************************************************
			RequestContext.getCurrentInstance().update("ffff");

			RequestContext.getCurrentInstance().update("ok");
		RequestContext.getCurrentInstance().update("detaill");
		
			
			
			
			return "";
			
			
		}
		

		
		
		
		//**********************************************************************
 
		
		//**************************************************
		

	  
		
		//***********************************************************
		
		 
		
		public String supp(String emp)
		{
			
			System.out.println("supp find"+emp);
			
			
		
			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager();   
			 em.getTransaction().begin();
			  
			 Personnel e = em.find(Personnel.class, emp);
	em.remove(e);
		    em.getTransaction().commit();
		   
			System.out.println("suuuuuuuuuupppp");
			RequestContext.getCurrentInstance().update(":ajoutArticle:l");

			return "";
			
			
			
		}
		
		
 
		//**************************

		List<Personnel> l = new ArrayList<Personnel>();
		public List<Personnel> getL() {
			return ok();
		}
		public void setL(List<Personnel> l) {
			this.l = ok();
		}
		
		public List<Personnel> ok() {
			
			System.out.println("okkkk");
			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager();   
			 em.getTransaction().begin();
	l=em.createNamedQuery("Personnel.findAll",Personnel.class).getResultList();
		    em.getTransaction().commit();
			//System.out.println(l.get(0).getNom());
		    
		  if(l.isEmpty())
			  return null;
			  else
		return l;
		
	}
		private Personnel selectedEmp;
		public Personnel getSelectedEmp() {
	        return selectedEmp;
	    }
	 
	    public void setSelectedEmp(Personnel selectedEmp) {
	        this.selectedEmp = selectedEmp;
	    }
	    //**************************************************

	    public String modif() {
	    	System.out.println("moddddddddddddddddddd"+empS.getLogin());
	    	System.out.println("moddddddddddddddddddd"+ancien.getLogin());
	    	try{
	    		
	    		emf = Persistence.createEntityManagerFactory("sotetel"); 
	    		em = emf.createEntityManager();   
	    		 em.getTransaction().begin();
	    	        int m = em.createQuery("update Personnel e set nom='"+empS.getNom()+
	    	        		"',prenom='"+empS.getPrenom()+"',fonction='"+empS.getFonction()+"',login='"+empS.getLogin()
	    	        		+"',email='"+empS.getEmail()+"',motDePasse='"+empS.getMotDePasse()+"',sexe='"+empS.getSexe()+
	    	        		"',cin="+empS.getCin()+",tel="+empS.getTel()+",adresse='"+empS.getAdresse()+"'where login='"+ancien.getLogin()+"'").executeUpdate();

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
	    
	    
	    
	    
	    
	    //*************************************************
	    
	    
	    
		private List<String> lMat;
		
		
		public List<String> getlMat() {
			
			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager();  
		   lMat =(List<String>) em.createQuery("select login from Personnel").getResultList();
			
			
			
			
			
			
			
			return lMat;
		}

		public void setlMat(List<String> lMat) {
			this.lMat = lMat;
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	//************************************************************************************
	
	
	
 