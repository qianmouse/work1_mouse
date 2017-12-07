package cn.connext.user.entity;

import org.springframework.stereotype.Component;
/**
 * 用户实体类
 * */
@Component
public class User {
    private String phone;
    private String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
