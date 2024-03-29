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

<!-- ======= List Section ======= -->
<section id="list" class="list">
	<div class="container" data-aos="fade-up">
		<div class="row">
			<c:forEach var="item" items="${restaurantList }">
				<div class="col-sm-6 col-md-4">
				    <div class="thumbnail">
				      <c:choose>
			    		<c:when test="${not empty item.restaurant_image}">
					      <img src="${contextPath}/upload/${item.restaurant_license}/${item.restaurant_image}">
			    		</c:when>
			    		<c:otherwise>
					      <img src="${contextPath}/upload/basic.jpg">							    		
			    		</c:otherwise>
				    	</c:choose>
				      <div class="caption">
				        <h4>${item.restaurant_name }</h4>
				        <p class="intro">${item.restaurant_introduction }</p>
				        <p class="list-btn"><a href="${contextPath}/restaurant/restaurantMain/${item.restaurant_license}" class="btn-detail" role="button">자세히 보기</a></p>
				      </div>
				    </div>
				  </div>			
			
			</c:forEach>
		</div>
	</div>
</section>
<!-- End List -->