<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  

<!-- ======= Join Section ======= -->
<section id="contact" class="contact breadcrumbs">
  <div class="container" data-aos="fade-up">

    <div class="section-title">
      <h2>Join</h2>
      <p>Join for Restaurantly</p>
    </div>
  </div>

  <div class="container" data-aos="fade-up">

     <div class="login-from">

       <form action="${contextPath}/owner/addOwner.do" method="post" role="form" class="php-email-form">
          <div class="form-group">
            <input type="text" name="owner_id" class="form-control" id="owner_id" placeholder="Id" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="password" class="form-control" name="owner_pw" id="owner_pw" placeholder="Password" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="password" class="form-control" name="owner_pw2" id="owner_pw2" placeholder="Password Repeat" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="text" name="owner_name" class="form-control" id="owner_name" placeholder="Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="text" name="owner_phone" class="form-control" id="owner_phone" placeholder="Phone" />
          </div>
          <div class="form-group">
            <input type="text" name="owner_email" class="form-control" id="owner_email" placeholder="Email" />
          </div>
         <div class="text-center"><button type="submit">Join</button></div>
       </form>

     </div>

  </div>
</section><!-- End Join Section -->