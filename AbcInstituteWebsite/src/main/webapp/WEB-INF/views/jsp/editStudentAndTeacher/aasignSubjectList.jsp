<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>


  <div class="mainbody">
  <h1>Assign Subject List </h1>
  <s:form  method="post" modelAttribute="user" action="assignSubjectList" >
   <fieldset> <table>
    <tr><td>
      <label >UserId:</label></td><td>
      <s:input path="userId" size="20" readonly="true" /></td><td>
      </td></tr>
      <tr><td>
      <s:label path="name">Name:</s:label></td><td>
      <s:input path="name" size="20" readonly="true" />
     </td></tr>
    <tr><td>
      <label for="checkbox">Select Subject:</label></td><td>
   <s:checkboxes items="${subjectList}" itemValue="subjectType" path="subjectList" id="subjectList" itemLabel="subjectName" delimiter="<br/> "/>
        
 
      </td><td>
      </td></tr>
    
      
 
     <tr><td>
      <p >
        <input type="submit" value="Assign Subject"/>
       </p></td></tr>
   </table>
      </fieldset>
  </s:form>
  
  </div>
  
