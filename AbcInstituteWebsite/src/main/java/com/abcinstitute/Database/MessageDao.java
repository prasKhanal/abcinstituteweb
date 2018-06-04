/**
 * 
 */
package com.abcinstitute.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.abcinstitute.beans.Message;

/**
 * @author pras_khanal
 *
 */
@Repository
public class MessageDao extends NamedParameterJdbcDaoSupport {
	
	 @Autowired
	 MessageDao(DataSource dataSource){
	        setDataSource(dataSource);
	    }
 
	final class MessageMapper implements RowMapper<Message>{
		@Override
		public Message mapRow(ResultSet rs,int rowNum) throws SQLException{
			Message message=new Message();
			message.setMessage(rs.getString("MessageMessage"));
			message.setSubject(rs.getString("MessageSubject"));
			message.setSubjectType(rs.getString("Subjectcode"));
			message.setDate(rs.getString("Date"));
			return message;
		}
	}
	
	public List<Integer> getSubjectsMessage(String subjectType) {
		String sql="SELECT MessageId FROM Message WHERE Subjectcode=:subjectType";
		SqlParameterSource namedParameters = new MapSqlParameterSource("subjectType",subjectType);
		return (List<Integer>)this.getNamedParameterJdbcTemplate().queryForList(sql,namedParameters,Integer.class);
		
	}
	public Message getMessage(String subject) {
		String sql="SELECT * FROM Message WHERE MessageSubject=:subject";
		SqlParameterSource namedParameters = new MapSqlParameterSource("subject",subject);
		return this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters, new MessageMapper());
	}
	
		public Message getMessage(int messageId){
			String sql="SELECT * FROM Message WHERE MessageId=:messageId";
			SqlParameterSource namedParameters = new MapSqlParameterSource("messageId",messageId);
			return this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters, new MessageMapper());
		
}
		public void addMessage(Message message) {
			String sql="Insert Into Message(MessageSubject, MessageMessage , Subjectcode) VALUES(:subject,:message,:code)";
			SqlParameterSource namedParameters = new MapSqlParameterSource("message",message.getMessage()).addValue("subject", message.getMessage()).
					addValue("code", message.getSubjectType());
			this.getNamedParameterJdbcTemplate().update(sql, namedParameters);	
		}
}
