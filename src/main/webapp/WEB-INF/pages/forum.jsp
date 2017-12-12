<%--
  Created by IntelliJ IDEA.
  User: Hao.Qian
  Date: 2017/12/11
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js" charset="UTF-8"></script>
    <script>
        //获得sessionStorage中绑定的手机号
        var phone = sessionStorage.getItem("phone");
        $(document).ready(function () {
            $("#index").attr("href","/user/messages.do?phone="+phone);
            $("#h2").html("当前用户："+phone);
            $(".delData").on("click",delData);
            $(".SeeData").on("click",SeeData);
            $("#manage").on("click",manage);

        });

        //进入管理员界面
        function manage() {
            var url = "/user/manage.do";
            var params = {"phone":phone};
            $.post(url,params,function (role) {
                if ("isManager" !== role){
                    alert("你不是管理员");
                    return false;
                }
                window.location.href = "/user/toManage.do";
            })
        }

        //根据title删除消息
        function delData() {
            var mid = $(this).parent().parent().attr('id');
            var url = "/messages/delMes.do";
            var params={"mid":mid};
            $.post(url,params,function () {
                alert("删除成功");
                //删除消息后重新获得显示消息
                window.location.href = "/messages/forum.do";
            })
        }

        //查看消息正文
        function SeeData() {
            var mid = $(this).parent().parent().attr('id');
            var url = "/messages/findText.do";
            window.location.href = url+"?mid="+mid;
        }
    </script>
</head>
<body>

<h2 id="h2"></h2>
<center>
<a href="/user/login.do">退出登录</a>
    <a href="" id="index">我的消息</a>
    <button type="button" id="manage">管理用户</button>
<h3>论坛</h3>
<table border="1" width="800px">
    <tr>
        <td>title</td>
        <td>作者</td>
        <td>date</td>
        <td>评论数</td>
        <td>最后评论时间</td>
        <td>操作</td>
    </tr>
    <c:forEach var="mes" items="${list}">
        <tr id="${mes.mid}">
            <td>${mes.title}</td>
            <td>${mes.phone}</td>
            <td>${mes.date.toLocaleString()}</td>
            <td>${mes.count}</td>
            <td>${mes.cdate.toLocaleString()}</td>
            <td>
                <button type='button' class='delData'>删除</button>
                <button type='button' class='SeeData'>查看</button>
            </td>
        </tr>
    </c:forEach>
</table>
</center>
</body>
</html>
