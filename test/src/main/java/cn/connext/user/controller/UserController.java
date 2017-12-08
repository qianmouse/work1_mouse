package cn.connext.user.controller;
import cn.connext.md5.MD5Util;
import cn.connext.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户模块控制层
 * */
@RequestMapping("/user/")
@Controller
public class UserController {
    @Resource
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //登录成功，返回到消息页面
    @RequestMapping("messages")
    public String messages(){
        return "messages";
    }

    //返回到登录界面
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    //返回到注册界面
    @RequestMapping("register")
    public String register(){
        return "register";
    }

    //判断输入的图片验证码是否正确
    @RequestMapping("inp.do")
    @ResponseBody
    public String inp(String inp,HttpServletRequest request){
        HttpSession session = request.getSession();
        String num = (String) session.getAttribute("number");
        if (inp.equals(num)){
            return "yes";
        }
        return "no";
    }

    //获得图形验证码
    @RequestMapping("image.do")
    @ResponseBody
    public String showPic(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        BufferedImage image =
                new BufferedImage(80,30,
                        BufferedImage.TYPE_INT_RGB);
        //获得画笔
        Graphics g = image.getGraphics();
        //给画笔设置颜色
        g.setColor(new Color(255,255,255));
        //给画布设置背景颜色(即给画布上色)
        g.fillRect(0, 0, 80, 30);
        //给画笔设置颜色
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255),
                r.nextInt(255),r.nextInt(255)));
        //设置字体 (字体，风格，大小)
        g.setFont(new Font(null,
                Font.BOLD|Font.ITALIC,24));

        //生成验证码
        Random random = new Random();
        String number = "";
        String chars = "ABCDEFGHIJKLMNOPQRS"
                + "TUVWXYZ0123456789";
        for(int i = 0; i < 5; i ++){
            number += chars.charAt(
                    random.nextInt(chars.length()));
        }

        //将验证码(number)绑订到session对象上
        HttpSession session =
                request.getSession();
        session.setAttribute("number", number);


        //在画布上绘图(将验证码转换成一张图片)
        g.drawString(number, 1, 25);

        //加一些干扰线
        for(int i = 0; i < 8; i ++){
            g.setColor(new Color(r.nextInt(255),
                    r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(80), r.nextInt(30),
                    r.nextInt(80), r.nextInt(30));
        }

		/*
		 * step2.将图片压缩，然后输出
		 */
        //设置content-type
        response.setContentType("image/jpeg");
        //获得字节输出流（图片是二进制数据）
        OutputStream os =
                response.getOutputStream();
        //将原始图片(image)按照指定的算法压缩(jpeg),
        //然后将压缩之后得到的字节写入response对象。
        javax.imageio.ImageIO.write(
                image, "jpeg", os);
        os.close();

        return number;
    }

    //获得验证码返回前台进行判断
    @RequestMapping("getCode")
    @ResponseBody
    public String getCode(){
        String code;
        Random ne=new Random();
        code=String.valueOf(ne.nextInt(9999-1000+1)+1000);
        return code;
    }

    //注册账户
    @RequestMapping("savePhone")
    public String savePhone(String phone,String pwd){
        pwd = MD5Util.MD5(pwd);
        userService.register(phone,pwd);
        return "login";
    }

    //查看手机和密码是否正确，正确返回手机号码，错误返回"error"
    @RequestMapping("loginIn")
    @ResponseBody
    public String loginIn(String phone,String pwd){
        pwd = MD5Util.MD5(pwd);
        String uid = userService.login(phone,pwd);
        return uid;
    }

    //判断数据库是否存在手机号码
    @RequestMapping("findPhone")
    @ResponseBody
    public String findPhone(String phone){
        if (userService.findPhone(phone))
            return "exist";
        return "inexistence";
    }





}
