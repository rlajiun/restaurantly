<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<!-- ======= Header ======= -->
<div class="container d-flex align-items-center">

	<h1 class="logo mr-auto">
		<c:choose>
			<c:when test="${user eq 'owner' }">
				<a href="${contextPath}/owner/main.do">Restaurantly for Owner</a>
			</c:when>
			<c:otherwise>
				<a href="${contextPath}/main.do">Restaurantly</a>
			</c:otherwise>
		</c:choose>
	</h1>
	<!-- Uncomment below if you prefer to use an image logo -->
	<!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

	<nav class="nav-menu d-none d-lg-block">
		<ul>
			<c:choose>
				<c:when test="${user eq 'owner' }">
					<li class="active"><a href="${contextPath}/owner/main.do">Home</a></li>
					<li><a href="${contextPath}/owner/booking/myBookList.do">예약 목록</a></li>
					<li><a href="${contextPath}/review/reviewList.do?restaurant_license=${owner.restaurant_license}">리뷰 목록</a></li>
					<li class="book-a-table text-center" >
						<a href="${contextPath}/owner/restaurant/restaurantMain.do">식당 관리</a></li>
				</c:when>
				<c:otherwise>
					<li class="active"><a href="${contextPath}/main.do">Home</a></li>
					<li><a href="${contextPath}/restaurant/whatToEat.do">오늘의 음식</a></li>
					<li><a href="${contextPath}/review/myReviewList.do?customer_id=${customer.customer_id }">리뷰 목록</a></li>
					<li class="book-a-table text-center" >
						<a href="${contextPath}/booking/myBookList.do">예약 목록</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
	<!-- .nav-menu -->

</div>
<!-- End Header -->