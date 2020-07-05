package org.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.contact.model.ACCESO_USUARIOS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import mx.telcel.util.Constantes;


//EL REPOSITORIO QUE HACE REFERENCIA A LA TABLA DE LO USUARIOS REGISTRADOS
public class JdbcUsuarios implements JdbcDaoUsuariosInterface{
	
	@Autowired
	private  DataSource dataSource2;//IF NOT EXISTS (SELECT NUM_FACTURA FROM MTE_FACT_SERV)
	private  JdbcTemplate jdbcTemplate = new JdbcTemplate();

	  @SuppressWarnings({ "rawtypes", "static-access" })
	    @Transactional("dataSource2")
		public  List<ACCESO_USUARIOS> OBTENERLISTA_PARAMETROS_POR_EL_NOMBRE_DE_USUARIO(String NOMBRE_DE_USUARIO) {
			jdbcTemplate.setDataSource(getDataSource2());
	        //QUERY PRODUCTIVO String query = "SELECT * FROM MTE_FACT_SERV_PRE WHERE UUID_FACTURA='"+FACTURA+"'";//quitar el ' para agregar las condiciones de abajo
			String query = "SELECT * FROM ACCESO_USUARIOS WHERE USERNAME = '"+NOMBRE_DE_USUARIO+"' ";
			return jdbcTemplate.query(query, new ACCESO_USUARIOSVMapper());
		}
		

		public DataSource getDataSource2() {
		return dataSource2;
	    }


     public void setDataSource2(DataSource dataSource2) {
	 	this.dataSource2 = dataSource2;
	}


		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		
		private static final class ACCESO_USUARIOSVMapper implements RowMapper<ACCESO_USUARIOS>{
			@SuppressWarnings({ "static-access", "unchecked" })
			public ACCESO_USUARIOS mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				ACCESO_USUARIOS asignarvalores = new ACCESO_USUARIOS();
				
				asignarvalores.setID_USER(rs.getInt("ID_USER"));
				asignarvalores.setUSERNAME(rs.getString("USERNAME"));
				asignarvalores.setPASSWORD(rs.getString("PASSWORD"));
				asignarvalores.setHABILITADO(rs.getString("HABILITADO"));
				asignarvalores.setROLE_USER(rs.getInt("ROLE_USER"));
				 asignarvalores.setPARAMETROS_DISPONIBLES(rs.getString("PARAMETROS_DISPONIBLES"));
				  return asignarvalores;
			}	
		}

}
