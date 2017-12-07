package cn.connext.user.service.impl;

import cn.connext.user.dao.UserDao;
import cn.connext.user.entity.User;
import cn.connext.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户模块业务层实现类
 * */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public Boolean findPhone(String phone) {
        String str = userDao.findPhone(phone);
        if(phone.equals(str))
            return true;
        return false;
    }

    public String login(String phone, String pwd) {
        User user = userDao.login(phone,pwd);
        if(user == null)
            return "error";
        return user.getPhone();
    }

    public void register(String phone, String pwd) {

        userDao.register(phone,pwd);
    }
}
