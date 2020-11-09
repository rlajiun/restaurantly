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
<section id="contact" class="contact breadcrumbs <c:if test="${empty owner }">owner-login</c:if>">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>수정</h2>
			<p>식당 수정하기</p>
		</div>
	</div>

	<div class="container" data-aos="fade-up">

		<div class="login-form">

			<form action="${contextPath}/owner/restaurant/editRestaurant.do"
				method="post" role="form" class="join-form"
				enctype="multipart/form-data">
				<div class="form-group">
					<input type="hidden" name="owner_id" class="form-control" id="id" value="${owner.owner_id }" />
				</div>
				<div class="pic-form">
					<label class="form-group pic-btn"> 
						<c:choose>
							<c:when test="${myRestaurant.restaurant_image eq null }">
								<img id="image" src="http://placehold.it/120x120">									
							</c:when>
							<c:otherwise>
								<img id="image" src="${contextPath}/upload/${myRestaurant.restaurant_license}/${myRestaurant.restaurant_image}">
								<input type="hidden" name="restaurant_image" class="form-control" value="${myRestaurant.restaurant_image }" />																	
							</c:otherwise>
						</c:choose>
						<input type="file" name="file" class="form-control" id="file" onchange="readURL(this);" />
					</label>
					<div class="pic-group">
						<div class="form-group">
							<select name="restaurant_item" class="form-control">
								<option value="">업태구분명</option>
								<option value="한식" <c:if test="${myRestaurant.restaurant_item eq '한식'}">selected</c:if>>한식</option>
								<option value="치킨" <c:if test="${myRestaurant.restaurant_item eq '치킨'}">selected</c:if>>치킨</option>
								<option value="양식" <c:if test="${myRestaurant.restaurant_item eq '양식'}">selected</c:if>>양식</option> 
								<option value="일식" <c:if test="${myRestaurant.restaurant_item eq '일식'}">selected</c:if>>일식</option>
								<option value="중식" <c:if test="${myRestaurant.restaurant_item eq '중식'}">selected</c:if>>중식</option>
								<option value="고기" <c:if test="${myRestaurant.restaurant_item eq '고기'}">selected</c:if>>고기</option>
								<option value="분식" <c:if test="${myRestaurant.restaurant_item eq '분식'}">selected</c:if>>분식</option>
								<option value="주류" <c:if test="${myRestaurant.restaurant_item eq '주류'}">selected</c:if>>주류</option>
								<option value="카페" <c:if test="${myRestaurant.restaurant_item eq '카페'}">selected</c:if>>카페</option>
								<option value="기타" <c:if test="${myRestaurant.restaurant_item eq '기타'}">selected</c:if>>기타</option>
							</select>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="restaurant_license"
								id="license" placeholder="사업자등록번호" data-rule="required" readonly value="${myRestaurant.restaurant_license }"
								data-msg="사업자등록번호를 입렵해주세요" />
							<div class="validate"></div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<input type="text" name="restaurant_name" class="form-control"
						id="name" placeholder="업소명" data-rule="required" value="${myRestaurant.restaurant_name }"
						data-msg="업소명을 입력해주세요" />
					<div class="validate"></div>
				</div>
				<div class="form-group">
					<input type="text" name="restaurant_phone" class="form-control"
						id="phone" placeholder="소재지전화" data-rule="phone" value="${myRestaurant.restaurant_phone }"
						data-msg="소재지 전화번호를 입력해주세요" />
					<div class="validate"></div>
				</div>
				<div class="form-group">
					<input type="text" name="restaurant_representative"
						class="form-control" placeholder="대표자명" value="${myRestaurant.restaurant_representative }" />
					<div class="validate"></div>
				</div>
				<div class="form-group">
					<input type="text" name="restaurant_address" class="form-control"
						placeholder="소재지(도로명)" value="${myRestaurant.restaurant_address }" />
					<div class="validate"></div>
				</div>
				<div class="form-group">
					<textarea name="restaurant_introduction" class="form-control"
						placeholder="소개글을 작성해주세요" rows="8">${myRestaurant.restaurant_introduction }</textarea>
				</div>
				<div class="mb-3">
					<div class="loading">Loading</div>
					<div class="error-message"></div>
				</div>
				<div class="text-center">
					<button type="submit">수정하기</button>
				</div>
			</form>

		</div>

	</div>
</section>
<!-- End Add Section -->