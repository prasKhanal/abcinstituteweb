<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <div class="greeting"><form action="<c:url value='j_spring_security_logout' />" method="post"><p>Welcome,<font size="+0.75">${principleUser}</font>
      <input name="Logout" type="submit"
					value="Logout" /></p>
  </form></div>