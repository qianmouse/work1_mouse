<%--
  Created by IntelliJ IDEA.
  User: Hao.Qian
  Date: 2017/12/12
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js" charset="UTF-8"></script>
    <script>
        var phone = sessionStorage.getItem("phone");
        $(document).ready(function () {
            $("#h2").html("当前用户："+phone);
            $("#index").attr("href","/user/messages.do?phone="+phone);
            $("#button").on("click",newRole);
        });

        function newRole() {
            var role = $("#role").val();
            $.post("/user/roleName.do",{"role":role},function (str) {
                if("rename" === str){
                    alert("角色名已存在！");
                    $("#role").val("");
                    return false;
                }
                var permission = $("#permission").val();
                var url = "/user/newRole.do";
                var params = {"role":role,"permission":permission};
                $.post(url,params,function () {
                    alert("新建成功");
                    window.location.href = "/user/role.do";
                })
            });
        }

    </script>
</head>
<body>
<h2 id="h2"></h2>
<center>
    <a href="/user/login.do">退出登录</a>
    <a href="" id="index">我的消息</a>
    <a href="/messages/forum.do">进入论坛</a>
    <a href="/user/toManage.do">用户管理</a>


    <h3>角色管理</h3>
    <table border="1" width="800px">
        <tr>
            <td>角色</td>
            <td>权限</td>
        </tr>
        <c:forEach var="role" items="${list}">
            <tr id="${role.role}">
                <td>${role.role}</td>
                <td>${role.permission}</td
            </tr>
        </c:forEach>
    </table>

    <h3>新建角色</h3>
    <form action="" method="post">
        <table border="1">
            <tr>
                <td>角色名：</td>
                <td><input type="text" name="role" id="role"></td>
            </tr>
            <tr>
                <td>权限：</td>
                <td>
                    <select name="permission" id="permission">
                        <option value="无" selected="selected">无</option>
                        <option value="编辑">编辑</option>
                        <option value="删除">删除</option>
                        <option value="编辑删除">编辑删除</option>
                    </select>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2"><button id="button" type="button">新建</button></td>
            </tr>
        </table>
    </form>

</center>
</body>
</html>
