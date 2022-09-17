package site.isscloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.isscloud.config.WXConfig;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/tpl")
public class TemplateController {
    private final WXConfig wxConfig;

    public TemplateController(WXConfig wxConfig) {
        this.wxConfig = wxConfig;
    }

    @GetMapping("/thymeleaf")
    public String index(ModelMap modelMap) {
        Map<String, String> map = new HashMap<>();
        map.put("appid", wxConfig.getAppid());
        map.put("secret", wxConfig.getSecret());
        modelMap.addAttribute("setting", map);
        return "tl/index";
    }
}
