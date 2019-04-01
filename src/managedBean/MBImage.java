package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Vehicule;

public class MBImage {

private String imageID;
private String imageName;
public String getImageName() {
return imageName;
}

public void setImageName(String imageName) {
this.imageName = imageName;
}

public String getImageLength() {
return imageLength;
}

public void setImageLength(String imageLength) {
this.imageLength = imageLength;
}
private String imageLength;

public String getImageID() {
return imageID;
}

public void setImageID(String imageID) {
this.imageID = imageID;
}
EntityManagerFactory emf = null;  
EntityManager em = null;
public List<Vehicule> getAllImage()
{
List<Vehicule> imageInfo = new ArrayList<Vehicule>();
//**********************************

emf = Persistence.createEntityManagerFactory("sotetel"); 
em = emf.createEntityManager();   
 em.getTransaction().begin();
 imageInfo=em.createNamedQuery("Vehicule.findAll",Vehicule.class).getResultList();
em.getTransaction().commit();

//*************************************************************
return imageInfo;
}

}