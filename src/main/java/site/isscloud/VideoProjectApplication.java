package site.isscloud;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import site.isscloud.domain.User;
import site.isscloud.domain.Video;
import site.isscloud.domain.VideoOrder;
import site.isscloud.mapper.UserMapper;
import site.isscloud.mapper.VideoMapper;
import site.isscloud.mapper.VideoOrderMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableAsync
public class VideoProjectApplication {
    public static void main(String[] args) {
        String springVersion = SpringVersion.getVersion();
        String springBootVersion = SpringBootVersion.getVersion();
        System.out.println("Spring版本:" + springVersion + "\nSpringBoot版本:" + springBootVersion);
        SpringApplication.run(VideoProjectApplication.class, args);
//        testMyBatis();
    }

    private static void testMyBatis() {
        String resouce = "config/mybatis-config.xml";
        //读取配置⽂文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resouce);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //构建Session⼯⼚
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取Session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
            VideoOrderMapper videoOrderMapper = sqlSession.getMapper(VideoOrderMapper.class);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            testOneToMultiLazy(userMapper);
            testOneToOneLazy(videoOrderMapper);
//            testSearch(videoMapper);
//            testOneToOneSearch(videoOrderMapper);
//            testOneToMultiSearch(userMapper);
//            testInsert(videoMapper);
//            testUpdate(videoMapper);
//            testDelete(videoMapper);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

//        testSecondaryCache(sqlSessionFactory);
    }

    private static void testSearch(VideoMapper videoMapper) {
        Video video = videoMapper.selectById(44);
        List<Video> list = videoMapper.selectByTitleAndPoint("HTML", 8);
    }

    private static void testOneToOneSearch(VideoOrderMapper videoOrderMapper) {
        List<VideoOrder> list = videoOrderMapper.queryVideoOrderList();
        list.forEach(item -> {
            System.out.println(item.toString());
        });
    }

    private static void testOneToMultiSearch(UserMapper userMapper) {
        List<User> list = userMapper.queryUserOrder();
        list.forEach(item -> {
            System.out.println(item.toString());
        });
    }

    private static void testSecondaryCache(SqlSessionFactory sqlSessionFactory) {
        try {
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
            userMapper1.getUserById(1);
            sqlSession1.commit();
            sqlSession1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
            userMapper2.getUserById(1);
            sqlSession2.commit();
            sqlSession2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testOneToMultiLazy(UserMapper userMapper) {
        List<User> users = userMapper.queryUserOrderLazy();
        if (users != null && users.size() > 0) {
            users.forEach(user -> {
                System.out.println("user:"+user.getName());
                List<VideoOrder> list = user.getVideoOrderList();
                if(list != null && list.size() > 0) {
                    System.out.println(list);
                }
            });
        } else {
            System.out.println("查无数据");
        }
    }

    private static void testOneToOneLazy(VideoOrderMapper videoOrderMapper) {
        List<VideoOrder> orders = videoOrderMapper.queryVideoOrderListLazy();
        if(orders !=null && orders.size() > 0) {
            orders.forEach(videoOrder -> {
                System.out.println("videoOrder:"+videoOrder.getOutTradeNo());
                User user = videoOrder.getUser();
                System.out.println(user);
                Video video = videoOrder.getVideo();
                System.out.println(video);
            });
        }
    }

    private static void testInsert(VideoMapper videoMapper) {
        Video video1 = new Video("title1", "summary1", "", 9999, 9, new Date());
        Video video2 = new Video("title2", "summary2", "", 9999, 9, new Date());
        List<Video> list2 = new ArrayList<>();
        list2.add(video1);
        list2.add(video2);
        // 返回值是影响行数，做了配置后，新增记录会自动填充到video.id中
        // int rows = videoMapper.add(video1);
        // 特别注意，如果有数据库编辑操作，一定要显示commit()，否则数据库操作将无效
        int rows = videoMapper.addBatch(list2);
        // 会发现，新增后的数据库自增id,会反写回video1.id中
        System.out.println(list2.toString());
    }

    private static void testUpdate(VideoMapper videoMapper) {
        Video videoSelected = new Video();
        videoSelected.setId(70);
        videoSelected.setTitle("title_selected");
        videoMapper.updateSelected(videoSelected);
        System.out.println(videoSelected.toString());
    }

    private static void testDelete(VideoMapper videoMapper) {
        Map<String, Object> map = new HashMap<>();
        map.put("createTime", "2022-08-19 02:54:00");
        map.put("price", 9999);
        videoMapper.deleteByCreateTimeAndPrice(map);
    }

}
