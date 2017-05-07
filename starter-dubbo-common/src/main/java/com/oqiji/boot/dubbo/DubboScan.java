package com.oqiji.boot.dubbo;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by yongfeng on 2017/2/23.
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
