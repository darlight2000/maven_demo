package site.isscloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:pay.properties")
public class WXConfig {
    @Value(value = "${wxpay.appid}")
    private String appid;
    @Value(value = "${wxpay.secret}")
    private String secret;
    @Value(value = "${wxpay.merchid}")
    private String merchid;

    public String getAppid() {
        return appid;
    }

    public String getSecret() {
        return secret;
    }

    public String getMerchid() {
        return merchid;
    }
}
