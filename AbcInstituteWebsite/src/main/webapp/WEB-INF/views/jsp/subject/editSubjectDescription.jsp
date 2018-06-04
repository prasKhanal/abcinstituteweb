<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ss" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>




  <div class="mainbody">
  <h1>Edit Subject Description</h1>
  <s:form  method="post" modelAttribute="tempSubject" action="extractSubjectDescription" >
   <fieldset> <table>
   <tr><td>
      <label for="checkbox">Select Subject:</label></td><td>
   <s:select path="subjectType">
   <s:option value="NONE" label="--- Select ---"/>
   <s:options items="${principleUser.subjectList}" itemValue="subjectType"  itemLabel="subjectName"/>
</s:select>
 <input type="submit" value="Extract Subject"/>
 
      </td><td>
      </td></tr>
      </table></fieldset></s:form>
  <s:form  method="post" modelAttribute="subject" action="editSubjectDescriptionConfirm" >
   <fieldset> <table>
   <tr><td>
      <s:label path="subjectType">Subject Code:</s:label></td><td>
      <s:input path="subjectType" size="50" readonly="true" /></td>
      </tr><tr>
    <tr><td>
      <s:label path="subjectName">Subject Name:</s:label></td><td>
      <s:input path="subjectName" size="50"  /></td>
      </tr><tr><td></td><td>
      <br/>
             <font color="red" size="-1"> <s:errors path="subjectName" cssClass="error" /></font></td></tr>
      <tr> <td>
       <s:label path="subjectOverview">Subject OverView:</s:label></td><td>
      <s:textarea path="subjectOverview" cols="45" rows="10"/></td></tr><tr><td></td><td><br/>
      <font color="red" size="-1">
            <s:errors path="subjectOverview" cssClass="error" /></font>
             </td></tr>
      
              <tr> <td>
           <s:label path="prescribedText"> Prescribed Text:</s:label></td><td>
     <s:textarea path="prescribedText" cols="45" rows="2"/></td></tr><tr><td></td><td><br/><font color="red" size="-1">
            <s:errors path="prescribedText" cssClass="error" /></font>
             </td></tr>
             
         
    <tr><td></td><td>
     
      <p >
        <input type="submit" value="Submit"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="editSubjectDescription"><input name="Reset" type="reset" value="Reset"/></a>
      </p></td>
     </table>
      
      </fieldset>
  </s:form>
  
  </div>
  