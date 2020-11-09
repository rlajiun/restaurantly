<%@page import="com.restaurantly.review.vo.ReviewVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"  import="com.restaurantly.customer.vo.CustomerVO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<head>
<title>리뷰 작성</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<c:if test="${empty customer}">
	<script>
		alert('로그인 후 리뷰를 작성하세요.');
		window.location.href = "http://localhost:8080/main/form/loginForm.do";
	</script>
</c:if>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/star.js"></script>

<style>
.stars
{
    margin: 20px 0;
    font-size: 24px;
    color: #d17581;
}
</style>
<script type="text/javascript">
$('.starrr').on('starrr:change', function(e, value){
    ratingsField.val(value);
  });
</script>

</head>
<body>
<a href="http://localhost:8080/main/form/loginForm.do" class="venobox play-btn" data-vbtype="video" data-autoplay="true"></a>
     
<!-- ======= Add Section ======= -->
	
<section id="contact" class="contact breadcrumbs">
	<div class="container" >
		<div class="section-title">
			<h2>리뷰 남기기</h2>
			<p>make a review</p>
		</div>
	</div>
	
	<%ReviewVO existing =  
            (ReviewVO)request.getAttribute("existing"); 
       %> 
	<div class="container" >
		<div class="login-form">
			<form action="${contextPath}/review/addReview.do" method="post" modelAttribute="reviewVO" role="form" class="join-form"enctype="multipart/form-data">
				 <input type="hidden" id="customer_id" name="customer_id" value="${customer.customer_id }" />
				<div class="form-group">
					<%-- <input type="text" name="restaurant_id" class="form-control"id="name" value="${ }" readonly /> --%>
					<input type="text" name="restaurant_license" value = <%=existing.getRestaurant_license()%> class="form-control"id="name" placeholder="식당id"  />
				</div>
				
				<div class="form-group">
					<textarea name="review_content" value = <%=existing.getReview_content() %> class="form-control" placeholder="리뷰를 작성해주세요" rows="8"></textarea>
				</div>
				<div class="form-group">
					<input type="number" class="form-control" name="review_score" value = <%=existing.getReview_score()%>
						id="review_score" placeholder="별점" data-rule="required"
						data-msg="별점을 입렵해주세요" />
					<div class="validate"></div>
					<div class="row lead">
					        <div id="stars" class="starrr"></div>
					        별점: <span id="count"> 0</span> 
						</div>
				</div>
				<div class="mb-3">
					<div class="loading">Loading</div>
					<div class="error-message"></div>
				</div>
				<div class="text-center">
					<button type="submit">수정하기</button>
				</div>
			</form>
		</div> <!-- end of login form -->
	</div>
</section>
<!-- End Add Section -->
</body>
</html>
