package site.isscloud.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时统计订单任务
 */
@Component
public class VideoOrderTask {
    // @Scheduled(fixedRate = 2000) 每隔两秒
    @Scheduled(cron = "0 */2 * * * ?") // 每隔两分钟
    public void sum(){
        System.out.println(LocalDateTime.now()+" 当前交易额为："+ (int)(Math.random()*10000));
    }
}
