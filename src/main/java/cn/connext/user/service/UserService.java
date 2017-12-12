package cn.connext.user.service;


        import cn.connext.user.entity.Role;
        import cn.connext.user.entity.User;

        import java.util.List;

/**
 * 用户模块业务层接口
 * */
public interface UserService {
    //修改用户
    void alterUser(String phone,String identity,String role);

    //判断角色重名
    String findRoleName(String role);

    //新建角色
    void newRole(String role,String permission);

    //查找所有角色
    List<Role> findAllRole();

    //查看所有用户
    List<User> findUser();

    //查看身份
    String getIdentity(String phone);

    //查看管理员权限
    Boolean manage(String phone);

    //找手机号
    Boolean findPhone(String phone);

    //匹配手机号和密码
    String login(String phone,String pwd);

    //保存手机号和密码
    void register(String phone,String pwd);

}
