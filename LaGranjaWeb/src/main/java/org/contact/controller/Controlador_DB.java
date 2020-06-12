package org.contact.controller;

import java.util.ArrayList;

import org.contact.model.ACCESO_USUARIOS;
import org.contact.model.PARAMETROS;
import org.contact.service.JdbcServiceParametrosInterface;
import org.contact.service.JdbcServiceUsuariosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mx.telcel.util.Constantes;
import mx.telcel.util.Herramientas;

@Controller
public class Controlador_DB {
	@SuppressWarnings("unused")
	@Autowired
	private JdbcServiceUsuariosInterface SERVICIO_USUARIOS;
	@SuppressWarnings("unused")
	@Autowired
	private JdbcServiceParametrosInterface SERVICIO_PARAMETROS;
	//CAMBIOS
	//VALIDO CON JDBC
		@RequestMapping(value = "/UpdateIndicadorProceso", method = RequestMethod.POST)
		public String UPDATE_INDICADOR(@ModelAttribute("Verregiones") PARAMETROS REGIONES, BindingResult result) {
			SERVICIO_PARAMETROS.UPDATE_PARAMETRO(REGIONES);
			return "redirect:/TransformaBibes";
		}
		//METODOS QUE SIRVEN PARA LA PARTE DE PARAMETROS
			//VALIDADO CON JDBC 
			@RequestMapping("/ParametrosVista") //ESTA RUTA MUESTRA LOS PARAMETROS POR APLICATIVO A LOS CUALES TIENEN ACCESO
			public String listregiones(Model modelo){
					  Constantes.usuarioparametros = SERVICIO_USUARIOS.OBTENERLISTA_PARAMETROS_POR_EL_NOMBRE_DE_USUARIO(Herramientas.obtener_nombre_de_usuario_loggeado());// CON EL OBJETO PREVIO SE GUARDA EL RESULTADO DE LA CONSULTA AL MANDARLE EL NOMBRE DE USUARIO 
					  modelo.addAttribute("regiones", new PARAMETROS()); //ENVIA LA CLASE CON LOS PARAMETROS VACIOS PARA QUE EL CAMPO DEL INPUT ESTÉ VACIO  
					  modelo.addAttribute("regionesestatico", SERVICIO_PARAMETROS.OBTENER_PARAMETROS_PARA_EL_USUARIO_LOGGEADO(Constantes.usuarioparametros.get(0).getPARAMETROS_DISPONIBLES())); //MUESTRA LA LISTA DE PARAMETROS 
						Constantes.acceso_parametros.clear();
						Constantes.usuarioparametros.clear();
				  //}
				return "Formularioparametros";
			}
			//VALIDADO CON JDBC 
			@RequestMapping("/MandarValorRegionesEjecutar/{valor}") // ÉSTA RUTA MANDA EL VALOR SELECCIONADO (ID_PARAMETRO) DE LOS VALORES PROVENIENTES DE LA TABLA PARAMETROS  
			public String seleccionarunvalor(@PathVariable("valor") int ID_PARAMETRO, Model modelo ){
				Constantes.usuarioparametros = SERVICIO_USUARIOS.OBTENERLISTA_PARAMETROS_POR_EL_NOMBRE_DE_USUARIO(Herramientas.obtener_nombre_de_usuario_loggeado());// CON EL OBJETO PREVIO SE GUARDA EL RESULTADO DE LA CONSULTA AL MANDARLE EL NOMBRE DE USUARIO 
			    if(Constantes.usuarioparametros.size()!=0) {
						modelo.addAttribute("regiones", SERVICIO_PARAMETROS.OBTENER_PARAMETRO_DESEADO_PARA_OBJETO_POR_ID_PARAMETRO(ID_PARAMETRO)); //MANDA EL ID_PARAMETRO PARA OBTENER LOS VALORES PARA EL INPUT
						  modelo.addAttribute("regionesestatico", SERVICIO_PARAMETROS.OBTENER_PARAMETROS_PARA_EL_USUARIO_LOGGEADO(Constantes.usuarioparametros.get(0).getPARAMETROS_DISPONIBLES()));//MANDA NUEVAMENTE LA CONSULTA GENERAL DE TODA LA TABLA PARAMETROS
				 }
			    else if (Constantes.usuarioparametros.size()==0){
					   PARAMETROS sesionterminada = new PARAMETROS();
					   sesionterminada.setID_PARAMETRO(5000);
					   sesionterminada.setCLAVE("Sesión terminada, recargue la página para continuar");
					   sesionterminada.setVALOR("");
					   sesionterminada.setAPLICATIVO("");
					   sesionterminada.setDESCRIPCION("");
					   ArrayList a = new ArrayList();
					   a.add(sesionterminada);
					   modelo.addAttribute("regiones", new PARAMETROS());
					   modelo.addAttribute("regionesestatico", a);
				   }
			  return "Formularioparametros";//DEVUELVE LA VISTA CON LOS VALORES DE ESTAS CONSULTAS
			}
			//INVALID COLUMN OR SOMETHING
			
			//VALIDO CON JDBC
			@RequestMapping(value = "/UpdateRegionesEjecutar", method = RequestMethod.POST)
			public String UPDATE_REGIONES_EJECUTAR(@ModelAttribute("regiones") PARAMETROS REGIONES, BindingResult result) {
				SERVICIO_PARAMETROS.UPDATE_PARAMETRO(REGIONES);
				return "redirect:/ParametrosVista";
			}
		
