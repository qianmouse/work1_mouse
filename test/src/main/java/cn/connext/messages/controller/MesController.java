package cn.connext.messages.controller;

import cn.connext.messages.entity.Mes;
import cn.connext.messages.service.MesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
/**
 * 消息模块控制层
 * */
@RequestMapping("/messages/")
@Controller
public class MesController {
    @Resource
    private MesService mesService;

    //消息编辑页面
    @RequestMapping("edit")
    public String edit(){
        return "edit";
    }

    //获得消息正文并返回
    @RequestMapping("findText")
    @ResponseBody
    public String findText(String title){
        String text =  mesService.findText(title);
        return text;
    }

    //查询手机号对应的所有消息
    @RequestMapping("findMes")
    @ResponseBody
    public List<Mes> findMes(String phone){
        List<Mes> list = mesService.findMes(phone);
        return list;
    }

    //查看消息标题是否存在
    @RequestMapping("findTitle")
    @ResponseBody
    public String findTitle(String title){

        if (mesService.findTitle(title))
            return "exist";
        return "no";
    }

    //保存消息
    @RequestMapping("saveMes")
    public String saveMes(String title, Date date,String text,String phone){
        mesService.saveMes(title,date,text,phone);
        return "messages";
    }

    //删除消息
    @RequestMapping("delMes")
    public String delMes(String title){
        mesService.delMes(title);
        return "messages";
    }

}
