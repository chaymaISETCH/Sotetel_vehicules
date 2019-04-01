package managedBean;

import java.io.IOException;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.File;
 import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
 
 import org.primefaces.component.export.PDFOptions;




public class MBExporter {
	
	
	private String mat;

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}
	


}
