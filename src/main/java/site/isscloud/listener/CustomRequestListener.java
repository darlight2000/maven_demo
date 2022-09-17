package site.isscloud.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("requestDestroyed=============>");
        ServletRequestListener.super.requestDestroyed(sre);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("requestInitialized=============>");
        ServletRequestListener.super.requestInitialized(sre);
    }
}
