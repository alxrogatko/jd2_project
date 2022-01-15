<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>Регистрация пользователя</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="limiter">
    <div class="container-login100" style="background-image: url('images/project.gif');">
        <div class="wrap-login100">
            <form class="login100-form validate-form" accept-charset="UTF-8" method="post" action="/view/check-registration.html">
					<span class="login100-form-title p-b-26">
					    Регистрация
						<p>
						    <span style="color: #FF0000; ">
						        <c:out value="${exception}" default=" "> </c:out>
                            </span>
                        </p>
					</span>

                <div class="wrap-input100">
                    <input class="input100" type="text" name="email">
                    <span class="focus-input100" data-placeholder="Почта"></span>
                </div>

                <div class="wrap-input100">
                    <input class="input100" type="text" maxlength="10" name="nickname">
                    <span class="focus-input100" data-placeholder="Имя аккаунта"></span>
                </div>

                <div class="wrap-input100">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
                    <input class="input100" type="password" name="password">
                    <span class="focus-input100" data-placeholder="Пароль"></span>
                </div>

                <div class="wrap-input100">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
                    <input class="input100" type="password" name="repassword">
                    <span class="focus-input100" data-placeholder="Повторите пароль"></span>
                </div>

                Пол: <input type="radio" name="gender" value="женский" checked/>Женский
                <input type="radio" name="gender" value="мужской"/>Мужской
                <input type="radio" name="gender" value="не указан"/>Не указывать

                <div class="wrap-input100">
                    <input class="input100" type="text" name="age">
                    <span class="focus-input100" data-placeholder="Возраст"></span>
                </div>

                <div style="margin-top:20px">
                    <label for="date">Дата рождения: </label>
                    <input type="date" id="date" name="birthday"/>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn">
                            Регистрация
                        </button>
                    </div>
                </div>
                <div class="text-center p-t-115">
						<span class="txt1">
							Уже зарегестрированы?
						</span>
                    <a class="txt2" href="/view">
                        Войдите!
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="dropDownSelect1"></div>
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>