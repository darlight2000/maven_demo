package site.isscloud;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.isscloud.controller.MyUserController;
import site.isscloud.domain.MyUser;
import site.isscloud.service.MyUserService;
import site.isscloud.utils.JsonData;

import java.util.List;


@RunWith(SpringRunner.class) //底层⽤用junit SpringJUnit4ClassRunner
@SpringBootTest(classes = {VideoProjectApplication.class}) //VideoProjectApplication 为入口类名称
public class UserTest {
    @Autowired
    private MyUserController userController;
    @Autowired
    private MyUserService userService;

    @Before
    public void testBefore() {
        System.out.println("Before:该方法在该类所有测试方法前执行");
    }

    @Test
    public void loginTest() {
        MyUser myUser = new MyUser();
        myUser.setUsername("dark1");
        myUser.setPwd("1");
        JsonData jsonData = userController.login(myUser.getUsername(), myUser.getPwd());
        System.out.println(jsonData.toString());
        TestCase.assertEquals(0, jsonData.getCode());
    }

    @Test
    public void listUserTest() {
        List<MyUser> myUsers = userService.listUser();
        myUsers.forEach(user -> {
            System.out.println(user.toString());
        });
        TestCase.assertTrue(myUsers.size() > 0);
    }

    @After
    public void testAfter() {
        System.out.println("After:该方法在该类所有测试方法后执行");
    }
}
