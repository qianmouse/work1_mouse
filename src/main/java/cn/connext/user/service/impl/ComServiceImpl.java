package cn.connext.user.service.impl;

import cn.connext.user.dao.ComDao;
import cn.connext.user.dao.MesDao;
import cn.connext.user.entity.Comment;
import cn.connext.user.entity.Mes;
import cn.connext.user.service.ComService;
import cn.connext.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ComServiceImpl implements ComService {

    @Resource
    private ComDao comDao;
    @Resource
    private MesDao mesDao;
    @Resource
    private UserService userService;

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

    //自己评论的，自己文章的，有权限的可以删除评论
    public Boolean delComByCid(int cid,int mid,String phone) {
        Comment com = comDao.getComByCid(cid);
        String cPhone = com.getPhone();
        Mes mes = mesDao.findText(mid);
        String mPhone = mes.getPhone();
        if (phone.equals(cPhone)|phone.equals(mPhone)|userService.delPermission(phone)){
            comDao.delComByCid(cid);
            comDao.countMinus(mid);
            return true;
        }
        return false;
    }

    public Comment getComByCid(int cid) {
        return comDao.getComByCid(cid);
    }
}
