<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title><spring:message code='registration.main-title' /></title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
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

	<div class="container">

		<%-- <form:form method="POST" modelAttribute="userForm" class="form-signin">
			<h2 class="form-signin-heading">Create your account</h2>

			<spring:bind path="firstName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="firstName" class="form-control"
						placeholder="First name" autofocus="true"></form:input>
					<form:errors path="firstName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="lastName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="lastName" class="form-control"
						placeholder="Last name" autofocus="true"></form:input>
					<form:errors path="lastName"></form:errors>
				</div>
			</spring:bind>


			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="email" class="form-control"
						placeholder="Email" autofocus="true"></form:input>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="passwordConfirm"
						class="form-control" placeholder="Confirm your password"></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>
	</div> --%>


		<div class="wrapper fadeInDown">
			<div id="formContent">
				<!-- Tabs Titles -->

				<!-- Icon -->
				<div class="fadeIn first">
					<img
						src="https://www.freeiconspng.com/thumbs/login-icon/user-login-icon-29.png"
						id="icon" alt="Login icon" />
				</div>

				<form:form method="POST" modelAttribute="userForm"
					class="form-signin">
					<h2 class="form-heading">
						<spring:message code="registration.title" />
					</h2>

					<div class="form-group ${error != null ? 'has-error' : ''}">
						<span>${message}</span>

						<spring:bind path="firstName">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<input name="firstName" type="text"	placeholder="<spring:message code='registration.firstName'/>"
									class="form-control" autofocus="true" />
							</div>
						</spring:bind>

						<spring:bind path="lastName">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<input name="lastName" type="text"	placeholder="<spring:message code='registration.lastName'/>"
									class="form-control" autofocus="true" />
							</div>
						</spring:bind>


						<spring:bind path="email">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<input name="email" type="text"	placeholder="<spring:message code='login.email'/>"
									class="form-control" autofocus="true" />
							</div>
						</spring:bind>

						<spring:bind path="password">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<input name="password" type="text"	placeholder="<spring:message code='login.password'/>"
									class="form-control" autofocus="true" />
							</div>
						</spring:bind>

						<spring:bind path="passwordConfirm">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<input name="passwordConfirm" type="text"	placeholder="<spring:message code='registration.passwordConfirm'/>"
									class="form-control" autofocus="true" />
							</div>
						</spring:bind>
						<span>${error}</span> <input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" />


						<button class="fadeIn fourth" type="submit">
							<spring:message code='registration.sign-up' />
						</button>
					</div>

				</form:form>

			</div>
		</div>
</body>
</html>