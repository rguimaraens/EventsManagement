<%-- 
    Document   : index
    Created on : Nov 15, 2014, 12:23:05 AM
    Author     : rgcs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../templates/header.jspf" %>
<div class="page-header">
    <h2>Project Base Actions</h2>
</div>
<div class="row">
    ${message}
</div>
<div class="row">
    System: ${productType}
    <h2>Menu</h2>
    <h3>Users</h3>
    <ol>
        <li><a href="${pageContext.request.contextPath}/User/all">List</a></li> 
        <li><a href="${pageContext.request.contextPath}/User/add">Create</a></li>
    </ol>
    <h3>Event</h3>
    <ol>
        <li><a href="${pageContext.request.contextPath}/Event/all">View</a></li>
        <li><a href="${pageContext.request.contextPath}/Event/edit/1" class="btn btn-primary btn-embossed">Edit</a></li>
        <li><a href="${pageContext.request.contextPath}/Activity/subscription">Subscription</a></li>
    </ol>
    <h3>Activity Type</h3>
    <ol>
        <li><a href="${pageContext.request.contextPath}/ActivityType/add">Create</a></li>
        <li><a href="${pageContext.request.contextPath}/ActivityType/all">List</a></li> 
    </ol>
    <h3>Activities</h3>
    <ol>
        <li><a href="${pageContext.request.contextPath}/Activity/add">Create</a></li>
        <li><a href="${pageContext.request.contextPath}/Activity/all">List</a></li> 
    </ol>
    <h3>Payments (variance)</h3>
    <ol>
        <li><a href="${pageContext.request.contextPath}/Activity/paymentSubscription">List</a></li>
    </ol>
    <h3>Contact (variance)</h3>
    <ol>
        <li><a href="${pageContext.request.contextPath}/contact">View</a></li>
    </ol>
</div>
<%@include file="../templates/footer.jspf" %>
