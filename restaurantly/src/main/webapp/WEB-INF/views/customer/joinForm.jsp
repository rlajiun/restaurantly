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

  <div class="container" d ata-aos="fade-up">

     <div class="login-from">

       <form action="${contextPath}/customer/addCustomer.do" method="post" role="form" class="php-email-form">
          <div class="form-group">
            <input type="text" name="id" class="form-control" id="id" placeholder="Id" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="password" class="form-control" name="pw" id="pw" placeholder="Password" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="password" class="form-control" name="pw2" id="pw2" placeholder="Password Repeat" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="text" name="name" class="form-control" id="name" placeholder="Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="text" name="email" class="form-control" id="email" placeholder="Email" />
          </div>
          <div class="form-group">
            <input type="text" name="phone" class="form-control" id="phone" placeholder="Phone" />
          </div>
          <div class="form-group">
            <input type="date" name="birthdate" class="form-control" id="birthdate" placeholder="Birthdate" />
          </div>
         <div class="text-center"><button type="submit">Join</button></div>
       </form>

     </div>

  </div>
</section><!-- End Join Section -->