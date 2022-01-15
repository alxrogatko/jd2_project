<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype HTML>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
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

            <a href="/view/${userId}/profile.html">
                <div class="menu-block">
                    <div class="icon">
                        <img src="${pageContext.request.contextPath}/images/user.png" alt="profile">
                    </div>
                    <div class="menu-text">Профиль</div>
                </div>
            </a>

            <a href="/view/friends.html">
                <div class="menu-block">
                    <div class="icon">
                        <img src="${pageContext.request.contextPath}/images/friends.png" alt="profile">
                    </div>
                    <div class="menu-text">Друзья</div>
                </div>
            </a>

            <a href="/view/messages.html">
                <div class="menu-block">
                    <div class="icon">
                        <img src="${pageContext.request.contextPath}/images/message.png" alt="profile">
                    </div>
                    <div class="menu-text">Сообщения</div>
                </div>
            </a>

            <a href="/view/settings.html">
                <div class="menu-block">
                    <div class="icon">
                        <img src="${pageContext.request.contextPath}/images/settings.png" alt="profile">
                    </div>
                    <div class="menu-text">Настройки</div>
                </div>
            </a>

        </div>
    </div>

    <div class="item-avatar">
        <div class="messages-block">
            <c:if test="${showDialogList == true}">
                <div class="show-block-with-messages-list">
                    <div class="search-dialog">

                    </div>

                    <div class="wrapper-dialog-block">
                        <c:forEach items="${dialogList}" var="dialogList">
                            <a href="/view/${dialogList.getId()}/chat.html">
                                <div class="dialog-block">
                                    <div class="dialog-avatar">

                                    </div>
                                    <div class="wrapper-for-dialog-block-content">
                                        <div class="dialog-block-nickname">
                                            <c:if test="${userId == dialogList.getFirstUser()}">
                                                <c:out value="${dialogList.getSecondUserNickname()}"/>
                                            </c:if>
                                            <c:if test="${userId == dialogList.getSecondUser()}">
                                                <c:out value="${dialogList.getFirstUserNickname()}"/>
                                            </c:if>

                                        </div>
                                        <div class="dialog-block-last-message">
                                            <c:out value="${dialogList.getLastMessageSenderNickname()}"/>:
                                            <c:out value="${dialogList.getLastMessage()}"/>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <c:if test="${showChat == true}">
            <div class="show-block-with-open-chat">
                <c:forEach items="${messagesList}" var="messagesList">
                <c:if test="${userId == messagesList.getSenderId()}">
                <div class="wrapper-for-my-message">
                    <div class="my-message">
                        </c:if>
                        <c:if test="${userId != messagesList.getSenderId()}">
                        <div class="wrapper-for-companion-message">
                            <div class="companion-message">
                                </c:if>
                                    ${messagesList.getMessage()}
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    <div class="input-block">
                        <form action="/view/${dialogId}/send.do" accept-charset="UTF-8" method="post">
                            <input type="text" autofocus name="message">
                        </form>
                    </div>
                    </c:if>
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