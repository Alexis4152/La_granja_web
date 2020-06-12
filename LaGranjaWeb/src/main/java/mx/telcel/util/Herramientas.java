package mx.telcel.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("unused")
public class Herramientas {
	
	public void pruebacommit() {
		
	}
	public static String obtener_nombre_de_usuario_loggeado() {//PARA OBTENER EL NOMBRE DEL USUARIO
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
}
