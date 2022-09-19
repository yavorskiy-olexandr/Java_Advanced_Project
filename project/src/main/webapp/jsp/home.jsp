<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="security" uri="http://www.springframework.org/security"%> --%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>



<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>

<body>
	<div class="container" style="width: 100%; margin=0px">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 20%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a> <a
				href="/create-score" class="w3-bar-item w3-button">Create scores</a>
			<a href="/buckets" class="w3-bar-item w3-button">Bucket</a>
		</div>
		<!-- Page Content -->
		<div style="margin-left: 20%">

			<div class="w3-container w3-teal">
				<h1>Scores</h1>
			</div>

			<div class="w3-container">

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					<h2>
						Welcome ${pageContext.request.userPrincipal.name} | <a
							onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h2>
				</c:if>
				<c:if test="${not empty scores}">
					<c:forEach items="${scores}" var="currentScores">
						<div class="w3-card-4" style="width: 20%; margin: 2%">
							<img src="data:image/jpg;base64, ${currentScores.encodedImage}" alt="image" style="width: 100%">
							<div class="w3-container w3-center">
								<h3>${currentScores.math}</h3>
								<p>${currentScores.physics}</p>
								<p>${currentScores.english}</p>
							</div>
							<form:form action="${contextPath}/bucket" method="POST" enctype="multipart/form-data">
								<input type="hidden" value="${currentScores.id}"
									class="form-control" name="scoresId"> 
									<input type="submit" class="w3-button w3-block w3-dark-grey"
									value="+ add to bucket">
							</form:form>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>