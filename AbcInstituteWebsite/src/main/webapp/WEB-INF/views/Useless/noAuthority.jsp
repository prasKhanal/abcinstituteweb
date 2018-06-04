<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>



<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Welcome page</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
.greeting {
	width: 200px;
	height:15px;
	float: right;
	padding-top: 10px;
	padding-right: 0;
	padding-bottom: 10px;
	padding-left: 0;
	background-color: #A7BE6B;
}
.container .content .greeting p {
	font-family: "MS Serif", "New York", serif;
	font-size: 13px;
	background-color: #A7BE6B;
}
.mainbody {
	width: 500px;
	height: 300px;
	float: Left;
	padding-top: 10px;
	padding-right: 0;
	padding-bottom: 10px;
	padding-left: 0;
}
.description{
	width: 195px;
	height:270px;
	float: right;
	padding-top: 0px;
	padding-right: 0px;
	padding-bottom: 0px;
	padding-left: 5px;
	}
.container .content .description img {
	clear: right;
	float: none;
	height: auto;
	width: 195px;
}
.container .content .description ul {
	font-family: "Comic Sans MS", cursive;
	color: #069;
	font-weight: bold;
	font-style: normal;
}
</style>


<!-- print -->

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
   
    <!-- end .sidebar1 --></div>
    <!-- InstanceBeginEditable name="conent" -->
  <div class="content">
  <div class="greeting">
  <form action="<c:url value='j_spring_security_logout' />" method="post"><p>Welcome,<font size="+0.75">${principleUser.name}</font>
      <input name="Logout" type="submit"
					value="Logout" /></p>
  </form></div>
  <div class="mainbody" Style="text-align: center;">
  <div Style="width:460px;margin: 0 auto;
    text-align: center;">
  <h1>Access Denied</h1>
  <div style="background: white; width: 474px; list-style-image: square; ">
<h2  style="width: 460px; color:red;">You donot have authority to open this page</h2>



  </div>
</div>
  
  </div>
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
  </div>
  <!-- end .content --></div>
  <!-- InstanceEndEditable -->
  <div class="footer">
<p  style="color:#70706E;font: 10px arial">ABC Online Institute Pty. Ltd.  | 108 Illawara Road | Marrickville NSW 2204 | info@aoi.edu.au | tel 1300 309 240 | int. tel +61 3 9662 1401 | fax +61 3 9662 4472 | Cricos Provider: 02679C | RTO: 21594 </p>
  <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
<!-- InstanceEnd --></html>
