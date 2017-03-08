<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show All Students</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone</th>
        <th>Date of birth</th>
        <th>Email</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${student}" var="student">
        <tr>
            <td><c:out value="${student.id}" /></td>
            <td><c:out value="${student.name}" /></td>
            <td><c:out value="${student.surname}" /></td>
            <td><c:out value="${student.phone}" /></td>
            <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${student.birthday}" /></td>
            <td><c:out value="${student.email}" /></td>
            <td><a href="StudentController?action=edit&id=<c:out value="${student.id}"/>">Update</a></td>
            <td><a href="StudentController?action=delete&id=<c:out value="${student.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="StudentController?action=insert">Add Student</a></p>
</body>
</html>