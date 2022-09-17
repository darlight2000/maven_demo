package site.isscloud.mapper;

import org.springframework.stereotype.Repository;
import site.isscloud.domain.MyVideo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MyVideoMapper {
    public static Map<Integer, MyVideo> videoMap = new HashMap<>();
    static {
        videoMap.put(1,new MyVideo(1,"java"));
        videoMap.put(2,new MyVideo(2,"sping"));
        videoMap.put(3,new MyVideo(3,"springboot"));
        videoMap.put(4,new MyVideo(4,"springcloud"));
        videoMap.put(5,new MyVideo(5,"微服务"));
        videoMap.put(6,new MyVideo(6,"mybatis"));
    }

    public List<MyVideo> listVideo(){
        List<MyVideo> list = new ArrayList<>();
        list.addAll(videoMap.values());

        return list;
    }
}
