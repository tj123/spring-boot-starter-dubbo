package io.dubbo.springboot;

import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by 永锋 on 2017/2/23.
 */
public class DubboScanListener  implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ApplicationPreparedEvent) {
			ApplicationPreparedEvent preparedEvent = (ApplicationPreparedEvent)event;
			DubboScan dubboScan = preparedEvent.getSpringApplication().getMainApplicationClass().getAnnotation(DubboScan.class);
			if(dubboScan != null) {
				ConfigurableApplicationContext context = preparedEvent.getApplicationContext();
				registry(context, dubboScan.value());
				registry(context, dubboScan.basePackages());
			}
		}
	}

	private void registry(ConfigurableApplicationContext context, String[] scanPackages) {
		if(scanPackages == null){
			return;
		}
		for(String scanPackage : scanPackages){
			AnnotationBean scanner = BeanUtils.instantiate(AnnotationBean.class);
			scanner.setPackage(scanPackage);
			scanner.setApplicationContext(context);
			context.addBeanFactoryPostProcessor(scanner);
			context.getBeanFactory().addBeanPostProcessor(scanner);
			context.getBeanFactory().registerSingleton(scanPackage + ".dubboScannerBean", scanner);
		}
	}
}
