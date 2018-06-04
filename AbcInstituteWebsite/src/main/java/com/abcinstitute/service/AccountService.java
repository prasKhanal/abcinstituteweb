/**
 * 
 */
package com.abcinstitute.service;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.abcinstitute.Database.AccountDao;
import com.abcinstitute.beans.Invoice;
import com.abcinstitute.beans.Receipt;
import com.abcinstitute.beans.Subject;

/**
 * @author pras_khanal
 *
 */
@Service("accountService")
public class AccountService {
 private AccountDao accountDao;
 @Autowired
 public void setAccountDao(AccountDao accountDao){
	 this.accountDao=accountDao;
 }
	/**
	 * @param userId
	 * @return
	 */
 public List<Receipt> getReceiptList(int userId) {
		List<Receipt> receiptList=new ArrayList <Receipt>();
		Iterator <Integer> iterator=accountDao.getReceiptIdList(userId).iterator();
		while(iterator.hasNext())
		receiptList.add(accountDao.getReceipt(iterator.next()));
		return receiptList;
	}
 
 public List<Invoice> getUnpaidInvoiceList(int userId){
	 List<Invoice> list = new ArrayList<Invoice>();
	 Iterator <Integer>iterator= accountDao.getUnpaidInvoiceIds(userId).iterator();
	 while(iterator.hasNext()) list.add(accountDao.getInvoice(iterator.next()));
	 return list;
}
	/**
	 * @param parseInt
	 * @return
	 */
 public List<Invoice> getInvoiceList(int userId){
	 List<Invoice> list = new ArrayList<Invoice>();
	 Iterator <Integer>iterator= accountDao.getInvoiceIds(userId).iterator();
	 while(iterator.hasNext()) list.add(accountDao.getInvoice(iterator.next()));
	 return list;
}
 /**
	 * @param paidInvoices
	 */
	public void changeInvoiceStatus(List<Integer> paidInvoices) {
		Iterator<Integer> iterator=paidInvoices.iterator();
		while(iterator.hasNext()) accountDao.changeInvoiceStatus(iterator.next());
	}
/**
 * @param receipt
 * @return
 */
public int createRecept(Receipt receipt) {
	return accountDao.createRecept(receipt);
}
/**
 * @param createRecept
 * @return
 */
public Receipt getReceipt(int receiptId) {
	return accountDao.getReceipt(receiptId);
}
/**
 * @param parseInt
 * @return
 */
public boolean anyPayableInvoice(int parseInt) {
	return (accountDao.anyPayableInvoice(parseInt)>1);
}
@InitBinder
protected void initBinderinvoice(ServletRequestDataBinder binder) throws Exception {
    binder.registerCustomEditor(Invoice.class, "invoiceList", new PropertyEditorSupport() {
    	@Override
    public void setAsText(String text) {
       Invoice invoice  = accountDao.getInvoice(Integer.parseInt(text));
        setValue(invoice);
    }
    });
}
/**
 * @param userId
 * @param subject
 */
public void createInvoice(int userId, Subject subject) {
 accountDao.createInvoice(userId, subject);
}
}
