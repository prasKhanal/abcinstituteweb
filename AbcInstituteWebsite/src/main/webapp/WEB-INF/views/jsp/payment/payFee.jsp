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
  <s:form  method="post" modelAttribute="user" action="payFee" >
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
	    </table>
      </fieldset>
      <p><b> Select the Invoice Ids you want to pay:</b> <br/>
      <c:if test="${err ne null }">
      <font color="red" size="-1">
      ${err}<br/>
      </font>
      </c:if>
        <s:checkboxes items="${invoices}" itemValue="invoiceId" itemLabel="invoiceId" path="invoiceList" id="invoice"   delimiter="&nbsp;&nbsp;&nbsp;&nbsp;"/>
        <br/>
        <c:if test="${err ne \"All invoice paid\" }">
         <input type="submit" value="Pay Fee"/></c:if>
         </p>
  </s:form>
  
  </div>
  