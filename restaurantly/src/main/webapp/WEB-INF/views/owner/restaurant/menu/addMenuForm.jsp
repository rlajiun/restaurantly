<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<script>
	$('.pic-btn').bind("click", function() {
		$('#file').click();
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#image').attr('src', e.target.result);
			};
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>

<!-- ======= Add Section ======= -->
<section id="contact" class="contact breadcrumbs">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>등록</h2>
			<p>메뉴 등록하기</p>
		</div>
	</div>

	<div class="container" data-aos="fade-up">

		<div class="login-form">

			<form action="${contextPath}/owner/restaurant/addMenu.do"
				method="post" role="form" class="join-form"
				enctype="multipart/form-data">
				<div class="form-group">
					<input type="hidden" name="restaurant_license" class="form-control" id="id"
						value="${myRestaurant.restaurant_license }" />
				</div>
				<div class="pic-form">
					<label class="form-group pic-btn"> <img id="image"
						src="http://placehold.it/120x120"> <input type="file"
						name="file" class="form-control" id="file"
						onchange="readURL(this);" />
					</label>
					<div class="pic-group">
						<div class="form-group">
							<select name="menu_category" class="form-control">
								<option value="">메뉴구분명</option>
								<option value="치킨">치킨</option>
								<option value="피자">피자</option>
								<option value="햄버거">햄버거</option>
								<option value="커피">커피</option>
								<option value="샌드위치">샌드위치</option>
								<option value="샐러드">샐러드</option>
								<option value="짜장면">짜장면</option>
								<option value="짬뽕">짬뽕</option>
								<option value="탕수육">탕수육</option>
								<option value="직접추가">직접추가</option>
							</select>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="restaurant_license"
								id="license" placeholder="사업자등록번호" data-rule="required"
								data-msg="사업자등록번호를 입렵해주세요" />
							<div class="validate"></div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<input type="text" name="menu_name" class="form-control"
						id="name" placeholder="메뉴명" data-rule="required"
						data-msg="메뉴명을 입력해주세요" />
					<div class="validate"></div>
				</div>
				<div class="form-group">
					<input type="number" name="menu_price" class="form-control"
						id="price" placeholder="가격" data-rule="phone"
						data-msg="가격을 입력해주세요" />
					<div class="validate"></div>
				</div>
				<div class="mb-3">
					<div class="loading">Loading</div>
					<div class="error-message"></div>
				</div>
				<div class="text-center">
					<button type="submit">등록하기</button>
				</div>
			</form>

		</div>

	</div>
</section>
<!-- End Add Section -->