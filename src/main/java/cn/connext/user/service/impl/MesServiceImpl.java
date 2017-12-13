package cn.connext.user.service.impl;

import cn.connext.user.dao.ComDao;
import cn.connext.user.dao.MesDao;
import cn.connext.user.entity.Mes;
import cn.connext.user.service.MesService;
import cn.connext.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
/**
 * 用户模块业务层实现类
 * */
@Transactional
@Service
public class MesServiceImpl implements MesService {
    @Resource
    private MesDao mesDao;
    @Resource
    private UserService userService;
    @Resource
    private ComDao comDao;

    //查看是否具有修改权限
    //自己的文章可以修改
    public Boolean alterMes(int mid, String phone) {
        Mes mes = mesDao.findText(mid);
        String str = mes.getPhone();
        if(phone.equals(str)|userService.altPermission(phone))
            return true;
        return false;
    }

    public Mes findText(int mid){
        Mes mes = mesDao.findText(mid);
        return mes;
    }

    public Boolean findTitle(String title) {
        String str = mesDao.findTitle(title);
        if (title.equals(str))
            return true;
        return false;
    }

    public List<Mes> findMes(String phone) {
        List<Mes> list = mesDao.findMes(phone);
        return list;
    }

    public List<Mes> findAll() {
        List<Mes> list = mesDao.findAll();
        return list;
    }

    public void saveMes(String title, String text, String phone) {
        Mes mes = new Mes();
        mes.setTitle(title);
        mes.setDate(new Date());
        mes.setText(text);
        mes.setPhone(phone);
        mesDao.saveMes(mes);
    }

    public Boolean delMes(int mid,String phone) {
        //可以删除自己的消息
        //有权限删除
        Mes mes = mesDao.findText(mid);
        String str = mes.getPhone();
        if (str.equals(phone)|userService.delPermission(phone)){
            mesDao.delMes(mid);
            comDao.delCom(mid);
            return true;
        }
        return false;
    }

    public void editMes(String title,String text,int mid) {
        Mes mes = new Mes();
        mes.setTitle(title);
        mes.setText(text);
        mes.setMid(mid);
        mesDao.editMes(mes);
    }
}
