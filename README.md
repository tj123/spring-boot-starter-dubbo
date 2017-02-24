#spring-boot-start-dubbo

spring-boot-start-dubbo，让你可以使用spring-boot的方式开发dubbo程序。使dubbo开发变得如此简单。
> 该项目是由teaey的项目[spring-boot-starter-dubbo](https://github.com/teaey/spring-boot-starter-dubbo)重构而成

## 如何使用

### 1. clone 代码（可选，已经发布到中央仓库，可以直接依赖中央仓库的稳定版本）

```
git clone git@github.com:teaey/spring-boot-starter-dubbo.git
```

### 2. 编译安装（可选）

```
cd spring-boot-starter-dubbo
mvn clean install
```


### 3. 修改maven配置文件(可以参考样例[spring-boot-starter-dubbo-sample](https://github.com/teaey/spring-boot-starter-dubbo-sample))

##### 在Spring Boot项目的pom.xml修改依赖的版本及编码:
```
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

 ```
#### 该项目分为了两个模块：
* starter-common 该模块主要功能为扫描dubbo组件 
* starter-server 依赖 starter-common 便于注册到zookeeper

##### maven插件用于打包成可执行的jar文件,添加以下插件(这里一定要加载需要打包成jar的mudule的pom中)
```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>${spring-boot.version}</version>
</plugin>
```

### 4. 发布服务

服务接口:

```
package cn.teaey.sprintboot.test;

public interface EchoService {
    String echo(String str);
}

```
##### 在pom.xml中添加以下依赖:

根据实际情况依赖最新版本

```
 <dependency>
     <groupId>io.dubbo.springboot</groupId>
     <artifactId>starter-server</artifactId>
     <version>1.0.0</version>
 </dependency>
 ```

在application.properties添加Dubbo的版本信息和客户端超时信息,如下:
```
spring.dubbo.application.name=provider
spring.dubbo.registry.address=zookeeper://192.168.99.100:32770
spring.dubbo.protocol.name=dubbo
spring.dubbo.protocol.port=20880
spring.dubbo.scan=cn.teaey.sprintboot.test
```
> spring.dubbo.scan 为要扫描的包。也可使用@DubboScan进行配置

* spring boot启动
```
package cn.teaey.sprintboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.dubbo.springboot.DubboScan;

@SpringBootApplication
@DubboScan({"cn.teaey.springboot.test"})
public class Server {
    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
}

```
* 编写你的Dubbo服务,只需要添加要发布的服务实现上添加 @Service ,如下
```
package cn.teaey.sprintboot.test;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class EchoServerImpl implements EchoService {

    public String echo(String str) {
        System.out.println(str);
        return str;
    }
}

```

### 5. 消费Dubbo服务
* 在application.properties添加Dubbo的版本信息和客户端超时信息,如下:
```
spring.dubbo.application.name=consumer
spring.dubbo.registry.address=zookeeper://192.168.99.100:32770
spring.dubbo.scan=cn.teaey.sprintboot.test
```

##### 在pom.xml中添加以下依赖:

根据实际情况依赖最新版本

```
 <dependency>
     <groupId>io.dubbo.springboot</groupId>
     <artifactId>starter-common</artifactId>
     <version>1.0.0</version>
 </dependency>
 ```

* spring boot启动
```
package cn.teaey.sprintboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@DubboScan({"cn.teaey.springboot.test"})
public class Client {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Client.class, args);
        AbcService bean = run.getBean(AbcService.class);
        System.out.println(bean.echoService.echo("abccc"));
    }
}

```
* 引用Dubbo服务,只需要添加要发布的服务实现上添加 @Reference ,如下:
```
package cn.teaey.sprintboot.test;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class AbcService {
    @Reference(version = "1.0.0")
    public EchoService echoService;
}
```

### 6. 打包

> 可以直接执行Server或者Client启动

> 可以通过mvn clean package 打包成可执行的jar文件
