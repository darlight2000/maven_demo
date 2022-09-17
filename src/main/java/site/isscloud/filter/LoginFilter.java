package site.isscloud.filter;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "LoginFilter")
public class LoginFilter implements Filter {
    private static ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("init LoginFilter:"+filterConfig.toString());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter LoginFilter");
        /* //此处实现判断请求的私有接口，是否有正确的token
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        if(StringUtils.isEmpty(token)) {
            //token不存在，则向client端输出错误信息
            renderJson(response,JsonData.buildError(-2, "token 不存在"));
            return;
        }
        // 判断token是否合法
        User user = UserService.tokenMap.get(token);
        if(user == null) {
            //token异常或过期，则向client端输出错误信息
            renderJson(response,JsonData.buildError(-3, "token异常或过期"));
            return;
        }
         */
        filterChain.doFilter(servletRequest,servletResponse);
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
    public void destroy() {
        Filter.super.destroy();
        System.out.println("destroy LoginFilter");
    }
}
