<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  

<script>
$(function(){
	$('button.plus-btn').click(function() {
		console.log('click');
		$('#file').click();
	});
});
	
	function readURL(input) {
		var plus_form = $('.plus-form').clone();
		console.log(input);
		for (var image of input.files) {
			var reader = new FileReader();
			
			reader.onload = function(e) {
				var source = plus_form.clone();
			      source.removeClass('plus-form');
			      source.addClass('plus-group');
			      source.find('img').attr('src', e.target.result);
			      $('#plus-list').append(source.hide().fadeIn());
			};
			reader.readAsDataURL(image);
		}
	}
</script>

<!-- ======= Add Gallery Section ======= -->
<section id="contact" class="contact breadcrumbs">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>등록</h2>
			<p>사진 등록하기</p>
		</div>
	</div>

	<div class="container" data-aos="fade-up">

		<div class="whatToEat-form">
			<!-- photo start -->
			<div class="container-fluid" data-aos="fade-up" data-aos-delay="100">

				<div class="row no-gutters">

					<div class="col-lg-3 col-md-4 plus-form">
						<div class="form-group">
								<input type="hidden" name="restaurant_license" class="form-control"
									value="${myRestaurant.restaurant_license }" />
							</div>
						<div class="gallery-item">
							<a href="${contextPath}/restaurant/restaurantMain/"> 
								<img src="${contextPath}/upload/" alt="" class="img-fluid">
							</a>
						</div>
						<div class="minus-btn">
							<button type="button" class="plus-btn minus" onclick="del_form(this);"><i class="icofont-minus"></i></button>
						</div>
					</div>

					<form action="${contextPath}/owner/restaurant/addPhoto.do"
						method="post" role="form" class="add" name="photoList" enctype="multipart/form-data">
						<div id="plus-list"></div>
						<div id="plus-btn" class="mb-3">
							<label class="pic-btn">
								<button type="button" class="plus-btn"><i class="icofont-plus"></i></button>
								<input type="file" name="file" class="form-control" id="file" onchange="readURL(this);" multiple />
							</label>
							<div class="loading">Loading</div>
							<div class="error-message"></div>
						</div>
						<div class="text-center">
							<button type="submit">등록하기</button>
						</div>
					</form>

				</div>

			</div>

		</div>

	</div>
</section>
<!-- End What to Eat Section -->