<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>


  <div class="mainbody">
  <h1>PayFee </h1>
  <h2>Receipt Description</h2>
  <p><b>Student Id:</b>${payableUser.userId}<br/>
      ${payableUser.name} ${payableUser.surName}<br/>
      ${payableUser.address.streetNumber},${payableUser.address.street}<br/>
      ${payableUser.address.city}, ${payableUser.address.state}, ${payableUser.address.postCode}
      </p>
   <fieldset> <table>
    <tr><th width="10%" >Receipt Id</th>
    <th width="30%" >Date</th>
    <th  width="40%" >Description</th>
    <th width="30%">Amount</th>
    <th></th>
   
  <tr>
  <td id="th1">
  ${receipt.receiptId}
  </td>
   <td>
  ${receipt.date}
  </td> 
  <td> 
   ${receipt.description}
  </td> 
  <td>
  ${receipt.totalAmount}
  </td>
  </tr>
 
	    </table>
      </fieldset>
      <form>
             <p>
             
         <a href="welcome"><input type="button" value="Go Back"/></a>
         </p>
  </form>
  
  </div>
  