package managedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import dao.CarteDao;
import model.CarteCarburant;
import model.Vehicule;
import model.VisiteTechnique;
public class MBCarte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public MBCarte() {
		// TODO Auto-generated constructor stub
	}
	//*******************************************************
	EntityManagerFactory emf = null;  
	EntityManager em = null;
	
	
	 private List<String> images;
    
 
        
    
 
    public List<String> getImages() {
    	images = new ArrayList<String>();
       for(int i=0;i<6;i++)
            images.add("i"+i+".jpg");
          
        return images;
    }
	
	
	
	CarteDao dao = new CarteDao();
	
	public CarteDao getDao() {
		return dao;
	}
	public void setDao(CarteDao dao) {
		this.dao = dao;
	}


	private String mat;
	public void setMat(String m)
	{
		
		mat=m;
	}
	public String getMat() {
		
		return mat;
	}
	

	
	
	CarteCarburant e = new CarteCarburant();
	
	
	public CarteCarburant getE() {
		return e;
	}


	public void setE(CarteCarburant e) {
		this.e = e;
	}
	
	
	
//**********************************************************
	

	
	public String ajout()
	{
		System.out.print("hiiiiiiiiii carte ajout");
	


	
Vehicule v = new Vehicule();
v.setMatricule(mat);
e.setVehicule(v);
	int i =dao.ajout(e);
	if(i==0) {
		
		
		  FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage("msg",new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur" ,  "carte n°"+e.getNum()+" déjà existante") );
	}
	    System.out.print("gd carte ajout");
	
		
		return "";
	}

//*****************************************************************
	
	private List<CarteCarburant> l;
	private List<CarteCarburant> ll;


	public List<CarteCarburant> getLl() {
		System.out.print(mf);
		return ll;
	}
	public void setLl(List<CarteCarburant> ll) {
		this.ll = ll;
	}
	public List<CarteCarburant> getL() {
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		l=em.createNamedQuery("CarteCarburant.findAll",CarteCarburant.class).getResultList();
		
	    em.getTransaction().commit();
	    if(l==null)return null;
	    else
	    return l;
	}


	public void setL(List<CarteCarburant> l) {
		this.l = l;
	}

	private String mf;
	
//****************************************************************
	
	public String getMf() {
		return mf;
	}
	public void setMf(String mf) {
		this.mf = mf;
	}
	
	

	
	
	private CarteCarburant selservice;


	public CarteCarburant getSelservice() {

	    return selservice;
	}


	public void setSelservice(CarteCarburant l ) {
		this.selservice = l;
	}	
	
	//***********************************
	public String supp(CarteCarburant s) {
		
		System.out.println("supp"+s.getNum());
		
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		 CarteCarburant v = em.find(CarteCarburant.class, s.getNum());
	em.remove(v);
	
	em.getTransaction().commit();
		
		
		return "";
		
	
		
	}
	private CarteCarburant sancien;
	public CarteCarburant getSancien() {
		return sancien;
	}


	public void setSancien(CarteCarburant sancien) {
		this.sancien = sancien;
	}


//*************************************
public String mod() {
		
		
		
		
		
		emf = Persistence.createEntityManagerFactory("sotetel"); 
		em = emf.createEntityManager();   
		 em.getTransaction().begin();
		 CarteCarburant v = em.find(CarteCarburant.class, selservice.getNum());
	em.remove(sancien);
	em.persist(v);
	em.getTransaction().commit();
		
return "";

	
	
	
	
		
		
	}
public String modif()
{System.out.print("hi   modif    "+selservice.getNum());
	System.out.print("hi   modif"+sancien.getNum());

//********************************************************
	
	
	
	
Vehicule v = new Vehicule();
v.setMatricule(selservice.getVehicule().getMatricule());
selservice.setVehicule(v);
	int i =dao.mod(sancien.getNum(),selservice);

	
	
	if(i==0) {
		
		
		  FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage("msg",new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur" ,  "carte n°"+e.getNum()+" déjà existante") );
	}
	    System.out.print("gd carte ajout");
	
		
		return "";
	
	
	
	
//***********************************************************

	
}
private String m;


public String getM() {
	return m;
}
public void setM(String m) {
	this.m = m;
}
public String modifff(RowEditEvent event) {
	System.out.println("okkkkkkkkkkkkkkkkkkkkkkkk");

	 CarteCarburant t= (CarteCarburant) event.getObject();
	 Vehicule v = new Vehicule();
			 v.setMatricule(m);
t.setVehicule(v);
System.out.println(t.getVehicule().getMatricule());

	 em.getTransaction().begin();

em.merge(t);
em.getTransaction().commit();

return "";


}




public String modif2()
{
	//System.out.print("hi   modif    "+selservice.getService());
	//System.out.print("hi   modif"+sancien.getService());
	sancien=new CarteCarburant();
	sancien.setNum(selservice.getNum());
	RequestContext.getCurrentInstance().update(":f");
	RequestContext context = RequestContext.getCurrentInstance();
	context.execute("PF('carDialog').show();");

	return "";
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//************************************************

}
