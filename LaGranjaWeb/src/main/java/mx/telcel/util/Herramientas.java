package mx.telcel.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.contact.model.VENTA;
import org.contact.model.DESCRIPCION_DE_VENTA;
import org.contact.model.PRODUCTOS;
import org.contact.service.JdbcServicio_Acceso_Usuarios_Alexis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@SuppressWarnings("unused")
public class Herramientas {
	@Autowired
	private JdbcServicio_Acceso_Usuarios_Alexis SERVICIO;
	
	public void pruebacommit() {
		
	}
	public static String USUARIO_LOGGEADO() {//PARA OBTENER EL NOMBRE DEL USUARIO
		String userName="";
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); //SE VERIFICA QUE EL USUARIO ESTÉ AUTENTIFICADO 
			UserDetails userDetails = null;
			if (principal instanceof UserDetails) {
			  userDetails = (UserDetails) principal;
			}
			userName = userDetails.getUsername(); //Aqui se guarda el nombre del usuario que está loggeado actualmente
			
		}catch(NullPointerException e) {
			System.out.println("Usuario no encontrado: "+e.getMessage());
		}
		return userName;
	}


	public static void AGREGAR_PRODUCTO_A_LISTA(int CANTIDAD_DEL_PRODUCTO_EN_BASE, int ID_PRODUCTO, String NOMBRE, float PRECIO, float CANTIDAD) {
		boolean EXISTE=false;
		if(CANTIDAD_DEL_PRODUCTO_EN_BASE>=1){//HAY EN EXISTENCIA
			System.out.println("HAY EN EXISTENCIA: "+NOMBRE+", PIEZAS: "+CANTIDAD_DEL_PRODUCTO_EN_BASE);
			if(Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA.size()==0) {//SI NO TIENE ELEMENTOS, AGREGA EL PRIMERO
				DESCRIPCION_DE_VENTA A_VENTA= 
						new DESCRIPCION_DE_VENTA(ID_PRODUCTO,NOMBRE,CANTIDAD,PRECIO,CANTIDAD*PRECIO);
				Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA.add(A_VENTA);//SE AGREGA EL NUEVO PRODUCTO
				Constantes.TOTAL_DE_VENTA=0;//SE REINICIA EL TOTAL
				for(DESCRIPCION_DE_VENTA RUN : Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA) {//PARA SOLO SUMAR LOS IMPORTES DE LOS PRODUCTOS AGREGADOS EN LA LISTA
					Constantes.TOTAL_DE_VENTA+=RUN.getIMPORTE();
				}
			}else {//CUANDO YA TIENE AL MENOS UN ELEMENTO LA LISTA
				for(DESCRIPCION_DE_VENTA BUSCAR_SI_EXISTE : Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA){//BUSCANDO SI YA SE AGREGO
					if(BUSCAR_SI_EXISTE.getID_PRODUCTO()==ID_PRODUCTO&&BUSCAR_SI_EXISTE.getNOMBRE_PRODUCTO().equalsIgnoreCase(NOMBRE)) {//BUSCAMOS QUE COINCIDA EL ID PRODUCTO Y EL NOMBRE DEL PRODUCTO, PORQUE EJEMPLO, MEDIA PECHUGA DEPENDE DE PECHUGA Y AMBOS TIENEN EL MISMO ID MÁS NO EL MISMO NOMBRE
						BUSCAR_SI_EXISTE.setCANTIDAD(BUSCAR_SI_EXISTE.getCANTIDAD()+CANTIDAD); BUSCAR_SI_EXISTE.setIMPORTE(BUSCAR_SI_EXISTE.getCANTIDAD()*BUSCAR_SI_EXISTE.getPRECIO());
						Constantes.TOTAL_DE_VENTA=0;//SE REINICIA EL TOTAL
						for(DESCRIPCION_DE_VENTA RUN : Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA) {//PARA SOLO SUMAR LOS IMPORTES DE LOS PRODUCTOS AGREGADOS EN LA LISTA
							Constantes.TOTAL_DE_VENTA+=RUN.getIMPORTE();
						}
						EXISTE=true;
					}
				}
				if(EXISTE==false) {//SI NO SE HA AGREGADO SE AGREGA A LOS DEMÁS PRODUCTOS
					DESCRIPCION_DE_VENTA A_VENTA= 
							new DESCRIPCION_DE_VENTA(ID_PRODUCTO,NOMBRE,CANTIDAD,PRECIO,CANTIDAD*PRECIO);
					Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA.add(A_VENTA);//SE AGREGA EL NUEVO PRODUCTO
					Constantes.TOTAL_DE_VENTA=0;//SE REINICIA EL TOTAL
					for(DESCRIPCION_DE_VENTA RUN : Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA) {//PARA SOLO SUMAR LOS IMPORTES DE LOS PRODUCTOS AGREGADOS EN LA LISTA
						Constantes.TOTAL_DE_VENTA+=RUN.getIMPORTE();
					}
				}
			}
		}else {
			System.out.println("NO HAY EN EXISTENCIA: "+NOMBRE+" PIEZAS : "+CANTIDAD_DEL_PRODUCTO_EN_BASE);
		}
	}
	public static void ELIMINAR_PRODUCTO_DE_VENTA(int ID_PRODUCTO) {
		Iterator<DESCRIPCION_DE_VENTA> ITERADOR_PRODUCTOS = Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA.iterator();
		while (ITERADOR_PRODUCTOS.hasNext()) {
			DESCRIPCION_DE_VENTA PRODUCTOS = ITERADOR_PRODUCTOS.next();
			if (PRODUCTOS.getID_PRODUCTO()==ID_PRODUCTO) {
				ITERADOR_PRODUCTOS.remove();
			}
		}
		Constantes.TOTAL_DE_VENTA=0;//SE REINICIA EL TOTAL
		for(DESCRIPCION_DE_VENTA RUN : Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA) {//PARA SOLO SUMAR LOS IMPORTES DE LOS PRODUCTOS AGREGADOS EN LA LISTA
			Constantes.TOTAL_DE_VENTA+=RUN.getIMPORTE();
		}
	}
	public static void LIMPIAR_TODA_LA_VENTA(){
		Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA.clear();
		Constantes.TOTAL_DE_VENTA=0;
	}
	public static String DIA_DE_HOY() {
		Date date = new Date();
		// Caso 2: obtener la fecha y salida por pantalla con formato:
		DateFormat hourFormat = new SimpleDateFormat("ddMMyy");
       return hourFormat.format(date);
	}
}