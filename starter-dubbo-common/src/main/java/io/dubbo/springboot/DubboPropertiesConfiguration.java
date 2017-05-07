package io.dubbo.springboot;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@AutoConfigureOrder(2)
@Import(DubboRegistrar.class)
public class DubboPropertiesConfiguration {

}
