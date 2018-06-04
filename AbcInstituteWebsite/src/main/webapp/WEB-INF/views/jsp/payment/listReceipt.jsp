<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>



  <div class="mainbody">
  <h2>Invoice List</h2>
  <p><b>Student Id:</b>${payableUser.userId}<br/>
      ${payableUser.name} ${payableUser.surName}<br/>
      ${payableUser.address.streetNumber},${payableUser.address.street}<br/>
      ${payableUser.address.city}, ${payableUser.address.state}, ${payableUser.address.postCode}
      </p>
   <fieldset> <table>
    <tr><th width="10%" >Invoice Id</th>
    <th width="30%" >Date</th>
    <th  width="40%" >Description</th>
    <th width="30%">Cost</th>
    <th width="30%">Paid</th>
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
  ${invoice.status}
  </td>
  <td>
  </td>
  </tr>
	</c:forEach>
	    </table>
      </fieldset>
     <p>
         <a href="welcome"><input type="button" value="Go Back "/></a>
         </p>

  
  </div>
  