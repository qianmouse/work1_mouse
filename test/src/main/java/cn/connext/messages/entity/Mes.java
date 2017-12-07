package cn.connext.messages.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
//消息实体类t 
@Component
public class Mes {
    private String title;

    private Date date;

    private String text;
    private String phone;

    @Override
    public String toString() {
        return "Mes{" +
                "phone='" + phone + '\'' +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
