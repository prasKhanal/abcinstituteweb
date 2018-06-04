<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

  <div class="mainbody">
  <h1>Add Subject Confirm</h1>
  <s:form  method="post" modelAttribute="subject" action="addSubjectConfirm" >
   <fieldset> <table>
    
    <tr><td>
      <s:label path="subjectName">Subject Name:</s:label></td><td>
      <s:input path="subjectName" size="50"  readonly="true"/></td>
      </tr>
      <tr> <td>
       <s:label path="subjectOverview">Subject OverView:</s:label></td><td>
      <s:textarea path="subjectOverview" cols="45" rows="10" readonly="true"/></td></tr>
       <tr><td>
      <s:label path="cost">Subject Cost:</s:label></td><td>
      <s:input path="cost" size="50" readonly="true" /></td>
      </tr>
             <tr> <td>
        <s:label path="subjectType"> Subject Type:</s:label></td><td>
      <s:input path="subjectType" size="45" readonly="true"/>
      </td></tr>
              <tr> <td>
           <s:label path="prescribedText"> Prescribed Text:</s:label></td><td>
     <s:textarea path="prescribedText" cols="45" rows="2" readonly="true"/></td></tr>
         
    <tr><td></td><td>
     
      <p >
        <input type="submit" name="Confirm" value="Confirm"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
       <input name="Go Back" type="submit" value="Go Back"/>
      </p></td>
      <tr><td></td><td><p><font color="red" size="-1">${err}</font></p></td></tr>
     </table>
      
      </fieldset>
  </s:form>
  
  </div>
