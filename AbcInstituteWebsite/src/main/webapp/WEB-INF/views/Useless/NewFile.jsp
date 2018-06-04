<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ss" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>



<html >
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- InstanceBeginEditable name="doctitle" -->
<title>Register User</title>
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
  <h1>Change Your Password  </h1>
  <s:form  method="post" modelAttribute="password" action="changePassword" >
   <fieldset> <table>
    
    <tr><td>
      <s:label path="password">Password:</s:label></td><td>
      <s:input path="password" size="20"  /></td><td>
      </td></tr>
      <tr> <td>
       <s:label path="confirmPassword">Confirm Password:</s:label></td><td>
      <s:input path="confirmPassword" size="20" /></td><td><br/><font color="red" size="-1">
            <s:errors path="password" cssClass="error" /></font>
             </td></tr>
      
 
     <tr><td>
      <p >
        <input type="submit" value="Change Password"/>
       </p></td></tr>
   </table>
      </fieldset>
  </s:form>
  
  </div>
  <div class="greeting"><form action="<c:url value='j_spring_security_logout' />" method="post"><p>Welcome,<font size="+1">${principleUser.name}</font>
      <input name="Logout" type="submit"
					value="Logout" /></p>
  </form></div>
  <div class="description"><img src="resources/images/Screen Shot 2013-01-15 at 8.47.34 PM.png" width="236" height="33" />
  <ul>
  <li>Edit Detail</li>
  <li>PayFee</li>
  <li>Select Subject  
  </li><li>Assign Subject List 
  </li><li>Register Student

  </li></ul>
  </div><!-- end .content --></div>
  <!-- InstanceEndEditable -->
  <div class="footer">
<p>&nbsp; </p>
  <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
<!-- InstanceEnd --></html>
