<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>Регистрация пользователя</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="css.html" />
</head>
<body>
<div class="limiter">
    <div class="container-login100" style="background-image: url('login-and-register-style/images/bg-01.jpg');">
        <div class="wrap-login100">
            <form class="login100-form validate-form" method = "post" action = "/view">
					<span class="login100-form-title p-b-26">
						Регистрация прошла успешно
					</span>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn">
                            Войти
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="dropDownSelect1"></div>
<jsp:include page="js.html" />
</body>
</html>