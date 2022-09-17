package site.isscloud.service.impl;

import org.springframework.stereotype.Service;
import site.isscloud.domain.MyUser;
import site.isscloud.mapper.MyUserMapper;
import site.isscloud.service.MyUserService;

import java.util.List;
import java.util.UUID;

@Service
public class MyUserServiceImpl implements MyUserService {

    private final MyUserMapper userMapper;
    public MyUserServiceImpl(MyUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String login(String username, String pwd) {
        MyUser myUser = userMapper.login(username, pwd);
        String token;
        if (myUser == null) {
            token = null;
        } else {
            token = UUID.randomUUID().toString();
            System.out.println("token:" + token);
            MyUserService.tokenMap.put(token, myUser);
        }
        return token;
    }

    @Override
    public List<MyUser> listUser() {
        System.out.println("测试热部署");
        return userMapper.listUser();
    }
}
