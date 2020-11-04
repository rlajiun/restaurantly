<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			console.log(input);
			console.log($(input).find('.preview'));
			var reader = new FileReader();
			reader.onload = function(e) {
				$(input).parent().next().find('.preview').attr('src',
						e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	var cnt = 0;
	function fn_addFile() {
		cnt++;
		/* $("#d_file").append("<br>"+"<input type='file' name='file"+cnt+"' />"); */
		$("#d_file")
				.append(
						"<tr><td>"
								+ "<input type='file' name='file"
								+ cnt
								+ "' onchange='readURL(this);' /></td><td><img class='preview' scr='#' width=200 height=200/></td></tr>");
	}
</script>

</head>
<body>
	<h1 style="text-align: center">리뷰 쓰기</h1>
	<form name="reviewForm" method="post"
		action="${contextPath}/review/addNewReview.do"
		enctype="multipart/form-data">
		<table border="1" align="center">
			<tr>
				<td align="right">작성자</td>
				<td colspan=2 align="left"><input type="text" size="20"
					maxlength="100" value="${customer_id}" readonly /></td>
			</tr>

			<tr>
				<td align="right" valign="top"><br>리뷰 내용:</td>
				<td colspan=2><textarea name="content" rows="10" cols="65"
						maxlength="4000"></textarea></td>
			</tr>
			<tr>
				<td align="right">이미지파일 첨부:</td>
				<td><input type="file" name="imageFileName"
					onchange="readURL(this);" /></td>
				<td><img class="preview" src="#" width=200 height=200 /></td>

			</tr>
			<tr>
				<td align="left"><input type="button" value="파일 추가"
					onClick="fn_addFile()" /></td>
			</tr>


			<tr id="d_file">

			</tr>
			<tr>
				<td align="right"></td>
				<td colspan="2"><input type="submit" value="완료" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
