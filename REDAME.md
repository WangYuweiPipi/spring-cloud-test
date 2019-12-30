- Spring Cloud版本：Finchley.RELEASE
- Spring Boot版本：2.0.2.RELEASE
#### Eureka
用于服务的注册与发现
##### Eureka Server 服务注册中心
- 提供服务注册与发现
- 默认情况下，Eureka Server本身也是Server Client，所以配置文件中配置eureka.client.registerWithEureka:false和fetchRegistry:false来表明自己是一个eureka server
##### Server Provider
- 服务提供方
- 将自身服务注册到Eureka
##### Server Consumer
- 服务消费方
- 从Eureka获取注册服务列表，从而能够消费服务
#### Feign  
支持服务间的调用以及负载均衡
#### Hystrix
处理服务的熔断防止事故扩散
#### Config
分布式系统的配置管理
#### Bus
控制总线
#### Zuul
服务网关

### Module介绍
##### spring-cloud-config
- Config Server
- Eureka Client
##### spring-cloud-config-client
- Config Client
- Eureka Client
- Bus + RabbitMQ
##### spring-cloud-eureka
- Eureka Server
##### spring-cloud-eureka-client
- Eureka client
##### spring-cloud-eureka-feign
- Eureka Server Provider
- Eureka Server Consumer
- Feign
- Hystrix



