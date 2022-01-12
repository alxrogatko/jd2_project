<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype HTML>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>Home</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/lightbox.css">
</head>
<body>
<header>
    <a href="/view/${userId}/profile.html">
        <div class="logo">Логотип</div>
    </a>
    <div class="search">Поиск</div>
</header>

<div class="content">
    <div class="item-menu">
        <div class="menu">

            <a href="/view/${userId}/profile.html">
                <div class="menu-block">
                    <div class="icon">
                        <img src="../images/user.png" alt="profile">
                    </div>
                    <div class="menu-text">Профиль</div>
                </div>
            </a>

            <a href="/view/friends.html">
                <div class="menu-block">
                    <div class="icon">
                        <img src="../images/friends.png" alt="friends">
                    </div>
                    <div class="menu-text">Друзья</div>
                </div>
            </a>

            <a href="/view/messages.jsp">
                <div class="menu-block">
                    <div class="icon">
                        <img src="../images/message.png" alt="messages">
                    </div>
                    <div class="menu-text">Сообщения</div>
                </div>
            </a>

            <a href="/view/settings.html">
                <div class="menu-block">
                    <div class="icon">
                        <img src="../images/settings.png" alt="settings">
                    </div>
                    <div class="menu-text">Настройки</div>
                </div>
            </a>

        </div>
    </div>

    <div class="item-avatar">
        <div class="avatar-block">
        </div>
        <div class="info-block">

            <c:set var="user" value="${user}"/>


            <div class="nickname">
                <b><c:out value="${user.getNickname()}"/></b>
            </div>
            <div class="info">
                <b>
                    Пол: <c:out value="${user.getGender()}" default="Не указано"/><br>
                    Возраст: <c:out value="${user.getAge()}" default="Не указано"/><br>
                    Дата рождения: <c:out value="${user.getBirthday()}" default="Не указано"/>
                </b>
            </div>
        </div>
        <c:if test="${thisIsNotMainUserPage == true}">
            <c:choose>

                <c:when test="${requestStatus == 'none'}">
                    <form method="get" action="/view/${user.getId()}/profile.html">
                        <button class="command-circle" type="submit" name="button" value="request">
                            <div class="add-user-icon">
                                <img src="../images/plus.png" alt="add-user"/>
                            </div>
                        </button>
                    </form>
                </c:when>

                <c:when test="${requestStatus == 'request'}">
                    <form method="get" action="/view/${user.getId()}/profile.html">
                        <button class="command-circle" type="submit" name="button" value="wait">
                            <div class="add-user-icon">
                                <img src="../images/time.png" alt="requested"/>
                            </div>
                        </button>
                    </form>
                </c:when>

                <c:when test="${requestStatus == 'added'}">
                    <form method="get" action="/view/${user.getId()}/profile.html">
                        <form method="get">
                            <button class="command-circle" type="submit" name="button" value="delete">
                                <div class="add-user-icon">
                                    <img src="../images/check.png" alt="added"/>
                                </div>
                            </button>
                        </form>
                    </form>
                </c:when>
            </c:choose>
            <form method="get" action="/view/${user.getId()}/create-dialog.html">
                <button class="command-circle" type="submit" name="button" value="create-dialog">
                    <div class="add-user-icon">
                        <img src="../images/message.png" alt="add-user"/>
                    </div>
                </button>
            </form>
        </c:if>
    </div>


    <div class="item-fast-block">
        <div class="fast-block"></div>
    </div>
</div>

<footer>
    <div class="logout">Выход</div>
</footer>
</body>
</html>