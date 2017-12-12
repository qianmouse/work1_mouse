package cn.connext.user.controller;

import cn.connext.user.service.ComService;
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
    public String delComByCid(int cid,int mid){
        comService.delComByCid(cid);
        comService.countMinus(mid);
        return "ok";
    }

}
