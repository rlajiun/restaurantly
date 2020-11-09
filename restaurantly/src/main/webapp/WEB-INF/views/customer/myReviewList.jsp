<%@page import="com.restaurantly.customer.vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 리뷰</title>
<c:if test="${empty customer}">
	<script>
		alert('로그인 후 리뷰를 작성하세요.');
		window.location.href = "http://localhost:8080/main/form/loginForm.do";
	</script>

</c:if>

</head>
<body>

<!-- ======= title section======= -->
<section id="contact" class="contact breadcrumbs">
	<div class="container" data-aos="fade-up">
		<div class="section-title">
			<h2>내가 쓴 리뷰</h2>
			<p>my reviews</p>
		</div>
	</div>
</section>

<!-- ======= List Section ======= -->
<section id="list" class="list">
	<div class="container">
		<div align="center"  >
			<c:forEach var="item" items="${reviewList }">
				<div class="col-sm-6 col-md-4">
				    <div class="thumbnail">
				    <c:forEach var="inner" items="${item.photoList }">
   				    <%--   <img src="C:\\restaurantly\\file_repo"/${inner.fileName}"> --%>
   				      <img src="../../img/specials-1.png">
   				     
				    </c:forEach>
				      <div class="caption">
				        <h3>${item.review_content }</h3>
				        <h5>${item.review_writedate }</h3>
				        <h5>${item.review_score }.0/5.0</h5>  
				        <span><a href="${contextPath}/restaurant/restaurantMain/${item.restaurant_license}" class="btn-detail" role="button">보기</a></span>
				        <span><a href="${contextPath}/review/modReviewForm.do" class="btn-detail" role="button">수정</a></span>
				      	<span><a href="${contextPath}/review/deleteReview.do?review_id=${item.review_id}" class="btn-detail" role="button">삭제</a></span>
				       
				       <!-- <input id="editButton" type="button" value="수정" class="btn-detail" role="button " />
				       <input id="clickMe" type="button" value="삭제" class="btn-detail" role="button onclick="doFunction();" />
				       -->
				       </div>
				    </div>
				  </div>			
			
			</c:forEach>
		</div>
	</div>
</section>



<!-- ======= review list section======= -->
<section id="list" class="list">
<div class="container">
		<div class="row">
	
<c:choose>	
	<c:when test="${not empty reviewList }">
				
		<c:forEach var="item" items="${reviewList}">
		<table border="1" align="center">
					<tr>
						<td align="right">리뷰 내용:</td>
						<td colspan=2 align="left">${item.review_content}</td>
					</tr>
					<tr>
						<td align="right">별점:</td>
						<td colspan=2 align="left">${item.review_content}</td>
					</tr>
					<tr>
						<td align="right">작성일:</td>
						<td colspan=2 align="left">${item.review_writedate}</td>
					</tr>
					<tr>
						<td align="right">별점:</td>
						<td colspan=2 align="left">${item.review_score}</td>
					</tr>
					<tr>
						<td align="right">식당:</td>
						<td colspan=2 align="left">${item.restaurant_license}</td>
					</tr>
				
			     <%-- 	<img src="${contextPath}/${item.review_image_path}/${item.review_id}.jpg" alt="">--%>
		</table>
		</c:forEach>
				
	</c:when>
	<c:otherwise>
		<div class="container">
		<div class="section-title">
			<h2>리뷰가 없습니다. 리뷰를 작성해보세요.</h2>
			<p>no reviews yet.</p>
		</div>
	</div>
	</c:otherwise>
</c:choose>
		    		    	
</section id="contact" class="contact breadcrumbs">
</body>
</html>