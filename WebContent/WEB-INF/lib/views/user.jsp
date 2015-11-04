<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <body>
     Please enter the user details:<br/>
     <form:form modelAttribute="userForm" method="post">
        First Name: <form:input path="firstName" />
        <form:errors path="firstName" /><br />
        Last Name: <form:input path="lastName"/>
        <form:errors path="lastName" /><br />
        Username: <form:input path="userName" />
        <form:errors path="userName" /><br />
        Password: <form:input path="password"/>
        <form:errors path="password" /><br />
        <input type="submit" value="Create" />
     </form:form>
  </body>
</html>