<%--
  Created by IntelliJ IDEA.
  User: Hao.Qian
  Date: 2017/12/11
  Time: 13:45
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
            //获得sessionStorage中绑定的手机号
            $("#index").attr("href","/user/messages.do?phone="+phone);
            $("#h2").html("当前用户："+phone)
            $(".editData").on("click",editData);
            $(".delData").on("click",delData);
            $(".delCom").on("click",delCom);
            $("#put").on("click",putCom);
        });

        function putCom() {
            var mid = $("#mid").val();
            var url = "/comment/putCom.do";
            var comment = $("#comment").val();
            var params = {"comment":comment,"mid":mid,"phone":phone};
            $.post(url,params,function () {
                alert("评论成功");
                window.location.href = "/messages/findText.do?mid="+mid;
            });

        }

        function delCom() {
            var mid = $("#mid").val();
            var url = "/comment/delComByCid.do";
            var cid = $(this).attr('name');
            var params = {"cid":cid,"mid":mid};
            $.post(url,params,function () {
                alert("删除成功");
                //删除消息后重新获得显示消息
                window.location.href = "/messages/findText.do?mid="+mid;
            });
        }

        function delData() {
            var mid = $("#mid").val();
            var url = "/messages/delMes.do";
            var params={"mid":mid};
            $.post(url,params,function () {
                alert("删除成功");
                //删除消息后重新获得显示消息
                window.location.href = "/messages/forum.do";
            })
        }

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
<center>
    <a href="/user/login.do">退出登录</a>
    <a href="" id="index">我的消息</a>
    <a href="/messages/forum.do">进入论坛</a>

    <h2>${mes.title}</h2>
    作者：${mes.phone}|时间：${mes.date.toLocaleString()}
    <div style="text-align: left"><p>${mes.text}</p></div>
    <button type='button' class='editData'>修改</button>
    <button type='button' class='delData'>删除</button>
    <input id="mid" type="hidden" value="${mes.mid}">

    <c:forEach var="list" items="${list}">
        <div style="text-align: left">
            <h6>${list.phone}(${list.cdate.toLocaleString()})：</h6>
            <p>${list.comment}<p/>
            <button name="${list.cid}" type="button" class="delCom">删除</button>
        </div>
    </c:forEach>



    <div>
        <textarea id="comment" name="comment"></textarea><input id="put" type="button" value="评论">
    </div>


</center>

</body>
</html>
