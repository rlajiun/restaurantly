<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>

<!-- ======= List Section ======= -->
<section id="list" class="list breadcrumbs mybook-list <c:if test="${empty customer }">customer-login</c:if>">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>예약</h2>
			<p>예약 목록</p>
		</div>
	</div>
	<c:choose>
		<c:when test="${not empty bookingList }">
			<div class="container" data-aos="fade-up">
				<div class="row">
					<c:forEach var="item" items="${bookingList }">
						<div class="col-sm-6 col-md-4 book">
						    <div class="thumbnail">
						    	<a href="${contextPath}/restaurant/restaurantMain/${item.restaurant_license}">
							    	<c:choose>
							    		<c:when test="${not empty item.restaurant_image}">
									      <img src="${contextPath}/upload/${item.restaurant_license}/${item.restaurant_image}">
							    		</c:when>
							    		<c:otherwise>
									      <img src="${contextPath}/upload/basic.jpg">							    		
							    		</c:otherwise>
							    	</c:choose>
						    	</a>
						      <div class="caption">
						        <h4>${item.restaurant_name }</h4>
						        <p class="intro">
						        	Phone: ${item.restaurant_phone }<br>
						        	Address: ${item.restaurant_address }<br>
						        	예약일: ${item.booking_date } ${item.booking_time }
						        	<c:if test="${item.booking_count != 0 }">
							  			<br>예약인원: ${item.booking_count }
						        	</c:if>
						        	<c:if test="${item.booking_count != 0 }">
							  			<br>예약내용: ${item.booking_message }
						        	</c:if>
						        </p>
						        <div class="list-btn">
						         <p class="loading">Loading</p>
						         <c:choose>
						         	<c:when test="${item.booking_state eq 'cancel'}">
							         <p class="btn-detail" >취소 완료</p>
						         	</c:when>
						         	<c:when test="${item.booking_state eq 'request'}">
							         <p class="btn-detail" >취소 대기중</p>
						         	</c:when>
						         	<c:when test="${item.booking_state eq 'confirm'}">
						         	 <button type="submit" class="btn-detail" name="${item.restaurant_license }" role="write">리뷰 쓰기</button>
							         <p class="btn-detail" >예약 확정</p>
						         	</c:when>
						         	<c:otherwise>
							         <button type="submit" class="btn-detail" name="${item.booking_id }" role="request">취소 하기</button>
						         	</c:otherwise>
						         </c:choose>
						         </div>
						      </div>
						    </div>
						  </div>			
					
					</c:forEach>
				</div>
			</div>
			
		</c:when>
		<c:otherwise>
			<div class="container" data-aos="fade-up">
				<p>예약된 식당이 없습니다.</p>
			</div>
		</c:otherwise>
	</c:choose>
</section>
<!-- End List -->