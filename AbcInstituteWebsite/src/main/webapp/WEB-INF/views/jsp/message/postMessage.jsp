<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

  <div class="mainbody">
  <h1>Post Message </h1>
 <s:form  method="post" modelAttribute="message" action="postMessage" >
   <fieldset> <table>
   <tr><td>
    <label for="subjectType">Select Subject:</label></td><td>
   <s:select path="subjectType">
   <s:option value="NONE" label="--- Select ---"/>
   <s:options items="${subjectList}" itemValue="subjectType"  itemLabel="subjectName"/>
</s:select>
</td></tr>
<tr><td></td><td>
      <br/>
             <font color="red" size="-1"> <s:errors path="subjectType" cssClass="error" /></font></td></tr>
    
    <tr><td>
      <s:label path="subject">Message Subject:</s:label></td><td>
      <s:input path="subject" size="50"  /></td>
      </tr><tr><td></td><td>
      <br/>
             <font color="red" size="-1"> <s:errors path="subject" cssClass="error" /></font></td></tr>
      <tr> <td>
       <s:label path="message">Message:</s:label></td><td>
      <s:textarea path="message" cols="45" rows="10"/></td></tr><tr><td></td><td><br/>
      <font color="red" size="-1">
            <s:errors path="message" cssClass="error" /></font>
             </td></tr>
      
 
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
  