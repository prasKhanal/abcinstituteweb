  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <div class="description"><img src="resources/images/Screen Shot 2013-01-15 at 8.47.34 PM.png" width="236" height="45" />
  <ul>
  <li><a href="<%=request.getContextPath()%>/EditDetail">Edit User Detail</a></li>
  <li><a href="<%=request.getContextPath()%>/changePassword">Change Password</a></li>
  
<c:set var = "admin" value="ROLE_ADMIN"/>
<c:set var = "student" value="ROLE_STUDENT"/> 
<c:set var = "teacher" value="ROLE_TEACHER"/>
<c:set var = "role" value="${role}"/>    

  <c:if test="${role eq student }"><li><a href="<%=request.getContextPath()%>/payfee">PayFee</a></li></c:if>
  <c:if test="${role ne student }"><li><a href="<%=request.getContextPath()%>/uploadResources">Upload Resources</a></li></c:if>  
  <c:if test="${role eq admin }"><li><a href="<%=request.getContextPath()%>/EditStudentOrTeacher">EditStudent/Teacher</a></li></c:if>
  <c:if test="${role eq admin }"><li><a href="<%=request.getContextPath()%>/RegisterUser">Register User</a></li></c:if>
   <c:if test="${role ne student }"> <li><a href="<%=request.getContextPath()%>/editSubjectDescription">Edit Subject Description</a></li></c:if>
  <c:if test="${role ne student}"><li><a href="<%=request.getContextPath()%>/postMessage">Post Message</a></li></c:if>
    <c:if test="${role eq student }"><li><a href="<%=request.getContextPath()%>/listReceipt">List Receipt</a></li></c:if>
    <c:if test="${role eq student }"><li><a href="<%=request.getContextPath()%>/listInvoice">List Invoice</a></li></c:if>
     <c:if test="${role eq admin }"><li><a href="<%=request.getContextPath()%>/addSubject">Add Subject</a></li></c:if>  
    
  
  </ul>
  </div>