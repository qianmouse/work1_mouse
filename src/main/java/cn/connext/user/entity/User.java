package cn.connext.user.entity;

import org.springframework.stereotype.Component;
/**
 * 用户实体类
 * */
@Component
public class User {
    private String phone;
    private String pwd;
    private String identity;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }


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
                ", role='" + role + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
