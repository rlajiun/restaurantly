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
        <h1>Welcome to <span>${myRestaurant.restaurant_name }</span></h1>

        <div class="btns">
	        <c:choose>
		        <c:when test="${not empty myRestaurant.menuList }">
		          <a href="${contextPath}/owner/restaurant/editMenuForm.do" class="btn-menu animated fadeInUp scrollto">Edit Menu</a>		        
		        </c:when>
	        	<c:otherwise>
		          <a href="${contextPath}/owner/restaurant/addMenuForm.do" class="btn-menu animated fadeInUp scrollto">Add Menu</a>		        
	        	</c:otherwise>
	        </c:choose>
	        <c:choose>
	        	<c:when test="${not empty myRestaurant.photoList }">
		          <a href="${contextPath}/owner/restaurant/editGalleryForm.do" class="btn-book animated fadeInUp scrollto">Edit Gallery</a>
	        	</c:when>
	        	<c:otherwise>
		          <a href="${contextPath}/owner/restaurant/addGalleryForm.do" class="btn-book animated fadeInUp scrollto">Add Gallery</a>
	        	</c:otherwise>
	        </c:choose>
        </div>
      </div>
      <div class="col-lg-4 d-flex align-items-center justify-content-center btns">
        <a href="${contextPath}/owner/restaurant/editRestaurantForm.do" class="btn-edit animated fadeInUp scrollto">Edit<br>Restaurant</a>
      </div>
		
    </div>
  </div>
</section><!-- End Hero -->

<!-- ======= About Section ======= -->
<section id="about" class="about">
  <div class="container" data-aos="fade-up">

    <div class="row">
      <div class="col-lg-6 order-1 order-lg-2" data-aos="zoom-in" data-aos-delay="100">
        <div class="about-img">
          <img src="${contextPath}/upload/${myRestaurant.restaurant_license}/${myRestaurant.restaurant_image }">
        </div>
      </div>
      <div class="col-lg-6 pt-4 pt-lg-0 order-2 order-lg-1 content">
        <h3>${myRestaurant.restaurant_name }</h3>
        <p class="font-italic">
          ${myRestaurant.restaurant_introduction }
        </p>
      </div>
    </div>

  </div>
</section><!-- End About Section -->

<!-- ======= Menu Section ======= -->
<c:if test="${not empty myRestaurant.menuList }">
	<section id="menu" class="menu section-bg">
	  <div class="container" data-aos="fade-up">
	
	    <div class="section-title">
	      <h2>Menu</h2>
	      <p>Check Our Tasty Menu</p>
	    </div>
	
	    <div class="row menu-container" data-aos="fade-up" data-aos-delay="200">
	    	<c:forEach var="menu" items="${myRestaurant.menuList}">
		      <div class="col-lg-6 menu-item">
		      	<div class="menu-content">
			          <a href="${contextPath}/upload/${menu.restaurant_license }/${menu.menu_image }" class="venobox" data-gall="gallery-item">
			        	<img src="${contextPath}/upload/${menu.restaurant_license }/${menu.menu_image }" class="menu-img">${menu.menu_name }
			          </a>
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

    <form action="forms/book-a-table.php" method="post" role="form" class="php-email-form" data-aos="fade-up" data-aos-delay="100">
      <div class="form-row">
        <div class="col-lg-4 col-md-6 form-group">
          <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
          <div class="validate"></div>
        </div>
        <div class="col-lg-4 col-md-6 form-group">
          <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email">
          <div class="validate"></div>
        </div>
        <div class="col-lg-4 col-md-6 form-group">
          <input type="text" class="form-control" name="phone" id="phone" placeholder="Your Phone" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
          <div class="validate"></div>
        </div>
        <div class="col-lg-4 col-md-6 form-group">
          <input type="text" name="date" class="form-control" id="date" placeholder="Date" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
          <div class="validate"></div>
        </div>
        <div class="col-lg-4 col-md-6 form-group">
          <input type="text" class="form-control" name="time" id="time" placeholder="Time" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
          <div class="validate"></div>
        </div>
        <div class="col-lg-4 col-md-6 form-group">
          <input type="number" class="form-control" name="people" id="people" placeholder="# of people" data-rule="minlen:1" data-msg="Please enter at least 1 chars">
          <div class="validate"></div>
        </div>
      </div>
      <div class="form-group">
        <textarea class="form-control" name="message" rows="5" placeholder="Message"></textarea>
        <div class="validate"></div>
      </div>
      <div class="mb-3">
        <div class="loading">Loading</div>
        <div class="error-message"></div>
        <div class="sent-message">Your booking request was sent. We will call back or send an Email to confirm your reservation. Thank you!</div>
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

    <div class="owl-carousel testimonials-carousel" data-aos="zoom-in" data-aos-delay="100">

      <div class="testimonial-item">
        <p>
          <i class="bx bxs-quote-alt-left quote-icon-left"></i>
          <img src="${contextPath}//thumbnail.jpg">
          Proin iaculis purus consequat sem cure digni ssim donec porttitora entum suscipit rhoncus. Accusantium quam, ultricies eget id, aliquam eget nibh et. Maecen aliquam, risus at semper.
          <i class="bx bxs-quote-alt-right quote-icon-right"></i>
        </p>
        <img src="assets/img/testimonials/testimonials-1.jpg" class="testimonial-img" alt="">
        <h3>Saul Goodman</h3>
        <h4>Ceo &amp; Founder</h4>
      </div>	

    </div>

  </div>
</section><!-- End Testimonials Section -->

<!-- ======= Gallery Section ======= -->
<c:if test="${not empty myRestaurant.photoList }">

	<section id="gallery" class="gallery">
	
	  <div class="container" data-aos="fade-up">
	    <div class="section-title">
	      <h2>Gallery</h2>
	      <p>Some photos from Our Restaurant</p>
	    </div>
	  </div>
	
	  <div class="container-fluid" data-aos="fade-up" data-aos-delay="100">
	
	    <div class="row no-gutters">
		    <c:forEach var="photo" items="photoList">
		      <div class="col-lg-3 col-md-4">
		        <div class="gallery-item">
		          <a href="assets/img/gallery/gallery-1.jpg" class="venobox" data-gall="gallery-item">
		            <img src="assets/img/gallery/gallery-1.jpg" alt="" class="img-fluid">
		          </a>
		        </div>
		      </div>
		    </c:forEach>	
	    </div>
	
	  </div>
	</section><!-- End Gallery Section -->
</c:if>

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
            <p>${myRestaurant.restaurant_detail }</p>
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
            <p>${myRestaurant.restaurant_phone }</p>
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