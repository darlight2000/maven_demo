package site.isscloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.isscloud.config.WXConfig;
import site.isscloud.task.AsyncTask;
import site.isscloud.utils.JsonData;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/v1/pub/test")
@PropertySource("classpath:pay.properties")
public class TestController {
    @Value(value = "${wxpay.appid}")
    private String payAppId;
    @Value(value = "${wxpay.secret}")
    private String paySecret;

    private final WXConfig wxConfig;
    private final AsyncTask asyncTask;

    public TestController(WXConfig wxConfig, AsyncTask asyncTask) {
        this.wxConfig = wxConfig;
        this.asyncTask = asyncTask;
    }

    @GetMapping("payconfig")
    public JsonData getPayConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("appid", payAppId);
        map.put("secret", paySecret);
        return JsonData.buildSuccess(map);
    }

    @GetMapping("config_class")
    public JsonData configClass() {
        Map<String, String> map = new HashMap<>();
        map.put("appid", wxConfig.getAppid());
        map.put("secret", wxConfig.getSecret());
        map.put("merchid", wxConfig.getMerchid());
        return JsonData.buildSuccess(map);
    }

    @GetMapping("exception")
    public JsonData testException() {
        int i = 1 / 0;
        return JsonData.buildSuccess("成功");
    }

    @PostMapping("sync")
    public JsonData testSync(){
        System.out.println(LocalDateTime.now()+": testSync call start");
        Future<String> result1 = asyncTask.asyncTask1();
        Future<String> result2 = asyncTask.asyncTask2();
        for(;;){
            if(result1.isDone() && result2.isDone()) {
                String str1 = null;
                try {
                    str1 = result1.get();
                    String str2 = result2.get();
                    System.out.println(LocalDateTime.now()+" testSync executed: result1="+str1+"|result2="+str2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    break;
                }
            }
        }

        System.out.println(LocalDateTime.now()+": testSync call finished");
        return JsonData.buildSuccess("同步调用成功");
    }

    @PostMapping("async")
    public JsonData testAsync(){
        System.out.println(LocalDateTime.now()+": testAsync call start");
        asyncTask.asyncTask1();
        asyncTask.asyncTask2();
        System.out.println(LocalDateTime.now()+": testAsync call finished");
        return JsonData.buildSuccess("异步调用成功");
    }
}
