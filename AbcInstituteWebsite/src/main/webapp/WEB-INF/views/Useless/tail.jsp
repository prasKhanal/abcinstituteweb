<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
  <div class="description"><img src="resources/images/Screen Shot 2013-01-15 at 8.47.34 PM.png" width="236" height="45" />
  <ul>
  <li><a href="EditDetail">Edit User Detail</a></li>
  <li><a href="changePassword">Change Password</a></li>
  
<c:set var = "admin" value="ROLE_ADMIN"/>
<c:set var = "student" value="ROLE_STUDENT"/> 
<c:set var = "teacher" value="ROLE_TEACHER"/>
<c:set var = "role" value="${principleUser.userRole}"/>    

  <li><a href="payfee">PayFee</a></li>
  <c:if test="${role ne student }"><li><a href="uploadResources">Upload Resources</a></li></c:if>  
  <c:if test="${role eq admin }"><li><a href="EditStudentOrTeacher">EditStudent/Teacher</a></li></c:if>
    <c:if test="${role eq student }"><li><a href="listInvoice">List Invoice</a></li></c:if>
    <c:if test="${role eq student }"><li><a href="listReceipt">List Receipt</a></li></c:if>
  <c:if test="${role eq admin }"><li><a href="RegisterUser">Register User</a></li></c:if>
  <c:if test="${role eq admin }"><li><a href="addSubject">Add Subject</a></li></c:if>
   <c:if test="${role ne student }"> <li><a href="editSubjectDescription">Edit Subject Description</a></li></c:if>
  <c:if test="${role ne student}"><li><a href="postMessage">Post Message</a></li></c:if>
  </ul>
  </div>
  <!-- end .content --></div>
  <!-- InstanceEndEditable -->
  <div class="footer">
<p  style="color:#70706E;font: 10px arial">ABC Online Institute Pty. Ltd.  | 108 Illawara Road | Marrickville NSW 2204 | info@aoi.edu.au | tel 1300 309 240 | int. tel +61 3 9662 1401 | fax +61 3 9662 4472 | Cricos Provider: 02679C | RTO: 21594 </p>
 <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
<!-- InstanceEnd --></html>
