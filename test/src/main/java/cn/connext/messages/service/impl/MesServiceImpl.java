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

    public String findText(String title){
        String text = mesDao.findText(title);
        return text;
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

    public void saveMes(String title, Date date, String text, String phone) {
        Mes mes = new Mes();
        mes.setTitle(title);
        mes.setDate(date);
        mes.setText(text);
        mes.setPhone(phone);
        mesDao.saveMes(mes);
    }

    public void delMes(String title) {

        mesDao.delMes(title);
    }
}
