package org.contact.model;



public class PARAMETROS {
    
	   private int ID_PARAMETRO;
	    
	    private String CLAVE;
	    private String VALOR;
	    private String APLICATIVO;
	    private String DESCRIPCION;
	    
	   
		public int getID_PARAMETRO() {
			return ID_PARAMETRO;
		}
		public void setID_PARAMETRO(int iD_PARAMETRO) {
			ID_PARAMETRO = iD_PARAMETRO;
		}
		public String getCLAVE() {
			return CLAVE;
		}
		public void setCLAVE(String cLAVE) {
			CLAVE = cLAVE;
		}
		public String getVALOR() {
			return VALOR;
		}
		public void setVALOR(String vALOR) {
			VALOR = vALOR;
		}
		public String getAPLICATIVO() {
			return APLICATIVO;
		}
		public void setAPLICATIVO(String aPLICATIVO) {
			APLICATIVO = aPLICATIVO;
		}
		public String getDESCRIPCION() {
			return DESCRIPCION;
		}
		public void setDESCRIPCION(String dESCRIPCION) {
			DESCRIPCION = dESCRIPCION;
		}
		
}