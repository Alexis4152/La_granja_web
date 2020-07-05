package org.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.contact.model.ACCESO_USUARIOS;
import org.contact.model.PARAMETROS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import mx.telcel.util.Constantes;

public class JdbcParametros implements JdbcDaoParametrosInterface{
	
	@Autowired
	private  DataSource dataSource;//IF NOT EXISTS (SELECT NUM_FACTURA FROM MTE_FACT_SERV)	
	private  JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@SuppressWarnings({ "rawtypes", "static-access" }) //PARAMETRO COMPLETO EN PARAMETROS_MTE DE CICLOS CORPORATIVOS 31,32,20,60,61,63,41,42,1,2,43,44
	public  List<PARAMETROS> OBTENER_PARAMETROS_PARA_EL_USUARIO_LOGGEADO(String PARAMETROS) {
	    String query = "";
	    if(PARAMETROS.equalsIgnoreCase("All")) {
	    	query = "SELECT * FROM PARAMETROS ORDER BY ID_PARAMETRO ASC";
	    }else {
	    	query ="SELECT * FROM PARAMETROS WHERE ID_PARAMETRO IN ("+PARAMETROS+") ORDER BY ID_PARAMETRO ASC";
	    }
	    jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query(query, new PARAMETROSLISTAMapper());	
	}
	@SuppressWarnings({ "rawtypes", "static-access" }) //PARAMETRO COMPLETO EN PARAMETROS_MTE DE CICLOS CORPORATIVOS 31,32,20,60,61,63,41,42,1,2,43,44
	public  List<PARAMETROS>OBTENER_PARAMETRO_DESEADO_PARA_LISTA(String PARAMETRO) {
	    	String query ="SELECT * FROM PARAMETROS WHERE CLAVE = '"+PARAMETRO+"' ";
	    jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query(query, new PARAMETROSLISTAMapper());	
	}
	@SuppressWarnings({ "rawtypes", "static-access", "unchecked" }) //PARAMETRO COMPLETO EN PARAMETROS_MTE DE CICLOS CORPORATIVOS 31,32,20,60,61,63,41,42,1,2,43,44
	public  PARAMETROS OBTENER_PARAMETRO_DESEADO_PARA_OBJETO_POR_ID_PARAMETRO(int PARAMETRO) {
	    	String query ="SELECT * FROM PARAMETROS WHERE ID_PARAMETRO = "+PARAMETRO+" ";
	    jdbcTemplate.setDataSource(getDataSource());
		return (PARAMETROS) jdbcTemplate.queryForObject(query, new PARAMETROSOBJETOMapper());
				
	}
	@SuppressWarnings({ "rawtypes", "static-access", "unchecked" }) //PARAMETRO COMPLETO EN PARAMETROS_MTE DE CICLOS CORPORATIVOS 31,32,20,60,61,63,41,42,1,2,43,44
	public  PARAMETROS OBTENER_PARAMETRO_DESEADO_PARA_OBJETO_POR_CLAVE(String PARAMETRO) {
	    	String query ="SELECT * FROM PARAMETROS WHERE CLAVE = '"+PARAMETRO+"' ";
	    jdbcTemplate.setDataSource(getDataSource());
		return (PARAMETROS) jdbcTemplate.queryForObject(query, new PARAMETROSOBJETOMapper());
				
	}
	public void UPDATE_PARAMETRO(PARAMETROS PARAMETRO_A_ACTUALIZAR) {
		 jdbcTemplate.setDataSource(getDataSource());
		 String query = "UPDATE PARAMETROS SET CLAVE = ?, VALOR = ?, APLICATIVO = ?, DESCRIPCION = ? WHERE ID_PARAMETRO = ?";
		 jdbcTemplate.update(query, PARAMETRO_A_ACTUALIZAR.getCLAVE(),PARAMETRO_A_ACTUALIZAR.getVALOR(),PARAMETRO_A_ACTUALIZAR.getAPLICATIVO(),PARAMETRO_A_ACTUALIZAR.getDESCRIPCION(),PARAMETRO_A_ACTUALIZAR.getID_PARAMETRO());
	}
	public void ELIMINAR_PARAMETRO(int ID) {
		jdbcTemplate.setDataSource(getDataSource());
		Object []ID_PARAMETRO = {ID};
		int [] types = {Types.INTEGER};
		String query = "DELETE PARAMETROS WHERE ID_PARAMETRO = ?";
		jdbcTemplate.update(query,ID_PARAMETRO,types);
	}
	public void AGREGAR_PARAMETRO(PARAMETROS NUEVO_PARAMETRO) {
		jdbcTemplate.setDataSource(getDataSource());
		String query = "INSERT INTO PARAMETROS(CLAVE,VALOR,APLICATIVO,DESCRIPCION) VALUES(?,?,?,?)";
		jdbcTemplate.update(query, NUEVO_PARAMETRO.getCLAVE(),NUEVO_PARAMETRO.getVALOR(),NUEVO_PARAMETRO.getAPLICATIVO(),NUEVO_PARAMETRO.getDESCRIPCION());
	}
	public List<PARAMETROS> SELECT_LIKE(String VALOR_BUSCADO,String PARAMETROS_DISPONIBLES) {
		jdbcTemplate.setDataSource(getDataSource());
		String query = "";
	    if(PARAMETROS_DISPONIBLES.equalsIgnoreCase("All")) {
	    	query = "SELECT * FROM PARAMETROS WHERE CLAVE LIKE '%"+VALOR_BUSCADO+"%' ";
	    }else {
	    	query = "SELECT * FROM PARAMETROS WHERE CLAVE LIKE '%"+VALOR_BUSCADO+"%' AND ID_PARAMETRO IN ("+PARAMETROS_DISPONIBLES+")";
	    }
	   
		return jdbcTemplate.query(query, new PARAMETROSLISTAMapper());
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	private static final class PARAMETROSLISTAMapper implements RowMapper<PARAMETROS>{
		@SuppressWarnings({ "static-access", "unchecked" })
		public PARAMETROS mapRow(ResultSet rs, int rowNum) throws SQLException {
			PARAMETROS asignarvalores = new PARAMETROS();	
			asignarvalores.setID_PARAMETRO(rs.getInt("ID_PARAMETRO"));
			asignarvalores.setCLAVE(rs.getString("CLAVE"));
			asignarvalores.setVALOR(rs.getString("VALOR"));
			asignarvalores.setAPLICATIVO(rs.getString("APLICATIVO"));
			asignarvalores.setDESCRIPCION(rs.getString("DESCRIPCION"));
			  return asignarvalores;
		}	
	}
	@SuppressWarnings({ "rawtypes", "unused" })
	private static final class PARAMETROSOBJETOMapper implements ParameterizedRowMapper{
		public PARAMETROS mapRow(ResultSet rs, int rowNum) throws SQLException {
			PARAMETROS asignarvalores = new PARAMETROS();	
			asignarvalores.setID_PARAMETRO(rs.getInt("ID_PARAMETRO"));
			asignarvalores.setCLAVE(rs.getString("CLAVE"));
			asignarvalores.setVALOR(rs.getString("VALOR"));
			asignarvalores.setAPLICATIVO(rs.getString("APLICATIVO"));
			asignarvalores.setDESCRIPCION(rs.getString("DESCRIPCION"));
			  return asignarvalores;
		}
	}
	
}
