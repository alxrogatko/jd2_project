<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype HTML>
<html>
    <head>
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Home</title>
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
        <header>
            <a href="profile.jsp">
                <div class="logo">Логотип</div>
            </a>
            <div class="search">Поиск</div>
        </header>
        
        <div class="content">
            <div class="item-menu">
                <div class="menu">
                
                <a href="/home.jsp">  
                    <div class="menu-block">
                        <div class="icon">
                            <img src="../images/user.png" alt="profile">
                        </div>
                        <div class="menu-text">Профиль</div>
                    </div>
                </a>
                
                <a href="friends.jsp">
                    <div class="menu-block">
                        <div class="icon">
                            <img src="../images/friends.png" alt="profile">
                        </div>
                        <div class="menu-text">Друзья</div>
                    </div>
                </a>
                
                <a href="messages.jsp">
                    <div class="menu-block">
                        <div class="icon">
                            <img src="../images/message.png" alt="profile">
                        </div>
                        <div class="menu-text">Сообщения</div>
                    </div>
                </a>
                
                <a href="settings.jsp">
                    <div class="menu-block">
                        <div class="icon">
                            <img src="../images/settings.png" alt="profile">
                        </div>
                        <div class="menu-text">Настройки</div>
                    </div>
                </a>
                
            </div>
            </div>
            
            <div class="item-avatar">
                <div class="messages-block">
                    <div class="show-block">
                        
                    </div>
                    <div class="input-block">
                        <form action="/send.do" method="post">
                        <input type="text">
                            </form>
                    </div>
                </div>
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