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