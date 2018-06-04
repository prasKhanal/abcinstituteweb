<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
  <div class="mainbody">
  <h1>Show Message</h1>
  <h2>Message Subject</h2>
  <p>${message.subject}</p>
  <h3>Date</h3>
  <p>${message.date}</p>
   <h3> Message</h3>
 <p>
${message.message}
</p>


     
      <p >
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/subject/${message.subjectType}"><input  type="Button" value="GoBack"/></a>
      </p>

  </div>
  