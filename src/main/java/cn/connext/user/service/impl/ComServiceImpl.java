package cn.connext.user.service.impl;

import cn.connext.user.dao.ComDao;
import cn.connext.user.entity.Comment;
import cn.connext.user.service.ComService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ComServiceImpl implements ComService {

    @Resource
    private ComDao comDao;

    public void putCom(String comment, int mid, String phone) {
        Comment com = new Comment();
        com.setComment(comment);
        com.setCdate(new Date());
        com.setMid(mid);
        com.setPhone(phone);
        comDao.putCom(com);
    }

    public void countAdd(int mid){
        comDao.countAdd(mid);
    }

    public void countMinus(int mid) {
        comDao.countMinus(mid);
    }

    public List<Comment> findCom(int mid) {
        return comDao.findCom(mid);
    }

    public void delCom(int mid) {
        comDao.delCom(mid);
    }

    public void delComByCid(int cid) {
        comDao.delComByCid(cid);
    }
}
