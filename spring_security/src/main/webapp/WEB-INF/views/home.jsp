<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<jsp:include page="common/header.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h2>
	${name} Logged In. 
</h2>
<a href="<c:url value="j_spring_security_logout" />" > Logout</a>

</body>
</html>
