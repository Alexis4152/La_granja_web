package org.contact.model;

import java.util.Date;

public class VENTA {
private int ID_VENTA;
private int ID_USUARIO;
private float DESCUENTO;
private float TOTAL;
private float SUBTOTAL;
private float PAGO;
private float CAMBIO;
private String ESTADO_VENTA;
private String NOMBRE_CREDITO;
private Date FECHA;




public VENTA() {
	
}
//PARA MOSTRAR VENTAS
public VENTA(int iD_VENTA, float dESCUENTO, float tOTAL, float sUBTOTAL, float pAGO, float cAMBIO, Date fECHA){
	ID_VENTA = iD_VENTA;DESCUENTO = dESCUENTO;TOTAL = tOTAL;
	SUBTOTAL = sUBTOTAL;PAGO = pAGO; CAMBIO = cAMBIO;FECHA = fECHA;
}
//PARA AGREGAR A LA TABLA VENTA
public VENTA( int iD_USUARIO, float dESCUENTO, float tOTAL, float sUBTOTAL, float pAGO, float cAMBIO,String eSTADO_VENTA, String nOMBRE_CREDITO) {
	super();
	ID_USUARIO = iD_USUARIO;DESCUENTO = dESCUENTO;TOTAL = tOTAL;
	SUBTOTAL = sUBTOTAL;PAGO = pAGO; CAMBIO = cAMBIO;ESTADO_VENTA = eSTADO_VENTA;
	NOMBRE_CREDITO = nOMBRE_CREDITO;
}
public int getID_VENTA() {
	return ID_VENTA;
}
public void setID_VENTA(int iD_VENTA) {
	ID_VENTA = iD_VENTA;
}
public int getID_USUARIO() {
	return ID_USUARIO;
}
public void setID_USUARIO(int iD_USUARIO) {
	ID_USUARIO = iD_USUARIO;
}
public float getDESCUENTO() {
	return DESCUENTO;
}
public void setDESCUENTO(float dESCUENTO) {
	DESCUENTO = dESCUENTO;
}
public float getTOTAL() {
	return TOTAL;
}
public void setTOTAL(float tOTAL) {
	TOTAL = tOTAL;
}
public float getSUBTOTAL() {
	return SUBTOTAL;
}
public void setSUBTOTAL(float sUBTOTAL) {
	SUBTOTAL = sUBTOTAL;
}
public float getPAGO() {
	return PAGO;
}
public void setPAGO(float pAGO) {
	PAGO = pAGO;
}
public float getCAMBIO() {
	return CAMBIO;
}
public void setCAMBIO(float cAMBIO) {
	CAMBIO = cAMBIO;
}
public String getESTADO_VENTA() {
	return ESTADO_VENTA;
}
public void setESTADO_VENTA(String eSTADO_VENTA) {
	ESTADO_VENTA = eSTADO_VENTA;
}
public String getNOMBRE_CREDITO() {
	return NOMBRE_CREDITO;
}
public void setNOMBRE_CREDITO(String nOMBRE_CREDITO) {
	NOMBRE_CREDITO = nOMBRE_CREDITO;
}
public Date getFECHA() {
	return FECHA;
}
public void setFECHA(Date fECHA) {
	FECHA = fECHA;
}


}
