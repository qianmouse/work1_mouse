package cn.connext.user.dao;
import cn.connext.user.entity.Role;
import cn.connext.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户模块持久层
 * */
@Repository
public interface UserDao {
    //获得用户的权限
    String getPermission(@Param("phone") String phone);

    //修改用户
    void alterUser(@Param("user") User user);

    //判断角色名
    String findRoleName(@Param("role") String role);

    //新建角色
    void newRole(@Param("role") Role role);

    //查找所有角色
    List<Role> findAllRole();

    //查找所有用户
    List<User> findUser();

    //查看身份
    String getIdentity(@Param("phone") String phone);

    //查找手机
    String findPhone(@Param("phone") String phone);

    //登录
    User login(@Param("phone") String phone, @Param("pwd") String pwd);

    //注册
    void register(@Param("phone") String phone, @Param("pwd") String pwd);

    //增加失败次数
    void addCount(@Param("phone") String phone);

    //锁定用户
    void lockUser(@Param("phone") String phone);

    //解锁用户
    void unLock(@Param("phone") String phone);

    //查看是否锁定



}
