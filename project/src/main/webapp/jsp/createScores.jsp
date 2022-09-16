<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create score</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

	<div class="container" style="width: 100%; margin=0px">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 20%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a> 
			<a href="/create-score" class="w3-bar-item w3-button">Create scores</a> 
				<a href="#" class="w3-bar-item w3-button">Bucket</a>
		</div>
		<!-- Page Content -->
		<div style="margin-left: 20%">
			<div class="w3-container w3-teal">
				<h1>Create new Score</h1>
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




				<form:form method="POST" action="${contextPath}/addScores" modelAttribute="scores">
					<table>
						<tr>
							<td><form:label path="math">math</form:label></td>
							<td><form:input path="math" /></td>
						</tr>
						<tr>
							<td><form:label path="phisics">Phisics</form:label></td>
							<td><form:input path="phisics" /></td>
						</tr>
						<tr>
							<td><form:label path="english">English</form:label></td>
							<td><form:input path="english" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit" /></td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>


			</div>

		</div>


	</div>
	
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>