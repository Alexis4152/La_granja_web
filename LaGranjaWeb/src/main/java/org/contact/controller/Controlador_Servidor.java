package org.contact.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.contact.dao.JdbcUsuarios;
import org.contact.dao.JdbcDaoUsuariosInterface;
import org.contact.dao.JdbcDaoParametrosInterface;
import org.contact.dao.JdbcParametros;
import org.contact.model.ACCESO_USUARIOS;
import org.contact.model.PARAMETROS;
import org.contact.service.JdbcServiceUsuariosInterface;
import org.contact.service.JdbcServiceParametrosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import mx.telcel.util.Constantes;
import mx.telcel.util.Herramientas;

@SuppressWarnings("unused")
@Controller
public class Controlador_Servidor{
	//INTERFACE
	//SERVICIO
	//CLASE DE IMPLEMENTACIÓN
	//DAO
	//DATA
	//ACCESS
	//OBJECT
	
	
	
	
	@Autowired
	private JdbcServiceUsuariosInterface SERVICIO_USUARIOS;
	@Autowired
	private JdbcServiceParametrosInterface SERVICIO_PARAMETROS;

	@RequestMapping(value = "/Login")
	public String Loggin() {
		return "Login";//RETORN A LA VISTA DE LOGIN
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/Choices")
	public String Options() {
	return "Opciones";
	}
	
	//YA PREPARADO PARA CONFIGURAR EL HILO - YA CONFIGURADO CON HILOS
	@SuppressWarnings("static-access")
	@RequestMapping(value="/Aplicativos", method = RequestMethod.GET) // �sta ruta me lleva a la pagina de inicio
	public String listContacts(ModelMap modelo) throws Exception {
		return "Aplicativos";
	}
	//YA PREPARADO PARA CONFIGURAR EL HILO - YA CONFIGURADO CON HILOS
	@SuppressWarnings("static-access")
	@RequestMapping("/Memoria") // �sta ruta me lleva a la pagina de inicio
	public String Memoria(ModelMap modelo) throws Exception {
		return "Memoria";
	}
	// RUTAS PARA IR A LA PAGINA DE ACUERDO AL PROCESO
	@SuppressWarnings("static-access")
	@RequestMapping("/IndicadorComplementoPagoFact") // �sta ruta me lleva a la pagina de inicio
	public String GotoIndicador(ModelMap modelo) throws Exception {
		return "ProcesoIndicador";
	}
	// URL DE EJEMPLO YA LIGADA A JQUERY PARA REFRESACAR LA VISTA, NO RECARGARLA
	@ResponseBody @RequestMapping("/Bajar_proceso/{Proceso}") // �sta ruta me lleva a la pagina de inicio
	public String Down_process(@PathVariable("Proceso") int proceso) throws Exception { // LO QUE // //// // HTTP
		switch (proceso) {
		case 1:break;// ProcesoIndicador
		case 2:break;// ProcesosTransBibes
		case 3:break;// ProcesosTransforma
		case 4:break;// ProcesosCoreCP
		case 5:break;// ProcesosCMasiva
		case 6:break;// ProcesosCancelaciones
		}
		return Constantes.bandera;
	}// BAJAR PROCESOS
	//METODOS QUE SIRVEN PARA LA PARTE DE LA TABLA PARAMETROS 
	    @SuppressWarnings("static-access")
		@RequestMapping(value = "/Logout") //LA SALIDA DEL SISTEMA
		public String Logout(){
	    	//SERVERS.Close();
			return "Login";
		}
}