			//VALIDADO CON JDBC
		    @SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value = "/ConsultaLikePARAMETROS/{key}", method = RequestMethod.GET)//A CONSIDERAR POR EL NOMBRE DEL USUARIO LA LISTA DE PARAMETROS A LAS CUALES PODRA TENER ACCESO
			public ModelAndView LIKE_REGIONES_EJECUTAR(@PathVariable("key") String valor, ModelMap model) {
		    	Herramientas.obtener_nombre_de_usuario_loggeado();
				Constantes.usuarioparametros = SERVICIO_USUARIOS.OBTENERLISTA_PARAMETROS_POR_EL_NOMBRE_DE_USUARIO(Herramientas.obtener_nombre_de_usuario_loggeado());// CON EL OBJETO PREVIO SE GUARDA EL RESULTADO DE LA CONSULTA AL MANDARLE EL NOMBRE DE USUARIO 
			    // CON EL OBJETO PREVIO SE GUARDA EL RESULTADO DE LA CONSULTA AL MANDARLE EL NOMBRE DE USUARIO 
			  
			   if(Constantes.usuarioparametros.size()!=0){
				
				    model.put("regionesestatico", SERVICIO_PARAMETROS.SELECT_LIKE(valor,Constantes.usuarioparametros.get(0).getPARAMETROS_DISPONIBLES()));
					Constantes.acceso_parametros.clear();	
			   }
			   else if (Constantes.usuarioparametros.size()==0){
				   PARAMETROS sesionterminada = new PARAMETROS();
				   sesionterminada.setID_PARAMETRO(5000);
				   sesionterminada.setCLAVE("Sesión terminada, recargue la página para continuar");
				   sesionterminada.setVALOR("");
				   sesionterminada.setAPLICATIVO("");
				   sesionterminada.setDESCRIPCION("");
				   ArrayList a = new ArrayList();
				   a.add(sesionterminada);
				   
				   model.put("regionesestatico", a);
			   }
				return new ModelAndView("/Parametros",model); //CON PARAMETROS SOLO SE REFRESCA LA PARTE DE LA TABLA PARAMETROS MANDANDO LA INFO NUEVA
			}
			//VALIDADO CON JDBC
		    @SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value = "/Consulta_SELECT_ALL_PARAMETROS", method = RequestMethod.GET)//A CONSIDERAR POR EL NOMBRE DEL USUARIO Y  LA LISTA DE PARAMETROS A LAS CUALES PODRA TENER ACCESO PERO TENIENDO LA RUTA PRINCIPAL DE LOS PARAMETROS 
			public ModelAndView SELECT_ALL_REGIONES_EJECUTAR(ModelMap model) {
		    	Constantes.usuarioparametros = SERVICIO_USUARIOS.OBTENERLISTA_PARAMETROS_POR_EL_NOMBRE_DE_USUARIO(Herramientas.obtener_nombre_de_usuario_loggeado());// CON EL OBJETO PREVIO SE GUARDA EL RESULTADO DE LA CONSULTA AL MANDARLE EL NOMBRE DE USUARIO 
			   ACCESO_USUARIOS parametros_del_usuario = new ACCESO_USUARIOS();
			  		  if(Constantes.usuarioparametros.size()!=0) {
			 		 model.put("regionesestatico",SERVICIO_PARAMETROS.OBTENER_PARAMETROS_PARA_EL_USUARIO_LOGGEADO(Constantes.usuarioparametros.get(0).getPARAMETROS_DISPONIBLES()));
				    	Constantes.acceso_parametros.clear();			    
				  }
				  else if (Constantes.usuarioparametros.size()==0){
					  PARAMETROS sesionterminada = new PARAMETROS();
					   sesionterminada.setID_PARAMETRO(5000);
					   sesionterminada.setCLAVE("Sesión terminada, recargue la página para continuar");
					   sesionterminada.setVALOR("");
					   sesionterminada.setAPLICATIVO("");
					   sesionterminada.setDESCRIPCION("");
					   ArrayList a = new ArrayList();
					   a.add(sesionterminada);
					   
					   model.put("regionesestatico", a);
					  
				   }
					return new ModelAndView("/Parametros",model); //CON FORMULARIOPARAMETROS ME MANDA LA VISTA COMPLETA
			} 
		    //VALIDO CON EL JDBC
		    @RequestMapping(value = "/EliminarParametro/{regiones}") //PARA ELIMINAR UN PARAMETRO
			public String Deleting(@PathVariable("regiones") Integer id){
		    	SERVICIO_PARAMETROS.ELIMINAR_PARAMETRO(id);
		        return "redirect:/ParametrosVista"; //CON FORMULARIOPARAMETROS ME MANDA LA VISTA COMPLETA
			} 
		    //VALIDADO CON EL JDBC
		    @RequestMapping(value = "/NuevoParametro", method = RequestMethod.POST) //PARA AGREGAR
			public String addContact(@ModelAttribute("regiones")  PARAMETROS parametronuevo, BindingResult result) {
		    	SERVICIO_PARAMETROS.AGREGAR_PARAMETRO(parametronuevo);
				return "redirect:/ParametrosVista";
			}
}