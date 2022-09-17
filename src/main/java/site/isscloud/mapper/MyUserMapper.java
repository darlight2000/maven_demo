package site.isscloud.mapper;

import org.springframework.stereotype.Repository;
import site.isscloud.domain.MyUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MyUserMapper {
    public static Map<String, MyUser> userMap = new HashMap<>();

    static {
        userMap.put("dark1", new MyUser(1, "dark1", "1"));
        userMap.put("dark2", new MyUser(2, "dark2", "1"));
        userMap.put("dark3", new MyUser(3, "dark3", "1"));
        userMap.put("dark4", new MyUser(4, "dark4", "1"));
        userMap.put("dark5", new MyUser(5, "dark5", "1"));
        userMap.put("dark6", new MyUser(6, "dark6", "1"));
    }

    public List<MyUser> listUser() {
        List<MyUser> list = new ArrayList<>();
        list.addAll(userMap.values());
        return list;
    }

    public MyUser login(String username, String pwd) {
        MyUser myUser = userMap.get(username);
        if (myUser == null) {
            return null;
        }
        if(myUser.getPwd().equals(pwd)) {
            return myUser;
        }
        return null;
    }
}
