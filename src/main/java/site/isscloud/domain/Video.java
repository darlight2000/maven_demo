package site.isscloud.domain;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
    private Integer id;
    private String title;
    private String summary;
    private String coverImg;
    private Integer price;
    private Integer point;
    private Date createTime;

    public Video() {
    }

    public Video(String title, String summary, String coverImg, Integer price, Integer point, Date createTime) {
        this.title = title;
        this.summary = summary;
        this.coverImg = coverImg;
        this.price = price;
        this.point = point;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", price=" + price +
                ", point=" + point +
                ", createTime=" + createTime +
                '}';
    }
}
