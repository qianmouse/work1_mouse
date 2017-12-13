package cn.connext.user.controller;

import cn.connext.user.entity.Comment;
import cn.connext.user.entity.Mes;
import cn.connext.user.service.ComService;
import cn.connext.user.service.MesService;
import cn.connext.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 评论模块控制层
 */
@RequestMapping("comment")
@Controller
public class ComController {
    @Resource
    private ComService comService;

    //发表评论
    @RequestMapping("putCom")
    @ResponseBody
    public String putCom(String comment,int mid,String phone){
        comService.putCom(comment,mid,phone);
        comService.countAdd(mid);
        return "text";
    }

    //删除评论
    @RequestMapping("delComByCid")
    @ResponseBody
    public String delComByCid(int cid,int mid,String phone){
        //自己评论的，自己文章的，有权限的可以删除评论
        if (comService.delComByCid(cid,mid,phone)){
            return "success";
        }
        return "fail";
    }

}
