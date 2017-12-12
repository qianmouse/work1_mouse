package cn.connext.user.service.impl;

import cn.connext.user.dao.UserDao;
import cn.connext.user.entity.Role;
import cn.connext.user.entity.User;
import cn.connext.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户模块业务层实现类
 * */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    //修改用户
    public void alterUser(String phone, String identity, String role) {
        User user = new User();
        user.setPhone(phone);
        user.setIdentity(identity);
        user.setRole(role);
        userDao.alterUser(user);
    }

    //判断角色重名
    public String findRoleName(String role) {
        String str = userDao.findRoleName(role);
        if (role.equals(str)){
            return "rename";
        }
        return "ok";
    }

    public void newRole(String role, String permission) {
        Role role1 = new Role();
        role1.setRole(role);
        role1.setPermission(permission);
        userDao.newRole(role1);
    }

    public List<Role> findAllRole() {
        return userDao.findAllRole();
    }

    //查看所有User
    public List<User> findUser() {
        return userDao.findUser();
    }

    //查看用户身份
    public String getIdentity(String phone) {
        String identity = userDao.getIdentity(phone);
        return identity;
    }

    //登录管理员界面
    public Boolean manage(String phone){
        String identity = userDao.getIdentity(phone);
        if ("manager".equals(identity))
            return true;
        return false;
    }

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
