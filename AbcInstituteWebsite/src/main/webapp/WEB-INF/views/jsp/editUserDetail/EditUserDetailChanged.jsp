
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

  <div class="mainbody">
  <h1>User Detail Changed</h1>
  <s:form  method="post" modelAttribute="tempUser" >
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
     
    
     <tr><td></td><td>
      <p >
       
       <a href="welcome"><input name="Go Back" type="Button" value="Go Back"/></a>
     
      </p></td></tr>
     </table>
      
      </fieldset>
  </s:form>
  
  </div>
  