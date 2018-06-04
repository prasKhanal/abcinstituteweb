<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

  <div class="mainbody">
  <h1>Edit User Detail</h1>
  <s:form  method="post" modelAttribute="user" action="EditDetail" >
   <fieldset> <table>
    <tr><td>
      <s:label path="userId">User Id:</s:label></td><td>
      <s:input path="userId" size="20" readonly="true" />
     </td></tr>
    
    <tr><td>
      <s:label path="name">Name:</s:label></td><td>
      <s:input path="name" size="20"  /></td><td>
      <br/>
             <font color="red" size="-1"> <s:errors path="name" cssClass="error" /></font></td></tr>
      <tr> <td>
       <s:label path="surName">SurName:</s:label></td><td>
      <s:input path="surName" size="20" /></td><td><br/><font color="red" size="-1">
            <s:errors path="surName" cssClass="error" /></font>
             </td></tr>
      <tr> <td>
      <s:label path="address.streetNumber">Street Number:</s:label></td><td>
      <s:input path="address.streetNumber" size="20" /></td><td><br/><font color="red" size="-1">
            <s:errors path="address.streetNumber" cssClass="error" /></font>
             </td></tr>
             <tr> <td>
      <s:label path="address.street">Street Name:</s:label></td><td>
      <s:input path="address.street" size="20" /></td><td><br/><font color="red" size="-1">
            <s:errors path="address.street" cssClass="error" /></font>
             </td></tr>
            <tr> <td>  
        <s:label path="address.city"> City:</s:label></td><td>
      <s:input path="address.city" size="20" /></td><td><br/><font color="red" size="-1">
            <s:errors path="address.city" cssClass="error" /></font>
             </td></tr>
             <tr> <td>
        <s:label path="address.state"> State:</s:label></td><td>
      <s:select path="address.state"  multiple="false">
      <s:option value=""  label="--- Select ---"/>
      <s:option value="NSW" label="New South Wales"/>
      <s:option value="SA" label="South Australia"/>
      <s:option value="WS" label="West Australia"/>
      <s:option value="ACT" label="Australian Capital Teroteries"/>
      <s:option value="NT" label="Northen Terroteries"/>
      </s:select></td><td><br/><font color="red" size="-1">
            <s:errors path="address.state" cssClass="error" /></font>
             </td></tr>
              <tr> <td>
           <s:label path="address.postCode"> PostCode:</s:label></td><td>
      <s:input path="address.postCode" size="20" /></td><td><br/><font color="red" size="-1">
            <s:errors path="address.postCode" cssClass="error" /></font>
             </td></tr>
             
         <tr><td>
      <s:label path="phoneNumber">Phone Number:</s:label></td><td>
      <s:input onchange="required()"  path="phoneNumber" size="20"  /></td><td>
      <br/>
             <font color="red" size="-1"> <s:errors path="phoneNumber" cssClass="error" /></font></td></tr>
     <tr><td>
      <s:label path="email">Email:</s:label></td><td>
      <s:input path="email" size="20"  /></td><td>
      <br/>
             <font color="red" size="-1"> <s:errors path="email" cssClass="error" />
             </font></td></tr>
   
    <tr><td></td><td>
     
      <p >
        <input type="submit" value="Submit"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="EditDetail"><input name="Refresh" type="Button" value="Refresh"/></a>
      </p></td>
     </table>
      
      </fieldset>
  </s:form>
  
  </div>
  