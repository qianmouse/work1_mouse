package cn.connext.user.service;

import cn.connext.user.entity.Mes;

import java.util.List;
/**
 * 消息模块业务处接口
 * */
public interface MesService {
    //查看是否具有修改文章的权限
    Boolean alterMes(int mid,String phone);

    //根据id找到正文
    Mes findText(int mid);

    //判断标题是否存在
    Boolean findTitle(String title);

    //查找手机号所有消息
    List<Mes> findMes(String phone);

    //查找所有消息
    List<Mes> findAll();

    //保存消息
    void saveMes(String title,String text,String phone);

    //删除消息
    Boolean delMes(int mid,String phone);

    //修改
    void editMes(String title,String text,int mid);

}
