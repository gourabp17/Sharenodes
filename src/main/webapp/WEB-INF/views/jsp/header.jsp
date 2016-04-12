<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="icon" href="${baseurl}/resources/core/images/favicon.ico" type="image/icon">
<title>Sharenodes-Home</title>

<spring:url value="${baseurl}/resources/core/css/base.css" var="coreCss" />
<spring:url value="${baseurl}/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/resources/core/css/base.css" var="headerMenuCss" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${headerMenuCss}" rel="stylesheet" />
<spring:url value="${baseurl}/resources/core/js/jquery.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>

</head>
<body>


	<nav class="navbar navbar-static-top  navbar-inverse" role="navigation"
		id="topNavBar">
		<div class="container">
			<div class="navbar-header" data-toggle="collapse"
				data-target="#collapse-1">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a href="${baseurl}" class="navbar-brand brnd">
				        <img alt="Brand" src="${baseurl}/resources/core/images/sharenodes_icon.png">
				 <%-- <b>Sharenodes ${message}</b> --%>
				 </a>
		 	</div>

			<div class="collapse navbar-collapse navbar-right " id="collapse-1">
				<ul class="nav navbar-nav" id="myHeader"">

					<c:choose>
						<c:when test="${empty succesfullogin}">

							<li><a onclick="loginModal()" data-target="#myModal">Sign
									In<b style="letter-spacing: .5px"> / </b>Register
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a class="dropdown-toggle" data-toggle="dropdown">
									${succesfullogin} </a>
								<ul class="dropdown-menu" id="dropdownlogout">
									<li><a href=#>PROFILE</a></li>
									<li><a href="${baseurl}/loginform/logout">Logout</a></li>
								</ul></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>
		<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>





	<div class="modal" id="createUserModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<form:form id="regForm" action="registercomp" method="post"
					commandName="test">

					<div class="modal-header ">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>

						<h5 class="modal-title " id="myModalLabel">Register</h5>
					</div>

					<div class="modal-body">

						<div class="form-group">

							<div class="input-group">
								<span class="input-group-addon"> Name</span> <input type="text"
									class="form-control" id="regName" name="regName"
									placeholder="John Writer" maxlength="25" required>
							</div>
						</div>
						<div class="form-group">

							<div class="input-group">
								<span class="input-group-addon">Company name</span> <input
									type="text" class="form-control" id="regComp" name="regComp"
									placeholder="Example pvt ltd" maxlength="50" required>
							</div>
						</div>

						<div class="form-group">

							<div class="input-group">
								<span class="input-group-addon">Email</span> <input type="email"
									class="form-control" id="regEmail" name="regEmail"
									placeholder="xyz@example.com" maxlength="50"
									data-toggle="popover" data-trigger="hover" data-placement="top"
									data-content="User will be the super user. Can add/modify/delete other users"
									required>
							</div>
						</div>
						<div class="form-group">

							<div class="input-group">
								<span class="input-group-addon">Mobile</span> <input type="text"
									class="form-control" id="regMobile" name="regMobile"
									placeholder="7722334455" maxlength="10" required>
							</div>
						</div>
						<div class="form-group">

							<div class="input-group">
								<span class="input-group-addon">Password</span> <input
									type="password" class="form-control" id="regPwd" name="regPwd"
									placeholder="Alphabet and number only" maxlength="20" required>
							</div>
						</div>
						<div class="form-group">

							<div class="input-group">
								<span class="input-group-addon">Re-Password</span> <input
									type="password" class="form-control" id="reRegPwd"
									name="reRegPwd" placeholder="Alphabet and number"
									maxlength="20" required>
							</div>
						</div>
						<div class="form-group">

							<div class="input-group">
								<span class="input-group-addon"><img src="" alt="captcha"
									id="captchaImage" /></span> <input type="text" class="form-control"
									id="captcha" placeholder="verify captcha" name="captcha"
									onkeypress="regUser()" maxlength="5" required> <span
									class="input-group-addon" id="captchaRefresh"
									onclick="captchaRefresh()"><span
									class="glyphicon glyphicon-refresh"></span></span>
							</div>
						</div>

						<div id="regformAlert" style="display: none"
							class="alert alert-danger" role="alert"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-toolbar"
							onclick="loginModal()" data-target="#myModal">
							<span class="glyphicon glyphicon-hand-left"> </span> Back
						</button>
						<button type="submit" class="btn btn-primary disabled">
							<span class="glyphicon glyphicon-user"> </span> Register
						</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<div class="modal " id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header ">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

					<h5 class="modal-title " id="myModalLabel">LOGIN TO CPortal</h5>
				</div>


				<form:form id="loginForm" method="post"
					commandName="login">
					<div class="modal-body">
						<div class="form-group">
							<label for="email">Email address:</label>
							<div class="input-group">
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-user"></span></span> <input type="email"
									class="form-control" id="username" name="username"
									placeholder="Eg: abcxyz@example.com">
							</div>
						</div>
						<div class="form-group">
							<label for="password">Password:</label>
							<div class="input-group">
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span> <input
									type="password" class="form-control" placeholder="**********"
									id="pwd" name="password">
							</div>
						</div>
						<div class="form-group"
							style="text-align: right; margin: 0px 2px 0px 0px">
							<span onclick="forgetpwdModal()" data-target="#forgetpwdModal"
								style="font-size: 70%; cursor: pointer">FORGET PASSWORD</span>
						</div>
						<div id="formAlert" style="display: none"
							class="alert alert-success" role="alert"></div>

					</div>

								
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-lock"> </span> Login
						</button>
						<button type="button" class="btn btn-toolbar"
							onclick="registerModal();
                            captchaRefresh()"
							data-target="#createUserModal">
							<span class="glyphicon glyphicon-user"> </span> Create Account
						</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<div class="modal" id="forgetpwdModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<div class="modal-header ">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

					<h5 class="modal-title " id="myModalLabel">FORGET PASSWORD</h5>
				</div>

				<div class="modal-body">

					<div></div>

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-toolbar"
						onclick="loginModal()" data-target="#myModal">
						<span class="glyphicon glyphicon-hand-left"> </span> Back
					</button>
					<button type="submit" class="btn btn-primary" onclick="forPwd()">
						<span class="glyphicon glyphicon-user"> </span> SUBMIT
					</button>
				</div>
			</div>
		</div>
	</div>