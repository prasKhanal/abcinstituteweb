/**
 * 
 */
package com.abcinstitute.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abcinstitute.beans.Invoice;
import com.abcinstitute.beans.Receipt;
import com.abcinstitute.beans.User;
import com.abcinstitute.service.AccountService;
import com.abcinstitute.service.UserService;

/**
 * @author pras_khanal
 *
 */
@Controller
public class PaymentController {
	private AccountService accountService;
	 
    @Autowired
    public void setAccountService(AccountService accountService){
    	this.accountService=accountService;
    }
	private UserService userService;
	 
    @Autowired
    public void setUserService(UserService userService){
    	this.userService=userService;
    }
	
	@RequestMapping(value="/listReceipt", method = RequestMethod.GET)
	public String ListInvoice(ModelMap model, Principal principal) {
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));	
			model.addAttribute("payableUser", userService.getUserWithAddress(principal.getName()));		 
		 model.addAttribute("receipts",accountService.getReceiptList(Integer.parseInt(principal.getName())));
		return "receiptList";
	}
	
	@RequestMapping(value="/listInvoice", method = RequestMethod.GET)
	public String ListReceipt(ModelMap model, Principal principal) {
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
			model.addAttribute("payableUser", userService.getUserWithAddress(principal.getName()));

		 model.addAttribute("invoices",accountService.getInvoiceList(Integer.parseInt( principal.getName())));
		return "listReceipt";
	}
	
	@RequestMapping(value="/payfee", method = RequestMethod.GET)
	public String payFee(ModelMap model, Principal principal) {
		User user =new User();
		model.addAttribute("user",user);
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		model.addAttribute("payableUser", userService.getUserWithAddress(principal.getName()));
		model.addAttribute("invoices",accountService.getUnpaidInvoiceList(Integer.parseInt( principal.getName())));
		if(!accountService.anyPayableInvoice(Integer.parseInt( principal.getName()))){
			model.addAttribute("err","All invoice paid");
		}
		return "payFee";
	}
	@RequestMapping(value="/payFee", method = RequestMethod.POST)
	public String payFee1(ModelMap model, User user,Principal principal) {
		model.addAttribute("user",user);
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		model.addAttribute("payableUser", userService.getUserWithAddress(principal.getName()));
		 if(user.getInvoiceList()==null){
			model.addAttribute("invoices",accountService.getUnpaidInvoiceList(Integer.parseInt( principal.getName())));
			model.addAttribute("err","Please select one invoice");
			return "payFee";
		}
		else{
		Iterator<Invoice> iterator =user.getInvoiceList().iterator();
		int total=0;
		while(iterator.hasNext()) total+=iterator.next().getCost();
		model.addAttribute("totalCost",total);
		model.addAttribute("invoices",user.getInvoiceList());
		return "payConfirm";
		}
	}
	@RequestMapping(value="/payFeeConfirm", method = RequestMethod.POST)
	public String payFee2(ModelMap model, User user,Principal principal) {
		Iterator<Invoice> iterator =user.getInvoiceList().iterator();
		int total=0;
		while(iterator.hasNext()) total+=iterator.next().getCost();
		model.addAttribute("totalCost",total);
		model.addAttribute("user",user);
		model.addAttribute("invoices",user.getInvoiceList());
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
			model.addAttribute("payableUser", userService.getUserWithAddress(principal.getName()));

		 return "payComit";
	}
	@RequestMapping(value="/payComit", method = RequestMethod.POST)
	public String payFee3(ModelMap model, User user,Principal principal) {
		Iterator<Invoice> iterator =user.getInvoiceList().iterator();
		int total=0;
		String ids="";
		List <Integer>paidInvoices=new   ArrayList<Integer>();
		while(iterator.hasNext()) {
			Invoice invoice=iterator.next();
			total+=invoice.getCost();
			paidInvoices.add(invoice.getInvoiceId());
			ids+=invoice.getSubjectEnrolled()+",";
		}
		accountService.changeInvoiceStatus(paidInvoices);
		Receipt receipt=new Receipt();
		receipt.setTotalAmount(total);
		receipt.setUserId(Integer.parseInt(principal.getName()));
		receipt.setDescription("Paid Enrolment fee for:"+ ids.substring(0, ids.length()-2));
		
		model.addAttribute("receipt",accountService.getReceipt(accountService.createRecept(receipt)));
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
			model.addAttribute("payableUser", userService.getUserWithAddress(principal.getName()));
		 return "receiptGenerate";
	}
	
}
