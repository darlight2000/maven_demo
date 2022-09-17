package site.isscloud.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import site.isscloud.domain.MyUser;
import site.isscloud.service.MyUserService;
import site.isscloud.utils.JsonData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {
    private static ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor preHandle===========>");
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        if(StringUtils.isEmpty(token)) {
            //token不存在，则向client端输出错误信息
            renderJson(response,JsonData.buildError(-2, "token 不存在"));
            return false;
        }
        // 判断token是否合法
        MyUser myUser = MyUserService.tokenMap.get(token);
        if(myUser == null) {
            //token异常或过期，则向client端输出错误信息
            renderJson(response,JsonData.buildError(-3, "token异常或过期"));
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor postHandle===========>");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 用来向client端，输出json对象
     * @param response
     * @param json
     */
    private void renderJson(HttpServletResponse response, Object json) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try(PrintWriter writer = response.getWriter()){
            writer.print(objectMapper.writeValueAsString(json));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor afterCompletion===========>");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
