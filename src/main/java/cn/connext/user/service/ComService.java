package cn.connext.user.service;

import cn.connext.user.entity.Comment;

import java.util.List;

public interface ComService {
    void putCom(String comment,int mid,String phone);

    void countAdd(int mid);

    void countMinus(int mid);

    List<Comment> findCom(int mid);

    void delCom(int mid);

    void delComByCid(int cid);
}
