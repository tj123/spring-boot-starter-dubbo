package io.dubbo.springboot;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.bind.PropertiesConfigurationFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.validation.BindException;

import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import io.dubbo.springboot.config.DubboProtocolConfig;
import io.dubbo.springboot.config.DubboProviderConfig;
import io.dubbo.springboot.config.DubboRegistryConfig;

/**
 * 注册Dubbo
 * @author Francis
 *
 */
@Configuration
public class DubboRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

	private ConfigurableEnvironment environment;

	private DubboProperties dubboProperties;

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		this.bindDubboProperties();
		this.registerRegistries(registry);
		this.registerProtocols(registry);
		this.registerProviders(registry);
	}
	
	private void registerRegistries(BeanDefinitionRegistry registry){
		List<DubboRegistryConfig> registries = dubboProperties.getRegistry();
		if(registries != null && !registries.isEmpty()){
			for (int i = 1, length = registries.size(); i < length; i++) {
				DubboRegistryConfig dubboRegistryConfig = registries.get(i);
				String beanId = dubboRegistryConfig.getId();
				if (!registry.containsBeanDefinition(beanId)) {
					this.registerBeanDefinition(registry, RegistryConfig.class, dubboRegistryConfig, beanId);
				}
			}
		}
	}
	
	private void registerProtocols(BeanDefinitionRegistry registry){
		List<DubboProtocolConfig> protocols = dubboProperties.getProtocol();
    	if(protocols != null && !protocols.isEmpty()){
    		for (int i = 1, length = protocols.size(); i < length; i++) {
    			DubboProtocolConfig dubboProtocolConfig = protocols.get(i);
    			String beanId = dubboProtocolConfig.getName();
    			this.registerBeanDefinition(registry, ProtocolConfig.class, dubboProtocolConfig, beanId);
    		}
    	}
	}
	
	private void registerProviders(BeanDefinitionRegistry registry){
		List<DubboProviderConfig> providers = dubboProperties.getProvider();
    	if(providers != null && !providers.isEmpty()){
    		for (int i = 1, length = providers.size(); i < length; i++) {
    			DubboProviderConfig dubboProviderConfig = providers.get(i);
    			String beanId = dubboProviderConfig.getId();
    			this.registerBeanDefinition(registry, ProviderConfig.class, dubboProviderConfig, beanId);
    		}
    	}
	}
	
	private void registerBeanDefinition(BeanDefinitionRegistry registry, Class<?> beanClass, Object bean, String beanId){
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(beanClass);
		beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
		beanDefinition.setSynthetic(true);
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		Map<String, String> properties = null;
		try {
			properties = BeanUtils.describe(bean);
			properties.remove("class");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		propertyValues.addPropertyValues(properties);
		registry.registerBeanDefinition(beanId, beanDefinition);
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = (ConfigurableEnvironment)environment;
	}
	
	private void bindDubboProperties(){
		DubboProperties dubboProperties = new DubboProperties();
		PropertiesConfigurationFactory<Object> registryFactory = new PropertiesConfigurationFactory<Object>(dubboProperties);
		registryFactory.setTargetName("spring.dubbo");
		registryFactory.setPropertySources(this.environment.getPropertySources());
		registryFactory.setConversionService(this.environment.getConversionService());
		try {
			registryFactory.bindPropertiesToTarget();
		} catch (BindException e) {
			e.printStackTrace();
		}
		this.dubboProperties = dubboProperties;
	}

}
