<%--
  Created by IntelliJ IDEA.
  User: Hao.Qian
  Date: 2017/11/27
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js" charset="UTF-8"></script>
    <script>
        $(document).ready(function () {
            //绑定光标移除事件，输入用户名不存在时发送警告
            $("#phone").blur(function () {
                var phone = $("#phone").val();
                var url = "/user/findPhone.do";
                var params={"phone":phone};
                $.post(url,params,function (result) {
                    if (result !== "exist")
                        alert("用户名不存在");
                })
            });
            $("#button").click(function () {
                var url = "/user/loginIn.do";
                var params = {"phone":$("#phone").val(),"pwd":$("#pwd").val()};
                $.post(url,params,function (result) {
                    if(result === "error"){
                        alert("密码错误,重新输入");
                        return false;
                    }else {
                        //登录成功后将手机号存入sessionStorage，并跳转到消息页面
                        sessionStorage.setItem("phone",result);
                        window.location.href = "/user/messages.do";
                    }

                })
            });
        });




    </script>
</head>
<body>
<h2 align=center>欢迎您</h2>
<center>
    <form action="/user/loginIn.do" method="post">
        <table border="1">
            <tr>
                <td>手机号：</td>
                <td><input type="text" name="phone" id="phone"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="pwd" id="pwd" type="password"></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input id="button" type="button" value="点击登陆"></td>
            </tr>
        </table>
    </form>
    <a href="/user/register.do">点击注册</a>
</center>
</body>
</html>
