package site.isscloud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.isscloud.utils.JsonData;

@RestController
@RequestMapping("/api/v1/pri/order")
public class MyVideoOrderController {
    @PostMapping("save")
    public JsonData saveOrder(){
        return JsonData.buildSuccess("δΈεζε");
    }
}
