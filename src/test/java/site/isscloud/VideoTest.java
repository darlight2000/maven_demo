package site.isscloud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import site.isscloud.domain.MyVideo;
import site.isscloud.utils.JsonData;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class) //底层⽤用junit SpringJUnit4ClassRunner
@SpringBootTest(classes={VideoProjectApplication.class}) //VideoProjectApplication 为入口类名称
@AutoConfigureMockMvc
public class VideoTest {
    private String baseUrl = "/api/v1/pub/video";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void videoListTest() {
        MvcResult mvcResult;
        try {
            mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(baseUrl + "/list"))
                    .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        } catch (Exception e) {
            mvcResult = null;
            System.out.println(e);
        }

        if(mvcResult != null){
            int status = mvcResult.getResponse().getStatus();
            System.out.println("status:"+status);
            String result;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                result = mvcResult.getResponse().getContentAsString(Charset.defaultCharset());
                JsonData jsonData = null;
                try {
                    jsonData = objectMapper.readValue(result, JsonData.class);
                } catch (JsonMappingException e) {
                    e.printStackTrace();
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                if(jsonData != null) {
                   List temp = objectMapper.convertValue(jsonData.getData(),List.class);
                   List<MyVideo> myVideos = new ArrayList<>();
                   temp.forEach(item-> {
                       MyVideo myVideo = objectMapper.convertValue(item, MyVideo.class);
                       if(myVideo != null){
                           myVideos.add(myVideo);
                       }
                   });
                   myVideos.forEach(item-> System.out.println(item.toString()));
                }
            }
            catch (Exception e) {
                result = e.toString();
            }
        }
    }

    @Before
    public void testBefore(){
        System.out.println("这个是测试Before");
    }

    @Test
    public void testOne(){
        System.out.println("这个是测试One");
        TestCase.assertEquals(1,1);
    }

    @After
    public void testAfter(){
        System.out.println("这个是测试After");
    }
}
