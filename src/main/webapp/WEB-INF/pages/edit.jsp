<%--
  Created by IntelliJ IDEA.
  User: Hao.Qian
  Date: 2017/12/4
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js" charset="UTF-8"></script>
    <script>
        $(document).ready(function () {
            var phone = sessionStorage.getItem("phone");
            $("#h2").html("当前用户："+phone);
            $("#index").attr("href","/user/messages.do?phone="+phone);
            $("#button").click(function () {
                var title = $("#title").val();
                var text = $("#text").val();
                var mid = $(this).parent().parent().attr('id');
                console.log(text);
                console.log(title);
                console.log(mid);
                var url = "/messages/edit.do";
                var params = {"title":title,"text":text,"mid":mid};
                $.post(url,params,function () {
                    alert("保存成功");
                    window.location.href = "/messages/findText.do?mid="+mid;
                })
            })
        })

    </script>
</head>
<body>
<h2 id="h2"></h2>
<center>
<a href="/user/login.do">退出登录</a>
    <a href="" id="index">我的消息</a>
<form action="" method="post">
    <table border="1">
        <tr>
            <td>title：</td>
            <td><input type="text" name="title" id="title" value="${mes.title}"></td>
        </tr>
        <tr>
            <td>text：</td>
            <td><textarea name="text" id="text">${mes.text}</textarea></td>
        </tr>
        <tr align="center" id="${mes.mid}">
            <td colspan="2"><input id="button" type="button" value="点击保存"></td>
        </tr>
    </table>
</form>
</center>
</body>
</html>
