<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>



  <div class="mainbody">
  <h1>Subject DESCRIPTION</h1>
  <h2>${subject.subjectName}(${subject.subjectType})</h2>
 <h3> Subject Overview</h3>
 <p>
Welcome to a new session of study at Charles Sturt University.
</p><p>
${subject.subjectOverview}
</p>
<h4>Teaching staff</h4><p>

</p>
<h4> Prescribed text(s)</h4><p>
${subject.prescribedText}
</p>
 <p >
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/welcome"><input  type="Button" value="GoBack"/></a>
      </p>


  </div>
  <div class="greeting"><form action="<c:url value='j_spring_security_logout' />" method="post"><p>Welcome,<font size="+0.75">${principleUser}</font>
      <input name="Logout" type="submit"
					value="Logout" /></p>
  </form></div>
   <div class="description"><img src="resources/images/Screen Shot 2013-01-15 at 8.47.34 PM.png" width="236" height="45" />
 
  <div class="description"><div class="greeting">Message List</div>
  <ul>
  <c:forEach items="${subject.messageList}" var="message">  
  <li><a href="message/${message.subject}" >${message.subject}<br/><font color="red" size=-2>${message.date}</font></a></li>
	</c:forEach>
	</ul>
  </div>
  <div class="description">
  <div class="greeting">Resource List</div>
  <ul>
  <c:forEach items="${subject.resourceList}" var="resource">  
  <li><a target="blank" href="download/${resource.subjectType}/${resource.actualName}" >${resource.actualName}</a></li>
	</c:forEach>
	</ul>
  </div>
  </div>