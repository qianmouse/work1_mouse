package cn.connext.user.service;


/**
 * 用户模块业务层接口
 * */
public interface UserService {
    //找手机号
    Boolean findPhone(String phone);

    //匹配手机号和密码
    String login(String phone,String pwd);

    //保存手机号和密码
    void register(String phone,String pwd);

}
