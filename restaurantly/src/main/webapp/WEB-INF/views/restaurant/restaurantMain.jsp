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
        <h1>Welcome to <span>${restaurant.restaurant_name }</span></h1>

        <div class="btns">
          <a href="#menu" class="btn-menu animated fadeInUp scrollto">Our Menu</a>
          <a href="#book-a-table" class="btn-book animated fadeInUp scrollto">Book a Table</a>
        </div>
      </div>

    </div>
  </div>
</section><!-- End Hero -->

<!-- ======= About Section ======= -->
<section id="about" class="about">
  <div class="container" data-aos="fade-up">

    <div class="row">
      <div class="col-lg-6 order-1 order-lg-2" data-aos="zoom-in" data-aos-delay="100">
        <c:if test="${not empty restaurant.restaurant_image}">
          <div class="about-img">
	          <img src="${contextPath}/upload/${restaurant.restaurant_license}/${restaurant.restaurant_image}">          
          </div>
        </c:if>
      </div>
      <div class="col-lg-6 pt-4 pt-lg-0 order-2 order-lg-1 content">
        <h3>${restaurant.restaurant_name }</h3>
        <p class="font-italic">
          ${restaurant.restaurant_introduction }
        </p>
      </div>
    </div>

  </div>
</section><!-- End About Section -->

<!-- ======= Menu Section ======= -->
<c:if test="${not empty menuList }">
	<section id="menu" class="menu section-bg">
	  <div class="container" data-aos="fade-up">
	
	    <div class="section-title">
	      <h2>Menu</h2>
	      <p>Check Our Tasty Menu</p>
	    </div>
	
	    <div class="row menu-container" data-aos="fade-up" data-aos-delay="200">
		  <c:forEach var="menu" items="${menuList }">
  			<div class="col-lg-6 menu-item">
      		   <div class="menu-content">
    			    <c:choose>
  						<c:when test="${not empty menu.menu_image }">
  							<a href="${contextPath}/upload/${menu.restaurant_license }/${menu.menu_image }" class="venobox" data-gall="gallery-item">
  								<img src="${contextPath}/upload/${menu.restaurant_license }/${menu.menu_image }" class="menu-img">${menu.menu_name }
  							</a>		      		
	  					</c:when>
	  					<c:otherwise>
  						   <a>
  							  <img src="${contextPath}/upload/menu.jpg" class="menu-img">${menu.menu_name }
  						  </a>		      		
  						</c:otherwise>
	  				</c:choose>
	  				<fmt:formatNumber  value="${menu.menu_price}" type="number" var="menu_price" />
	  				<span>${menu_price }원</span>
	  				<div class="menu-ingredients">
	  				  ${menu.menu_description }
  				   </div>
	  			</div>
	  		</div>
  		</c:forEach>
	
	    </div>
	
	  </div>
	</section><!-- End Menu Section -->
	
</c:if>

<!-- ======= Book A Table Section ======= -->
<section id="book-a-table" class="book-a-table">
  <div class="container" data-aos="fade-up">

    <div class="section-title">
      <h2>Reservation</h2>
      <p>Book a Table</p>
    </div>

    <form action="${contextPath}/booking/book-a-table.do" method="post" role="form" class="book-a-table php-email-form" data-aos="fade-up" data-aos-delay="100">
      <div class="form-row">
      	<div class="form-group">
          <input type="hidden" name="customer_id" class="form-control" value="${customer.customer_id }" data-rule="login">
          <input type="hidden" name="restaurant_license" class="form-control" value="${restaurant.restaurant_license }">
          <input type="hidden" name="booking_state" class="form-control" value="wait">
         </div>
        <div class="col-lg-4 col-md-6 form-group">
          <input type="date" name="booking_date" class="form-control" id="date" placeholder="Date" data-rule="date" data-msg="예약날짜를 확인해주세요">
          <div class="validate"></div>
        </div>
        <div class="col-lg-4 col-md-6 form-group">
          <input type="time" class="form-control" name="booking_time" id="time" placeholder="Time" data-rule="time" data-msg="예약시간을 확인해주세요">
          <div class="validate"></div>
        </div>
        <div class="col-lg-4 col-md-6 form-group">
          <input type="number" class="form-control" name="booking_count" id="people" placeholder="# of people">
          <div class="validate"></div>
        </div>
      </div>
      <div class="form-group">
        <textarea class="form-control" name="booking_message" rows="5" placeholder="Message"></textarea>
        <div class="validate"></div>
      </div>
      <div class="mb-3">	
        <div class="loading">Loading</div>
        <div class="error-message"></div>
        <div class="sent-message">예약이 정상적으로 처리되었습니다. <a href="${contextPath}/booking/myBookList.do?customer_id=${customer.customer_id }"><br>예약내역 확인하러 가기</a></div>
      </div>
      <div class="text-center"><button type="submit">Book a Table</button></div>
    </form>

  </div>
