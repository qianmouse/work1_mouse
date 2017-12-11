package cn.connext.messages.service.impl;

import cn.connext.messages.dao.MesDao;
import cn.connext.messages.entity.Mes;
import cn.connext.messages.service.MesService;
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

    public void saveMes(String title, Date date, String text, String phone) {
        Mes mes = new Mes();
        mes.setTitle(title);
        mes.setDate(date);
        mes.setText(text);
        mes.setPhone(phone);
        mesDao.saveMes(mes);
    }

    public void delMes(int mid) {

        mesDao.delMes(mid);
    }

    public void editMes(String title,String text,int mid) {
        Mes mes = new Mes();
        mes.setTitle(title);
        mes.setText(text);
        mes.setMid(mid);
        mesDao.editMes(mes);
    }
}
