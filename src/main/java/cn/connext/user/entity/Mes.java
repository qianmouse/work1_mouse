package cn.connext.user.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
//消息实体类t 
@Component
public class Mes {
    private int mid;
    private String title;

    private Date date;

    private String text;
    private String phone;
    private int count;
    private Date cdate;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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

    @Override
    public String toString() {
        return "Mes{" +
                "mid=" + mid +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", phone='" + phone + '\'' +
                ", count=" + count +
                ", cdate=" + cdate +
                '}';
    }
}