</section><!-- End Book A Table Section -->

<!-- ======= Testimonials Section ======= -->
<section id="testimonials" class="testimonials section-bg">
  <div class="container" data-aos="fade-up">

    <div class="section-title">
      <h2>Testimonials</h2>
      <p>What they're saying about us</p>
    </div>
    
<!-- 리뷰 목록: 사진여러장 -->
    <div class="owl-carousel testimonials-carousel" data-aos="zoom-in" data-aos-delay="100">
    <!-- 리뷰 목록 -->
			<c:forEach var="item" items="${reviewList }">
				<div class="testimonial-item">
					<p>
						<i class="bx bxs-quote-alt-left quote-icon-left"></i> 
						${item.review_content} 
						<i class="bx bxs-quote-alt-right quote-icon-right"></i>
					</p>
					<!-- <img src="assets/img/testimonials/testimonials-1.jpg"
						class="testimonial-img" alt=""> -->
					<h3>- ${item.customer_id}님</h3>
					
				</div>

			</c:forEach>
		
    </div> <!-- end of 리뷰목록 -->

  </div>
</section><!-- End Testimonials Section -->

<!-- review img gallery -->
<!-- ======= Gallery Section ======= -->
    <section id="gallery" class="gallery">

      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>Gallery</h2>
          <p>Some photos from Our Restaurant</p>
        </div>
      </div>

      <div class="container-fluid" data-aos="fade-up" data-aos-delay="100">

        <div class="row no-gutters">
			<c:forEach var="item" items="${reviewList }">
		 		<c:forEach var="inner" items="${item.photoList }">
					 <div class="col-lg-3 col-md-4">
			            <div class="gallery-item">
			              <a href="${contextPath}/upload/${inner.fileName}" class="venobox" data-gall="gallery-item">
			               <img src="${contextPath}/upload/${inner.fileName}"  class="img-fluid">
			              </a>
			            </div>
			          </div>
				</c:forEach> 
			</c:forEach>
        </div>

      </div>
    </section><!-- End Gallery Section -->

<!-- 이미지 -->
<%-- <div align="center"  >
	<c:forEach var="item" items="${reviewList }">
		<div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
			    <c:forEach var="inner" items="${item.photoList }">
			 	<img src="${contextPath}/upload/${inner.fileName}">
				</c:forEach> 
			</div>
		</div>	
	</c:forEach>
</div> --%>
<!-- ======= Contact Section ======= -->
<section id="contact" class="contact">
  <div class="container" data-aos="fade-up">

    <div class="section-title">
      <h2>Contact</h2>
      <p>Contact Us</p>
    </div>
  </div>

  <div data-aos="fade-up">
    <iframe style="border:0; width: 100%; height: 350px;" src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12097.433213460943!2d-74.0062269!3d40.7101282!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb89d1fe6bc499443!2sDowntown+Conference+Center!5e0!3m2!1smk!2sbg!4v1539943755621" frameborder="0" allowfullscreen></iframe>
  </div>

  <div class="container" data-aos="fade-up">

    <div class="row mt-5">

      <div class="col-lg-4">
        <div class="info">
          <div class="address">
            <i class="icofont-google-map"></i>
            <h4>Location:</h4>
            <p>${restaurant.restaurant_address }</p>
          </div>

          <div class="open-hours">
            <i class="icofont-clock-time icofont-rotate-90"></i>
            <h4>Open Hours:</h4>
            <p>
              Monday-Saturday:<br>
              11:00 AM - 23:00 PM
            </p>
          </div>

          <div class="phone">
            <i class="icofont-phone"></i>
            <h4>Call:</h4>
            <p>${restaurant.restaurant_phone }</p>
          </div>

        </div>

      </div>

      <div class="col-lg-8 mt-5 mt-lg-0">

        <form action="forms/contact.php" method="post" role="form" class="php-email-form">
          <div class="form-row">
            <div class="col-md-6 form-group">
              <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
              <div class="validate"></div>
            </div>
            <div class="col-md-6 form-group">
              <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
              <div class="validate"></div>
            </div>
          </div>
          <div class="form-group">
            <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <textarea class="form-control" name="message" rows="8" data-rule="required" data-msg="Please write something for us" placeholder="Message"></textarea>
            <div class="validate"></div>
          </div>
          <div class="mb-3">
            <div class="loading">Loading</div>
            <div class="error-message"></div>
            <div class="sent-message">Your message has been sent. Thank you!</div>
          </div>
          <div class="text-center"><button type="submit">Send Message</button></div>
        </form>

      </div>

    </div>

  </div>
</section><!-- End Contact Section -->