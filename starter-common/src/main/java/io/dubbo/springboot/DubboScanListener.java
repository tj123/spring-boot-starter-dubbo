package io.dubbo.springboot;

import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yongfeng on 2017/2/23.
 */
@EnableConfigurationProperties(DubboProperties.class)
public class DubboScanListener  implements ApplicationListener {
	private static Logger logger = LoggerFactory.getLogger(DubboScanListener.class);
	private Set<String> registeredScanner = new HashSet<>();
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ApplicationPreparedEvent) {
			registeredScanner.clear();
			ApplicationPreparedEvent preparedEvent = (ApplicationPreparedEvent)event;
			DubboScan dubboScan = preparedEvent.getSpringApplication().getMainApplicationClass().getAnnotation(DubboScan.class);
			ConfigurableApplicationContext context = preparedEvent.getApplicationContext();
			if(dubboScan != null) {
				registry(context, dubboScan.value());
				registry(context, dubboScan.basePackages());
			}
			String envScan = context.getEnvironment().getProperty("spring.dubbo.scan");
			if(StringUtils.isEmpty(envScan)){
				return;
			}
			registry(context, envScan);
		}
	}

	private void registry(ConfigurableApplicationContext context, String... scanPackages) {
		if(scanPackages == null){
			return;
		}
		for(String scanPackage : scanPackages){
			if(registeredScanner.contains(scanPackage)){
				logger.debug("the scanner of {} have registered, please ensure your @DubooScan and spring.dubbo.scan do not have repetitive package",
								scanPackage);
				continue;
			}
			registeredScanner.add(scanPackage);
			AnnotationBean scanner = BeanUtils.instantiate(AnnotationBean.class);
			scanner.setPackage(scanPackage);
			scanner.setApplicationContext(context);
			context.addBeanFactoryPostProcessor(scanner);
			context.getBeanFactory().addBeanPostProcessor(scanner);
			context.getBeanFactory().registerSingleton(scanPackage + ".dubboScannerBean", scanner);
		}
	}
}
