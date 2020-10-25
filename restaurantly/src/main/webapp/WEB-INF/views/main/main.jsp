<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  

<!-- ======= Hero Section ======= -->
<section id="hero" class="d-flex align-items-center">
  <div class="container position-relative text-center text-lg-left" data-aos="zoom-in" data-aos-delay="100">
    <div class="row">
      <div class="col-lg-8">
        <h1>Welcome to <span>Restaurantly</span></h1>
        <h2>Delivering great food for more than 18 years!</h2>

        <div class="btns">
          <a href="#menu" class="btn-menu animated fadeInUp scrollto">Our Menu</a>
          <a href="#book-a-table" class="btn-book animated fadeInUp scrollto">Book a Table</a>
        </div>
      </div>
      <div class="col-lg-4 d-flex align-items-center justify-content-center" data-aos="zoom-in" data-aos-delay="200">
        <a href="https://www.youtube.com/watch?v=GlrxcuEDyF8" class="venobox play-btn" data-vbtype="video" data-autoplay="true"></a>
      </div>

    </div>
  </div>
</section><!-- End Hero -->

<!-- ======= Category Section ======= -->
<section id="category" class="category">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/what-to-eat.jpg" alt="음식 추천">
						<span class="category-info">음식 추천</span>
					</a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/all.jpg" alt="전체보기">
						<span class="category-info">전체보기</span></a>
		
				</div>
			</div>
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/k-food.jpg" alt="한식">
						<span class="category-info">한식</span></a>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/chicken.jpg" alt="치킨">
						<span class="category-info">치킨</span></a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/w-food.jpg" alt="양식">
						<span class="category-info">양식</span></a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/j-food.jpg" alt="일식">
						<span class="category-info">일식</span></a>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/c-food.jpg" alt="중식">
						<span class="category-info">중식</span></a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/meat.jpg" alt="고기">
						<span class="category-info">고기</span></a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/school-food.jpg" alt="분식">
						<span class="category-info">분식</span></a>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/alcohol.jpg" alt="주류">
						<span class="category-info">주류</span></a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/cafe.jpg" alt="카페">
						<span class="category-info">카페</span></a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="category-item">
					<a href="#" class="thumbnail">
						<img src="${contextPath}/assets/img/category/etc.jpg" alt="기타">
						<span class="category-info">기타</span></a>
				</div>
			</div>
			
		</div>
	</div>
</section>
<!-- End Category -->