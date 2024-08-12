<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result</title>
</head>
<body bgcolor="lightblue">
    <br/><br/>
    <c:choose>
        <c:when test="${search != 'searchnotfound'}">
            <h1 style="color:green; text-align:center;">STUDENT DATA</h1>
            <table align="center" border="1">
                <tr>
                    <th>SID</th>
                    <th>SNAME</th>
                    <th>SAGE</th>
                    <th>SADDRESS</th>
                </tr>
                <tr>
                    <td>${search.sid}</td>
                    <td>${search.sname}</td>
                    <td>${search.sage}</td>
                    <td>${search.saddr}</td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <h1 style='color: red; text-align: center;'>RECORD NOT FOUND</h1>
        </c:otherwise>
    </c:choose>
</body>
</html>
