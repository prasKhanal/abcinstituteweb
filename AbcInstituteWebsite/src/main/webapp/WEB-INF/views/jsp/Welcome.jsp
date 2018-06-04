
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
  <div class="mainbody" Style="text-align: center;">
  <div Style="width:460px;margin: 0 auto;
    text-align: center;">
  <h1>Subject List</h1>
  <div style="background: white; width: 474px; list-style-image: square; ">
<h2 style="width: 460px; ">Subject Sites &amp; Forums</h2>


 <table style="width: 460px; list-style-image: square; ">
  <tbody>
  <c:forEach items="${subjectList}" var="subject">
  <tr><td width="80%">
  
  <a href="subject/${subject.subjectType}" >${subject.subjectName}(${subject.subjectType})</a></td></tr>
	</c:forEach><tr><td width="80%">
  </tbody>

</table>
  </div>
</div>
  
  </div>
  