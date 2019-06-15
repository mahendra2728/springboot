<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
      <thead>
        <tr>
          <th>User Name</th>
          <th>First Name</th>
          <th>Last Name</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${students}" var="student">
         <tr>
          <td>${student.getUserName()}</td>
          <td>${student.getFirstName()}</td>
           <td>${student.getLastName()}</td>
          <td><img src="C://Mahendra Work Details/upload/test.png" /></td>
         </tr>
        </c:forEach>
      </tbody>
    </table> 
</body>
</html>