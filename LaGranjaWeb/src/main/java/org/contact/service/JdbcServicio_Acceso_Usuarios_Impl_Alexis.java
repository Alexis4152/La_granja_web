package org.contact.service;

import java.util.List;

import org.contact.dao.JdbcDao_Acceso_Usuarios_Alexis;
import org.contact.model.ACCESO_USUARIOS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdbcServicio_Acceso_Usuarios_Impl_Alexis implements JdbcServicio_Acceso_Usuarios_Alexis{

	@Autowired
	private JdbcDao_Acceso_Usuarios_Alexis Dao;
	
	@Override
	@Transactional
	public List<ACCESO_USUARIOS> MOSTRAR_USUARIOS() {
		return Dao.MOSTRAR_USUARIOS();
	}

	
	
}
