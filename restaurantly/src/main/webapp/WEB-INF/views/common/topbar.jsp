<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<!-- ======= Top Bar ======= -->
<div class="container d-flex">
	<div class="contact-info mr-auto">
		<i class="icofont-phone"></i> +1 5589 55488 55 <span
			class="d-none d-lg-inline-block"><i
			class="icofont-clock-time icofont-rotate-180"></i> Mon-Sat: 11:00
			AM - 23:00 PM</span>
	</div>
	<div class="languages">
		<ul>
			<c:choose>
				<c:when test="${not empty customer }">
					<li><a href="${contextPath}/customer/logout.do">Logout</a></li>
					<li><a href="${contextPath}/customer/myPageMain.do">MyPage</a></li>
				</c:when>
				<c:when test="${not empty owner }">
					<li><a href="${contextPath}/owner/logout.do">Logout</a></li>
					<li><a href="${contextPath}/owner/myPageMain.do">MyPage</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${contextPath}/loginForm.do">Login</a></li>
					<li><a href="${contextPath}/joinForm.do">Join</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>