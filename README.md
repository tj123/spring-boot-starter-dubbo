#spring-boot-start-dubbo

## 如何使用

### 1. 基本使用请见：

https://github.com/teaey/spring-boot-starter-dubbo
```
git clone git@github.com:JohnsonLow/spring-boot-starter-dubbo.git
```

### 2. 支持XML配置文件：
### 2. 编译安装（暂时未发布。目前未发现bug）

优先加载XML配置，路径：META-INF/spring/applicationContext*.xml

### 3. 支持Properties配置文件：

### 3. 修改maven配置文件(可以参考样例[spring-boot-starter-dubbo-sample](https://github.com/JohnsonLow/spring-boot-starter-dubbo-sample))

##### 在Spring Boot项目的pom.xml修改依赖的版本及编码:
```
# annotation
spring.dubbo.scan=com.ouyeel
<properties>
    <java.version>1.7</java.version>
    <spring-boot.version>1.5.1.RELEASE</spring-boot.version>
    <version.compiler-plugin>3.5.1</version.compiler-plugin>
    <version.source-plugin>2.2.1</version.source-plugin>
    <version.javadoc-plugin>2.9.1</version.javadoc-plugin>
    <version.maven-gpg-plugin>1.5</version.maven-gpg-plugin>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
</properties>

# application
spring.dubbo.application.name=data-task-provider
 ```
#### 该项目分为了两个模块：
* starter-dubbo-common 该模块主要功能为扫描dubbo组件 
* starter-dubbo-server 依赖 starter-common 便于注册到zookeeper

# registry
spring.dubbo.registry[0].id=reg-int
spring.dubbo.registry[0].address=zookeeper://127.0.0.1:2181
spring.dubbo.registry[1].id=reg-ext
spring.dubbo.registry[1].address=zookeeper://192.168.0.10:2181
spring.dubbo.registry[2].id=reg-test
spring.dubbo.registry[2].address=zookeeper://192.168.0.30:2181
##### maven插件用于打包成可执行的jar文件,添加以下插件(这里一定要加载需要打包成jar的mudule的pom中)
```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```
### 4. 服务接口
```
package com.lyf.samples.api;

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
public interface HelloService {
    String code(String device);
}

# consumer
spring.dubbo.consumer.check=false
```
### 5. 发布服务

##### 在pom.xml中添加以下依赖:

根据实际情况依赖最新版本

```
 <dependency>
     <groupId>com.oqiji.springboot</groupId>
     <artifactId>starter-dubbo-server</artifactId>
     <version>1.0.0</version>
 </dependency>
 ```

在application.yml添加Dubbo的版本信息和客户端超时信息,如下:
```
spring:
  dubbo:
    application:
      name: provider
    registry:
      address: zookeeper://127.0.0.1:20181
    protocol:
      name: dubbo
      prot: 20880

  datasource:
      url: jdbc:mysql://127.0.0.1:3306/qiji?useUnicode=true&characterEncoding=UTF8
      username: qiji
      password: qiji,123
debug: true
```
> spring.dubbo.scan 为要扫描的包。也可使用@DubboScan进行配置

* 编写你的Dubbo服务,只需要添加要发布的服务实现上添加 @Service ,如下
```
  package com.lyf.ds;
  
  import com.alibaba.dubbo.config.annotation.Service;
  import com.lyf.samples.api.HelloService;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.jdbc.core.JdbcTemplate;
  import org.springframework.util.CollectionUtils;
  import java.util.List;
  
  @Service(version = "1.0")
  public class HelloServiceProvider implements HelloService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public String code(String device) {
      List<String> res =  jdbcTemplate.queryForList("SELECT code FROM activity WHERE device = ? ", String.class, device);
      if(CollectionUtils.isEmpty(res)){
        return null;
      }
      return res.get(0);
    }
  }

```

* spring boot启动
```
  package com.lyf.ds;
  
  import com.oqiji.boot.dubbo.DubboScan;
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  
  /**
   * Created by 永锋 on 2017/2/22.
   */
  @SpringBootApplication
  @DubboScan("com.lyf.ds")
  public class Server {
    public static void main(String[] args) {
      SpringApplication.run(Server.class, args);
    }
  }
```

### 6. 消费Dubbo服务
* 在application.properties添加Dubbo的版本信息和客户端超时信息,如下:
```
spring:
  dubbo:
    application:
      name: consumer
    registry:
      address: zookeeper://127.0.0.1:20181
#    scan: com.lyf.dc
debug: true

```

##### 在pom.xml中添加以下依赖:

根据实际情况依赖最新版本

```
 <dependency>
    <groupId>com.oqiji.springboot</groupId>
    <artifactId>starter-dubbo-common</artifactId>
    <version>1.0.0</version>
 </dependency>
 ```
* 引用Dubbo服务,只需要添加要发布的服务实现上添加 @Reference ,如下:
```
  package com.lyf.dc;
  
  import com.alibaba.dubbo.config.annotation.Reference;
  import com.lyf.samples.api.HelloService;
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;
  import org.springframework.stereotype.Component;
  
  @Component
  public class HelloServiceReq {
    private static Logger logger = LoggerFactory.getLogger(HelloServiceReq.class);
  
    @Reference(version = "1.0")
    public HelloService helloService;
  
    public void hello() {
      long start = System.currentTimeMillis();
      for (int i = 0; i < 10000; i++) {
        String result = helloService.code("bbk_bbk72_t_jb3_jzusjfbi65wwqosk" + i);
        logger.info("{}. result is {}", i, result);
      }
      logger.info("total spent {} ms", System.currentTimeMillis() - start);
    }
  }

```
* spring boot启动
```
  package com.lyf.dct;
  
  import com.lyf.dc.HelloServiceReq;
  import com.oqiji.boot.dubbo.DubboScan;
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.context.ConfigurableApplicationContext;
  
  @SpringBootApplication
  @DubboScan("com.lyf.dc")
  public class Client {
    public static void main(String[] args) {
      ConfigurableApplicationContext context = SpringApplication.run(Client.class, args);
      HelloServiceReq helloService = context.getBean(HelloServiceReq.class);
      helloService.hello();
    }
  }

```


### 7. 打包

> 可以直接执行Server或者Client启动

> 可以通过mvn clean package 打包成可执行的jar文件
