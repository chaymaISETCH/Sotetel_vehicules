package managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

import dao.EmployeDao;
import model.Personnel;

public class MBLogin {

	public MBLogin() {
		// TODO Auto-generated constructor stub
	}
	static  Personnel e=new Personnel();
	



	public Personnel getE() {
		return e;
	}



	public void setE(Personnel e) {
		this.e = e;
	}
	
	EmployeDao dao = new EmployeDao();

	
	
	public String cc()
	{
		 FacesMessage message = null;
	        boolean loggedIn = false;
			int i = dao.login(e.getLogin(),e.getMotDePasse());

	        if(i==1) {
	            loggedIn = true;
	        
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Authentification réussie","");

				return "/IndexRes.xhtml?faces-redirect=true";
	        } else {
	            loggedIn = false;
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Authentification", "Authentification échouée");
	        }
	         
	        FacesContext.getCurrentInstance().addMessage(null, message);
	        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		
		return "";
		/*System.out.print("cccccccccccccf"+e.getLogin()+e.getMotDePasse()+"dddd");
		int i = dao.login(e.getLogin(),e.getMotDePasse());

		if(i==0) {
			
			

			System.out.print("noooooo 000000000000000000000");
			RequestContext.getCurrentInstance().update(":ff");
		

			   FacesMessage msg = new FacesMessage("mot de passe incorrect","" );
		        FacesContext.getCurrentInstance().addMessage("ppp", msg);

		  
			
			

		}
		
		else {
	
			return "/IndexRes.xhtml?faces-redirect=true";
						
		}
		
	return"";}*/
		
		
	}
}
