package org.contact.service;

import java.util.List;

import org.contact.model.ACCESO_USUARIOS;


public interface JdbcServiceUsuariosInterface {
	
	public  List<ACCESO_USUARIOS> OBTENERLISTA_PARAMETROS_POR_EL_NOMBRE_DE_USUARIO(String NOMBRE_DE_USUARIO);
	//1 - 1000
	
}
