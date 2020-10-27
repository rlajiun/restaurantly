<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  

<!-- ======= What to Eat Section ======= -->
<section id="contact" class="contact breadcrumbs">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>What to Eat</h2>
			<p>
				What Do You Think About <span class="whatToEat">${menu_category}</span>?
			</p>
		</div>
	</div>

	<div class="container" data-aos="fade-up">

		<div class="whatToEat-form">
			<!-- photo start -->
			<div class="container-fluid" data-aos="fade-up" data-aos-delay="100">

				<div class="row no-gutters">

					<c:forEach var="menu" items="${catMenuList }">
						<div class="col-lg-3 col-md-4">
							<div class="gallery-item">
								<a href="${contextPath}/restaurant/restaurantMain.do?license=${menu.restaurant_license}" class="venobox"
									data-gall="gallery-item"> <img src="${contextPath}/${menu.menu_image_path }"
									alt="" class="img-fluid">
								</a>
							</div>
						</div>
					</c:forEach>

					<form action="${contextPath}/restaurant/restaurantList.do"
						method="post" role="form" class="php-email-form">
						<input type="hidden" id="menu_category" name="menu_category"
							value="${menu_category }" />
						<div class="text-center">
							<button type="submit">Book Now</button>
						</div>
					</form>

				</div>

			</div>

		</div>

	</div>
</section>
<!-- End What to Eat Section -->