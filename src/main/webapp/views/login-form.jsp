<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../templates/header.jspf" %>
<div class="page-header">
    <h2>Please, Login!</h2>
</div>
<c:if test="${param.error != null}">        
    <p>
        Invalid username or password.
    </p>
</c:if>
<c:if test="${param.logout != null}">       
    <p>
        You have been logged out.
    </p>
</c:if>
<c:if test="${param.alreadyInstalled != null}">       
    <p>
        The system already was installed.
    </p>
</c:if>
<c:if test="${param.installed != null}">       
    <p>
        The system was installed. Please Login.
    </p>
</c:if> 
<div class="row">
    <div>
        ${message}
    </div>
</div>
<div class="row">
    <div class="well col-md-4 col-md-offset-4">
        <form:form method="POST" commandName="login" action="${pageContext.request.contextPath}/login">
            <div class="form-group">              
                <label>Username:</label>
                <form:input path="username" id="username" class="form-control" />
            </div>
            <div class="form-group">              
                <label>Password:</label>
                <form:input type="password" path="password" id="password" class="form-control" />
            </div>
            <button type="submit" class="btn btn-default btn-embossed btn-large btn-primary">Login</button>
            <a class="btn btn-embossed btn-info pull-right" href="${pageContext.request.contextPath}/signup">Signup</a>
        </form:form>
    </div>
</div>
<%@include file="../templates/footer.jspf" %>
