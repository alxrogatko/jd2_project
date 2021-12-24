<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype HTML>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="utf-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header>
    <a href="/view/${userId}/profile.html">
        <div class="logo">Логотип</div>
    </a>
    <div class="search">Поиск</div>
</header>

<div class="wrapper">

    <div class="menu">

        <a href="/view/${userId}/profile.html">
            <div class="menu-block">
                <div class="icon">
                    <img src="images/user.png" alt="profile">
                </div>
                <div class="menu-text">Профиль</div>
            </div>
        </a>

        <a href="/view/friends.html">
            <div class="menu-block">
                <div class="icon">
                    <img src="images/friends.png" alt="profile">
                </div>
                <div class="menu-text">Друзья</div>
            </div>
        </a>

        <a href="/view/messages.html">
            <div class="menu-block">
                <div class="icon">
                    <img src="images/message.png" alt="profile">
                </div>
                <div class="menu-text">Сообщения</div>
            </div>
        </a>

        <a href="/view/settings.html">
            <div class="menu-block">
                <div class="icon">
                    <img src="images/settings.png" alt="profile">
                </div>
                <div class="menu-text">Настройки</div>
            </div>
        </a>

    </div>
    <div class="fast-block"></div>

    <div class="friend-box">
        <div class="friend-choice-block">
            <a href="/view/friends.html">
                <div class="inner-friend-choice-block">
                    <div class="inner-friend-choice-block-text">
                        <b>Друзья</b>
                    </div>
                </div>
            </a>
            <a href="/view/users.html">
                <div class="inner-friend-choice-block">
                    <div class="inner-friend-choice-block-text">
                        <b>Все пользователи</b>
                    </div>
                </div>
            </a>
        </div>

        <div class="friends-menu">
            <a href="/view/friends.html">
                <div class="inner-friends-menu">
                    <div class="friends-menu-text">
                        Мои друзья
                    </div>
                </div>
            </a>
            <a href="/view/friends-requests.html">
                <div class="inner-friends-menu">
                    <div class="friends-menu-text">
                        Заявки
                    </div>
                </div>
            </a>
        </div>

        <c:if test="${thisIsMyFriends == true}">
            <a href="/view/profile.html">
                <div class="my-friend-block">
                    <div class="avatar-in-search"></div>
                    <div class="nickname-in-search">Test</div>
                </div>
            </a>
        </c:if>
        <c:if test="${thisIsMyFriends == false}">
            <c:forEach items="${friends}" var="friends">
                <div class="wrapper-for-search-friend-block">
                    <a href="/view/${friends.getOwnerId()}/profile.html">
                        <div class="friend-request-block">
                            <div class="avatar-in-search"></div>
                            <div class="nickname-in-search"><c:out value="${friends.getOwnerName()}"/></div>
                        </div>
                    </a>

                    <a href="/friends-requests.html">
                        <form method="get">
                            <button class="accept-or-decline-request-circle" type="submit" name="friendRequestButton"
                                    value="accept">
                                <div class="accept-or-dicline-icon">
                                    <img src="images/check.png" alt="accept">
                                </div>
                            </button>
                            <button class="accept-or-decline-request-circle" type="submit" name="friendRequestButton"
                                    value="decline">
                                <div class="accept-or-dicline-icon">
                                    <img src="images/cancel.png">
                                </div>
                            </button>
                        </form>
                    </a>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>

<footer>
    <div class="logout">Выход</div>
</footer>
</body>
</html>