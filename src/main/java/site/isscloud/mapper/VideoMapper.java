package site.isscloud.mapper;

import org.apache.ibatis.annotations.Param;
import site.isscloud.domain.Video;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface VideoMapper {
    // @Param("video_id")用来定义别名
    Video selectById(@Param("video_id") int videoId);

    // 特别注意，如果是多参数，必须要加@Param，否则会报错
    List<Video> selectByTitleAndPoint(@Param("title") String title,@Param("point") int point);

    // 新增Video `title`,`summary`,`cover_img`,`price`,`create_time`,`point`
    int add(Video video);

    // 批量插入
    int addBatch(List<Video> list);

    //update
    int updateSelected(Video video);

    // 通过创建时间及价格来进行删除
    int deleteByCreateTimeAndPrice(Map<String,Object> map);
}
