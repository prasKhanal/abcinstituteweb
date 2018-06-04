<%@LANGUAGE="JAVASCRIPT" CODEPAGE="65001"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/logIn.dwt.asp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>Untitled Document</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
.container .content .mainbody #form2 table {
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}
.container .content .mainbody {
	text-align: center;
	vertical-align: top;
}
.container .content .mainbody #form2 p {
	text-align: center;
}
</style>
<!-- InstanceEndEditable -->

<link href="Main.css" rel="stylesheet" type="text/css" />
<link href="otherpage.css" rel="stylesheet" type="text/css" />

<link href="extras.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="container">
  <div class="header">
    <p><a href="#"><img src="images/logo.png" alt="logoImage" name="Insert_logo" width="199" height="128" id="Insert_logo" style="background: #C6D580; display:block;" /></a></p>
    <p>&nbsp;</p>
  </div>
  <div class="sidebar1">
    <ul class="nav">
      <li><a href="#">Home</a></li>
      <li><a href="#">About Us</a></li>
      <li><a href="#">Course</a></li>
      <li><a href="#">Contact Us</a></li>
    </ul>
   
    <!-- end .sidebar1 --></div>
    <!-- InstanceBeginEditable name="conent" -->
  <div class="content">
    <div class="greeting"><p>Welcome, Mr Pramesh Khanal</p></div>
  <div class="mainbody">
  <h1>Edit Detail</h1>
  <form id="form2" name="form2" method="post" action="">
    <table>
    <tr><td>
      <label for="eName">Name:</label></td><td>
      <input type="text" name="eName" id="eName" size="20"  /> 
      <input type="button" name="eNameB" id="eNameB" value="Edit" />
      
      </td></tr>
      <tr> <td>
       <label for="eSurName">SurName:</label></td><td>
      <input type="text" name="eSurName" id="eSurName" size="20" /> 
      <input type="button" name="eSurnameNameB" id="eSurnameNameB" value="Edit" />
      </td></tr>
      <tr> <td>
       <label for="eAddress">Address:</label></td><td>
      <textarea name="eAddress" cols="30" rows="4"></textarea>
      <input type="button" name="eAddress" id="eAddress" value="Edit" />
      </td></tr>
      <tr><td>
      <label for="eEmail">Email: </label></td><td>
          <input type="text" name="eEmail" id="eEmail" size="20" />
          <input type="button" name="eEmailB" value="Edit"/></td></tr> 
      </table>
      <p >
        <input type="submit" value="Submit"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="Reset"/>
      </p>
      <p>&nbsp;</p>
  </form>
  
  </div>
  <div class="description"><img src="images/Screen Shot 2013-01-15 at 8.47.34 PM.png" width="236" height="45" />
  <ul>
  <li>Edit Detail</li>
  <li>PayFee</li>
  <li>Select Subject  
  <li>Assign Subject List  
  <li>Register Student
    </Select>
  </ul>
  </div>
  <div class="SubList">
  <h3> SubjectList   </h3>
   <p><img src="sublist.png" width="135" height="180" alt="subl" /></p></div><!-- end .content --></div>
  <!-- InstanceEndEditable -->
  <div class="footer">
<p>&nbsp; </p>
  <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
<!-- InstanceEnd --></html>
