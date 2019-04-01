package model;

import javax.faces.context.FacesContext;

import org.primefaces.model.StreamedContent;

public class Image {
private int id;
public Image() {

}
public Image(int id, StreamedContent image) {
	this.id = id;
	this.image = image;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public StreamedContent getImage() {
	
	return image;
}
public void setImage(StreamedContent image) {
	this.image = image;
}
private StreamedContent image;

}
