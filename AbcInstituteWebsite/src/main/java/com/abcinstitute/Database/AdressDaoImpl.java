package com.abcinstitute.Database;
/**
 * 
 *//*
package com.app.Database;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.beans.Address;

*//**
 * @author pras_khanal
 *
 *//*
@Repository
public class AdressDaoImpl extends NamedParameterJdbcDaoSupport implements AddressDao {

	
	 (non-Javadoc)
	 * @see com.app.Database.AddressDao#getAddress(int)
	 
	@Override
	public Address getAddress(int userId) {
		String sql="SELECT * FROM Address WHERE User_Id=:userId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
		return this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters, new AddressMapper());
	}


	 (non-Javadoc)
	 * @see com.app.Database.AddressDao#editUserAddress(com.app.beans.Address, int)
	 
	@Override
	public void editUserAddress(Address address, int userId) {
		String sql="UPDATE  Address SET  StreetNumber=:streetNumber, Street=:street," +
				" City=:city, State=:state, PostCode=:postCode where user_id=:userId";	
			SqlParameterSource namedParameter=new MapSqlParameterSource("streetNumber",address.getStreetNumber()).
					addValue("street", address.getStreet()).addValue("city", address.getCity()).
					addValue("state", address.getState()).addValue("postCode", address.getPostCode()).
					addValue("userId", userId);
			this.getNamedParameterJdbcTemplate().update(sql, namedParameter);
		
	}


	 (non-Javadoc)
	 * @see com.app.Database.AddressDao#addAddress(com.app.beans.Address, int)
	 
	@Override
	public void addAddress(Address address, int userId) {
		String sql="INSERT INTO Address" +
				"(StreetNumber, Street ,City ,State , PostCode, User_Id) " +
				"VALUES(:streetNumber, :street,:city,:state,:postcode,:User_Id)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("password", "password").
				addValue("streetNumber", address.getStreetNumber())
				.addValue("street", address.getStreet().toLowerCase())
				.addValue("city", address.getCity().toLowerCase())
				.addValue("state",address.getState().toLowerCase())
				.addValue("postcode",address.getPostCode())
				.addValue("User_Id",userId);
		
		 this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
		
	}
	//Nested class used to map Adresss class directly from Sql query
	
	final class AddressMapper implements RowMapper<Address>{

		@Override
		public Address mapRow(ResultSet rs, int arg1) throws SQLException {
			Address address=new Address();
			address.setStreetNumber(rs.getInt( "StreetNumber"));
			address.setStreet(rs.getString("street"));
			address.setCity(rs.getString("City"));
			address.setState(rs.getString("State"));
			address.setPostCode(rs.getInt("PostCode"));
			return address;
	    }}
	
	}
*/