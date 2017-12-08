<%--
  Created by IntelliJ IDEA.
  User: Hao.Qian
  Date: 2017/11/28
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>messages</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js" charset="UTF-8"></script>
    <script>
        $(document).ready(function () {
            //获得sessionStorage中绑定的手机号
            var phone = sessionStorage.getItem("phone");
            $("#h2").html("当前用户："+phone);
            //消息展现
            findMes();


        });


        //根据title删除消息
        function delData() {
            var title = $(this).parent().parent().attr('id');
            var url = "/messages/delMes.do";
            var params={"title":title};
            $.post(url,params,function () {
                alert("删除成功");
                //删除消息后重新获得显示消息
                findMes();
            })
        }

        //查看消息正文，显示在div中
        function SeeData() {
            var title = $(this).parent().parent().attr('id');
            var url = "/messages/findText.do";
            var params={"title":title};
            $.post(url,params,function (text) {
                $("#div").html(text);
            })

        }

        //根据手机号获得消息集合
        function findMes() {
            var phone = sessionStorage.getItem("phone");
            var url = "/messages/findMes.do";
            var params={"phone":phone};
            $.post(url,params,function (result) {
                //调用setTableMes方法插入表格
                setTableMes(result);
            })
        }



        function setTableMes(result){
            var tBody=$("#tbody");

            tBody.empty();
            for(var i in result){
                var time = new Date(result[i].date);
                var tr=$("<tr id="+result[i].title+"></tr>");
                tr.append("<td>"+result[i].title+"</td>");
                tr.append("<td>"+time.getMonth()+1+"-"+time.getDate()+"</td>");
                tr.append("<td>" +
                    "<button type='button' class='delData'>删除</button>" +
                    "<button type='button' class='SeeData'>查看</button>" +
                    "</td>");
                tBody.append(tr);
            }
            //绑定单机事件
            $(".delData").on("click",delData);
            $(".SeeData").on("click",SeeData);
        }
    </script>
</head>
<style>
    #div{
        position: absolute;
        height: 200px;
        width: 300px;
    }
</style>
<body>
<h2 id="h2"></h2>
<a href="/user/login.do">退出登录</a>
<a href="/messages/edit.do">新增消息</a>
<table border="1" width="800px">
    <thead>
    <tr>
        <td>title</td>
        <td>date</td>
        <td>操作</td>
    </tr>
    </thead>

    <tbody id="tbody"></tbody>
</table>

<div id="div"></div>






</body>
</html>
