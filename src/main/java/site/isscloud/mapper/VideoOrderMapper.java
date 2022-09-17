package site.isscloud.mapper;

import site.isscloud.domain.User;
import site.isscloud.domain.Video;
import site.isscloud.domain.VideoOrder;

import java.util.List;

public interface VideoOrderMapper {
    List<VideoOrder> queryVideoOrderList();
    List<VideoOrder> queryVideoOrderListLazy();
    List<Video> queryVideoById();
    List<User> queryUserById();
}
