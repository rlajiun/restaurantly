<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<script>
$(function() {
		var user = $('.login-nav li.active').find('a').text();
		var action, name_id, name_pw;
		
		if (user == 'Owner') {
			action = '${contextPath}/owner/login.do';
			name_id = 'owner_id';
			name_pw = 'owner_pw';
			
		} else {
			action = '${contextPath}/customer/login.do';
			name_id = 'customer_id';
			name_pw = 'customer_pw';
		}
		$('li.active').parents('form').attr('action', action);
		$('#id').attr('name', name_id);
		$('#pw').attr('name', name_pw);
			
	$('.login-nav').find('li').on('click', function(){
		$(this).addClass('active');
		$(this).siblings().removeClass('active');
		
		user = $(this).find('a').text();

		if (user == 'Owner') {
			action = '${contextPath}/owner/login.do';
			name_id = 'owner_id';
			name_pw = 'owner_pw';
		} else {
			action = '${contextPath}/customer/login.do';
			name_id = 'customer_id';
			name_pw = 'customer_pw';
		}
		$(this).parents('form').attr('action', action);
		$('#id').attr('name', name_id);
		$('#pw').attr('name', name_pw);
	});
	
	$('form.login-form').submit(function(e) {
		e.preventDefault();
		
		var this_form = $(this);
	    var action = $(this).attr('action');
	    var data = $(this).serialize();
	    
	    login_form_submit(this_form,action,data);
	    
	    return true;
	});
	
	function login_form_submit(this_form, action, data) {
	    $.ajax({
	      type: "POST",
	      url: action,
	      data: data
	    }).done( function(data){
	      console.log('data>>>>>>'+data);
	      console.log('msg>>>>>>'+data.msg);
	      console.log('url>>>>>>'+data.url);
	      
	      var msg = data.msg;
	      var url = data.url;

	      if (url != null) {
	        this_form.find('.loading').slideUp();
	        window.location.href = url;
	      } else {
	        this_form.find('.loading').slideUp();
	        this_form.find("input:not(input[type=submit]), textarea").val('');
	        if(!msg) {
	          msg = 'Form submission failed and no error message returned from: ' + action + '<br>';
	        }
	        this_form.find('.error-message').slideDown().html(msg);
	      }
	    }).fail( function(data){
	      console.log(data);
	      var error_msg = "Form submission failed!<br>";
	      if(data.statusText || data.status) {
	        error_msg += 'Status:';
	        if(data.statusText) {
	          error_msg += ' ' + data.statusText;
	        }
	        if(data.status) {
	          error_msg += ' ' + data.status;
	        }
	        error_msg += '<br>';
	      }
	      if(data.responseText) {
	        error_msg += data.responseText;
	      }
	      this_form.find('.loading').slideUp();
	      this_form.find('.error-message').slideDown().html(error_msg);
	    });
	  }
});
</script>

<!-- ======= Login Section ======= -->
<section id="contact" class="contact breadcrumbs">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>Login</h2>
			<p>Login to Restaurantly</p>
		</div>
	</div>

	<div class="container" data-aos="fade-up">

		<div class="login-form">

			<form method="post" role="form" class="php-email-form login-form">
				<ul class="nav login-nav">
					<c:choose>
						<c:when test="${user eq 'owner' }">
							<li><a>Customer</a></li>
							<li class="active"><a>Owner</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"><a>Customer</a></li>
							<li><a>Owner</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
				<div class="form-group">
					<input type="text" class="form-control" id="id" placeholder="Id" />
				</div>
				<div class="form-group">
					<input type="password" class="form-control" id="pw" placeholder="Password" />
				</div>
				<div class="mb-3">
		            <div class="loading">Loading</div>
		            <div class="error-message"></div>
		        </div>
				<div class="text-center">
					<button type="submit" >Login</button>
				</div>
			</form>

		</div>

	</div>
</section>
<!-- End Login Section -->