<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

  <div class="mainbody">
  <h1>Add Subject</h1>
  <s:form  method="post" modelAttribute="subject" action="addSubject" >
   <fieldset> <table>
    
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
       <tr><td>
      <s:label path="cost">Subject Cost:</s:label></td><td>
      <s:input path="cost" size="50"  /></td>
      </tr><tr><td></td><td>
      <br/>
             <font color="red" size="-1"> <s:errors path="cost" cssClass="error" /></font></td></tr>
      
             <tr> <td>
        <s:label path="subjectType"> Subject Type:</s:label></td><td>
      <s:select path="subjectType"  multiple="false">
      <s:option value=""  label="--- Select ---"/>
      <s:option value="MGT" label="Management"/>
      <s:option value="ITC" label="Information Technology"/>
      <s:option value="ACT" label="Accounting"/>
      
      </s:select></td></tr><tr><td></td><td><br/><font color="red" size="-1">
            <s:errors path="subjectType" cssClass="error" /></font>
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
        <a href="addSubject"><input name="Reset" type="reset" value="Reset"/></a>
      </p></td></tr>
     </table>
      
      </fieldset>
  </s:form>
  
  </div>
 