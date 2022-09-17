package site.isscloud.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
public class CustomWebMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/api/v1/pri/**")
                //配置不不拦截某些路路径，⽐比如静态资源
                .excludePathPatterns("/**/*.html","/**/*.js");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public LoginInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }
}
