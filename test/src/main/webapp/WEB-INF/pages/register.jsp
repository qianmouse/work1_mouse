<%--
  Created by IntelliJ IDEA.
  User: Hao.Qian
  Date: 2017/11/27
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js" charset="UTF-8"></script>
    <script>

        $(document).ready(function () {
            //隐藏图形验证框
            $(".td").hide();
            //验证图形验证码
            $("#graph").click(function () {
                var inp = $("#inp").val();
                url = "/user/inp.do"
                var params = {"inp":inp};
                $.post(url,params,function (result) {
                    if (result==="yes"){
                        alert("验证成功");
                        $("#gain").attr("disabled", false);
                    }else{
                        alert("验证失败");
                        //验证失败换一张图片
                        ref();
                    }
                })
            })

            //获取随机图形验证码
            function ref() {
                var timenow = new Date().getTime();
                $("#num").attr("src","/user/image.do?date="+timenow);
            }
            //点击图片换图
            $("#num").click(function () {
                ref();
            });
            //验证手机号格式及手机号已存在提示
            $("#phone").blur(function () {
                var phone = $("#phone").val();
                var ret = /^\d{11}$/;
                if (!ret.test(phone)){
                    alert("请输入正确格式的手机号码");
                    $("#phone").val("");
                }
                var url = "/user/findPhone.do";
                var params={"phone":phone};
                $.post(url,params,function (result) {
                    if (result === "exist")
                        alert("用户名已存在");
                })
            });

            //注册验证
            $("#button").click(function () {
                var code = $("#test").val();
                if (code!==sessionStorage.getItem("code")){
                    alert("验证码不正确");
                    $("#gain").attr("disabled", true);
                    //验证码不正确时显示图形验证码
                    $(".td").show();
                    return false;
                }
                var phone = $("#phone").val();
                var url2 = "/user/findPhone.do";
                var params={"phone":phone};
                $.post(url2,params,function (result) {
                    if (result === "exist"){
                        alert("用户名已存在");
                        return false;
                    }
                })
                //对输入格式的约束
                var ret = /^\d{11}$/;
                if (!ret.test(phone)){
                    alert("请输入正确格式的手机号码");
                    $("#phone").val("");
                    return false;
                }
                if($("#pwd").val()===null){
                    alert("请设置密码");
                    return false;
                }
                if($("#pwd").val().length<4){
                    alert("密码不能小于4位数");
                    return false;
                }
                var url3 = "/user/savePhone.do";
                var params = {"phone":$("#phone").val(),"pwd":$("#pwd").val()};
                $.post(url3,params,function () {
                    alert("注册成功");
                })
            });

        })



        //后台获取验证码传到前台显示给用户，并存在sessionStorage以供验证
        function getcode(obj) {
            var url = "/user/getCode.do";
            $.post(url,function (result) {
                sessionStorage.setItem("code",result);
                alert("验证码是："+result);
                settime(obj);
            })
        }

        //设置验证码获取时间权限
        var countdown=60;
        function settime(obj) {
            if (countdown == 0) {
                obj.removeAttribute("disabled");
                //清空数据
                sessionStorage.setItem("code","");
                obj.value="获取验证码";
                countdown = 60;
                return;
            } else {
                    obj.setAttribute("disabled", true);
                    obj.value="重新发送(" + countdown + ")";
                    countdown--;
            }
            setTimeout(function() {
                    settime(obj) }
                ,1000)
        }

    </script>
</head>
<body>
<h2 align=center>注册页面</h2>

<center>
    <form action="/user/savePhone.do" method="post">
        <table border="1">
            <tr>
                <td>手机号：</td>
                <td><input name="phone" id="phone"></td>
            </tr>
            <tr>
                <td>验证码：</td>
                <td><input name="code" id="test"></td>
                <td><input id="gain" type="button" value="获取验证码" onclick="getcode(this)"></td>
                <td class="td"><img id="num" src="/user/image.do" /></td>
                <td class="td"><input id="inp"></td>
                <td class="td"><input id="graph" type="button" value="图形验证"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="pwd" type="password" id="pwd"></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input id="button" type="button" value="提交注册"></td>
            </tr>
        </table>
    </form>

    <a href="/user/login.do"><front color="GREEN" >点击直接登录</front></a>
</center>
</body>
</html>
