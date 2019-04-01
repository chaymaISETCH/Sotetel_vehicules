package managedBean;

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
import dao.MaintenanceDao;
import model.CarteCarburant;
import model.Maintenance;
import model.Vehicule;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import dao.VisiteDao;
import model.CarteCarburant;
import model.Vehicule;
import model.VisiteTechnique;

public class MBMaintenance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MBMaintenance() {
		mainDT2.setVehicule(v);	}


//****************************************************************

	//***********************************
	public String supp(Maintenance s) {
		
		System.out.println("supp"+s.getNum());
		dao.supp(s);		
		return "";
		
	
		
	}
	
	
//******************************************************	
	public String test(Maintenance s) {
		
		System.out.println("supp"+s.getNum());
	
		
		return "";
		
	
		
	}
	//********************modifierrrrrrrrrrrrrrrrrrrrrrrrrr
	
	public String test() {
		System.out.print(selmain.getNum());

		
		int i = dao.mod(selmain);
	    RequestContext.getCurrentInstance().execute("PF('carDialog').hide()");

		RequestContext.getCurrentInstance().update(":f1");
		   FacesMessage msg = new FacesMessage("Visite Technique N°  a été modifié","" );
	        FacesContext.getCurrentInstance().addMessage("msg", msg);

	  
		return "";
	
		
	}
	//******************************************************	

private Maintenance mainDT;

	public Maintenance getMainDT() {
	return mainDT;
}
public void setMainDT(Maintenance v) {
	this.mainDT = v;
}
//******************************************************


private Maintenance selmain;

public Maintenance getSelmain() {
return selmain;
}
public void setSelmain(Maintenance vi) {
this.selmain = vi;
}
//******************************************************	

	private int duree;
	public int getDuree()
	{return duree;}
	public void setDuree(int d) {
		duree = d;
		
	}
private Maintenance mainDT2=new Maintenance();

public Maintenance getMainDT2() {
return mainDT2;
}
public void setMainDT2(Maintenance v) {
this.mainDT2 = v;
}
	
	//*********************************************************
	   public void onRowSelect(SelectEvent event) {
	    
		   mainDT=(Maintenance) event.getObject();
			RequestContext.getCurrentInstance().update(":f1");
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('d').show();");
		   
	    }
	   
	   //**************************************************************************************************************************************************
	   
	   
	   MaintenanceDao dao = new MaintenanceDao();
		
		public MaintenanceDao getDao() {
			return dao;
		}
		public void setDao(MaintenanceDao dao) {
			this.dao = dao;
		}
	   //***************************************************
		
		private String mat;
		public void setMat(String m) {mat=m;}
		public String getMAt() {return mat;}
		private List<Maintenance> l;

Vehicule v =new Vehicule();
		public List<Maintenance> getL() {

		    return dao.liste();
		}


		public void setL(List<Maintenance> l) {
			this.l = l;
		}
		

//*********************************************************

		
		
		
		
//**********************************************************
		 public void onRowEdit(RowEditEvent event) {
			 Maintenance t= (Maintenance) event.getObject();
			 Vehicule v = new Vehicule();
			 mat=t.getVehicule().getMatricule();
			 v.setMatricule(mat);
			 t.setVehicule(v);
			
			 int i = dao.mod(t);
			 if(i==1) {
		        FacesMessage msg = new FacesMessage("Maintenance N°"+((VisiteTechnique) event.getObject()).getNum()+" a été modifié","" );
		        FacesContext.getCurrentInstance().addMessage("msg", msg);
			 }
				RequestContext.getCurrentInstance().update(":f2:d2");

		 
		 }
		     
		    public void onRowCancel(RowEditEvent event) {
		        FacesMessage msg = new FacesMessage("Maintenance N°", ((VisiteTechnique) event.getObject()).getNum()+"a été modifié" );
		        FacesContext.getCurrentInstance().addMessage("msg", msg);
		    }
		
		//**********************************************
		public String ajout()
		{
			
		
			int i = dao.ajout(mainDT2);
		    RequestContext.getCurrentInstance().execute("PF('d2').hide()");

			RequestContext.getCurrentInstance().update(":af1");
			   FacesMessage msg = new FacesMessage("Maintenance N°  a été modifié","" );
		        FacesContext.getCurrentInstance().addMessage("msg", msg);

		  
			return "";
		}
		public String mod()
		{
			System.out.print(selmain.getNum());

		
			int i = dao.mod(selmain);
		    RequestContext.getCurrentInstance().execute("PF('dd').hide()");

			RequestContext.getCurrentInstance().update(":f1");
			   FacesMessage msg = new FacesMessage("Visite Technique N°  a été modifié","" );
		        FacesContext.getCurrentInstance().addMessage("msg", msg);

		  
			return "";
		}
		
		 public void onCellEdit(CellEditEvent event) {
		        Object oldValue = event.getOldValue();
		        Object newValue = event.getNewValue();
		         
		        if(newValue != null && !newValue.equals(oldValue)) {
		            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
		            FacesContext.getCurrentInstance().addMessage(null, msg);
		        }
		    }
		 //**************************************************************
		 private String m;
			private List<Maintenance> ll;


			public List<Maintenance> getLl() {
				System.out.print(mf);
				return ll;
			}
			public void setLl(List<Maintenance> ll) {
				this.ll = ll;
			}
			private String mf;
			
		//****************************************************************
			
			public String getMf() {
				return mf;
			}
			public void setMf(String mf) {
				this.mf = mf;
			}
			

		 public String getM() {
		 	return m;
		 }
		 public void setM(String m) {
		 	this.m = m;
		 }
			EntityManagerFactory emf = null;  
			EntityManager em = null;
		 public String modifff(RowEditEvent event) {
				emf = Persistence.createEntityManagerFactory("sotetel"); 
				em = emf.createEntityManager();   
		 	System.out.println("okkkkkkkkkkkkkkkkkkkkkkkk");

		 	Maintenance t= (Maintenance) event.getObject();
		 
		 System.out.println(t.getVehicule().getMatricule());
		 	 em.getTransaction().begin();

			 em.merge(t);

			 Vehicule v = new Vehicule();
			 v.setMatricule(m);
t.setVehicule(v);
em.merge(t);


		 em.getTransaction().commit();

		 return "";


		 }

		
}
