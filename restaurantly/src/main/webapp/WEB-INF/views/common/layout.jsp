<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("utf-8");
%>

<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
	
	<meta content="" name="descriptison">
	<meta content="" name="keywords">
	
	<!-- Favicons -->
	<link href="assets/img/favicon.png" rel="icon">
	<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
	
	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Open+Sans&display=swap" rel="stylesheet">
	
	<!-- Vendor CSS Files -->
	<link href="${contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
	<link href="${contextPath}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
	<link href="${contextPath}/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
	<link href="${contextPath}/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
	<link href="${contextPath}/assets/vendor/venobox/venobox.css" rel="stylesheet">
	<link href="${contextPath}/assets/vendor/aos/aos.css" rel="stylesheet">
	
	<!-- Template Main CSS File -->
	<link href="${contextPath}/assets/css/style.css" rel="stylesheet">
	<link href="${contextPath}/assets/css/main.css" rel="stylesheet">
	
	<!-- Vendor JS Files -->
	<script src="${contextPath}/assets/vendor/jquery/jquery.min.js"></script>
	<script src="${contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${contextPath}/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
	<script src="${contextPath}/assets/vendor/php-email-form/validate.js"></script>
	<script src="${contextPath}/assets/vendor/join-form/validate.js"></script>
	<script src="${contextPath}/assets/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="${contextPath}/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="${contextPath}/assets/vendor/venobox/venobox.min.js"></script>
	<script src="${contextPath}/assets/vendor/aos/aos.js"></script>
	
	<!-- =======================================================
	* Template Name: Restaurantly - v1.1.0
	* Template URL: https://bootstrapmade.com/restaurantly-restaurant-template/
	* Author: BootstrapMade.com
	* License: https://bootstrapmade.com/license/
	======================================================== -->

	<title><tiles:insertAttribute name="title" /></title>
	
</head>
<body>
	<div id="topbar" class="d-flex align-items-center fixed-top">
		<tiles:insertAttribute name="topbar" />
	</div>
	
	<header id="header" class="fixed-top">
		 <tiles:insertAttribute name="header" />
	</header>
	
	<aside>
		 <tiles:insertAttribute name="side" />
	</aside>
	<article>
	 	<tiles:insertAttribute name="body" />
	</article>
	
	<footer id="footer">
   		<tiles:insertAttribute name="footer" />
   	</footer>
    
    <div id="preloader"></div>
	<a href="#" class="back-to-top"><i class="bx bx-up-arrow-alt"></i></a>
	
	<!-- Template Main JS File -->
	<script src="${contextPath}/assets/js/main.js"></script>     	
</body>      
        
        