
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<html >
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- InstanceBeginEditable name="doctitle" -->
<title>${title} </title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->

<link href="resources/css/Main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/otherpage.css" rel="stylesheet" type="text/css" />
<link href="resources/css/extras.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="container">
 <tiles:insertAttribute name="header" />
 <tiles:insertAttribute name="sidebar1" />
    <!-- InstanceBeginEditable name="conent" -->
  <div class="content">
 <tiles:insertAttribute name="body" />
  <tiles:insertAttribute name="greeting" />
  <tiles:insertAttribute name="description" />
  <!-- end .content --></div>
  <!-- InstanceEndEditable -->
 <tiles:insertAttribute name="footer" />
  <!-- end .container --></div>
</body>
<!-- InstanceEnd --></html>
