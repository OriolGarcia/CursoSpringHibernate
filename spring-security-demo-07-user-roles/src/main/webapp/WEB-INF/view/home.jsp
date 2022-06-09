<%--
  Created by IntelliJ IDEA.
  User: oriol.garcia
  Date: 03/06/2022
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>luv2code Company Home Page</title>
</head>
<body>

<h2> luv2 code Company Home page</h2>
<hr>
        <p>
            User <security:authentication property="principal.username"/>
            <br><br>
            Role(s):<security:authentication property="principal.authorities"/>
        </p>
<hr>
<security:authorize access="hasRole('MANAGER')">
<p>
        <a href="${pageContext.request.contextPath}/leaders"> LeaderShipMeeting</a>

</p>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
<p>
    <a href="${pageContext.request.contextPath}/systems"> Systems Mettig (only for admin</a>

</p>
</security:authorize>
<hr>


Welcome to the luv2code company home page!

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
