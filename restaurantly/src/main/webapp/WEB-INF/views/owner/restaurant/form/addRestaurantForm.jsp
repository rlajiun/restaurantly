<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<c:if test="${not empty action }">
	<script>
		alert('등록된 식당이 없습니다.\n식당을 등록해주세요!');
	</script>
</c:if>

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
<section id="contact" class="contact breadcrumbs <c:if test="${empty owner }">owner-login</c:if>">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>등록</h2>
			<p>식당 등록하기</p>
		</div>
	</div>

	<div class="container" data-aos="fade-up">

		<div class="login-form">

			<form action="${contextPath}/owner/restaurant/addRestaurant.do"
				method="post" role="form" class="join-form"
				enctype="multipart/form-data">
				<div class="form-group">
					<input type="hidden" name="owner_id" class="form-control" id="id"
						value="${owner.owner_id }" />
				</div>
				<div class="pic-form">
					<label class="form-group pic-btn"> <img id="image"
						src="http://placehold.it/120x120"> <input type="file"
						name="file" class="form-control" id="file"
						onchange="readURL(this);" />
					</label>
					<div class="pic-group">
						<div class="form-group">
							<select name="restaurant_item" class="form-control">
								<option value="">업태구분명</option>
								<option value="한식">한식</option>
								<option value="치킨">치킨</option>
								<option value="양식">양식</option>
								<option value="일식">일식</option>
								<option value="중식">중식</option>
								<option value="고기">고기</option>
								<option value="분식">분식</option>
								<option value="주류">주류</option>
								<option value="카페">카페</option>
								<option value="기타">기타</option>
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
					<input type="text" name="restaurant_name" class="form-control"
						id="name" placeholder="업소명" data-rule="required"
						data-msg="업소명을 입력해주세요" />
					<div class="validate"></div>
				</div>
				<div class="form-group">
					<input type="text" name="restaurant_phone" class="form-control"
						id="phone" placeholder="소재지전화" data-rule="phone"
						data-msg="소재지 전화번호를 입력해주세요" />
					<div class="validate"></div>
				</div>
				<div class="form-group">
					<input type="text" name="restaurant_representative"
						class="form-control" placeholder="대표자명" />
					<div class="validate"></div>
				</div>
				<div class="form-group">
					<input type="text" name="restaurant_address" class="form-control"
						placeholder="소재지(도로명)" />
					<div class="validate"></div>
				</div>
				<div class="form-group">
					<textarea name="restaurant_introduction" class="form-control"
						placeholder="소개글을 작성해주세요" rows="8"></textarea>
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