package site.isscloud.service.impl;
import org.springframework.stereotype.Service;
import site.isscloud.domain.MyVideo;
import site.isscloud.mapper.MyVideoMapper;
import site.isscloud.service.MyVideoService;
import java.util.List;

@Service
public class MyVideoServiceImpl implements MyVideoService {
    private final MyVideoMapper videoMapper;

    public MyVideoServiceImpl(MyVideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

    @Override
    public List<MyVideo> listVideo() {

        List<MyVideo> list = videoMapper.listVideo();
        /**
        // 通过ObjectMapper将对象转换为字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr;
        try {
            jsonStr = objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            jsonStr = e.getMessage();
        }
         System.out.println("jsonStr:"+jsonStr);

        // 通过ObjectMapper将Json字符串转换为对象
        List<Video> temp = null;
        try {
            temp = objectMapper.readValue(jsonStr,List.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
         */
        return list;
    }
}
