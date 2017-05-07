package io.dubbo.springboot;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.utils.ReflectUtils;
import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.rpc.Protocol;
import io.dubbo.springboot.config.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.bind.PropertiesConfigurationFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.validation.BindException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 注册Dubbo
 *
 * @author Francis
 */
public class DubboRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private static final Log logger = LogFactory.getLog(DubboRegistrar.class);

    private ConfigurableEnvironment environment;

    private DubboProperties dubboProperties;

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        this.bindDubboProperties();
        this.registerApplication(registry);
        this.registerRegistries(registry);
        this.registerProtocols(registry);
        this.registerProviders(registry);
        this.registerConsumer(registry);
    }

    private void registerApplication(BeanDefinitionRegistry registry) {
        DubboApplicationConfig application = dubboProperties.getApplication();
        if (application != null) {
            String beanId = application.getId();
            if (beanId == null || beanId.length() == 0) {
                beanId = this.generateBeanId(registry, ApplicationConfig.class, null, true);
            }
            boolean primary = true;
            if (!registry.containsBeanDefinition(beanId)) {
                this.registerBeanDefinition(registry, ApplicationConfig.class, application, beanId, primary);
            }
        }
    }

    private void registerConsumer(BeanDefinitionRegistry registry) {
        DubboConsumerConfig consumer = dubboProperties.getConsumer();
        if (consumer != null) {
            String beanId = consumer.getId();
            if (beanId == null || beanId.length() == 0) {
                beanId = this.generateBeanId(registry, ConsumerConfig.class, null, true);
            }
            boolean primary = true;
            if (!registry.containsBeanDefinition(beanId)) {
                this.registerBeanDefinition(registry, ConsumerConfig.class, consumer, beanId, primary);
            }
        }
    }

    private void registerRegistries(BeanDefinitionRegistry registry) {
        List<DubboRegistryConfig> registries = dubboProperties.getRegistry();
        if (registries != null && !registries.isEmpty()) {
            for (int i = 0, length = registries.size(); i < length; i++) {
                DubboRegistryConfig dubboRegistryConfig = registries.get(i);
                String beanId = dubboRegistryConfig.getId();
                if (beanId == null || beanId.length() == 0) {
                    beanId = this.generateBeanId(registry, RegistryConfig.class, null, false);
                }
                boolean primary = false;
                if (i == 0) {
                    primary = true;
                }
                if (!registry.containsBeanDefinition(beanId)) {
                    this.registerBeanDefinition(registry, RegistryConfig.class, dubboRegistryConfig, beanId, primary);
                }
            }
        }
    }

    private void registerProtocols(BeanDefinitionRegistry registry) {
        List<DubboProtocolConfig> protocols = dubboProperties.getProtocol();
        if (protocols != null && !protocols.isEmpty()) {
            for (int i = 0, length = protocols.size(); i < length; i++) {
                DubboProtocolConfig dubboProtocolConfig = protocols.get(i);
                String beanId = dubboProtocolConfig.getId();
                if (beanId == null || beanId.length() == 0) {
                    beanId = this.generateBeanId(registry, ProtocolConfig.class, dubboProtocolConfig.getName(), false);
                }
                boolean primary = false;
                if (i == 0) {
                    primary = true;
                }
                if (!registry.containsBeanDefinition(beanId)) {
                    this.registerBeanDefinition(registry, ProtocolConfig.class, dubboProtocolConfig, beanId, primary);

                    for (String beanName : registry.getBeanDefinitionNames()) {
                        BeanDefinition definition = registry.getBeanDefinition(beanName);
                        PropertyValue property = definition.getPropertyValues().getPropertyValue("protocol");
                        if (property != null) {
                            Object value = property.getValue();
                            if (value instanceof ProtocolConfig && beanId.equals(((ProtocolConfig) value).getName())) {
                                definition.getPropertyValues().addPropertyValue("protocol", new RuntimeBeanReference(beanId));
                            }
                        }
                    }
                }
            }
        }
    }

    private void registerProviders(BeanDefinitionRegistry registry) {
        List<DubboProviderConfig> providers = dubboProperties.getProvider();
        if (providers != null && !providers.isEmpty()) {
            for (int i = 0, length = providers.size(); i < length; i++) {
                DubboProviderConfig dubboProviderConfig = providers.get(i);
                String beanId = dubboProviderConfig.getId();
                if (beanId == null || beanId.length() == 0) {
                    beanId = this.generateBeanId(registry, ProviderConfig.class, null, false);
                }
                boolean primary = false;
                if (i == 0) {
                    primary = true;
                }
                if (!registry.containsBeanDefinition(beanId)) {
                    this.registerBeanDefinition(registry, ProviderConfig.class, dubboProviderConfig, beanId, primary);
                }
            }
        }
    }

    private void registerBeanDefinition(BeanDefinitionRegistry registry, Class<?> beanClass, Object bean, String beanId, boolean primary) {
        if (registry.containsBeanDefinition(beanId)) {
            throw new IllegalStateException("Duplicate spring bean id " + beanId);
        }

        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        beanDefinition.setSynthetic(true);
        beanDefinition.setPrimary(primary);
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        Map<String, String> properties = null;
        try {
            properties = new HashMap<String, String>();
            Map<String, Method> methods = ReflectUtils.getBeanPropertyReadMethods(bean.getClass());
            for (Map.Entry<String, Method> entry : methods.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue().invoke(bean);
                if (value != null) {
                    properties.put(key, value.toString());
                }
            }
            properties.remove("class");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        for (String property : properties.keySet()) {
            String value = properties.get(property);
            if (value != null) {
                value = value.trim();
                if ("registry".equals(property) && RegistryConfig.NO_AVAILABLE.equalsIgnoreCase(value)) {
                    RegistryConfig registryConfig = new RegistryConfig();
                    registryConfig.setAddress(RegistryConfig.NO_AVAILABLE);
                    propertyValues.addPropertyValue(property, registryConfig);
                } else if ("registry".equals(property) && value.indexOf(',') != -1) {
                    this.parseMultiRef("registries", value, beanDefinition);
                } else if ("provider".equals(property) && value.indexOf(',') != -1) {
                    this.parseMultiRef("providers", value, beanDefinition);
                } else if ("protocol".equals(property) && value.indexOf(',') != -1) {
                    this.parseMultiRef("protocols", value, beanDefinition);
                } else {
                    Object reference = null;
                    Class<?> type = value.getClass();
                    if (isPrimitive(type)) {
                        if (("async".equals(property) && "false".equals(value))
                                || ("timeout".equals(property) && "0".equals(value))
                                || ("delay".equals(property) && "0".equals(value))
                                || ("version".equals(property) && "0.0.0".equals(value))
                                || ("stat".equals(property) && "-1".equals(value))
                                || ("reliable".equals(property) && "false".equals(value))) {
                            value = null;
                        }
                        reference = value;
                    } else if ("protocol".equals(property)
                            && ExtensionLoader.getExtensionLoader(Protocol.class).hasExtension(value)
                            && (!registry.containsBeanDefinition(value)
                            || !ProtocolConfig.class.getName().equals(registry.getBeanDefinition(value).getBeanClassName()))) {
                        if (beanClass == ProviderConfig.class) {
                            logger.warn("Recommended replace spring.dubbo.provider.protocol=" + value + " to spring.dubbo.protocol.name=" + value);
                        }
                        ProtocolConfig protocol = new ProtocolConfig();
                        protocol.setName(value);
                        reference = protocol;
                    } else if ("monitor".equals(property)
                            && (registry.containsBeanDefinition(value)
                            || !MonitorConfig.class.getName().equals(registry.getBeanDefinition(value).getBeanClassName()))) {
                        reference = this.convertMonitor(value);
                    }
                    propertyValues.addPropertyValue(property, reference);
                }
            }
        }
        propertyValues.add("id", beanId);

        logger.debug(beanDefinition.getPropertyValues());
        registry.registerBeanDefinition(beanId, beanDefinition);
    }

    private String generateBeanId(BeanDefinitionRegistry registry, Class<?> beanClass, String beanName, boolean single) {
        String beanId = null;
        if (beanName == null || beanName.length() == 0) {
            beanName = beanClass.getName();
        }
        beanId = beanName;
        if (!single) {
            int counter = 2;
            while (registry.containsBeanDefinition(beanId)) {
                beanId = beanName + (counter++);
            }
        }
        return beanId;
    }

    private void parseMultiRef(String property, String value, RootBeanDefinition beanDefinition) {
        String[] values = value.split("\\s*[,]+\\s*");
        ManagedList<RuntimeBeanReference> list = null;
        for (int i = 0; i < values.length; i++) {
            String v = values[i];
            if (v != null && v.length() > 0) {
                if (list == null) {
                    list = new ManagedList<RuntimeBeanReference>();
                }
                list.add(new RuntimeBeanReference(v));
            }
        }
        beanDefinition.getPropertyValues().addPropertyValue(property, list);
    }

    private boolean isPrimitive(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Byte.class || cls == Character.class
                || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class
                || cls == Double.class || cls == String.class || cls == Date.class || cls == Class.class;
    }

    private static final Pattern GROUP_AND_VERION = Pattern.compile("^[\\-.0-9_a-zA-Z]+(\\:[\\-.0-9_a-zA-Z]+)?$");

    private MonitorConfig convertMonitor(String monitor) {
        if (monitor == null || monitor.length() == 0) {
            return null;
        }
        if (GROUP_AND_VERION.matcher(monitor).matches()) {
            String group;
            String version;
            int i = monitor.indexOf(':');
            if (i > 0) {
                group = monitor.substring(0, i);
                version = monitor.substring(i + 1);
            } else {
                group = monitor;
                version = null;
            }
            MonitorConfig monitorConfig = new MonitorConfig();
            monitorConfig.setGroup(group);
            monitorConfig.setVersion(version);
            return monitorConfig;
        }
        return null;
    }

    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }

    private void bindDubboProperties() {
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
