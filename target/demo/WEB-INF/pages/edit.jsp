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
            $("#button").click(function () {
                var title = $("#title").val();
                var date = new Date();
                var text = $("#text").val();
                var phone = sessionStorage.getItem("phone");
                var url = "/messages/saveMes.do";
                var params = {"title":title,"date":date,"text":text,"phone":phone};
                console.log(params);
                $.post(url,params,function () {
                    alert("保存成功");
                    window.location.href = "/user/messages.do";
                })
            })
        })

    </script>
</head>
<body>
<form action="" method="post">
    <table border="1">
        <tr>
            <td>title：</td>
            <td><input type="text" name="title" id="title"></td>
        </tr>
        <tr>
            <td>text：</td>
            <td><input name="text" id="text"></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input id="button" type="button" value="点击保存"></td>
        </tr>
    </table>
</form>

</body>
</html>
