package io.dubbo.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

import io.dubbo.springboot.config.DubboApplicationConfig;
import io.dubbo.springboot.config.DubboConsumerConfig;
import io.dubbo.springboot.config.DubboProtocolConfig;
import io.dubbo.springboot.config.DubboProviderConfig;
import io.dubbo.springboot.config.DubboRegistryConfig;

@ConfigurationProperties(prefix = "spring.dubbo")
public class DubboProperties {

    private String            scan;

    private DubboApplicationConfig application;

    private DubboRegistryConfig    registry;

    private DubboProtocolConfig    protocol;
    
    private DubboProviderConfig provider;
    
    private DubboConsumerConfig consumer;

    public String getScan() {
        return scan;
    }

    public DubboApplicationConfig getApplication() {
        return application;
    }

    public void setApplication(DubboApplicationConfig application) {
        this.application = application;
    }

    public DubboRegistryConfig getRegistry() {
        return registry;
    }

    public void setRegistry(DubboRegistryConfig registry) {
        this.registry = registry;
    }

    public DubboProtocolConfig getProtocol() {
        return protocol;
    }

    public void setProtocol(DubboProtocolConfig protocol) {
        this.protocol = protocol;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

	public DubboProviderConfig getProvider() {
		return provider;
	}

	public void setProvider(DubboProviderConfig provider) {
		this.provider = provider;
	}

	public DubboConsumerConfig getConsumer() {
		return consumer;
	}

	public void setConsumer(DubboConsumerConfig consumer) {
		this.consumer = consumer;
	}

}
