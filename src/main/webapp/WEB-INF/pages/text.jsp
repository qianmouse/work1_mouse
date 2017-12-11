<%--
  Created by IntelliJ IDEA.
  User: Hao.Qian
  Date: 2017/12/11
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js" charset="UTF-8"></script>
    <script>
        $(document).ready(function () {
            //获得sessionStorage中绑定的手机号
            var phone = sessionStorage.getItem("phone");
            $("#h2").html("当前用户："+phone)
            $(".editData").on("click",editData);
        });

        function editData() {
            var mid = $("#mid").val();
            var url = "/messages/editMes.do";
            window.location.href = url+"?mid="+mid;
        }
    </script>
    <style>
        div{
            width: 300px;
            border:1px solid #F00;
        }
    </style>
</head>
<body>
<h2 id="h2"></h2>
<a href="/user/login.do">退出登录</a>
<a href="/messages/edit.do">新增消息</a>
<a href="/user/messages.do">我的消息</a>
<center>
    <h2>${mes.title}</h2>
    作者：${mes.phone}|时间：${mes.date.toLocaleString()}
    <div>${mes.text}</div>
    <button type='button' class='editData'>修改</button>
    <input id="mid" type="hidden" value="${mes.mid}">

</center>

</body>
</html>
