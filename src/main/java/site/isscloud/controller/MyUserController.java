package site.isscloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.isscloud.domain.MyUser;
import site.isscloud.mapper.MyUserMapper;
import site.isscloud.service.MyUserService;
import site.isscloud.utils.JsonData;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/pub/myuser")
public class MyUserController {
    private final MyUserService userService;
    public MyUserController(MyUserService userService) {
        this.userService = userService;
    }

    /**
     * 登录
     * @param 用户名
     * @param 密码
     * @return token
     */
    @PostMapping("login")
    public JsonData login(String username, String pwd) {
        System.out.println("username:"+username+" pwd:"+pwd);
        String token = userService.login(username, pwd);
        return token != null? JsonData.buildSuccess(token):JsonData.buildError("账号密码错误");
    }

    /**
     * 返回所有用户列表
     * @return 用户列表
     */
    @GetMapping("list")
    public JsonData list() {
        List<MyUser> myUsers = userService.listUser();
        return JsonData.buildSuccess(myUsers);
    }

    /**
     * 通过id获取某用户
     * @param 用户id
     * @return 对应的用户对象
     */
    @RequestMapping("get")
    public JsonData getUser(int id) {
        Stream<MyUser> stream;
        stream = MyUserMapper.userMap.values().stream();
        List<MyUser> myUsers =  stream.filter(u -> u.getId() == id ).limit(1).collect(Collectors.toList());
        MyUser myUser;
        if(myUsers == null || myUsers.isEmpty()) {
            return JsonData.buildError("找不到该用户");
        }

        myUser = myUsers.get(0);
        return JsonData.buildSuccess(myUser);
    }
}
