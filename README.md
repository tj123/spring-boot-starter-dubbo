#spring-boot-start-dubbo

## 如何使用

### 1. 基本使用请见：

https://github.com/teaey/spring-boot-starter-dubbo

### 2. 支持XML配置文件：

优先加载XML配置，路径：META-INF/spring/applicationContext*.xml

### 3. 支持Properties配置文件：

```
# annotation
spring.dubbo.scan=com.ouyeel

# application
spring.dubbo.application.name=data-task-provider

# registry
spring.dubbo.registry[0].id=reg-int
spring.dubbo.registry[0].address=zookeeper://127.0.0.1:2181
spring.dubbo.registry[1].id=reg-ext
spring.dubbo.registry[1].address=zookeeper://192.168.0.10:2181
spring.dubbo.registry[2].id=reg-test
spring.dubbo.registry[2].address=zookeeper://192.168.0.30:2181

# protocol
spring.dubbo.protocol[0].name=dubbo
spring.dubbo.protocol[0].port=20880
spring.dubbo.protocol[1].name=rest
spring.dubbo.protocol[1].port=8089
spring.dubbo.protocol[1].contextpath=services

# provider
spring.dubbo.provider[0].id=provider-failfast
spring.dubbo.provider[0].cluster=failfast
spring.dubbo.provider[0].timeout=5000
spring.dubbo.provider[1].id=provider-failover
spring.dubbo.provider[1].cluster=failover
spring.dubbo.provider[1].timeout=3000

# consumer
spring.dubbo.consumer.check=false
```
