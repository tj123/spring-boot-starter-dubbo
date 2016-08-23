package io.dubbo.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import io.dubbo.springboot.config.DubboProtocolConfig;
import io.dubbo.springboot.config.DubboProviderConfig;
import io.dubbo.springboot.config.DubboRegistryConfig;

@Configuration
@EnableConfigurationProperties(DubboProperties.class)
@Import(DubboRegistrar.class)
public class DubboAutoConfiguration {

    @Autowired
    private DubboProperties dubboProperties;

    @Bean
    public ApplicationConfig requestApplicationConfig() {
        return dubboProperties.getApplication();
    }

    @Bean
    @Primary
    public RegistryConfig requestRegistryConfig() {
    	RegistryConfig defaultConfig = null;
    	List<DubboRegistryConfig> registries = dubboProperties.getRegistry();
    	if(registries != null && !registries.isEmpty()){
    		defaultConfig = registries.get(0);
    	}
        return defaultConfig;
    }

    @Bean
    @Primary
    public ProtocolConfig requestProtocolConfig() {
    	ProtocolConfig defaultConfig = null;
    	List<DubboProtocolConfig> protocols = dubboProperties.getProtocol();
    	if(protocols != null && !protocols.isEmpty()){
    		defaultConfig = protocols.get(0);
    	}
        return defaultConfig;
    }

    @Bean
    @Primary
    public ProviderConfig requestProviderConfig() {
    	ProviderConfig defaultConfig = null;
    	List<DubboProviderConfig> providers = dubboProperties.getProvider();
    	if(providers != null && !providers.isEmpty()){
    		defaultConfig = providers.get(0);
    	}
        return defaultConfig;
    }
    
    @Bean
    public ConsumerConfig requestConsumerConfig() {
        return dubboProperties.getConsumer();
    }

}
