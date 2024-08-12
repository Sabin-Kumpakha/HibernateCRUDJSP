<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Result</title>
</head>
<body bgcolor="lightblue">
    <br/><br/>
    <h1 style="color:red; text-align:center;">
    <c:set var="result" value="${requestScope.delete}"/>
    <c:choose>
        <c:when test="${result == 'success'}">
            <h1 style='color: green; text-align: center;'>DELETE OPERATION SUCCESSFUL</h1>
        </c:when>
        
        <c:when test="${result == 'failure'}">
            <h1 style='color: red; text-align: center;'>DELETE OPERATION FAILED</h1>
        </c:when>
        
        <c:when test="${result == 'notfound'}">
            <h1 style='color: orange; text-align: center;'>RECORD NOT FOUND</h1>
        </c:when>
    </c:choose>
        <!-- request.getAttribute("delete") --> 
    </h1>
</body>
</html>
