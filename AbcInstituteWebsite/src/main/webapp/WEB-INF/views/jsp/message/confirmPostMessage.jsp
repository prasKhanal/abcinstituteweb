<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

  <div class="mainbody">
  <h1>Post Message </h1>
 <s:form  method="post" modelAttribute="message" action="postMessageConfirm" >
   <fieldset> <table>
  <tr><td>
      <s:label path="subjectType">Message Subject:</s:label></td><td>
      <s:input path="subjectType" size="50"  readonly="true"/></td>
      </tr>
    
    <tr><td>
      <s:label path="subject">Message Subject:</s:label></td><td>
      <s:input path="subject" size="50" readonly="true" /></td>
      </tr>
      <tr> <td>
       <s:label path="message">Message:</s:label></td><td>
      <s:textarea path="message" cols="45" rows="10" readonly="true"/></td></tr>
      
 
     <tr><td></td><td>
      <p >
        <input type="submit" value="Submit"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="postMessage"><input name="Reset" type="reset" value="Reset"/></a>
      </p></td></tr>
   </table>
      </fieldset>
  </s:form>
  
  </div>
 