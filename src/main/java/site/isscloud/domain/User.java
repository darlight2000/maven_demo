package site.isscloud.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    private Integer id;
    private String name;
    private String pwd;
    private String phone;
    private String headImg;
    private Date createTime;

    private List<VideoOrder> videoOrderList;

    public User() {
    }

    public User(Integer id, String name, String pwd, String phone, String headImg, Date createTime, List<VideoOrder> videoOrderList) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.phone = phone;
        this.headImg = headImg;
        this.createTime = createTime;
        this.videoOrderList = videoOrderList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date creatTime) {
        this.createTime = creatTime;
    }

    public List<VideoOrder> getVideoOrderList() {
        return videoOrderList;
    }

    public void setVideoOrderList(List<VideoOrder> videoOrderList) {
        this.videoOrderList = videoOrderList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", headImg='" + headImg + '\'' +
                ", createTime=" + createTime +
                ", videoOrderList=" + videoOrderList +
                '}';
    }
}
