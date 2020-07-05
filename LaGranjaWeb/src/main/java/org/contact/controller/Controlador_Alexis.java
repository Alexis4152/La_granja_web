package org.contact.controller;

import org.contact.service.JdbcServicio_Acceso_Usuarios_Alexis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//ANNOTATIONS BY SPRING
@Controller
public class Controlador_Alexis {

	
	@Autowired
	private JdbcServicio_Acceso_Usuarios_Alexis SERVICIO;
	
	//Interface
	//Clase que implementa a la interface del servicio
	//Interface del dao
	//Clase que implementa la interface del dao = aqui se hacen las consultas
	
	//DAO
	//DATA
	//ACCESS
	//OBJECT

	//ESTO ES UNA VISTA
	@RequestMapping("/Usuarios")
	public String MOSTRAR_USUARIOS(Model modelo){
		
		modelo.addAttribute("LISTA_USUARIOS",SERVICIO.MOSTRAR_USUARIOS());
		
		return "Pantalla_usuarios";
	}
		
}