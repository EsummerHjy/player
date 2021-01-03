<%--
  Created by IntelliJ IDEA.
  User: 24309
  Date: 2020/12/31
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int identity=0;
%>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="../css/player.css" />
    <script type="text/javascript" src="../jQuery/jquery.min.js"></script>
    <script>
        $(function () {
            $('.type1').click(function () {
                $.ajax({
                    type:"GET",
                    url:"/player_war_exploded/PlayerType02Servlet",
                    data:{type:'PG'},
                    dataType:"json",
                    success:function (data) {
                        console.log('success');
                        var html = "";
                        for(var i=0;i<data.length;i++){  //遍历data数组
                            var ls = data[i].information;
                            html +="<div class='infomation'>"+ls+"</div><hr>";
                            console.log(ls);
                        }
                        $("#players").html(html);
                    },
                    error:function () {
                        console.log('error');
                    }
                })
            })
            $('.type2').click(function () {
                $.ajax({
                    type:"GET",
                    url:"/player_war_exploded/PlayerType02Servlet",
                    data:{type:'SG'},
                    dataType:"json",
                    success:function (data) {
                        console.log('success');
                        var html = "";
                        for(var i=0;i<data.length;i++){  //遍历data数组
                            var ls = data[i].information;
                            html +="<div class='infomation'>"+ls+"</div><hr>";
                            console.log(ls);
                        }
                        $("#players").html(html);
                    },
                    error:function () {
                        console.log('error');
                    }
                })
            })
            $('.type3').click(function () {
                $.ajax({
                    type:"GET",
                    url:"/player_war_exploded/PlayerType02Servlet",
                    data:{type:'SF'},
                    dataType:"json",
                    success:function (data) {
                        console.log('success');
                        var html = "";
                        for(var i=0;i<data.length;i++){  //遍历data数组
                            var ls = data[i].information;
                            html +="<div class='infomation'>"+ls+"</div><hr>";
                            console.log(ls);
                        }
                        $("#players").html(html);
                    },
                    error:function () {
                        console.log('error');
                    }
                })
            })
            $('.type4').click(function () {
                $.ajax({
                    type:"GET",
                    url:"/player_war_exploded/PlayerType02Servlet",
                    data:{type:'PF'},
                    dataType:"json",
                    success:function (data) {
                        console.log('success');
                        var html = "";
                        for(var i=0;i<data.length;i++){  //遍历data数组
                            var ls = data[i].information;
                            html +="<div class='infomation'>"+ls+"</div><hr>";
                            console.log(ls);
                        }
                        $("#players").html(html);
                    },
                    error:function () {
                        console.log('error');
                    }
                })
            })
            $('.type5').click(function () {
                $.ajax({
                    type:"GET",
                    url:"/player_war_exploded/PlayerType02Servlet",
                    data:{type:'C'},
                    dataType:"json",
                    success:function (data) {
                        console.log('success');
                        var html = "";
                        for(var i=0;i<data.length;i++){  //遍历data数组
                            var ls = data[i].information;
                            html +="<div class='infomation'>"+ls+"</div><hr>";
                            console.log(ls);
                        }
                        $("#players").html(html);
                    },
                    error:function () {
                        console.log('error');
                    }
                })
            })
            $('.collects').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/CollectServlet",
                    data: {playerId: $("input[name='playerId']").val()},
                    dataType: "json",
                    success:function (data) {
                        if (data[0] == 1)
                            alert('收藏成功');
                    }
                })
            })
            $('.uncollects').click(function () {
                $.ajax({
                    type: "GET",
                    url: "/player_war_exploded/UnCollectServlet",
                    data: {playerId: $("input[name='playerId']").val()},
                    dataType: "json",
                    success:function (data) {
                        if (data[0] == 1)
                            alert('取消成功');
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
            <a href="user.jsp"><span class="personal normal">首页</span></a>
        </div>
    </div>
</div>
<div id="t">
    <!-- 替代导航栏 -->
</div>
<!--以上为导航栏-->
<div id="body">
<%--    <form action="/player_war_exploded/PlayerTypeServlet">--%>
<%--    <div id="type">--%>
<%--        类别--%>
<%--        <div class="pg" >--%>
<%--            <button type="submit" onclick="loadXMLDoc()" name="type" value="PG">--%>
<%--                PG--%>
<%--&lt;%&ndash;                <%identity=1;%>&ndash;%&gt;--%>
<%--            </button>--%>
<%--        </div>--%>
<%--        <div class="sg">--%>
<%--            <button type="submit" onclick="loadXMLDoc()" name="type" value="SG">--%>
<%--                SG--%>
<%--&lt;%&ndash;                <%identity=2;%>&ndash;%&gt;--%>
<%--            </button>--%>
<%--        </div>--%>
<%--        <div class="sf">--%>
<%--            <button type="submit" onclick="loadXMLDoc()" name="type" value="SF">--%>
<%--                SF--%>
<%--&lt;%&ndash;                <%identity=3;%>&ndash;%&gt;--%>
<%--            </button>--%>
<%--        </div>--%>
<%--        <div class="pf">--%>
<%--            <button type="submit" onclick="loadXMLDoc()" name="type" value="PF">--%>
<%--                PF--%>
<%--&lt;%&ndash;                <%identity=4;%>&ndash;%&gt;--%>
<%--            </button>--%>
<%--        </div>--%>
<%--        <div class="c">--%>
<%--            <button type="submit" onclick="loadXMLDoc()" name="type" value="C">--%>
<%--                C--%>
<%--&lt;%&ndash;                <%identity=5;%>&ndash;%&gt;--%>
<%--            </button>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div id="type">
        类别
            <div class="pg" >
                <button type="submit" name="type1" class="type1" value="PG">
                    PG
                    <%--                <%identity=1;%>--%>
                </button>
            </div>
            <div class="sg">
                <button type="submit" name="type2" class="type2" value="SG">
                    SG
                    <%--                <%identity=2;%>--%>
                </button>
            </div>
            <div class="sf">
                <button type="submit" name="type3" class="type3" value="SF">
                    SF
                    <%--                <%identity=3;%>--%>
                </button>
            </div>
            <div class="pf">
                <button type="submit" name="type4" class="type4" value="PF">
                    PF
                    <%--                <%identity=4;%>--%>
                </button>
            </div>
            <div class="c">
                <button type="submit" name="type5" class="type5" value="C">
                    C
                    <%--                <%identity=5;%>--%>
                </button>
            </div>
    </div>
    <div class="players" id="players">

    </div>
    <div id="collect" name="news">
        <input type="text" name="playerId" placeholder="请输入球员Id">
        <button type="submit" class="collects">
            收藏
        </button>
        <button type="submit" class="uncollects">
            取消收藏
        </button>
    </div>
</div>
</body>
</html>
<%--分类--%>