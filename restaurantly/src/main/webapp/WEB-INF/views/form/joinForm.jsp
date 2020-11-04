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

     <div class="login-form">

       <form action="${contextPath}/customer/addCustomer.do" method="post" role="form" class="join-form">
          <div class="form-group">
            <input type="text" name="customer_id" class="form-control" id="id" placeholder="Id" data-rule="required" data-msg="아이디를 입력해주세요" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="password" class="form-control" name="customer_pw" id="pw" placeholder="Password" data-rule="required" data-msg="비밀번호를 입렵해주세요" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="password" class="form-control" name="customer_pw2" id="pw2" placeholder="Password Repeat" data-rule="repeat" data-msg="입력된 비밀번호가 다릅니다" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="text" name="customer_name" class="form-control" id="name" placeholder="Name" data-rule="required" data-msg="이름을 입력해주세요" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="text" name="customer_email" class="form-control" id="email" placeholder="Email" data-rule="email" data-msg="이메일을 입력해주세요" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="text" name="customer_phone" class="form-control" id="phone" placeholder="Phone" data-rule="phone" data-msg="번호를 입력해주세요" />
            <div class="validate"></div>
          </div>
          <div class="form-group">
            <input type="date" name="customer_birthdate" class="form-control" id="birthdate" placeholder="Birthdate" />
          </div>
          <div class="mb-3">
            <div class="loading">Loading</div>
            <div class="error-message"></div>
          </div>
         <div class="text-center"><button type="submit">Join</button></div>
       </form>

     </div>

  </div>
</section><!-- End Join Section -->