<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
	<title>Добро пожаловать</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login-and-register-style/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login-and-register-style/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login-and-register-style/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login-and-register-style/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="login-and-register-style/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login-and-register-style/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login-and-register-style/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="login-and-register-style/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login-and-register-style/css/util.css">
	<link rel="stylesheet" type="text/css" href="login-and-register-style/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('login-and-register-style/images/bg-01.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method = "post" action = "/view/home">
					<span class="login100-form-title p-b-26">
						Добро пожаловать
						<p> <c:out value= "${exception}" default = " "></c:out> </p>
					</span>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="email">
						<span class="focus-input100" data-placeholder="Почта"></span>
					</div>

					<div class="wrap-input100 validate-input">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="password">
						<span class="focus-input100" data-placeholder="Пароль"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Войти
							</button>
						</div>
					</div>

					<div class="text-center p-t-115">
						<span class="txt1">
							Нет аккаунта?
						</span>

						<a class="txt2" href="./registration.jsp">
							Зарегистрируйтесь!
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="login-and-register-style/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="login-and-register-style/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="login-and-register-style/vendor/bootstrap/js/popper.js"></script>
	<script src="login-and-register-style/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="login-and-register-style/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="login-and-register-style/vendor/daterangepicker/moment.min.js"></script>
	<script src="login-and-register-style/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="login-and-register-style/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="login-and-register-style/js/main.js"></script>

</body>
</html>