<%--
  Created by IntelliJ IDEA.
  User: 24309
  Date: 2020/12/31
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String information = (String)session.getAttribute("information");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="../css/commentary.css" />
    <script type="text/javascript" src="../jQuery/jquery.min.js"></script>
    <script>
        $(function () {
            $('.publish').click(function () {
                console.log(1);
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/AddCommentaryServlet",
                    data: {content: $("input[name='content']").val()},
                    dataType: "json",
                    success: function (data) {
                        $("#commentary").empty();
                        var html = "";
                        for (var i = 0; i < data.length; i++) {  //遍历data数组
                            var c = data[i].content;
                            var ui = data[i].userId;
                            html += "<div class='content'>发表用户Id：" + ui + "<br>评论内容：" + c
                                + "<br></div><hr>";
                        }
                        $("#commentary").html(html);
                    },
                    error: function () {
                        console.log('error');
                    }
                })
            })
        })
    </script>
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
        <div id="menu0_4">
            <input type="text" name="搜索栏" id="search" placeholder="请输入搜索内容" disabled="disabled"/>
            <input type="submit" id="searching" value="搜索" style="cursor: pointer;" />
        </div>
        <div id="menu0_3">
            <a href="player.jsp">球员</a>
        </div>
        <div id="menu0_2">
            <a href="user.jsp"><span class="personal normal">首页</span></a>
        </div>
    </div>
</div>
<div id="t">
    <!-- 替代导航栏 -->
</div>
<!--以上为导航栏-->
<div id="body">
    <div class="topic">
        <%out.print(information);%>
    </div>
    <div class="commentary" id="commentary">
        <c:forEach items="${commentaryList}" var="commentary" varStatus="vst">
            <div class="content">
                发表用户Id：${commentary.userId}
                <br>
                评论内容：${commentary.content}
                <br>
            </div>
            <hr>
        </c:forEach>
    </div>
</div>
<div id="publish">
    <input type="text" name="content" placeholder="请输入评论内容">
    <button type="submit" class="publish">
        发表评论
    </button>
</div>
</body>
</html>

