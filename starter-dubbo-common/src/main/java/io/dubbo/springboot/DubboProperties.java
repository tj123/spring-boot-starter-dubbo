package io.dubbo.springboot;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import io.dubbo.springboot.config.DubboApplicationConfig;
import io.dubbo.springboot.config.DubboConsumerConfig;
import io.dubbo.springboot.config.DubboProtocolConfig;
import io.dubbo.springboot.config.DubboProviderConfig;
import io.dubbo.springboot.config.DubboRegistryConfig;

@ConfigurationProperties(prefix = "spring.dubbo")
public class DubboProperties {

    private String scan;

    private DubboApplicationConfig application;

    private List<DubboRegistryConfig> registry;

    private List<DubboProtocolConfig> protocol;
    
    private List<DubboProviderConfig> provider;
    
    private DubboConsumerConfig consumer;

	public String getScan() {
		return scan;
	}

	public void setScan(String scan) {
		this.scan = scan;
	}

	public DubboApplicationConfig getApplication() {
		return application;
	}

	public void setApplication(DubboApplicationConfig application) {
		this.application = application;
	}

	public List<DubboRegistryConfig> getRegistry() {
		return registry;
	}

	public void setRegistry(List<DubboRegistryConfig> registry) {
		this.registry = registry;
	}

	public List<DubboProtocolConfig> getProtocol() {
		return protocol;
	}

	public void setProtocol(List<DubboProtocolConfig> protocol) {
		this.protocol = protocol;
	}

	public List<DubboProviderConfig> getProvider() {
		return provider;
	}

	public void setProvider(List<DubboProviderConfig> provider) {
		this.provider = provider;
	}

	public DubboConsumerConfig getConsumer() {
		return consumer;
	}

	public void setConsumer(DubboConsumerConfig consumer) {
		this.consumer = consumer;
	}

}
