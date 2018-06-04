<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>



  <div class="mainbody">
  <h1>PayFee </h1>
  <h2>Invoice Description</h2>
  <p><b>Student Id:</b>${payableUser.userId}<br/>
      ${payableUser.name} ${payableUser.surName}<br/>
      ${payableUser.address.streetNumber},${payableUser.address.street}<br/>
      ${payableUser.address.city}, ${payableUser.address.state}, ${payableUser.address.postCode}
      </p>
  <s:form  method="post" modelAttribute="user" action="payComit" >
   <fieldset> <table>
    <tr><th width="10%" >Invoice Id</th>
    <th width="30%" >Date</th>
    <th  width="40%" >Description</th>
    <th width="30%">Cost</th>
    <th></th>
     <c:forEach items="${invoices}" var="invoice">
  <tr>
  <td id="th1">
  ${invoice.invoiceId}
  </td>
   <td>
  ${invoice.date}
  </td> 
  <td> 
  Enrolled on ${invoice.subjectEnrolled}
  </td> 
  <td>
  ${invoice.cost}
  </td>
  <td>
  </td>
  </tr>
  
	</c:forEach>
     <tr>
  <td id="th1">
  </td>
   <td>
  </td> 
  <td> 
Total Cost:  </td> 
  <td>
  ${totalCost}
  </td>
  <td>
  </td>
  </tr>
	    </table>
      </fieldset>
      <p><b> Confirm Your Payment Card Detail:</b> <br/></p>
      <table>
        <tr> <td>
        <s:label path="payment.type"> Card Type:</s:label></td><td>
      <s:select path="payment.type"  readonly="true"  multiple="false">
      <s:option value=""  label="--- Select ---"/>
      <s:option value="Master Card" label="Master Card"/>
      <s:option value="Visa Card" label="Visa Card"/>
      <s:option value="American Express" label="American Express"/>
      </s:select></td></tr>
             <tr><td>
      <s:label path="payment.cardNumber">Card Number:</s:label></td><td>
      <s:input path="payment.cardNumber" readonly="true"  size="20"  /></td>
             </tr>
             <tr><td>
             <s:label path="payment.expiryDate">Expiry Date</s:label></td><td>
             <s:input path="payment.expiryDate"  readonly="true"  size="20"/></td>
             
             </tr>
              <tr><td>
             <s:label path="payment.cvcCode">CVC Code</s:label></td><td>
             <s:input path="payment.cvcCode"  readonly="true" size="5"/></td>
             
             </tr>
             <tr><td>
             <s:label path="payment.name">Card Holder Name</s:label></td><td>
             <s:input path="payment.name" readonly="true" size="20"/></td></tr>
             
             </table>
             <p>
        <s:checkboxes  field="hidden" items="${invoices}" itemValue="invoiceId" itemLabel="label" path="invoiceList" id="invoice" onclick="return false" onkeydown="return false"  
          delimiter="&nbsp;&nbsp;&nbsp;&nbsp;" class="check"/>
        <br/>
         <input type="submit" value="Confirm Pay"/>
         <input type="submit" value="Go Back"/>
         </p>
  </s:form>
  
  </div>
  