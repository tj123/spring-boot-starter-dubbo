package io.dubbo.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DubboXmlConfiguration.class, DubboPropertiesConfiguration.class})
public class DubboAutoConfiguration {

}
