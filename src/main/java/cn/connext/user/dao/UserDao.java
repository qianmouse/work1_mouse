package cn.connext.user.dao;
import cn.connext.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * 用户模块持久层
 * */
@Repository
public interface UserDao {
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
