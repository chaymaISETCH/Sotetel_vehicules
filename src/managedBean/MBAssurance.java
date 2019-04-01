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

import dao.AssuranceDao;
import dao.VisiteDao;
import model.CarteCarburant;
import model.Compagnie;
import model.Service;
import model.Vehicule;
import model.Assurance;
import org.primefaces.event.FlowEvent;
public class MBAssurance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	public MBAssurance() {
		// TODO Auto-generated constructor stub
		visiteDT2.setVehicule(v);

	}
	
	public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    private boolean skip;
	  public String onFlowProcess(FlowEvent event) {
	        if(skip) {
	            skip = false;   //reset in case user goes back
	            return "confirm";
	        }
	        else {
	            return event.getNewStep();
	        }
	    }
//***********************************************************
	public String jours(Date s) {
		
	
		
		
		return "5 Jours Restants";
		
	
		
	}
	
	
	//***********************************
	public String supp(Assurance s) {
		
		System.out.println("supp"+s.getNum());
		dao.supp(s);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect("Assurance.xhtml");
		} catch (IOException ee) {

		}
	
		
		
		return "";
		
	
		
	}
	
	
//******************************************************	

	
	
	public String test2(int s) {
		
		System.out.println("supp");
	
		
		return "";
		
	
		
	}
	//********************modifierrrrrrrrrrrrrrrrrrrrrrrrrr
	
	public String test() {
		System.out.print(selvisite.getNum());

		
		int i = dao.mod(selvisite);
	    RequestContext.getCurrentInstance().execute("PF('carDialog').hide()");

		RequestContext.getCurrentInstance().update(":f1");
		   FacesMessage msg = new FacesMessage("Visite Technique N°  a été modifié","" );
	        FacesContext.getCurrentInstance().addMessage("msg", msg);

	  
		return "";
	
		
	}
	//******************************************************	

private Assurance visiteDT=new Assurance();

	public Assurance getVisiteDT() {
	return visiteDT;
}
public void setVisiteDT(Assurance visiteDT) {
	this.visiteDT = visiteDT;
}
//******************************************************


private Assurance selvisite;

public Assurance getSelvisite() {
return selvisite;
}
public void setSelvisite(Assurance vi) {
this.selvisite = vi;
}
//******************************************************	

	private int duree;
	public int getDuree()
	{return duree;}
	public void setDuree(int d) {
		duree = d;
		
	}
private Assurance visiteDT2=new Assurance();

public Assurance getVisiteDT2() {
return visiteDT2;
}
public void setVisiteDT2(Assurance visiteDT) {
this.visiteDT2 = visiteDT;
}
	
	//*********************************************************
	   public void onRowSelect(SelectEvent event) {
	    
		   visiteDT=(Assurance) event.getObject();
			RequestContext.getCurrentInstance().update(":f1");
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('d').show();");
		   
	    }
	   
	   //**************************************************************************************************************************************************
	   
	   
		AssuranceDao dao = new AssuranceDao();
		
		public AssuranceDao getDao() {
			return dao;
		}
		public void setDao(AssuranceDao dao) {
			this.dao = dao;
		}
	   //***************************************************
		
		private String mat;
		public void setMat(String m) {mat=m;}
		public String getMAt() {return mat;}
		private List<Assurance> l;

Vehicule v =new Vehicule();
		public List<Assurance> getL() {
			System.out.println("get lste assuranceee");
System.out.println(dao.liste().size()+"");
		    return dao.liste();
		}


		public void setL(List<Assurance> l) {
			this.l = l;
		}
		

		
		 public void onRowEdit(RowEditEvent event) {
			 Assurance t= (Assurance) event.getObject();
			 Vehicule v = new Vehicule();
			 mat=t.getVehicule().getMatricule();
			 v.setMatricule(mat);
			 t.setVehicule(v);
			
			 int i = dao.mod(t);
			 if(i==1) {
		        FacesMessage msg = new FacesMessage("Assurance N°"+((Assurance) event.getObject()).getNum()+" a été modifié","" );
		        FacesContext.getCurrentInstance().addMessage("msg", msg);
			 }
				RequestContext.getCurrentInstance().update(":f2:d2");

		 
		 }
		     
		    public void onRowCancel(RowEditEvent event) {
		        FacesMessage msg = new FacesMessage("Assurance N°", ((Assurance) event.getObject()).getNum()+"a été modifié" );
		        FacesContext.getCurrentInstance().addMessage("msg", msg);
		    }
		
		//**********************************************
		public String ajout()
		{
		    

			Vehicule v = new Vehicule();
			v.setMatricule(m);
			visiteDT2.setVehicule(v);
			
			Compagnie com = new Compagnie();
			com.setNum(c);
			visiteDT2.setCompagnie(com);
				int i =dao.ajout(visiteDT2);
				if(i==0) {
					
					
					  FacesContext context = FacesContext.getCurrentInstance();
				         
				        context.addMessage("msg",new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur" ,  "contrat d'assurance N°"+visiteDT2.getNum()+" déjà existante") );
				}
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				try {
					ec.redirect("Assurance.xhtml");
				} catch (IOException ee) {

				}
					
					return "";
		//**************************************************
	
		}
		public String mod()
		{
			System.out.print(selvisite.getNum());

		
			int i = dao.mod(selvisite);
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
			
			private int c;
			 public int getC() {
				 	return c;
				 }
				 public void setC(int m) {
				 	this.c = m;
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

		 	 Assurance t= (Assurance) event.getObject();
		 
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
		 private Assurance sancien;
//***************************
		 
		 
		 
		 public String modif()
		 {System.out.print("hi   modif    "+selvisite.getNum());
		 	System.out.print("hi   modif"+sancien.getNum());

		 //********************************************************
		 	
		 	
		 	
		 	
		 Vehicule v = new Vehicule();
		 v.setMatricule(selvisite.getVehicule().getMatricule());
		 selvisite.setVehicule(v);
		 	int i =dao.mod(sancien.getNum(),selvisite);

		 	
		 	
		 	if(i==0) {
		 		
		 		
		 		  FacesContext context = FacesContext.getCurrentInstance();
		 	         
		 	        context.addMessage("msg",new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur" ,  "assurance n°"+sancien.getNum()+" déjà existante") );
		 	}
		 	    System.out.print("gd carte ajout");
		 	
		 		
		 		return "";
		 	
		 	
		 	
		 	
		 //***********************************************************

		 	
		 }
		 
		 ///****************************************************************
		 
		 
		 
		//*************************************
	 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 //*****************************************************
		
		 public String modif2()
		 {
		 	//System.out.print("hi   modif    "+selservice.getService());
		 	//System.out.print("hi   modif"+sancien.getService());
		 	sancien=new Assurance();
		 	sancien.setNum(selvisite.getNum());
		 	RequestContext.getCurrentInstance().update(":f");
		 	RequestContext context = RequestContext.getCurrentInstance();
		 	context.execute("PF('carDialog').show();");

		 	return "";
		 	
		 }

		public Assurance getSancien() {
			return sancien;
		}

		public void setSancien(Assurance sancien) {
			this.sancien = sancien;
		}
		
}
