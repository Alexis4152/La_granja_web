package org.contact.service;

import java.util.List;

import org.contact.model.ACCESO_USUARIOS;
import org.contact.model.DESCRIPCION_DE_VENTA;
import org.contact.model.PRODUCTOS;
import org.contact.model.VENTA;


public interface JdbcServicio_Acceso_Usuarios_Alexis {

	public List<PRODUCTOS> MOSTRAR_PRODUCTOS(String TIPO_PRODUCTO);
	public int REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(int ID_PRODUCTO);
	public List<PRODUCTOS> OBTENER_PRODUCTOS_PARA_PAQUETE(String ID_DE_PRODUCTOS);
	public List<PRODUCTOS> OBTENER_PRODUCTOS_PIERNA_HUACAL_COMPLETOS(String ID_DE_PRODUCTOS);
	public void INSERTAR_DATOS_EN_LA_TABLA_VENTA(VENTA OBJETO);
	public int OBTENER_ID_USUARIO(String USUARIO);
	public int[][] INSERTAR_DATOS_EN_LA_TABLA_DESCRIPCION_DE_VENTA(List<DESCRIPCION_DE_VENTA> PRODUCTOS, int batchSize);
	public int[][] DESCONTAR_DE_INVENTARIO(List<DESCRIPCION_DE_VENTA> PRODUCTOS,int batchSize);
	public List<VENTA>MOSTRAR_VENTAS_REALIZADAS();
		
}
