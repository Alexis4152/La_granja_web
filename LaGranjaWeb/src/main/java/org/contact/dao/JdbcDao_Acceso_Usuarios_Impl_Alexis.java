package org.contact.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.contact.model.ACCESO_USUARIOS;
import org.contact.model.DESCRIPCION_DE_VENTA;
import org.contact.model.PRODUCTOS;
import org.contact.model.VENTA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
//import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

import mx.telcel.util.Herramientas;

import org.contact.model.VENTA;

@Component
public class JdbcDao_Acceso_Usuarios_Impl_Alexis implements JdbcDao_Acceso_Usuarios_Alexis{

	@Autowired
	private DataSource dataSource2;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	//public static SimpleDateFormat DateAndHour = new SimpleDateFormat("dd/MM/yyyy a las HH:mm:ss");
	@SuppressWarnings("unchecked")
	@Override
	public List<PRODUCTOS> MOSTRAR_PRODUCTOS(String TIPO_PRODUCTO) {
		jdbcTemplate.setDataSource(getDataSource2());
		String query = "SELECT * FROM PRODUCTOS WHERE TIPO_PRODUCTO = '"+TIPO_PRODUCTO+"' ";
		return jdbcTemplate.query(query, new PRODUCTOSMapper());
	}
    
	public int REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(int ID_PRODUCTO) {
		jdbcTemplate.setDataSource(getDataSource2());
		String query ="SELECT CANTIDAD FROM PRODUCTOS WHERE ID_PRODUCTO='"+ID_PRODUCTO+"'";
		return jdbcTemplate.queryForInt(query);
	}
	@SuppressWarnings("unchecked")
	public List<PRODUCTOS> OBTENER_PRODUCTOS_PARA_PAQUETE(String ID_DE_PRODUCTOS) {
		jdbcTemplate.setDataSource(getDataSource2());
		String query = "SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO IN ("+ID_DE_PRODUCTOS+") ORDER BY ID_PRODUCTO ASC";
		return jdbcTemplate.query(query,(ID_DE_PRODUCTOS.equalsIgnoreCase("2,3,4,5,6,7,8,9,10") ? new PRODUCTOSPOLLOENTEROMapper() : new PRODUCTOSMEDIOPOLLOMapper()));
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PRODUCTOS> OBTENER_PRODUCTOS_PIERNA_HUACAL_COMPLETOS(String ID_DE_PRODUCTOS) {
		jdbcTemplate.setDataSource(getDataSource2());
		String query = "SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO IN ("+ID_DE_PRODUCTOS+") ORDER BY ID_PRODUCTO ASC";
		return jdbcTemplate.query(query, new PRODUCTOSMapper());
	}	
	public void INSERTAR_DATOS_EN_LA_TABLA_VENTA(VENTA OBJETO) {
		jdbcTemplate.setDataSource(getDataSource2());
		String query = "INSERT INTO VENTA(ID_USUARIO,DESCUENTO,TOTAL,SUBTOTAL,PAGO,CAMBIO,ESTADO_VENTA,NOMBRE_CREDITO,FECHA) VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		jdbcTemplate.update(query,OBJETO.getID_USUARIO(),OBJETO.getDESCUENTO(),OBJETO.getTOTAL(),OBJETO.getSUBTOTAL(),OBJETO.getPAGO(),OBJETO.getCAMBIO(),OBJETO.getESTADO_VENTA(),OBJETO.getNOMBRE_CREDITO());
	}
	public int OBTENER_ID_USUARIO(String USUARIO) {
		jdbcTemplate.setDataSource(getDataSource2());
		String query ="SELECT ID_USER FROM ACCESO_USUARIOS WHERE USERNAME='"+USUARIO+"' AND HABILITADO = 'Y'";
		return jdbcTemplate.queryForInt(query);
	}
	
	public int[][] INSERTAR_DATOS_EN_LA_TABLA_DESCRIPCION_DE_VENTA(List<DESCRIPCION_DE_VENTA> PRODUCTOS,int batchSize) {
		int[][] updateCounts=null;
		try {
				jdbcTemplate.setDataSource(getDataSource2());
		        updateCounts = jdbcTemplate.batchUpdate(
		        	    "INSERT INTO DESCRIPCION_DE_VENTA(ID_PRODUCTO, CANTIDAD, IMPORTE, ID_VENTA) VALUES (?,?,?,(SELECT MAX(ID_VENTA) FROM VENTA))",
		                PRODUCTOS,
		                batchSize,
		                new ParameterizedPreparedStatementSetter<DESCRIPCION_DE_VENTA>() {
							@Override
							public void setValues(PreparedStatement ps, DESCRIPCION_DE_VENTA VALOR) throws SQLException {
								  ps.setInt(1,VALOR.getID_PRODUCTO());
								   ps.setFloat(2, VALOR.getCANTIDAD());
								   ps.setFloat(3, VALOR.getIMPORTE());  					  
				          	}
		                });
			}catch(org.springframework.dao.DuplicateKeyException DKE) {			 
			}
			  return updateCounts;
	    }

	@Override
	public int[][] DESCONTAR_DE_INVENTARIO(List<DESCRIPCION_DE_VENTA> PRODUCTOS,int batchSize) {
		int[][] updateCounts = jdbcTemplate.batchUpdate(
                "UPDATE PRODUCTOS SET CANTIDAD = ((SELECT CANTIDAD FROM PRODUCTOS WHERE ID_PRODUCTO = ?)-?) WHERE ID_PRODUCTO= ?",
                PRODUCTOS,
                batchSize,
                new ParameterizedPreparedStatementSetter<DESCRIPCION_DE_VENTA>() {
                    public void setValues(PreparedStatement ps, DESCRIPCION_DE_VENTA argument)
						throws SQLException {
                        ps.setInt(1, argument.getID_PRODUCTO());
                        ps.setFloat(2, argument.getCANTIDAD());
                        ps.setInt(3, argument.getID_PRODUCTO());
                    }
                });
        return updateCounts;
	}
	//INICIO VENTAS REALIZADAS
	@Override
	public List<VENTA> MOSTRAR_VENTAS_REALIZADAS() {
		jdbcTemplate.setDataSource(getDataSource2());//TO_CHAR(FECHA, 'YYYY-MM-DD HH24:MI:SS')
		String query="SELECT ID_VENTA,SUBTOTAL,DESCUENTO,TOTAL,PAGO,CAMBIO,FECHA FROM POLLERIA.VENTA WHERE TO_CHAR(FECHA,'ddMMyy') = '"+Herramientas.DIA_DE_HOY()+"' ";
		return jdbcTemplate.query(query, new VENTAMapper());
	}
	//FIN DE VENTAS REALIZADAS
	@SuppressWarnings("rawtypes")
	private static final class PRODUCTOSMapper implements ParameterizedRowMapper{
		public PRODUCTOS mapRow(ResultSet rs, int rowNum) throws SQLException {
			PRODUCTOS asignarvalores = 
					new PRODUCTOS
					(rs.getInt("ID_PRODUCTO"),rs.getString("NOMBRE_PRODUCTO"),rs.getString("TIPO_PRODUCTO"),rs.getFloat("PRECIO"),rs.getFloat("CANTIDAD"));	
		    return asignarvalores;
		}
	}
	@SuppressWarnings("rawtypes")
	private static final class PRODUCTOSPOLLOENTEROMapper implements ParameterizedRowMapper{
		public PRODUCTOS mapRow(ResultSet rs, int rowNum) throws SQLException {
			PRODUCTOS asignarvalores = 
					new PRODUCTOS
					(rs.getInt("ID_PRODUCTO"),rs.getString("NOMBRE_PRODUCTO"),rs.getString("TIPO_PRODUCTO"),rs.getFloat("PRECIO"),
				    (rs.getInt("ID_PRODUCTO") == 3 ||rs.getInt("ID_PRODUCTO") == 4 ||rs.getInt("ID_PRODUCTO") == 5  ||rs.getInt("ID_PRODUCTO") == 10 ? 2 : 1));	
		    return asignarvalores;
		}
	}
	@SuppressWarnings("rawtypes")
	private static final class PRODUCTOSMEDIOPOLLOMapper implements ParameterizedRowMapper{
		public PRODUCTOS mapRow(ResultSet rs, int rowNum) throws SQLException {
			PRODUCTOS asignarvalores = 
					new PRODUCTOS
					(rs.getInt("ID_PRODUCTO"),rs.getString("NOMBRE_PRODUCTO"),rs.getString("TIPO_PRODUCTO"),rs.getFloat("PRECIO"),
				    (rs.getInt("ID_PRODUCTO") == 2 ? (float)0.5 : 1));	
		    return asignarvalores;
		}
	}
	@SuppressWarnings("rawtypes")
	private static final class VENTAMapper implements ParameterizedRowMapper{
		public VENTA mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			VENTA asignarvalores = new VENTA
					(rs.getInt("ID_VENTA"),rs.getFloat("SUBTOTAL"),rs.getFloat("DESCUENTO"),rs.getFloat("TOTAL"),rs.getFloat("PAGO"),rs.getFloat("CAMBIO"),rs.getDate("FECHA"));	
		    return asignarvalores;
		}
	}

	public DataSource getDataSource2() {return dataSource2;}
	public void setDataSource2(DataSource dataSource2) {this.dataSource2 = dataSource2;}
	public JdbcTemplate getJdbcTemplate() {return jdbcTemplate;}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
	
}
