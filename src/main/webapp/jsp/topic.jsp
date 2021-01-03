<%--
  Created by IntelliJ IDEA.
  User: 24309
  Date: 2020/12/31
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String information = (String)session.getAttribute("information");
    String character = (String)session.getAttribute("character");
    Integer uplayerId = (Integer)session.getAttribute("uplayerId");
    Integer playerId = (Integer)session.getAttribute("playerId");
    Integer utypeId = (Integer)session.getAttribute("utypeId");
    Integer typeId = (Integer)session.getAttribute("typeId");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="../css/topic.css" />
    <script type="text/javascript" src="../jQuery/jquery.min.js"></script>
    <script>
        $(function () {
            $('.initiate').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/AddTopicServlet",
                    data: {information: $("input[name='information']").val()},
                    dataType: "json",
                    success: function (data) {
                        $("#topics").empty();
                        var html = "";
                        for (var i = 0; i < data.length; i++) {  //遍历data数组
                            var ti = data[i].topicId;
                            var s = data[i].session;
                            var ui = data[i].userId;
                            html += "<div class='infomation'>话题Id：" + ti + "<br>话题标题：" + s
                            + "<br>发起用户Id：" + ui +"</div><hr>";
                        }
                        $("#topics").html(html);
                    },
                    error: function () {
                        console.log('error');
                    }
                })
            })
            $('.reports').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/ReportTopicServlet",
                    data: {topicId: $("input[name='report']").val()},
                    dataType: "json",
                    success:function (data) {
                        if (data[0] == 1){
                            alert('举报成功！');
                        }
                        else if(data[0] == 0){
                            alert('举报失败！');
                        }
                    }
                })
            })
            $('.deletes').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/DeleteTopicServlet",
                    data: {topicId: $("input[name='delete']").val(),session:$("div[class='player']").text()},
                    dataType: "json",
                    success:function (data) {
                        $("#topics").empty();
                        var html = "";
                        for (var i = 0; i < data.length; i++) {  //遍历data数组
                            var ti = data[i].topicId;
                            var s = data[i].session;
                            var ui = data[i].userId;
                            html += "<div class='infomation'>话题Id：" + ti + "<br>话题标题：" + s
                                + "<br>发起用户Id：" + ui +"</div><hr>";
                        }
                        $("#topics").html(html);
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
        <form action="/player_war_exploded/CommentaryServlet">
            <div id="menu0_4">
                <input type="text" name="search" id="search" placeholder="搜索话题(Id)"/>
                <input type="submit" id="searching" name="searching" value="搜索" style="cursor: pointer;" />
            </div>
        </form>
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
    <div class="player"><%out.print(information);%></div>
    <div class="topics" id="topics">
        <%out.print(uplayerId);out.print(playerId);out.print(utypeId);out.print(typeId);out.print(character);%>
        <c:forEach items="${topictopList}" var="topic" varStatus="vst">
            <div class="infomation">
                话题Id：${topic.topicId}
                <br>
                话题标题：${topic.session}
                <br>
                发起用户Id：${topic.userId}
                <br>
                已置顶
            </div>
            <hr>
        </c:forEach>
        <c:forEach items="${topicuntopList}" var="topic" varStatus="vst">
            <div class="infomation">
                话题Id：${topic.topicId}
                <br>
                话题标题：${topic.session}
                <br>
                发起用户Id：${topic.userId}
                <br>
            </div>
            <hr>
        </c:forEach>
    </div>
    <div id="initiate" name="news">
        <input type="text" name="information" placeholder="请输入话题标题">
        <button type="submit" class="initiate">
         发起话题
        </button>
        <input type="text" name="report" placeholder="请输入要举报的话题Id">
        <button type="submit" class="reports">
            举报他！
        </button>

<%--        <%if ((character.equals("管理者")&&(playerId==uplayerId))||((character.equals("管理员"))&&(typeId==utypeId))){%>--%>
        <%--        <%if(1 == 1){%>--%>
        <%if(playerId.equals(uplayerId)||typeId.equals(utypeId)){%>
        <input type="text" name="delete" placeholder="请输入要删除的话题Id">
        <button type="submit" class="deletes">
            执行权限，删除他！
        </button>
        <%}%>
    </div>
</div>
</body>
</html>
