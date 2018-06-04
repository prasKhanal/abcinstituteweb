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

import com.abcinstitute.beans.Resource;

/**
 * @author pras_khanal
 *
 */
@Repository
public class ResourceDao extends NamedParameterJdbcDaoSupport {
	
	 @Autowired
	 ResourceDao(DataSource dataSource){
	        setDataSource(dataSource);
	    }

	public List<Integer> getResourcesIds(String subjectType){
		String sql="SELECT ResourceId FROM Resource WHERE SubjectType=:subjectType";
		SqlParameterSource namedParameters = new MapSqlParameterSource("subjectType",subjectType);
		return (List<Integer>)this.getNamedParameterJdbcTemplate().queryForList(sql,namedParameters,Integer.class);
	}
	public Resource getResource(int id){
		String sql="Select * from Resource Where Resourceid=:id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",id);
		return this.getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters, new ResourceMapper());

	}

public void addResource(Resource resource) {
	String sql="Insert Into Resource(ResourceActualName , ResourceName,SubjectType)" +
			"Values(:actualName,:name,:type)";
	SqlParameterSource namedParameters = new MapSqlParameterSource("actualName",resource.getFile().getOriginalFilename()).
			addValue("name", resource.getResourceName()).addValue("type",resource.getSubjectType());
	this.getNamedParameterJdbcTemplate().update(sql,namedParameters);
	
}
public int containResource(Resource resource){
	String sql="SELECT COUNT(*)  FROM  Resource WHERE ResourceActualName =:actualName AND subjecttype=:subjectType";
	SqlParameterSource namedParameters = new MapSqlParameterSource("actualName",resource.getFile().getOriginalFilename()).
			addValue("subjectType",resource.getSubjectType());
	return this.getNamedParameterJdbcTemplate().queryForInt(sql, namedParameters);
}
	final class ResourceMapper implements RowMapper<Resource>{
		@Override
		public Resource mapRow(ResultSet rs,int rowNum)throws SQLException{
			Resource resource=new Resource();
			resource.setSubjectType(rs.getString("SubjectType"));
			resource.setActualName(rs.getString("ResourceActualName"));
			resource.setResourceName(rs.getString("ResourceName"));
			return resource;
		}
	}


}
