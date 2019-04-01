package managedBean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
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

public class MBVisiteV2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MBVisiteV2() {
		// TODO Auto-generated constructor stub
		visiteDT2.setVehicule(v);

	}
//***********************************************************
	public String jours(Date s) {
		
	
		
		
		return "5 Jours Restants";
		
	
		
	}
	
	
	//***********************************
	public String supp(VisiteTechnique s) {
		
		System.out.println("supp"+s.getNum());
		dao.supp(s);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect("VisiteF.xhtml");
		} catch (IOException ee) {

		}
	
		
		
		return "";
		
	
		
	}
	
	
//******************************************************	
	public String test(VisiteTechnique s) {
		
		System.out.println("supp"+s.getNum());
	
		
		return "";
		
	
		
	}
	//********************modifierrrrrrrrrrrrrrrrrrrrrrrrrr
	
	public String test() {
		System.out.print(selvisite.getNum());

		
		int i = dao.mod(selvisite);
	    RequestContext.getCurrentInstance().execute("PF('carDialog').hide()");

		RequestContext.getCurrentInstance().update(":f1");
		   FacesMessage msg = new FacesMessage("Visite Technique N�  a �t� modifi�","" );
	        FacesContext.getCurrentInstance().addMessage("msg", msg);

	  
		return "";
	
		
	}
	//******************************************************	

private VisiteTechnique visiteDT;

	public VisiteTechnique getVisiteDT() {
	return visiteDT;
}
public void setVisiteDT(VisiteTechnique visiteDT) {
	this.visiteDT = visiteDT;
}
//******************************************************


private VisiteTechnique selvisite;

public VisiteTechnique getSelvisite() {
return selvisite;
}
public void setSelvisite(VisiteTechnique vi) {
this.selvisite = vi;
}
//******************************************************	

	private int duree;
	public int getDuree()
	{return duree;}
	public void setDuree(int d) {
		duree = d;
		
	}
private VisiteTechnique visiteDT2=new VisiteTechnique();

public VisiteTechnique getVisiteDT2() {
return visiteDT2;
}
public void setVisiteDT2(VisiteTechnique visiteDT) {
this.visiteDT2 = visiteDT;
}
	
	//*********************************************************
	   public void onRowSelect(SelectEvent event) {
	    
		   visiteDT=(VisiteTechnique) event.getObject();
			RequestContext.getCurrentInstance().update(":f1");
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('d').show();");
		   
	    }
	   
	   //**************************************************************************************************************************************************
	   
	   
		VisiteDao dao = new VisiteDao();
		
		public VisiteDao getDao() {
			return dao;
		}
		public void setDao(VisiteDao dao) {
			this.dao = dao;
		}
	   //***************************************************
		
		private String mat;
		public void setMat(String m) {mat=m;}
		public String getMAt() {return mat;}
		private List<VisiteTechnique> l;

Vehicule v =new Vehicule();
		public List<VisiteTechnique> getL() {

		    return dao.liste();
		}


		public void setL(List<VisiteTechnique> l) {
			this.l = l;
		}
		

		
		 public void onRowEdit(RowEditEvent event) {
			 VisiteTechnique t= (VisiteTechnique) event.getObject();
			 Vehicule v = new Vehicule();
			 mat=t.getVehicule().getMatricule();
			 v.setMatricule(mat);
			 t.setVehicule(v);
			
			 int i = dao.mod(t);
			 if(i==1) {
		        FacesMessage msg = new FacesMessage("Visite Technique N�"+((VisiteTechnique) event.getObject()).getNum()+" a �t� modifi�","" );
		        FacesContext.getCurrentInstance().addMessage("msg", msg);
			 }
				RequestContext.getCurrentInstance().update(":f2:d2");

		 
		 }
		     
		    public void onRowCancel(RowEditEvent event) {
		        FacesMessage msg = new FacesMessage("Visite Technique N�", ((VisiteTechnique) event.getObject()).getNum()+"a �t� modifi�" );
		        FacesContext.getCurrentInstance().addMessage("msg", msg);
		    }
		
		//**********************************************
		public String ajout()
		{
			
		
			int i = dao.ajout(visiteDT2);
		    RequestContext.getCurrentInstance().execute("PF('d2').hide()");

			RequestContext.getCurrentInstance().update(":af1");
			   FacesMessage msg = new FacesMessage("Visite Technique N�  a �t� modifi�","" );
		        FacesContext.getCurrentInstance().addMessage("msg", msg);

		  
			return "";
		}
		public String mod()
		{
			System.out.print(selvisite.getNum());

		
			int i = dao.mod(selvisite);
		    RequestContext.getCurrentInstance().execute("PF('dd').hide()");

			RequestContext.getCurrentInstance().update(":f1");
			   FacesMessage msg = new FacesMessage("Visite Technique N�  a �t� modifi�","" );
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
			private List<CarteCarburant> ll;


			public List<CarteCarburant> getLl() {
				System.out.print(mf);
				return ll;
			}
			public void setLl(List<CarteCarburant> ll) {
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

		 	 VisiteTechnique t= (VisiteTechnique) event.getObject();
		 
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
