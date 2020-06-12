package org.contact.dao;

import java.util.List;

import org.contact.model.ACCESO_USUARIOS;

public interface JdbcDaoUsuariosInterface {
	public  List<ACCESO_USUARIOS> OBTENERLISTA_PARAMETROS_POR_EL_NOMBRE_DE_USUARIO(String NOMBRE_DE_USUARIO);
}
