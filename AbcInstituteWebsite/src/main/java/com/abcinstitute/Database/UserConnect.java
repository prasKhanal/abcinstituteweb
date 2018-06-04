/**
 * 
 */
package com.abcinstitute.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.abcinstitute.beans.User;

/**
 * @author pras_khanal
 *
 */
@Repository
public class UserConnect extends NamedParameterJdbcDaoSupport {
	
	 @Autowired
	 UserConnect(DataSource dataSource){
	        setDataSource(dataSource);
	    }
	private	GeneratedKeyHolder key =new GeneratedKeyHolder();
	public void editUser(User user){
		String sql="UPDATE  User SET UserFirstName=:firstName, UserLastName=:lastName," +
				"UserPhoneNumber=:phoneNumber, UserEmail=:email     where userid=:userId";
		SqlParameterSource namedParameters=new MapSqlParameterSource("firstName",user.getName()).
				addValue("lastName", user.getSurName()).addValue("phoneNumber", user.getPhoneNumber()).
				addValue("email", user.getEmail()).addValue("userId", user.getUserId());
		this.getNamedParameterJdbcTemplate().update(sql,namedParameters);
	}

       /*
        * Map user object using rowmapper to return user object
        */

public User getUser(int userId){
	String sql="SELECT * FROM User WHERE UserId=:userId";
	SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
	User user =this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters, new UserMapper());
	return user;
	}
//change password
public void changePassword(String password, int userId){
	boolean is=false;
	String sql="UPDATE   User  SET UserDeafaultPassword=:default, UserPassword =:password  WHERE userid=:userId";
	SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId)
	.addValue("password", password).addValue("default", is);
	 this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
}




		final class UserMapper implements RowMapper<User>{

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user=new User();
				user.setUserId(rs.getInt("UserId"));
				user.setEmail(rs.getString("UserEmail"));
				user.setName(rs.getString("UserFirstName"));
				user.setPhoneNumber(rs.getInt("UserPhoneNumber"));
				user.setSurName(rs.getString("UserLastName"));
				return user;

			}
			
		}

		public int addUser(User user){
			String sql="INSERT INTO User" +
					"(UserPassword,UserFirstName , UserLastName , ENABLED , UserPhoneNumber , UserEmail , UserDeafaultPassword) " +
					"VALUES(:password, :name,:surName,:enabled,:phNumber,:email,:defaultPassword)";
			SqlParameterSource namedParameters = new MapSqlParameterSource("password", "password").
					addValue("name", user.getName().toLowerCase())
					.addValue("surName", user.getSurName().toLowerCase())
					.addValue("enabled", true)
					.addValue("phNumber",user.getPhoneNumber())
					.addValue("email",user.getEmail())
					.addValue("defaultPassword",true);
			
			 this.getNamedParameterJdbcTemplate().update(sql, namedParameters,key,new String[]{"UserId"});
			 
			 user.setUserId(key .getKey().intValue());
			 return user.getUserId();
		}

		/**
		 * @param parseInt
		 * @return
		 */
		public String getUserFirstName(int userId) {
			String sql="Select UserFirstName from user where userid= :userId";
			SqlParameterSource parameters=new MapSqlParameterSource("userId",userId);
			SqlRowSet s= this.getNamedParameterJdbcTemplate().queryForRowSet(sql, parameters);
			String result="null";
			while(s.next()){
				 result =s.getString("UserFirstName");
			}
			return result;
		}

		/**
		 * @param userId
		 * @return
		 */
		public boolean isDefaultPassword(int userId) {
			String sql="SELECT UserDeafaultPassword FROM User WHERE UserId=:userId";
			SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
			if( this.getNamedParameterJdbcTemplate().queryForInt(sql, namedParameters)==1) return true;
			else return false;
		}
		/**
		 * methods to check current user role of userId
		 * @param userId
		 * @return
		 */
		public String checkRole(int userId) {
			String sql="SELECT UserAuthority from UserRole WHERE UserId=:userId";
			SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
			return this.getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters,String.class);
			
		}
		public int checkDuplicateAssign(int userId, String subjectCode) {
			String sql="SELECT COUNT(*) from SubjectStudent Where UserId=:id and subjecttype=:code";
			SqlParameterSource namedParameters = new MapSqlParameterSource("id",userId).
					addValue("code", subjectCode);
			return this.getNamedParameterJdbcTemplate().queryForInt(sql, namedParameters);

		}
		public int assignSubject(int userId, String subjectCode) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO SubjectStudent Values(:id,:code)";
			SqlParameterSource namedParameters = new MapSqlParameterSource("id",userId).
					addValue("code", subjectCode);
			return this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
		}
		public void assignSubjectTeacher(int userId, String subjectCode) {
			// TODO Auto-generated method stub
			String sql="UPDATE Subject SET userid=:id WHERE SubjectType=:code";
			SqlParameterSource namedParameters = new MapSqlParameterSource("id",userId).
					addValue("code", subjectCode);
			 this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
			
		}
		
		
	}

