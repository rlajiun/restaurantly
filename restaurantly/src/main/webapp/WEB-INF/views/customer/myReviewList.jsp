<%@page import="com.restaurantly.customer.vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>

<script type="text/javascript">
/* ---댓글 삭제 ajax */     
$(document).ready(function(){
     $(".delete").click(function(e){
        e.preventDefault();
        console.log("리뷰 삭제");
        console.log($(this).attr("id")); 
        var review_id = $(this).attr("id");
         /*  console.log(review_id);
          var param = JSON.stringify({"review_id": review_id});
          console.log("data >>>> ", param); */
         
          $.ajax({
           method: "GET",
           url: "${contextPath}/review/removeReview.do",
           contentType: "application/json; charset=UTF-8",
           data: review_id,         
           success: function (res) {
              console.log("done>>> ", res);
              if(res=='success'){
                 $('.'+review_id).remove();
              }
           },
           error: function (status) {
              console.log("status >>> ", status);
           } 
           }); 
   });
});   
 

</script>


<!-- ======= title section======= -->
<section id="contact" class="contact breadcrumbs <c:if test="${empty customer }">customer-login</c:if>" >
	<div class="container" data-aos="fade-up">
		<div class="section-title">
			<h2>내가 쓴 리뷰</h2>
			<p>my reviews</p>
		</div>
	</div>
</section>

<!-- ======= List Section ======= -->
<section id="list" class="list">
	<div class="container">
	
		<div align="center"  >
			<c:forEach var="item" items="${reviewList }">
			

				<div class="col-sm-6 col-md-4">
				    <div class="thumbnail">
				    <%-- <img src="${contextPath}/upload/${item.photoList[0].fileName}">
				     --%>
				    <c:forEach var="inner" items="${item.photoList }">
				 	<img src="${contextPath}/upload/${inner.fileName}">
					</c:forEach> 
				    
				      <div class="caption">
				        <h3>${item.review_content }</h3>
				        <h5>${item.review_writedate }</h3>
				        <h5>${item.review_score }.0/5.0</h5>  
				        <span><a href="${contextPath}/restaurant/restaurantMain/${item.restaurant_license}" class="btn-detail" role="button">보기</a></span>
				        <span><a class="edit btn-detail" href="#none" id="${item.review_id}">수정</a></span>
				      	<span><a class="delete btn-detail" href="#none" id="${item.review_id}">삭제</a></span>
				      	
				       </div>
				    </div>
				  </div>			
			
			</c:forEach>
		</div>
	</div>
</section>




</body>
</html>