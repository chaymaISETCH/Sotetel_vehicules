package managedBean;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import model.Vehicule;

public class UploadImageVehicule implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UploadImageVehicule() {
		
	}
	//*******************************************
	
	private Vehicule vv=new Vehicule();
	
	public Vehicule getVv() {
		return vv;
	}


	public void setVv(Vehicule vv) {
		this.vv = vv;
	}

	
	
	
	
	//*********************************************
	private Vehicule v;
	
	public Vehicule getV() {
		return v;
	}


	public void setV(Vehicule v) {
		this.v = v;
	}

	private UploadedFile uploadedFile; // +getter+setter

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}


	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}


	public void upload() {
    	System.out.println("hiiiii hiiii upload");

	}
	
	
	
	
	private UploadedFile i2; // +getter+setter

	public UploadedFile getI2() {
		return i2;
	}


	public void setI2(UploadedFile uploadedFile) {
		this.i2 = uploadedFile;
	}
	
	  public void file(FileUploadEvent event) {
		  
		  System.out.println("hiiiii hiiii upload Succesful"+ event.getFile().getFileName() + " is uploaded.");
		 

		  //  byte[] i =   event.getFile().getContents();
		    byte[] i2 =   event.getFile().getContents();
	
vv.setImage(i2);

    		
    		System.out.println("immmmmmmmmaaaaaaaaaaage");
    	    
    	 
    		  FacesContext context = FacesContext.getCurrentInstance();
    	         
    	        context.addMessage("msg", new FacesMessage( event.getFile().getFileName() ,  "téléchargement réussi") );
    	    
 
	    }
	
	//*************
	  private UploadedFile f;
	  
	    public UploadedFile getF() {
	        return f;
	    }
	 
	    public void setFile(UploadedFile file) {
	        this.f = file;
	    }
	     
	    public String u() {
	    	System.out.println("hiiiii hiiii upload");

	        if(f != null) {
	        	System.out.println("hiiiii hiiii upload 2éme");

	            FacesMessage message = new FacesMessage("Succesful", f.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
	        return "";
	    }
	  
	  
	  //********
	    public String edit(Vehicule v) {
	    	
	    	System.out.println(v.getMatricule()+"okkkkkkkkkkkk");
	    	return "";
	    	
	    	
	    	
	    	
	    }
	    
	    //*******************************************
    public String editt(Vehicule v) {
	    	
	    	System.out.println(v.getMatricule());
	    	return "";
	    	
	    	
	    	
	    	
	    }
	    //*******************************************
	  public String ajout() {
		  
		  System.out.println("ajouuuuthiiii");
		  if(vv.getImage()==null) {
			  

    		  FacesContext context = FacesContext.getCurrentInstance();
    	         
    	        context.addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Image" ,  "Il semblerait que vous n'avez pas encore ajouté d'image !") );
		  }
		  else {
	   	    EntityManagerFactory emf = null;  
	    		EntityManager em = null;
			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager();   
			
			 em.getTransaction().begin();
			 em.persist(vv);
 		    em.getTransaction().commit();
 		   FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage("msg", new FacesMessage("Véhicule" ,  "Véhicule a été ajouté avec succès") );
	   
		  
		  
		  }
		  return "";
		  
	  }
	 
	  
    public void handleFileUpload() {
    	System.out.println("hiiiii hiiii upload");
    	//System.out.println(""+uploadedFile.getSize()+uploadedFile.getFileName());
    	
    	    byte[] image = uploadedFile.getContents();
    	    EntityManagerFactory emf = null;  
    		EntityManager em = null;
    			
    			emf = Persistence.createEntityManagerFactory("sotetel"); 
    			em = emf.createEntityManager();   
    			 em.getTransaction().begin();


    			 Vehicule v = new Vehicule();
    			// v.setCarte("256355");
    			 v.setMatricule("55555555");
    			// v.setNbPlace(5);
    			 v.setPuissance(5);
    			 v.setImage(image);
    			 
em.persist(v);    			 
    		    em.getTransaction().commit();
    		
    		
    		System.out.println("immmmmmmmmaaaaaaaaaaage");
    	    
    	 
   
    	
       // FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
      //  FacesContext.getCurrentInstance().addMessage(null, message);
 
    
    
    }
}