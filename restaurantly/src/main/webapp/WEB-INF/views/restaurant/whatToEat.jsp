<!-- ======= What to Eat Section ======= -->
<section id="contact" class="contact breadcrumbs">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>What to Eat</h2>
			<p>
				What Do You Think About <span class="whatToEat">${whatToEat}</span>?
			</p>
		</div>
	</div>

	<div class="container" data-aos="fade-up">

		<div class="whatToEat-form">
			<!-- photo start -->
			<div class="container-fluid" data-aos="fade-up" data-aos-delay="100">

				<div class="row no-gutters">

					<c:choose>
						<c:when test="${whatToEatList == null }">
							<h3>Sorry, No Restaurant</h3>
							<div class="btns">
								<a href="${contextPath}/menu/whatToEat.do" class="btn-menu animated fadeInUp scrollto">Try Again</a>
							</div>
						</c:when>
						<c:when test="${whatToEatList != null }">
							<c:forEach var="pic" items="${whatToEatList }" >
								<div class="col-lg-3 col-md-4">
									<div class="gallery-item">
										<a href="${contextPath}/${pic }" class="venobox"
											data-gall="gallery-item"> <img
											src="${contextPath}/${pic }" alt="" class="img-fluid">
										</a>
									</div>
								</div>
							</c:forEach>
							
								<form action="${contextPath}/restaurant/listRestaurants.do"
									method="post" role="form" class="php-email-form">
									<input type="hidden" id="food_name" name="food_name"
										value="${whatToEat }" />
									<div class="text-center">
										<button type="submit">Book Now</button>
									</div>
								</form>
						</c:when>
					</c:choose>
					
				</div>

			</div>

		</div>

	</div>
</section>
<!-- End What to Eat Section -->