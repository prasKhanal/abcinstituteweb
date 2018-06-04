/**
 * 
 */
package com.abcinstitute.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.abcinstitute.beans.Subject;

/**
 * @author pras_khanal
 *
 */
@Repository
public class SubjectDao extends NamedParameterJdbcDaoSupport {
	
	
	
	 @Autowired
	 SubjectDao(DataSource dataSource){
	        setDataSource(dataSource);
	    }
	private	GeneratedKeyHolder key =new GeneratedKeyHolder();

	
	public Subject getSubject(String subjectType){
		String sql="SELECT * FROM Subject WHERE subjecttype=:subjectType";
		SqlParameterSource namedParameters = new MapSqlParameterSource("subjectType",subjectType);
		Subject subject=this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters, new SubjectMapper());
		return subject;
	}
	
	public List<String> getAssignedSubject(int userId) {
		String sql="SELECT SubjectType FROM SubjectStudent WHERE userid=:userId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
		return (List<String>)this.getNamedParameterJdbcTemplate().queryForList(sql,namedParameters,String.class);
		
	}

	public List< Map<String, Object>> generateSubjects(){
		String sql="SELECT  subjecttype FROM Subject";
		return this.getJdbcTemplate().queryForList(sql);
	}
	
	final class SubjectMapper implements RowMapper<Subject>{

		@Override
		public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
			Subject subject =new Subject();
			subject.setSubjectType(rs.getString("subjecttype"));
			subject.setSubjectOverview(rs.getString("SubjectOverview"));
			subject.setPrescribedText(rs.getString("PrescribedText"));
			subject.setSubjectName(rs.getString("SubjectName"));
			return subject;
		}}

	//check subject already in the database
	public int containSubject(Subject subject){
		String sql="SELECT COUNT(*)  FROM  Subject WHERE SubjectName =:subjectName AND subjecttype=:subjectType";
		SqlParameterSource namedParameters = new MapSqlParameterSource("subjectName",subject.getSubjectName()).addValue("subjectType",subject.getSubjectType());
		return this.getNamedParameterJdbcTemplate().queryForInt(sql, namedParameters);
	}
	//Add subject to database
	public int addSubject(Subject subject){
		String sql="INSERT INTO Subject(SubjectName,SubjectOverview,PrescribedText,Cost)" +
				"VALUES(:subjectName,:subjectOverview,:prescribedText,:Cost)";
		SqlParameterSource namedParameter=new MapSqlParameterSource("subjectName",subject.getSubjectName()).
				addValue("subjectOverview",subject.getSubjectOverview()).
				addValue("prescribedText",subject.getPrescribedText()).addValue("Cost", subject.getCost());
		this.getNamedParameterJdbcTemplate().update(sql, namedParameter,key,new String[]{"subjectcode"});
		int code=key.getKey().intValue();
		addSubjectCode(subject.getSubjectType(),code);
		return code;
	}
	public void addSubjectCode(String subjectType, int code) {
		String sql="Update Subject SET subjecttype=:subjectType where subjectcode=:subjectCode";
		SqlParameterSource namedParameter=new MapSqlParameterSource("subjectType",subjectType+code).
				addValue("subjectCode", code);
		this.getNamedParameterJdbcTemplate().update(sql,namedParameter);
		
	}
	public void editSubject(Subject subject) {
		String sql="UPDATE Subject SET SubjectName=:subjectName,SubjectOverview=:subjectOverview," +
				" PrescribedText=:text WHERE subjecttype=:code";
		SqlParameterSource namedParameters = new MapSqlParameterSource("subjectName",subject.getSubjectName()).addValue("subjectOverview", subject.getSubjectOverview())
		.addValue("text", subject.getPrescribedText()).addValue("code", subject.getSubjectType());
		this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
		}
	/**
	 * @return
	 */
	//to generate subjectLists
	public List<Subject> generateUnassignedSubjectList(){
		 List<Subject> list = new ArrayList<Subject>();
		for (Map<String, Object> map : generateUnassignedSubjects()) {
			Subject subject=null;
		    for (Map.Entry<String, Object> entry : map.entrySet()) {
		        subject = getSubject(entry.getValue().toString());
		        
		    }
		    list.add(subject);
		}
		return list;
	}
	private List< Map<String, Object>> generateUnassignedSubjects(){
		String sql="SELECT  subjecttype FROM Subject where UserId is null";
		return this.getJdbcTemplate().queryForList(sql);
	}
	

}
