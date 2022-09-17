package site.isscloud.service;

import site.isscloud.domain.MyUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MyUserService {
    static Map<String, MyUser> tokenMap = new HashMap<>();;
    String login(String username, String pwd);
    List<MyUser> listUser();
}
