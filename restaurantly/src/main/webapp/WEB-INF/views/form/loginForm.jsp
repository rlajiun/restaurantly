<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<!-- ======= Login Section ======= -->
<section id="contact" class="contact breadcrumbs">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>Login</h2>
			<p>Login to Restaurantly</p>
		</div>
	</div>

	<div class="container" data-aos="fade-up">

		<div class="login-from">

			<form action="${contextPath}/customer/login.do" method="post" role="form" class="php-email-form">
				<div class="form-group">
					<input type="text" name="customer_id" class="form-control" id="id" placeholder="Id" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
					<div class="validate"></div>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="customer_pw" id="pw" placeholder="Password" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
					<div class="validate"></div>
				</div>
				<div class="text-center">
					<button type="submit">Login</button>
				</div>
			</form>

		</div>

	</div>
</section>
<!-- End Login Section -->