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
        $(document).ready(function () {
            //获得sessionStorage中绑定的手机号
            var phone = sessionStorage.getItem("phone");
            $("#h2").html("当前用户："+phone);

        });
    </script>
</head>
<body>

<h2 id="h2"></h2>
<a href="/user/login.do">退出登录</a>
<a href="/messages/edit.do">新增消息</a>
<a href="/user/messages.do">我的消息</a>

</body>
</html>
