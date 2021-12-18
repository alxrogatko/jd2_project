<!doctype HTML>
<html>
    <head>
        <%@ page contentType="text/html; charset=UTF-8" %>
        <meta charset="utf-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <header>
            <a href="profile.jsp">
                <div class="logo">Логотип</div>
            </a>
            <div class="search">Поиск</div>
        </header>

        <div class="wrapper" >

        <div class="menu">

                <a href="/home.html">
                    <div class="menu-block">
                        <div class="icon">
                            <img src="images/user.png" alt="profile">
                        </div>
                        <div class="menu-text">Профиль</div>
                    </div>
                </a>

                <a href="friends.html">
                    <div class="menu-block">
                        <div class="icon">
                            <img src="images/friends.png" alt="profile">
                        </div>
                        <div class="menu-text">Друзья</div>
                    </div>
                </a>

                <a href="messages.html">
                    <div class="menu-block">
                        <div class="icon">
                            <img src="images/message.png" alt="profile">
                        </div>
                        <div class="menu-text">Сообщения</div>
                    </div>
                </a>

                <a href="settings.html">
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
                <div class="friend-choice-block"></div>
                <div class="search-friend-block">
                    <div class="avatar-in-search" ></div>
                    <div class="nickname-in-search">Tokamo</div>
                </div>

            </div>
        </div>
        
        <footer>
            <div class="logout">Выход</div>
        </footer>
    </body>
</html>