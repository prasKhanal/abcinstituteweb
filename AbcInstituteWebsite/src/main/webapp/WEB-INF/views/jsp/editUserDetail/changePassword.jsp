
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

  <div class="mainbody">
  <h1>Change Your Password  </h1>
  <s:form  method="post" modelAttribute="password" action="changePassword" >
   <fieldset> <table>
    <tr><td>
      <label >Password:</label></td><td>
      <input type="password" size="20"  /></td><td>
      </td></tr>
    <tr><td>
      <s:label path="password">New Password:</s:label></td><td>
      <s:input type="password" path="password" size="20"  /></td><td>
      </td></tr>
      <tr> <td>
       <s:label path="confirmPassword">Confirm Password:</s:label></td><td>
      <s:input type="password" path="confirmPassword" size="20" /></td><td><br/><font color="red" size="-1">
            <s:errors path="password" cssClass="error" /></font>
             </td></tr>
      
 
     <tr><td>
      <p >
        <input type="submit" value="Change Password"/>
       </p></td></tr>
   </table>
      </fieldset>
  </s:form>
  
  </div>
  