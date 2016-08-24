package io.dubbo.springboot;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@AutoConfigureAfter(DubboXmlConfiguration.class)
@EnableConfigurationProperties(DubboProperties.class)
@Import(DubboRegistrar.class)
public class DubboAutoConfiguration {

}
