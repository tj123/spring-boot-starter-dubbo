package io.dubbo.springboot;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by 永锋 on 2017/2/23.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface DubboScan{
	@AliasFor("value")
	String[] basePackages() default {};

	@AliasFor("basePackages")
	String[] value() default {};
}
