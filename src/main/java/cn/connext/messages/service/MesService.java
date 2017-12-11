package cn.connext.messages.service;

import cn.connext.messages.entity.Mes;

import java.util.Date;
import java.util.List;
/**
 * 消息模块业务处接口
 * */
public interface MesService {
    //根据id找到正文
    Mes findText(int mid);

    //判断标题是否存在
    Boolean findTitle(String title);

    //查找手机号所有消息
    List<Mes> findMes(String phone);

    //查找所有消息
    List<Mes> findAll();

    //保存消息
    void saveMes(String title, Date date,String text,String phone);

    //删除消息
    void delMes(int mid);

    //修改
    void editMes(String title,String text,int mid);

}
