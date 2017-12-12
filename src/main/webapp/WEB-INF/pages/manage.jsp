<%--
  Created by IntelliJ IDEA.
  User: Hao.Qian
  Date: 2017/12/12
  Time: 11:17
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
            $("#h2").html("当前用户："+phone);
            $("#index").attr("href","/user/messages.do?phone="+phone);
            $(".alter").on("click",function () {
                var userPhone = $(this).parent().parent().attr('id');
                var identity = $(this).prev().prev().val();
                var role = $(this).prev().val();
                var params = {"phone":userPhone,"identity":identity,"role":role};
                var url = "/user/alterUser.do";
                $.post(url,params,function () {
                    alert("修改成功");
                    window.location.href = "/user/toManage.do";
                });
            });

        });
    </script>
</head>
<body>
<h2 id="h2"></h2>
<center>
    <a href="/user/login.do">退出登录</a>
    <a href="" id="index">我的消息</a>
    <a href="/messages/forum.do">进入论坛</a>
    <a href="/user/role.do">角色管理</a>

    <h3>用户管理</h3>

    <table border="1" width="800px">
        <tr>
            <td>用户</td>
            <td>身份</td>
            <td>角色</td>
            <td>操作</td>
        </tr>
        <c:forEach var="user" items="${list}">
            <tr id="${user.phone}">
                <td>${user.phone}</td>
                <td>${user.identity}</td>
                <td>${user.role}</td>
                <td>
                    身份：
                    <select name="identity" id="identity">
                        <option value="user">user</option>
                        <option value="manager">manager</option>
                    </select>
                    角色：
                    <select name="role" id="role">
                        <c:forEach var="role" items="${roleList}">
                            <option value="${role.role}">${role.role}</option>
                        </c:forEach>
                    </select>
                    <button type="button" class="alter">修改</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</center>
</body>
</html>
