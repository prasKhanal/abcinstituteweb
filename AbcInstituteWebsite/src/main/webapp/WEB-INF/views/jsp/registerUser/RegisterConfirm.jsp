<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>


  <div class="mainbody">
  <h1>ConFirm  User</h1>
  <s:form  method="post" modelAttribute="user" action="confirmRegister" >
   <fieldset> <table>
    
    <tr><td>
      <s:label path="name">Name:</s:label></td><td>
      <s:input path="name" size="20" readonly="true" />
     </td></tr>
      <tr> <td>
       <s:label path="surName">SurName:</s:label></td><td>
      <s:input path="surName" size="20" readonly="true" />
             </td></tr>
      <tr> <td>
      <s:label path="address.streetNumber">Street Number:</s:label></td><td>
      <s:input path="address.streetNumber" size="20" readonly="true" /><br/>
             </td></tr>
             <tr> <td>
      <s:label path="address.street">Street Name:</s:label></td><td>
      <s:input path="address.street" size="20" readonly="true" /><br/>
             </td></tr>
            <tr> <td>  
        <s:label path="address.city"> City:</s:label></td><td>
      <s:input path="address.city" size="20" readonly="true"/>
             </td></tr>
             <tr> <td>
        <s:label path="address.state"> State:</s:label></td><td>
      <s:input path="address.state" size="20" readonly="true" />
             </td></tr>
              <tr> <td>
           <s:label path="address.postCode"> PostCode:</s:label></td><td>
      <s:input path="address.postCode" size="20" readonly="true"/><br/>
             </td></tr>
             
         <tr><td>
      <s:label path="phoneNumber">Phone Number:</s:label></td><td>
      <s:input  path="phoneNumber" size="20" readonly="true" />
      <br/>
             </td></tr>
     <tr><td>
      <s:label path="email">Email:</s:label></td><td>
      <s:input path="email" size="40" readonly="true" />
      <br/>
             </td></tr>
     <tr> <td>
        <s:label path="userRole" multiple="false" readonly="true" > User Type:</s:label></td>
        <td>      <s:input path="userRole" size="20" readonly="true" />
        
                 </td></tr>
    <tr><td> <font color="red" size="-1"><p>${duplicateUser}</p></font></td><td>
     <tr><td></td><td>
      <p >
        <input type="submit" name="Confirm" value="Confirm"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="submit" name="GoBack"  value="GoBack"/>
      </p></td></tr>
     </table>
      
      </fieldset>
  </s:form>
  
  </div>
  