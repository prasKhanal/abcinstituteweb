<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>


  <div class="mainbody">
  <h1>Assign Subject Confirm List </h1>
  <h4>Following subjects have been added: </h4>
  <s:form  method="post" modelAttribute="user" action="confirmAssignSubjectList" >
   <fieldset> <table>
    <tr><td>
      <label >UserId:</label></td><td>
      <s:input path="userId" size="20" readonly="true" /></td><td>
      </td></tr>
      <tr><td>
      <s:label path="name">Name:</s:label></td><td>
      <s:input path="name" size="20" readonly="true" />
     </td></tr>
   
  <tr>
  <td>
      <label >SubjectList:</label></td><td>
  <ul>
  <c:forEach items="${user.subjectList}" var="subject">
  <li>
		${subject.subjectName}
</li>
	</c:forEach>
  </ul>
  </td></tr>
    
      
 
     <tr><td>
      <p >
        <a href="welcome"><input type="button" value="Go Back"/></a>
       </p></td></tr>
   </table>
      </fieldset>
  </s:form>
  
  </div>
 