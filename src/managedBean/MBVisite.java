package managedBean;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import dao.VisiteDao;
import model.VisiteTechnique;
import model.Vehicule;
public class MBVisite implements Serializable{

	public MBVisite() {
		// TODO Auto-generated constructor stub
	}

		private static final long serialVersionUID = 1L;

		   public void onRowSelect(SelectEvent event) {
		    
			   visiteDT=(VisiteTechnique) event.getObject();
				RequestContext.getCurrentInstance().update(":ajoutCarte");
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('carDialog2').show();");
			   
		    }
		 
		    public void onRowUnselect(UnselectEvent event) {
		        FacesMessage msg = new FacesMessage("Car Unselected", ((VisiteTechnique) event.getObject()).getNum()+"");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		    }
	
		//*******************************************************
	private VisiteTechnique visiteDT;
	
		public VisiteTechnique getVisiteDT() {
		return visiteDT;
	}
	public void setVisiteDT(VisiteTechnique visiteDT) {
		this.visiteDT = visiteDT;
	}

		//******
	
	private VisiteTechnique visite1;
	
	public VisiteTechnique getVisite1() {
	return visiteDT;
}
public void setVisite1(VisiteTechnique v) {
	this.visite1 = v;
}
	
	//******************
		VisiteDao dao = new VisiteDao();
		
		public VisiteDao getDao() {
			return dao;
		}
		public void setDao(VisiteDao dao) {
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
		

		
		
		VisiteTechnique e = new VisiteTechnique();
		
		
		public VisiteTechnique getE() {
			return e;
		}


		public void setE(VisiteTechnique e) {
			this.e = e;
		}
		
		
		
	//**********************************************************
		

		
		public String ajout()
		{
			System.out.print("hiiiiiiiiii visite ajout");
		


		
	Vehicule v = new Vehicule();
	v.setMatricule(mat);
	e.setVehicule(v);
		int i =dao.ajout(e);
		if(i==0) {
			
			
			  FacesContext context = FacesContext.getCurrentInstance();
		         
		        context.addMessage("msg",new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur" ,  "visite n°"+e.getNum()+" déjà existante") );
		}
		    System.out.print("gd visite ajout");
		
			
			return "";
		}

	//*****************************************************************
		
		private List<VisiteTechnique> l;


		public List<VisiteTechnique> getL() {

		    return dao.liste();
		}


		public void setL(List<VisiteTechnique> l) {
			this.l = l;
		}
		
	//****************************************************************
		
		private VisiteTechnique selvisite;


		public VisiteTechnique getSelvisite() {

		    return selvisite;
		}


		public void setSelservice(VisiteTechnique l ) {
			this.selvisite = l;
		}	
		
		//***********************************
		public String supp(VisiteTechnique s) {
			
			System.out.println("supp"+s.getNum());
	
			return "";
			
		
			
		}
		private VisiteTechnique sancien;
		public VisiteTechnique getSancien() {
			return sancien;
		}


		public void setSancien(VisiteTechnique sancien) {
			this.sancien = sancien;
		}


	//*************************************
	public String mod() {

			
	return "";
			
		}
	public String modif()
	{
			
			return "";
		
		
		
		
	//***********************************************************

		
	}



	public String modif2()
	{
	
		return "";
		
	}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//************************************************

	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

