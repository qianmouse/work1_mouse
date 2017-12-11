package cn.connext.comment.entity;

import java.util.Date;

public class Comment {
    private int cid;
    private Date date;
    private String comment;
    private int mid;
    private String phone;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", mid=" + mid +
                ", phone='" + phone + '\'' +
                '}';
    }
}
