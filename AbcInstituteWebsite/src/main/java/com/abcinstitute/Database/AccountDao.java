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

import com.abcinstitute.beans.Invoice;
import com.abcinstitute.beans.Receipt;
import com.abcinstitute.beans.Subject;

/**
 * @author pras_khanal
 *
 */
@Repository
public class AccountDao extends NamedParameterJdbcDaoSupport {
	
	 @Autowired
	 AccountDao(DataSource dataSource){
	        setDataSource(dataSource);
	    }
	
	public Receipt getReceipt(int createRecept) {
		String sql="select * from receipt where receiptId=:receiptId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("receiptId",createRecept);
		return this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters,new ReceiptMapper());
	}
	
	public List<Integer> getInvoiceIds(int userId){
		String sql="SELECT invoiceid FROM invoice WHERE userId=:userId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
		return (List<Integer>)this.getNamedParameterJdbcTemplate().queryForList(sql,namedParameters,Integer.class);
	}
	
	public List<Integer> getUnpaidInvoiceIds(int userId){
		String sql="SELECT invoiceid FROM invoice WHERE userId=:userId And Status=false";
		SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
		return (List<Integer>)this.getNamedParameterJdbcTemplate().queryForList(sql,namedParameters,Integer.class);
	}
	public Invoice getInvoice(int invoiceId) {
		String sql="select * from invoice where invoiceid=:invoiceId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("invoiceId",invoiceId);
		return this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters,new InvoiceMapper());
	}
	
	public void changeInvoiceStatus(Integer paidInvoiceId) {
		String sql="UPDATE Invoice SET Status=true WHERE invoiceId=:invoiceId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("invoiceId",paidInvoiceId);
		this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	/**
	 * @param receipt
	 * @return
	 */
	public int createRecept(Receipt receipt) {
		String sql="INSERT INTO Receipt(userId ,Description, Amount) Values(:userId ,:Description, :Amount)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("userId",receipt.getUserId()).
				addValue("Description", receipt.getDescription()).addValue("Amount", receipt.getTotalAmount());
		return this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	/**
	 * @param userId
	 * @return
	 */
	public List<Integer> getReceiptIdList(int userId) {
		String sql="select receiptId from receipt where userId=:userId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
		return this.getNamedParameterJdbcTemplate().queryForList(sql, namedParameters, Integer.class);	
	}
	
	
	final class InvoiceMapper implements RowMapper<Invoice>{

		@Override
		public Invoice mapRow(ResultSet rs, int arg1) throws SQLException {
		    Invoice invoice = new Invoice();
		    invoice.setDate(rs.getString("Date").substring(0, 10));
		    invoice.setInvoiceId(rs.getInt("invoiceid"));
		    invoice.setStatus(rs.getBoolean("Status"));
		    invoice.setSubjectEnrolled(rs.getString("SubjectEnrolled"));
		    invoice.setUserId(rs.getInt("userId"));
		    invoice.setCost(rs.getInt("Cost"));
			return invoice;
		}
		
	}
	final class ReceiptMapper implements RowMapper<Receipt>{

		@Override
		public Receipt mapRow(ResultSet rs, int arg1) throws SQLException {
		    Receipt receipt = new Receipt();
		    receipt.setDate(rs.getString("Date").substring(0, 10));
		    receipt.setReceiptId(rs.getInt("receiptid"));
		    receipt.setDescription(rs.getString("Description"));
		    receipt.setTotalAmount(rs.getInt("Amount"));
		    receipt.setUserId(rs.getInt("userId"));
			return receipt;
		}
		
	}
	/**
	 * @param userId
	 * @param subjectCode
	 */
	public int createInvoice(int userId, Subject subject) {
		String sql="insert into invoice(SubjectEnrolled,userId,cost) values (:id,:user,:cost)";
		SqlParameterSource nameParameters=new MapSqlParameterSource("id",subject.getSubjectType()).addValue("user", userId)
				.addValue("cost", subject.getCost());
		return this.getNamedParameterJdbcTemplate().update(sql, nameParameters);
	}

	/**
	 * @param parseInt
	 * @return
	 */
	public int anyPayableInvoice(int userId) {
		String sql="SELECT COUNT(*)  FROM  Invoice WHERE userId =:userId AND Status=:Status";
		SqlParameterSource namedParameters = new MapSqlParameterSource("Status",0).addValue("userId",userId);
		return this.getNamedParameterJdbcTemplate().queryForInt(sql, namedParameters);
		
	}
}
