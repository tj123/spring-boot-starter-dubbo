package io.dubbo.springboot;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@AutoConfigureOrder(1)
@ImportResource("classpath:META-INF/spring/applicationContext*.xml")
public class DubboXmlConfiguration {

}
