package org.contact.model;

public class ACCESO_USUARIOS {
	
private int ID_USER;
private String USERNAME;
private String PASSWORD;
private int ROLE_USER;
private String HABILITADO;
private String PARAMETROS_DISPONIBLES;

public int getID_USER() {
	return ID_USER;
}
public void setID_USER(int iD_USER) {
	ID_USER = iD_USER;
}
public String getUSERNAME() {
	return USERNAME;
}
public void setUSERNAME(String uSERNAME) {
	USERNAME = uSERNAME;
}
public String getPASSWORD() {
	return PASSWORD;
}
public void setPASSWORD(String pASSWORD) {
	PASSWORD = pASSWORD;
}
public int getROLE_USER() {
	return ROLE_USER;
}
public void setROLE_USER(int rOLE_USER) {
	ROLE_USER = rOLE_USER;
}
public String getHABILITADO() {
	return HABILITADO;
}
public void setHABILITADO(String hABILITADO) {
	HABILITADO = hABILITADO;
}
public String getPARAMETROS_DISPONIBLES() {
	return PARAMETROS_DISPONIBLES;
}
public void setPARAMETROS_DISPONIBLES(String pARAMETROS_DISPONIBLES) {
	PARAMETROS_DISPONIBLES = pARAMETROS_DISPONIBLES;
}

}
