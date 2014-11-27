<%-- 
    Document   : _form
    Created on : Nov 15, 2014, 4:35:08 PM
    Author     : rgcs
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri='http://java.sun.com/jstl/core' prefix='c' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create and Update users on this page</h1>
        <div>
            ${message}
        </div>
        <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/User/${empty userID ? action : action.concat('/').concat(userID)}">
            <input type="hidden" name="userID" value="${userID}" >
            <table>
                <tbody>
                    <tr>
                        <td>First name:</td>
                        <td><form:input path="firstname" /></td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td><form:input path="lastname" /></td>
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td><form:input path="username" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="${empty userID ? "Add" : "Save"}" /></td>
                    </tr>
                </tbody>
            </table>
        </form:form>

        <p><a href="${pageContext.request.contextPath}">Home page</a></p>
    </body>
</html>