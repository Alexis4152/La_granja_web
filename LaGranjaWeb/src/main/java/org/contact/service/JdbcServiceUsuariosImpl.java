package org.contact.service;

import java.util.List;

import org.contact.dao.JdbcDaoUsuariosInterface;
import org.contact.model.ACCESO_USUARIOS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdbcServiceUsuariosImpl implements JdbcServiceUsuariosInterface{

	@Autowired
	private JdbcDaoUsuariosInterface Dao;
	@Override
	@Transactional
	public List<ACCESO_USUARIOS> OBTENERLISTA_PARAMETROS_POR_EL_NOMBRE_DE_USUARIO(String NOMBRE_DE_USUARIO) {
		return Dao.OBTENERLISTA_PARAMETROS_POR_EL_NOMBRE_DE_USUARIO(NOMBRE_DE_USUARIO);
	}

}
