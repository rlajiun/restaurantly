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
<section id="list" class="list breadcrumbs mybook-list <c:if test="${empty owner }">owner-login</c:if>">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>예약</h2>
			<p>예약자 목록</p>
		</div>
	</div>
	<c:choose>
		<c:when test="${not empty bookList }">
			<div class="container" data-aos="fade-up">
				<div class="row">
					<c:forEach var="item" items="${bookList }">
						<div class="col-sm-6 col-md-4 book">
						    <div class="thumbnail">
						      <div class="caption">
						        <h4>${item.customer_name }님</h4>
						        <div class="intro">
						        	<c:if test="${not empty item.customer_phone }">
						        	<div class="book-group">
						        	<span class="book-name">Phone</span><span class="book-val">${item.customer_phone }</span>
						        	</div>
						        	</c:if>
						        	<c:if test="${not empty item.restaurant_address }">
						        	<div class="book-group">
						        	<span class="book-name">Address</span><span class="book-val">${item.restaurant_address }</span>
						        	</div>
						        	</c:if>
						        	<div class="book-group">
						        	<span class="book-name">예약일</span><span class="book-val">${item.booking_date } ${item.booking_time }</span>
						        	</div>
						        	<c:if test="${item.booking_count != 0 }">
						        	<div class="book-group">
						        	<span class="book-name">예약인원</span><span class="book-val">${item.booking_count }</span>
						        	</div>
						        	</c:if>
						        	<c:if test="${not empty item.booking_message }">
						        	<div class="book-group">
						        	<span class="book-name">예약내용</span><span class="book-val">${item.booking_message }</span>
						        	</div>
						        	</c:if>
						        </div>
						        <div class="list-btn">
						         <p class="loading">Loading</p>
						         <c:choose>
						         	<c:when test="${item.booking_state eq 'cancel'}">
							         <p class="btn-detail" >취소 완료</p>
						         	</c:when>
						         	<c:when test="${item.booking_state eq 'request'}">
							         <button type="submit" class="btn-detail" name="${item.booking_id }" role="cancel">취소 승인</button>
						         	</c:when>
						         	<c:when test="${item.booking_state eq 'confirm'}">
							         <p class="btn-detail" >예약 확정</p>
						         	</c:when>
						         	<c:otherwise>
							         <button type="submit" class="btn-detail" name="${item.booking_id }" role="confirm">예약 승인</button>
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