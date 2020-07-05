package org.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.contact.model.ACCESO_USUARIOS;
import org.contact.model.PARAMETROS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcDao_Acceso_Usuarios_Impl_Alexis implements JdbcDao_Acceso_Usuarios_Alexis{

	@Autowired
	private DataSource dataSource2;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ACCESO_USUARIOS> MOSTRAR_USUARIOS() {
		jdbcTemplate.setDataSource(getDataSource2());
		return jdbcTemplate.query("SELECT * FROM ACCESO_USUARIOS", new ACCESO_USUARIOSMapper());
	}
	public List<ACCESO_USUARIOS> MOSTRAR_USUARIOS2() {
		jdbcTemplate.setDataSource(getDataSource2());
		return jdbcTemplate.query("SELECT * FROM ACCESO_USUARIOS", new ACCESO_USUARIOSMapper());
	}
	

	@SuppressWarnings("rawtypes")
	private static final class ACCESO_USUARIOSMapper implements ParameterizedRowMapper{
		public ACCESO_USUARIOS mapRow(ResultSet rs, int rowNum) throws SQLException {
			ACCESO_USUARIOS asignarvalores = new ACCESO_USUARIOS();	
			
			asignarvalores.setID_USER(rs.getInt("ID_USER"));
			asignarvalores.setUSERNAME(rs.getString("USERNAME"));
			asignarvalores.setPASSWORD(rs.getString("PASSWORD"));
			asignarvalores.setROLE_USER(rs.getInt("ROLE_USER"));
			asignarvalores.setHABILITADO(rs.getString("HABILITADO"));
		
			  return asignarvalores;
		}
	}
	
	public DataSource getDataSource2() {return dataSource2;}
	public void setDataSource2(DataSource dataSource2) {this.dataSource2 = dataSource2;}
	public JdbcTemplate getJdbcTemplate() {return jdbcTemplate;}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
}
