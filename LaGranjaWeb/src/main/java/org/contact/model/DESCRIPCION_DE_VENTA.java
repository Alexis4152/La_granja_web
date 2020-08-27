package org.contact.model;

import java.util.Date;

public class DESCRIPCION_DE_VENTA {

	private int ID_PRODUCTO;
	private String NOMBRE_PRODUCTO;
	private float CANTIDAD;
	private float PRECIO;
	private float IMPORTE;
	private int ID_VENTA;
	


	public DESCRIPCION_DE_VENTA() {
		
	}
	public DESCRIPCION_DE_VENTA(int ID_PRODUCTO, String NAME, float CUANTITY, float PRICE,float IMPORT ){
	this.ID_PRODUCTO=ID_PRODUCTO;this.NOMBRE_PRODUCTO=NAME;this.CANTIDAD=CUANTITY;this.PRECIO=PRICE;this.IMPORTE=IMPORT;	
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
	public float getCANTIDAD() {
		return CANTIDAD;
	}
	public void setCANTIDAD(float cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}
	public float getPRECIO() {
		return PRECIO;
	}
	public void setPRECIO(float pRECIO) {
		PRECIO = pRECIO;
	}
	public float getIMPORTE() {
		return IMPORTE;
	}
	public void setIMPORTE(float iMPORTE) {
		IMPORTE = iMPORTE;
	}
	public int getID_VENTA() {
		return ID_VENTA;
	}
	public void setID_VENTA(int iD_VENTA) {
		ID_VENTA = iD_VENTA;
	}
	
    
}
