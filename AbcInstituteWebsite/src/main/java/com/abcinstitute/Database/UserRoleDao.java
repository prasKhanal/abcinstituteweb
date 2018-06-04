/**
 * 
 */
package com.abcinstitute.Database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.abcinstitute.beans.User;

/**
 * @author pras_khanal
 *
 */
@Repository
public class UserRoleDao extends NamedParameterJdbcDaoSupport {
	
	 @Autowired
	 UserRoleDao(DataSource dataSource){
	        setDataSource(dataSource);
	    }


	/**
	 * @param user
	 */
	public void addUserRole(User user) {
		String sql="INSERT INTO UserRole" +
				"(UserId , UserAuthority )" +
				"VALUES (:userId,:userAuthority)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("userId", user.getUserId())
		.addValue("userAuthority",user.getUserRole());
		this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
		
	}
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public String getUserRole(int userId) {
		String sql="Select UserAuthority from userrole where userid= :userId";
		SqlParameterSource parameters=new MapSqlParameterSource("userId",userId);
		SqlRowSet s= this.getNamedParameterJdbcTemplate().queryForRowSet(sql, parameters);
		String result="null";
		while(s.next()){
			 result =s.getString("UserAuthority");
		}
		return result;
	}

}
