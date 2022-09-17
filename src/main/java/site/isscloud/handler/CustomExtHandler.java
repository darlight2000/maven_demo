package site.isscloud.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.isscloud.utils.JsonData;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomExtHandler {
    @ExceptionHandler(value = Exception.class)
    JsonData handlerException(Exception e, HttpServletRequest request) {
        return JsonData.buildError("服务器出错了" + e.toString());
    }
}
