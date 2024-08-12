<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Result</title>
</head>
<body bgcolor="lightblue">
    <br/><br/>
    <c:choose>
        <c:when test="${update == 'updateSuccess'}">
            <h1 style='color: green; text-align: center;'>UPDATE OPERATION SUCCESSFUL</h1>
        </c:when>
        <c:when test="${update == 'updateFailure'}">
            <h1 style='color: red; text-align: center;'>UPDATE OPERATION FAILED</h1>
        </c:when>
        <c:otherwise>
            <h1 style='color: orange; text-align: center;'>RECORD NOT FOUND</h1>
        </c:otherwise>
    </c:choose>
</body>
</html>
