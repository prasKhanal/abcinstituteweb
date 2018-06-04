<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>


  <div class="mainbody">
  <div >
  <h1>User Detail </h1>
  <s:form  method="post" modelAttribute="user" action="EditStudentOrTeacher" >
   <fieldset> <table>
    <tr><td>
      <label > Enter User Id:</label></td><td>
      <s:input path="userId" size="20" />
      </td></tr>
     <tr >
      <td ><font color="red" size="-1"> <s:errors path="name" cssClass="error" />
      ${err}</font><td></tr>
      <tr><td>
      <p >
        <input type="submit" name ="action" value="ExtractUser"/>
       </p></td></tr>
   </table>
      </fieldset>

  </div>
  <div id="detail">
  
  
   <fieldset> <table>
   <h3>Full User Detail</h3>
    <tr><td>
      <s:label path="userRole">User Role:</s:label></td><td>
      <s:input path="userRole" size="20" readonly="true" />
     </td></tr>
     <tr><td>
      <s:label path="userId">User Id:</s:label></td><td>
      <s:input path="userId" size="20" readonly="true" />
     </td></tr>
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
      <s:input path="email" size="30" readonly="true" />
      <br/>
             </td></tr>
     
    
     <tr><td></td><td>
      <p >
       
      <input type="submit"  name ="action" value="Edit Detail"/>
     
      </p></td></tr>
     </table>
      
      </fieldset>
  
  
 
  </div>
  <div id="subject">  <fieldset id="subject">
  <h3>Subject List</h3>
   <table>
  <tr><td>
  <ul>
  <c:forEach items="${user.subjectList}" var="subject">
  <li>
	<a href="<%=request.getContextPath()%>/subject/${subject.subjectType}">	${subject.subjectType}</a>
</li>
	</c:forEach>
  </ul>
  </td></tr>
  
     <tr><td>
      <p >
       
      <input name="action" type="submit" value="Assign"/> &nbsp;&nbsp;&nbsp;&nbsp;
       <input name="action" type="submit" value="Edit"/>
     
      </p></td></tr>
  </table></fieldset></s:form>
  </div>
  </div>
 
