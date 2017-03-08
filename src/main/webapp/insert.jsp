<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
</head>
<body>
<script>
    $(function() {
        $('input[name=birthday]').datepicker();
    });
</script>

<form method="POST" action='StudentController' name="frmAddStudent">
    ID : <input type="text" readonly="readonly" name="id" value="<c:out value="${student.id}" />"/>
    <br/>
    First Name : <input type="text" name="name" value="<c:out value="${student.name}" />"/>
    <br/>
    Last Name : <input type="text" name="surname" value="<c:out value="${student.surname}" />"/>
    <br/>
    Phone : <input type="text" name="phone" value="<c:out value="${student.phone}" />"/>
    <br/>
    Birthday : <input type="text" name="birthday" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${student.birthday}" />"/>
    <br/>
    Email : <input type="text" name="email" value="<c:out value="${student.email}" />"/>
    <br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
