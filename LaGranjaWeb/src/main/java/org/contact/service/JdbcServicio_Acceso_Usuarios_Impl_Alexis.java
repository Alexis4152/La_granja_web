package org.contact.service;

import java.util.List;

import org.contact.dao.JdbcDao_Acceso_Usuarios_Alexis;
import org.contact.model.ACCESO_USUARIOS;
import org.contact.model.DESCRIPCION_DE_VENTA;
import org.contact.model.PRODUCTOS;
import org.contact.model.VENTA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdbcServicio_Acceso_Usuarios_Impl_Alexis implements JdbcServicio_Acceso_Usuarios_Alexis{

	@Autowired
	private JdbcDao_Acceso_Usuarios_Alexis Dao;
	
	@Override
	@Transactional
	public List<PRODUCTOS> MOSTRAR_PRODUCTOS(String TIPO_PRODUCTO) {
		return Dao.MOSTRAR_PRODUCTOS(TIPO_PRODUCTO);
	}
	@Override
	@Transactional
	public int REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(int ID_PRODUCTO) {
		return Dao.REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(ID_PRODUCTO);
	}
	
	@Override
	@Transactional
	public List<PRODUCTOS> OBTENER_PRODUCTOS_PARA_PAQUETE(String TIPO_PRODUCTO) {
		return Dao.OBTENER_PRODUCTOS_PARA_PAQUETE(TIPO_PRODUCTO);
	}
	@Override
	@Transactional
	public List<PRODUCTOS> OBTENER_PRODUCTOS_PIERNA_HUACAL_COMPLETOS(String ID_DE_PRODUCTOS) {
		return Dao.OBTENER_PRODUCTOS_PIERNA_HUACAL_COMPLETOS(ID_DE_PRODUCTOS);
	}
	@Override
	@Transactional
	public void INSERTAR_DATOS_EN_LA_TABLA_VENTA(VENTA OBJETO) {
		 Dao.INSERTAR_DATOS_EN_LA_TABLA_VENTA(OBJETO);
	}
	@Override
	@Transactional
	public int OBTENER_ID_USUARIO(String USUARIO) {
		return Dao.OBTENER_ID_USUARIO(USUARIO);
	}
	@Override
	@Transactional
	public int[][] INSERTAR_DATOS_EN_LA_TABLA_DESCRIPCION_DE_VENTA(List<DESCRIPCION_DE_VENTA> PRODUCTOS, int batchSize) {
		return Dao.INSERTAR_DATOS_EN_LA_TABLA_DESCRIPCION_DE_VENTA(PRODUCTOS, batchSize);
	}
	@Override
	@Transactional
	public int[][] DESCONTAR_DE_INVENTARIO(List<DESCRIPCION_DE_VENTA> PRODUCTOS,int batchSize) {
		return Dao.DESCONTAR_DE_INVENTARIO(PRODUCTOS,batchSize);
	}
	@Override
	public List<VENTA> MOSTRAR_VENTAS_REALIZADAS() {
		return Dao.MOSTRAR_VENTAS_REALIZADAS();
	}

	
}
