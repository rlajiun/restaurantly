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
		$(this).closet('#file').click();
	});

	function readURL(input) {
		console.log(input);
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$(input).prev('#image').attr('src', e.target.result);
			};
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	function ckAddBox(select) {
		console.log($(select).find('option:selected').text());
		var value = $(select).find('option:selected').val();
		console.log(value);
		if (value === 'add') {
			var source = '<input type="text" name="menu_category" class="form-control" placeholder="직접추가" data-rule="required" data-msg="입력해주세요" />';
			$(select).closest('.form-group').prepend(source);
			$(select).remove();
		}
	}
	
    function del_form(button) {
    	$('.validate').html('').slideUp();
    	console.log('삭제버튼 눌림');
    	if (!confirm('삭제하시겠습니까?')) {
			return;
		}
	    var source = $(button).closest('.plus-group');
	    source.fadeOut("normal", function(){
	    	var name = source.find('.menu-id').val();
	    	console.log(name);
	    	if (name != null) {
				$.ajax({
					type: "POST",
			        url: '${contextPath}/owner/restaurant/delMenu.do',
			        data: {
			        	'menu_id': name
			        }
				}).done(function(){
			        source.remove();					
				}).fail(function(){
					$('.error-message').slideDown().html('삭제할 수 없습니다.');
				});
			}else{
		        source.remove();			    	
			}
	    });
   		console.log($('.plus-group').length);
   		var num = $('.plus-group').length;
   		if (num < 3 ) {
   			console.log("버튼 숨김!!!")
   			$('button.minus').hide();
   		}
    }

</script>

<!-- ======= Edit Menu Section ======= -->
<section id="contact" class="contact breadcrumbs">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>수정</h2>
			<p>메뉴 수정하기</p>
		</div>
	</div>

	<div class="container" data-aos="fade-up">

		<div class="add-form">
			<div class="flex-center plus-form">
				<div class="plus-form-list">
					<div class="form-group">
						<input type="hidden" name="restaurant_license" class="form-control"
							value="${myRestaurant.restaurant_license }" />
					</div>
					<div class="pic-form">
						<label class="form-group pic-btn">
							<img id="image" src="http://placehold.it/120x120"> 
							<input type="file" name="file" class="form-control" id="file" onchange="readURL(this);" />
						</label>
						<div class="pic-group">
							<div class="form-group">
								<input type="text" name="menu_name" class="form-control" placeholder="메뉴명" data-rule="required" data-msg="메뉴명을 입력해주세요" />
								<div class="validate"></div>
							</div>
							<div class="inline">
								<div class="form-group">
									<select name="menu_category" onchange="ckAddBox(this)" class="form-control" data-rule="selected" data-msg="선택해주세요">
										<option value="">메뉴구분명</option>
										<c:forEach var="category" items="${categoryList }">
											<option value="${category }">${category }</option>												
										</c:forEach>
										<option value="add">직접추가</option>
									</select>
									<div class="validate"></div>
								</div>
								<div class="form-group">
									<input type="number" name="menu_price" class="form-control" placeholder="가격" data-rule="required" data-msg="가격을 입력해주세요" />
									<div class="validate"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<textarea name="menu_description" class="form-control"
							placeholder="설명을 적어주세요" rows="3"></textarea>
					</div>
				</div>
				<div class="minus-btn">
					<button type="button" class="plus-btn minus" onclick="del_form(this);"><i class="icofont-minus"></i></button>
				</div>
			</div>

			<form action="${contextPath}/owner/restaurant/editMenu.do" method="post" role="form" class="add" name="menuList" enctype="multipart/form-data">
				<div id="plus-list">
						
					<c:forEach var="menu" items="${myRestaurant.menuList }">
						<div class="flex-center plus-group">
							<div class="plus-form-list">
								<div class="form-group">
									<input type="hidden" name="menu_id" class="form-control menu-id" value="${menu.menu_id }" />
									<input type="hidden" name="restaurant_license" class="form-control" value="${menu.restaurant_license }" />
								</div>
								<div class="pic-form">
									<label class="form-group pic-btn">
										<c:choose>
											<c:when test="${menu.menu_image eq null }">
												<img id="image" src="http://placehold.it/120x120"> 
											</c:when>
											<c:otherwise>
												<img id="image" src="${contextPath}/upload/${menu.restaurant_license}/${menu.menu_image }">
												<input type="hidden" name="menu_image" class="form-control" value="${menu.menu_image }" />
											</c:otherwise>
										</c:choose>
										<input type="file" name="file" class="form-control" id="file" onchange="readURL(this);" />
									</label>
									<div class="pic-group">
										<div class="form-group">
											<input type="text" name="menu_name" class="form-control" value="${menu.menu_name }" placeholder="메뉴명" data-rule="required" data-msg="메뉴명을 입력해주세요" />
											<div class="validate"></div>
										</div>
										<div class="inline">
											<div class="form-group">
												<select name="menu_category" onchange="ckAddBox(this)" class="form-control" data-rule="selected" data-msg="선택해주세요">
													<option value="">메뉴구분명</option>
													<c:forEach var="category" items="${categoryList }">
														<option value="${category }" <c:if test="${menu.menu_category eq category}">selected</c:if>>${category }</option>												
													</c:forEach>
													<option value="add">직접추가</option>
												</select>
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<input type="number" name="menu_price" class="form-control" value="${menu.menu_price }" placeholder="가격" data-rule="required" data-msg="가격을 입력해주세요" />
												<div class="validate"></div>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<textarea name="menu_description" class="form-control"
										placeholder="설명을 적어주세요" rows="3">${menu.menu_description }</textarea>
								</div>
							</div>
							<div class="minus-btn">
								<button type="button" class="plus-btn minus" onclick="del_form(this);"><i class="icofont-minus"></i></button>
							</div>
						</div>
						
					</c:forEach>
				</div>
				<div id="plus-btn" class="mb-3">
					<button type="button" id="plus" class="plus-btn"><i class="icofont-plus"></i></button>
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