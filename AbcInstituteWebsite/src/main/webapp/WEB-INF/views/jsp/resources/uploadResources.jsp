<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ss" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>



<html >
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- InstanceBeginEditable name="doctitle" -->
<title>Upload Resources</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->

<link href="resources/css/Main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/otherpage.css" rel="stylesheet" type="text/css" />

<link href="resources/css/extras.css" rel="stylesheet" type="text/css" />

</head>

<body>

<div class="container">
  <div class="header">
    <p><a href="#"><img src="resources/images/logo.png" alt="logoImage" name="Insert_logo" width="199" height="128" id="Insert_logo" style="background: #C6D580; display:block;" /></a></p>
    <p>&nbsp;</p>
  </div>
  <div class="sidebar1">
     <ul class="nav">
      <li><a href="welcomeHome">Home</a></li>
      <li><a href="welcome">My Profile</a></li>
      <li><a href="aboutUs">About Us</a></li>
      <li><a href="courseDetail">Course</a></li>
      <li><a href="contactUs">Contact Us</a></li>
    </ul>
   
    </div>
    <!-- InstanceBeginEditable name="conent" -->
  <div class="content">
  <div class="mainbody">
  <h1>Upload Resources</h1>
  <s:form  method="post" modelAttribute="resource" action="uploadResources"  enctype="multipart/form-data" >
   <fieldset> <table>
   <tr><td>
      <label for="checkbox">Select Subject:</label></td><td>
   <s:select path="subjectType">
   <s:option value="null" label="--- Select ---"/>
   <s:options items="${principleUser.subjectList}" itemValue="subjectType"  itemLabel="subjectName"/>
</s:select>
 </td></tr>
 <tr><td></td><td><br/>
      <font color="red" size="-1">
            <s:errors path="subjectType" cssClass="error" /></font>
             </td></tr>
 <tr>
  <td><label for="resourceName">File Name:</label></td>
  <td><s:input  path="resourceName" type="text"/>
</tr>
<tr><td></td><td><br/>
      <font color="red" size="-1">
            <s:errors path="resourceName" cssClass="error" /></font>
             </td></tr>
 <tr>
  <td><label for="file">Select File:</label></td>
  <td><s:input  path="file" type="file"/>
</tr>

    <tr><td></td><td>
     <p><font size="-1" color="red"> ${err}</font></p>
      <p >
      
        <input type="submit" value="Submit"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="editSubjectDescription"><input name="Reset" type="reset" value="Reset"/></a>
      </p></td>
     </table>
      
      </fieldset>
  </s:form>
  
  </div>
  <div class="greeting"><form action="<c:url value='j_spring_security_check' />" method="post"><p>Welcome,<font size="+0.75">${principleUser.name}</font>
      <input name="Logout" type="submit"
					value="Logout" /></p>
  </form></div>
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
  <c:if test="${role eq admin }"><li><a href="RegisterUser">Register User</a></li></c:if>
   <c:if test="${role ne student }"> <li><a href="editSubjectDescription">Edit Subject Description</a></li></c:if>
  <c:if test="${role ne student}"><li><a href="postMessage">Post Message</a></li></c:if>
  </ul>
  </div><!-- end .content --></div>
  <!-- InstanceEndEditable -->
  <div class="footer">
<p  style="color:#70706E;font: 10px arial">ABC Online Institute Pty. Ltd.  | 108 Illawara Road | Marrickville NSW 2204 | info@aoi.edu.au | tel 1300 309 240 | int. tel +61 3 9662 1401 | fax +61 3 9662 4472 | Cricos Provider: 02679C | RTO: 21594 </p>
  <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
<!-- InstanceEnd --></html>
