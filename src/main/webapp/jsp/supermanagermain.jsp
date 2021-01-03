<%--
  Created by IntelliJ IDEA.
  User: 24309
  Date: 2020/12/31
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="../css/supermanagermain.css" />
    <script type="text/javascript" src="../jQuery/jquery.min.js"></script>
    <script>
        $(function () {
            $('.u1').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/GLZServlet",
                    data: {userId: $("input[name='userId']").val(),Id:$("input[name='Id']").val()},
                    dataType: "json",
                    success: function (data) {
                        $(".user").empty();
                        var html = "";
                        for (var i = 0; i < data.length; i++) {  //遍历data数组
                            var un = data[i].userName;
                            var e = data[i].email;
                            var ui = data[i].userId;
                            var m = data[i].money;
                            var c =  data[i].character;
                            html += "<div class='users'>编号：" + ui + "<br>昵称：" + un + "<br>邮箱：" + e +
                                "<br>角色：" + c + "<br>余额" + m + "</div><hr>"
                        }
                        $(".user").html(html);
                    },
                    error: function () {
                        console.log('error');
                    }
                })
            })
            $('.u2').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/GLYServlet",
                    data: {userId: $("input[name='userId']").val(),Id:$("input[name='Id']").val()},
                    dataType: "json",
                    success: function (data) {
                        $(".user").empty();
                        var html = "";
                        for (var i = 0; i < data.length; i++) {  //遍历data数组
                            var un = data[i].userName;
                            var e = data[i].email;
                            var ui = data[i].userId;
                            var m = data[i].money;
                            var c =  data[i].character;
                            html += "<div class='users'>编号：" + ui + "<br>昵称：" + un + "<br>邮箱：" + e +
                                "<br>角色：" + c + "<br>余额" + m + "</div><hr>"
                        }
                        $(".user").html(html);
                    },
                    error: function () {
                        console.log('error');
                    }
                })
            })
            $('.u3').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/DeleteUserServlet",
                    data: {userId: $("input[name='userId']").val()},
                    dataType: "json",
                    success: function (data) {
                        $(".user").empty();
                        var html = "";
                        for (var i = 0; i < data.length; i++) {  //遍历data数组
                            var un = data[i].userName;
                            var e = data[i].email;
                            var ui = data[i].userId;
                            var m = data[i].money;
                            var c = data[i].character;
                            html += "<div class='users'>编号：" + ui + "<br>昵称：" + un + "<br>邮箱：" + e +
                                "<br>角色：" + c + "<br>余额" + m + "</div><hr>"
                        }
                        $(".user").html(html);
                    },
                    error: function () {
                        console.log('error');
                    }
                })
            })
            $('.r1').click(function () {
                    $.ajax({
                        type: "GET",
                        url: "/player_war_exploded/DeleteReportServlet",
                        data: {topicId: $("input[name='topicId']").val()},
                        dataType: "json",
                        success: function (data) {
                            $(".report").empty();
                            var html = "";
                            for (var i = 0; i < data.length; i++) {  //遍历data数组
                                var ti = data[i].topicId;
                                var s = data[i].session;
                                var ui = data[i].userId;
                                html += "<div class='reports'>话题话题Id：" + ti + "<br>话题标题："
                                    + s + "<br>发起用户Id：" + ui + "</div><hr>"
                            }
                            $(".report").html(html);
                        },
                        error: function () {
                            console.log('error');
                        }
                    })
            })
            $('.r2').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/CancelReportServlet",
                    data: {topicId: $("input[name='topicId']").val()},
                    dataType: "json",
                    success: function (data) {
                        $(".report").empty();
                        var html = "";
                        for (var i = 0; i < data.length; i++) {  //遍历data数组
                            var ti = data[i].topicId;
                            var s = data[i].session;
                            var ui = data[i].userId;
                            html += "<div class='reports'>话题话题Id：" + ti + "<br>话题标题："
                                + s + "<br>发起用户Id：" + ui + "</div><hr>"
                        }
                        $(".report").html(html);
                    },
                    error: function () {
                        console.log('error');
                    }
                })
            })
            $('.p1').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/ChangeTypeServlet",
                    data: {playersId: $("input[name='playersId']").val(),typesId: $("input[name='typesId']").val()},
                    dataType: "json",
                    success: function (data) {
                        $(".player").empty();
                        var html = "";
                        for (var i = 0; i < data.length; i++) {  //遍历data数组

                            var info = data[i].information;
                            var pi = data[i].playerId;
                            var ti = data[i].typeId;
                            html += "<div class='players'>球员Id：" + pi + "<br>球员信息："
                                + info + "<br>类别Id：" + ti + "</div><hr>"
                        }
                        $(".player").html(html);
                    },
                    error: function () {
                        console.log('error');
                    }
                })
            })
            $('.p2').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/AddPlayerServlet",
                    data: {information: $("input[name='information']").val(),typesId: $("input[name='typesId']").val()},
                    dataType: "json",
                    success: function (data) {
                        $(".player").empty();
                        var html = "";
                        for (var i = 0; i < data.length; i++) {  //遍历data数组

                            var info = data[i].information;
                            var pi = data[i].playerId;
                            var ti = data[i].typeId;
                            html += "<div class='players'>球员Id：" + pi + "<br>球员信息："
                                + info + "<br>类别Id：" + ti + "</div><hr>"
                        }
                        $(".player").html(html);
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
            <input type="text" name="搜索栏" id="search" placeholder="请输入搜索内容" disabled/>
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
    <div id="user">
        <span>用户管理</span>
        <hr>
        <div class="user">
            <c:forEach items="${usersList}" var="user" varStatus="vst">
                <div class="users">
                    编号：${user.userId}
                    <br>
                    昵称：${user.userName}
                    <br>
                    邮箱：${user.email}
                    <br>
                    角色：（1.普通会员    2.管理者    3.管理员）${user.character}
                    <br>
                    余额：${user.money}
                </div>
                <hr>
            </c:forEach>
        </div>
        <div class="func">
            <div class="userposition">
                <br><br>
                <input type="text" placeholder="请输入用户Id" name="userId">
                <input type="text" placeholder="请输入typeId或playerId" name="Id">
                <br><br>
                <button type="submit" class="u1">管理者</button>
                <button type="submit" class="u2">管理员</button>
                <button type="submit" class="u3">删除</button>
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <div id="report">
        <span>举报处理</span>
        <div class="report">
            <c:forEach items="${reportList}" var="topic" varStatus="vst">
                <div class="reports">
                    话题Id：${topic.topicId}
                    <br>
                    话题标题：${topic.session}
                    <br>
                    发起用户Id：${topic.userId}
                    <br>
                    被举报
                </div>
                <hr>
            </c:forEach>
<%--            <c:forEach items="${unreportList}" var="topic" varStatus="vst">--%>
<%--                <div class="reports">--%>
<%--                    话题Id：${topic.topicId}--%>
<%--                    <br>--%>
<%--                    话题标题：${topic.session}--%>
<%--                    <br>--%>
<%--                    发起用户Id：${topic.userId}--%>
<%--                    <br>--%>
<%--                </div>--%>
<%--                <hr>--%>
<%--            </c:forEach>--%>
        </div>
        <div class="func">
            <div class="reportposition">
                <br><br>
                <input type="text" placeholder="请输入话题Id" name="topicId">
                <br><br>
                <button type="submit" class="r1">删除</button>
                <button type="submit" class="r2">取消举报</button>
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <div id="type">
        <span>球员分类</span>
        <div class="player">
            <c:forEach items="${playersList}" var="player" varStatus="vst">
                <div class="players">
                    球员Id：${player.playerId}
                    <br>
                    球员信息：${player.information}
                    <br>
                    球员类别：（1.PG    2.SG    3.SF    4.PF    5.C）${player.typeId}
                </div>
                <hr>
            </c:forEach>
        </div>
        <div class="func">
            <div class="playerposition">
                <br><br>
                <input type="text" placeholder="请输入球员Id" name="playersId">
                <input type="text" placeholder="请输入类别Id" name="typesId">
                <input type="text" placeholder="请输入新增球员信息" name="information">
                <br><br>
                <button type="submit" class="p1">分组</button>
                <button type="submit" class="p2">增加</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%--
json,ajax,分类,功能
--%>