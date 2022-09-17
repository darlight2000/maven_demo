package site.isscloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.isscloud.domain.MyVideo;
import site.isscloud.service.MyVideoService;
import site.isscloud.utils.JsonData;

import java.util.List;

/**
 * 视频控制器
 */

@RestController
@RequestMapping("/api/v1/pub/myvideo")
public class MyVideoController {

    private final MyVideoService videoService;

    public MyVideoController(MyVideoService videoService) {
        this.videoService = videoService;
    }

    /**
     * 列出所有课程
     * @return 课程列表
     */
    @GetMapping("list")
    public JsonData list(){
        List<MyVideo> list = videoService.listVideo();
        return JsonData.buildSuccess(list);
    }
}
