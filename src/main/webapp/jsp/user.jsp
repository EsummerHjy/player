<%@ page import="com.sun.org.apache.bcel.internal.generic.LDIV" %><%--
  Created by IntelliJ IDEA.
  User: 24309
  Date: 2020/12/31
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String name = (String)session.getAttribute("userName");
    Integer Id = (Integer) session.getAttribute("userId");
    String email = (String)session.getAttribute("email");
    String character = (String)session.getAttribute("character");
    Integer money = (Integer) session.getAttribute("money");
    Integer playerId = (Integer)session.getAttribute("playerId");
    Integer typeId = (Integer) session.getAttribute("typeId");
    String identity = (String) session.getAttribute("identity");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="../css/user.css" />

</head>
<body>
<div id="top">
    <div id="topcenter">
        <div id="menu0_1">
            <img src="../image/导航栏篮球.jpg" height="100px" align="center"/>
            球员信息交流平台
        </div>
        <div id="menu0_5">
            <a href="/player_war_exploded/html/login.html"><img src="../image/个人.jpg" height="40px" align="top"></a>
        </div>
        <form action="/player_war_exploded/TopicServlet">
        <div id="menu0_4">
            <input type="text" name="search" id="search" placeholder="搜索球员"/>
            <input type="submit" id="searching" name="searching" value="搜索" style="cursor: pointer;" />
        </div>
        </form>
        <div id="menu0_3">
            <a href="player.jsp">球员</a>
        </div>
        <div id="menu0_2">
            <a href="user.jsp"><span class="personal">首页</span></a>
        </div>
        <script type="text/javascript" src="../jQuery/jquery.min.js"></script>
        <script type="text/javascript">
            var $personal=$('.personal');
            $personal.hover(function() {
                // 鼠标移入时添加hover类
                $personal.addClass("on");
            }, function() {
                // 鼠标移出时移出hover类
                $personal.removeClass("on");
            });
        </script>
    </div>
</div>
<div id="t">
    <!-- 替代导航栏 -->
</div>
<!--以上为导航栏-->
<div id="body">
    <br>
    <br>
    <div class="personalinformation">
				<span class="myinformation">
					我的信息
				</span>
        <hr class="line">
        <div class="mypicture">
            <img src="../image/篮球2.jpg" align="center">
        </div>
        <div class="myName">
            我的昵称:
        </div>
        <div id="myName">
            <%out.print(name);%>
        </div>
        <br>
        <hr class="line">
        <div class="myId">
            我的编号：
        </div>
        <div id="myId">
            <%out.print(Id);%>
        </div>
        <br>
        <hr class="line">
        <div class="myEmail">
            我的邮箱：
        </div>
        <div id="myEmail">
            <%out.print(email);%>
        </div>
        <br>
        <hr class="line">
        <div class="myCharacter">
            我的角色：
        </div>
        <div id="myCharacter">
            <%out.print(character);%>
        </div>
        <br>
        <hr class="line">
        <div class="myMoney">
            我的余额：
        </div>
        <div id="myMoney">
            <%out.print(money);%>
        </div>
        <br>
        <hr class="line">
        <div class="myPlayerId">
            管理球员编号：
        </div>
        <div id="myPlayerId">
            <%out.print(playerId);%>
        </div>
        <br>
        <hr class="line">
        <div class="myTopicId">
            管理球员类别编号：
        </div>
        <div id="myTopicId">
            <%out.print(typeId);%>
        </div>
        <br>
        <hr class="line">
    </div>
    <br />
    <br />
    <br />
    <br />
    <div id="collect">
        <c:forEach items="${playerList}" var="player" varStatus="vst">
            <div class="infomation">
                ${player.information}
            </div>
            <hr>
        </c:forEach>
    </div>
</div>

</body>
</html>
<%--jQuery--%>