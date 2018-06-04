<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
    <form name="form1" action="<c:url value='/j_spring_security_check' />"method='POST'>
    <table >
  <tr>
  <th><h1 align="center">LogIn</h1></th></tr>
  <tr>
    <td align="right" >  
        <label for="username">User Name:</label></td><td>
              <input type="text" name='j_username' value="${j_username}" />
      <span class="forgetUsername">Forget Your User Name</span>
    </td>
  
  </tr>
 
  <tr>
    <td align="right">
        <label for="password">Password:</label></td><td>
      <input type="password"  name='j_password' />
      <span class="forgetUsername">Forget Your Password</span></td>
   </tr>
  <tr><td></td>
    <td><c:if test="${ not empty error}"><p id="errorBlock">Username and Password did not Match</p></c:if></td>
   
  </tr>
  <tr><td></td>
    <td><p><input type="submit" name="logInSubmit" id="logInSubmit" value="Login" />        
         <input name="Reset" value="Reset" type="Reset" />
       </p></td></tr>
 
</table>
  </form>
  

