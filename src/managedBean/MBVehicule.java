package managedBean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


import java.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;

import model.*;
public class MBVehicule {
	List<StreamedContent> list=new ArrayList<StreamedContent>();
	private Vehicule carS;
	public Vehicule getCarS() {
		
		return carS;
	}
	
	public void setCarS(Vehicule c)
	{carS=c;}
	//***************************************
public 	List<StreamedContent> getList(){
	
	return list;
}
	//********************************************

public String edit(Vehicule v) {
	
	System.out.println(v.getMatricule());
	return "";
	
	
	
	
}
public String ccc() {
	
	System.out.println("timerrrrrrrrrrrrrrr");
	return "";
	
	
	
	
}
//*********************************************
public String supp(Vehicule c) {

	emf = Persistence.createEntityManagerFactory("sotetel"); 
	em = emf.createEntityManager();   
	 em.getTransaction().begin();
	 Vehicule v = em.find(Vehicule.class, c.getMatricule());
em.remove(v);
em.getTransaction().commit();
	
ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
try {
	ec.redirect("CarsV3.xhtml");
} catch (IOException ee) {

}
	return "";
	
	
}
List<Image> listImage=new ArrayList<Image>();

public 	List<Image> getListImage(){

return listImage;
}


//******************************************
private int i=0;





	public MBVehicule() {	
	
	
	
	
	List<Vehicule> l = new ArrayList<Vehicule>();
	EntityManagerFactory emf = null;  
	EntityManager em = null;
		
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
l=em.createNamedQuery("Vehicule.findAll",Vehicule.class).getResultList();
	    em.getTransaction().commit();
	
	
	System.out.println("immmmmmmmmaaaaaaaaaaage");
	
	
	
	
	
	
	
	
	
	
	
	


	
for(int i=0;i<l.size();i++) {
	System.out.println(i);
	InputStream dbStreamm =  new ByteArrayInputStream(l.get(i).getImage()); 

	dbImage = new DefaultStreamedContent(dbStreamm, "image/png");

	list.add(dbImage);
	listImage.add(new Image(i,list.get(i)));
	
}

//*******************************************



System.out.println(list.size());

	}
	
	public String show()
	
	{
		
		
		
		return "";
	}
	public List<Vehicule> getL() {
		return ok();
	}

	public void setL(List<Vehicule> l) {
		this.l = ok();
	}
	List<Vehicule> l = new ArrayList<Vehicule>();
	EntityManagerFactory emf = null;  
	EntityManager em = null;
	public List<Vehicule> ok() {
		
		System.out.println("okkkk");
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
l=em.createNamedQuery("Vehicule.findAll",Vehicule.class).getResultList();
		//System.out.println(l.get(2).getCarte());
	
		

	return l;
	
}
	
	//*****************************************************************************************************************************
	private List<String> lMat;
	
	
	public List<String> getlMat() {
		
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();  
	   lMat =(List<String>) em.createQuery("select matricule from Vehicule").getResultList();
		
		
		
		
		
		
		
		return lMat;
	}

	public void setlMat(List<String> lMat) {
		this.lMat = lMat;
	}
	
		
	
	//************************************Image****************************************


	
	//*******************************************************
	private StreamedContent dbImage;
	private StreamedContent db;

	public StreamedContent getDbImage() {
		
		return dbImage;
	}
	public StreamedContent o(String s) {
     

		return list.get(2);
	}

	public void setDbImage(StreamedContent dbImage) {
		

		this.dbImage = dbImage;
	}

//**********************************************************
	
	
	public StreamedContent getProductImage() throws IOException, SQLException {
		 
		FacesContext context = FacesContext.getCurrentInstance();
 
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}
 
		else {
 
			String id = context.getExternalContext().getRequestParameterMap()
					.get("pid");
 System.out.println("iddddddddddddddddddddddddddddddddddddd"+id);
		return listImage.get(Integer.parseInt(id)).getImage();
		//return listImage.get(i++).getImage();

 
		}
	}
	//*************************************************************************
	
	
	
	public StreamedContent getProductImagee() throws IOException, SQLException {
		 
		FacesContext context = FacesContext.getCurrentInstance();
 
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}
 
		else {
 
			String id = context.getExternalContext().getRequestParameterMap()
					.get("pid");
 System.out.println("iddddddddddddddddddddddddddddddddddddd Matricule"+id);
	//****************************************************************
		
		
		
	
			
			emf = Persistence.createEntityManagerFactory("sotetel"); 
			em = emf.createEntityManager();   

		
			
			
			
			Vehicule v = em.find(Vehicule.class, id);
			 //System.out.println("fdhfdhkjdfhdfkjhfdjhfdjh            "+v.getCarte());

		//******************************************************************************
			try {
			InputStream dbStreamm =  new ByteArrayInputStream(v.getImage()); 

			db = new DefaultStreamedContent(dbStreamm, "image/png");
			}
			catch(Exception e){}
		
			
			
			
			
			//*************************************************************
			
			
			
			return db;
			//return listImage.get(Integer.parseInt("1")).getImage();

		
		
		
		
		
		//return listImage.get(i++).getImage();

 
		}
	}
	
	
	//*********************************************************************
	
	
	public StreamedContent getProduct() throws IOException, SQLException {
	
		return listImage.get(i++).getImage();

 
		}
	
	
	
	
	public String message() {
		
		
		
		
		System.out.println("hi hi hi upload");
		return "";
	}
	}
	
	
	
	//********************************************************************************
	
	
	
	


