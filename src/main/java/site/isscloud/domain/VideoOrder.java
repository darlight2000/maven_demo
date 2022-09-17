package site.isscloud.domain;

import java.io.Serializable;
import java.util.Date;

public class VideoOrder implements Serializable {
    private Integer id;
    private String outTradeNo;
    private Integer state;
    private Integer totalFee;
    private Integer videoId;
    private String videoTitle;
    private String videoImg;
    private Integer userId;
    private User user;
    private Video video;
    private Date createTime;

    public VideoOrder() {
    }

    public VideoOrder(Integer id, String outTradeNo, Integer state, Integer totalFee, Integer videoId, String videoTitle, String videoImg, Integer userId, User user, Video video, Date createTime) {
        this.id = id;
        this.outTradeNo = outTradeNo;
        this.state = state;
        this.totalFee = totalFee;
        this.videoId = videoId;
        this.videoTitle = videoTitle;
        this.videoImg = videoImg;
        this.userId = userId;
        this.user = user;
        this.video = video;
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "id=" + id +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", state=" + state +
                ", totalFee=" + totalFee +
                ", videoId=" + videoId +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoImg='" + videoImg + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                ", video=" + video +
                ", createTime=" + createTime +
                '}';
    }
}
