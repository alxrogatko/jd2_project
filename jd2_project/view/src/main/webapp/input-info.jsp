<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
	<title>Регистрация пользователя</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="css.html"/>
</head>
<body>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('login-and-register-style/images/bg-01.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method = "post" action = "/view/home">
					<span class="login100-form-title p-b-26">
					    <p> Это ваш первый вход. Пожалуйста, заполните информацию о себе. <p>
						<p>
						    <font color = "#FF0000">
						        <c:out value= "${exception}" default = " "> </c:out>
                            </font>
                        </p>
					</span>

					<div class="wrap-input100">
						<input class="input100" type="text" name="nickname">
						<span class="focus-input100" data-placeholder="Имя аккаунта(обязательно)"></span>
					</div>


					Пол: <input type="radio" name="gender" value="мужской" checked />Женский
                         <input type="radio" name="gender" value="женский" />Мужской
                         <input type="radio" name="gender" value="не указан" />Не указывать

                    <div style="margin-top:20px">
                        <label for="date">Дата рождения: </label>
                        <input type="date" id="date" name="birthday"/>
                    </div>


                    <div style="margin-top:20px">
					    <div class="container-login100-form-btn">
						    <div class="wrap-login100-form-btn">
							    <div class="login100-form-bgbtn"></div>
							    <button class="login100-form-btn">
								    Подтвердить
							    </button>
						    </div>
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