package org.contact.service;

import java.util.List;

import org.contact.dao.JdbcDaoParametrosInterface;
import org.contact.model.PARAMETROS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdbcServiceParametrosImpl implements JdbcServiceParametrosInterface{

	@SuppressWarnings("unused")
	@Autowired
	private JdbcDaoParametrosInterface Dao;
	
	@Transactional
	public List<PARAMETROS> OBTENER_PARAMETROS_PARA_EL_USUARIO_LOGGEADO(String PARAMETROS) {
		return Dao.OBTENER_PARAMETROS_PARA_EL_USUARIO_LOGGEADO(PARAMETROS);
	}

	@Override
	@Transactional
	public List<PARAMETROS> OBTENER_PARAMETRO_DESEADO_PARA_LISTA(String PARAMETRO) {
		return Dao.OBTENER_PARAMETRO_DESEADO_PARA_LISTA(PARAMETRO);
	}

	@Override
	@Transactional
	public PARAMETROS OBTENER_PARAMETRO_DESEADO_PARA_OBJETO_POR_ID_PARAMETRO(int PARAMETRO) {
		return Dao.OBTENER_PARAMETRO_DESEADO_PARA_OBJETO_POR_ID_PARAMETRO(PARAMETRO);
	}

	@Override
	@Transactional
	public PARAMETROS OBTENER_PARAMETRO_DESEADO_PARA_OBJETO_POR_CLAVE(String PARAMETRO) {
		return Dao.OBTENER_PARAMETRO_DESEADO_PARA_OBJETO_POR_CLAVE(PARAMETRO);
	}

	@Override
	@Transactional
	public void UPDATE_PARAMETRO(PARAMETROS PARAMETRO_A_ACTUALIZAR) {
		Dao.UPDATE_PARAMETRO(PARAMETRO_A_ACTUALIZAR);
	}

	@Override
	@Transactional
	public void ELIMINAR_PARAMETRO(int ID) {
		Dao.ELIMINAR_PARAMETRO(ID);
	}

	@Override
	@Transactional
	public void AGREGAR_PARAMETRO(PARAMETROS NUEVO_PARAMETRO) {
	Dao.AGREGAR_PARAMETRO(NUEVO_PARAMETRO);
	}

	@Override
	@Transactional
	public List<PARAMETROS> SELECT_LIKE(String VALOR_BUSCADO, String PARAMETROS_DISPONIBLES) {
		return Dao.SELECT_LIKE(VALOR_BUSCADO, PARAMETROS_DISPONIBLES);
	}

}
