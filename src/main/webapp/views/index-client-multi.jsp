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
    <h3>Events</h3>
    <ol>
        <li><a href="${pageContext.request.contextPath}/Event/all">List</a></li>
    </ol>
    <h3>Activities</h3>
    <ol>
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
