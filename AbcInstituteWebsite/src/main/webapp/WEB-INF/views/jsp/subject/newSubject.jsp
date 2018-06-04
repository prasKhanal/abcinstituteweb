<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

  <div class="mainbody">
  <h1>Add Subject</h1>
  
   <fieldset> <table>
    
    <tr><td>
    </td><td>
    <p>
    Subject Name: ${subject.subjectName}<br/>
    Subject Code: ${subject.subjectType}</p></td></tr>
      
    <tr><td></td><td>
     
      <p >
       <a href="welcome"><input name="Go Back" type="button" value="Go Back"/></a>
      </p></td>
      
     </table>
      
      </fieldset>
  
  
  </div>
  