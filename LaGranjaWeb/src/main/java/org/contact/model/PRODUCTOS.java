package org.contact.model;

import java.util.Date;

public class PRODUCTOS {

	private int ID_PRODUCTO;
	private String NOMBRE_PRODUCTO;
	private String TIPO_PRODUCTO;
	private float PRECIO;
	private float CANTIDAD;
	
	public PRODUCTOS() {
		
	}
	public PRODUCTOS(int ID, String NAME, String TYPE, float PRICE, float CUANTITY){
	this.ID_PRODUCTO=ID;this.NOMBRE_PRODUCTO=NAME;this.TIPO_PRODUCTO=TYPE;this.PRECIO=PRICE;this.CANTIDAD=CUANTITY;	
	}
	
	public int getID_PRODUCTO() {
		return ID_PRODUCTO;
	}
	public void setID_PRODUCTO(int iD_PRODUCTO) {
		ID_PRODUCTO = iD_PRODUCTO;
	}
	public String getNOMBRE_PRODUCTO() {
		return NOMBRE_PRODUCTO;
	}
	public void setNOMBRE_PRODUCTO(String nOMBRE_PRODUCTO) {
		NOMBRE_PRODUCTO = nOMBRE_PRODUCTO;
	}
	public String getTIPO_PRODUCTO() {
		return TIPO_PRODUCTO;
	}
	public void setTIPO_PRODUCTO(String tIPO_PRODUCTO) {
		TIPO_PRODUCTO = tIPO_PRODUCTO;
	}
	public float getPRECIO() {
		return PRECIO;
	}
	public void setPRECIO(float pRECIO) {
		PRECIO = pRECIO;
	}
	public float getCANTIDAD() {
		return CANTIDAD;
	}
	public void setCANTIDAD(float cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}
}
