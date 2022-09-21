<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code='login.title'/></title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<script type="text/javascript">
	$(document).ready(function() {
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {
			var selectedOption = $('#locales').val();
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>
</head>
<body>

	<div class="container-fluid">

		<!-- Sidebar -->
		<div class="w3-sidebar" style="width: 10%">

			<div class="list-group" style="margin-top: 40px">

				<div class="list-group-item active">
					<div>
						<h3><spring:message code='login.title'/></h3>
					</div>
					<div>${pageContext.request.userPrincipal.name}</div>
				</div>

				<a href="/home" class="list-group-item"> <i
					class="fa fa-comment-o"></i><spring:message code='sidebar.home'/>
				</a>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<a href="/create-score" class="list-group-item"> <i
						class="fa fa-search"></i><spring:message code='sidebar.create-scores'/>
					</a>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_USER')">
					<a href="/buckets" class="list-group-item"> <i
						class="fa fa-search"></i><spring:message code='sidebar.bucket'/>
					</a>
				</security:authorize>


				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					<a class="list-group-item"
						onclick="document.forms['logoutForm'].submit()"
						style="cursor: pointer"> <i class="fa fa-search"></i> <spring:message code='sidebar.logout'/>
					</a>
				</c:if>
			</div>
		</div>
		<!-- Page Content -->
		<div style="margin-left: 10%">
			<div class="w3-container" >

				<form:form method="POST" action="${contextPath}/addScores" enctype="multipart/form-data" style="margin:10%">
					<%-- <table>
						<tr>
							<td>Math</td>
							<td><input type="number" name="math" /></td>
						</tr>
						<tr>
							<td>Physics</td>
							<td><input type="number" name="physics" /></td>
						</tr>
						<tr>
							<td>English</td>
							<td><input type="number" name="english" /></td>
						</tr>
						<tr>
							<td>Select an image to upload</td>
							<td><input type="file" name="file" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit" /></td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> --%>
						<div class="form-group">
						<label for="math"><spring:message code='scores.math'/></label> 
						<input class="form-control"
							aria-describedby="math" name="math" placeholder="<spring:message code='scores.math'/>">
					</div>
					
					
					<div class="form-group">
						<label for="physics"><spring:message code='scores.physics'/></label> 
						<input class="form-control"
							aria-describedby="physics" name="physics" placeholder="<spring:message code='scores.physics'/>">
					</div>
					
					<div class="form-group">
						<label for="english"><spring:message code='scores.english'/></label> 
						<input class="form-control"
							aria-describedby="english" name="english" placeholder="<spring:message code='scores.english'/>">
					</div>
					
					<div class="form-group">
						<label for="file"><spring:message code='scores.select_image'/></label> 
						<input class="form-control"
							aria-describedby="file" name="file" type="file" placeholder="<spring:message code='scores.image'/>">
					</div>
					
					  <button type="submit" class="btn btn-primary"><spring:message code='scores.submit'/></button>
					
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>


			</div>

		</div>


	</div>
	
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>