# 📚structure

```lua
handwritten
├── ClassLoader -- 类加载器
├── Collection -- 集合类
     ├── List
     ├── Map
     ├── Queue
     └── Stack
├── JDKProxy -- JDK动态代理
     ├── aspects
     ├── handler
     ├── service
     └── utils
├── Netty -- NIO网络应用框架
     ├── echo-client
     ├── echo-server
     └── netty-all
├── Redis-client -- Redis客户端
     ├── JedisClient
     ├── Redis
     └── util
├── rpc -- 远程过程调用
     ├── api
     ├── common
     ├── rpc-client
     └── rpc-server
├── Tomcat -- Http资源服务器
     ├── config
     ├── http
     └── servlet
└── z-staging box
     ├── ans -- 暂存箱
     └── tool -- 工具
```



# 📖Details

### Netty

**process**

- 初始化管道，服务端、客户端通过管道写入数据、读取数据

**knowledge**

- @FunctionalInterface修饰函数式接口，设置该类**只能拥有一个**抽象接口

  函数式接口表示使用该对象作为**入参**时，**必须实现**该抽象接口

- for (; ;)**相当于**while

- Thread.currentThread()返回当前代码段**正在被哪个线程调用**的信息

- ```
  iterator.remove(); // 删除当前指针，所指向的元素
  ```



### Redis-client

**process**

- 把方法与入参，**转换**为Redis可识别的命令
- 通过**Socket**向Redis发送后执行命令
- 通过Socket接收Redis消息

**knowledge**

- **INCR操作**使键的值+1

- **…**为可接收多个该类型对象

  ```java
  public static String commandTransform(Command command, byte[]... bytes) {
  	...
  }
  ```

  



### rpc

**实现目标**

- 客户端与服务端**共同维护**相同的Rpc接口，客户端调用，服务端执行

**process**

- 客户端

  创建代理类，把某方法执行修改为向端口发送Socket消息

  旨在发送消息让服务端来执行

- 服务端

  接收消息进行解析，执行对应方法，响应Socket消息

- 客户端

  接收服务端的Socket消息，即得到方法的执行的结果

**knowledge**

- WebSocket与HTTP同级，都是网络协议

- try-with-resources可自动关闭资源

  不用编写finally

  ```java
  try(FileInputStream fileInputStream = new FileInputStream) {
  
  } catch {
  
  }
  ```

- 指定JDK语法版本

  ```xml
  <properties>
  	<maven.compiler.source>1.8</maven.compiler.source>
  	<maven.compiler.target>1.8</maven.compiler.target>
  </properties>
  ```

- **project.version**使公共jar不用设定version

  ```xml
  <dependency>
      <groupId>com.codeman</groupId>
      <artifactId>api</artifactId>
      <version>${project.version}</version>
  </dependency>
  ```



### Spring

**content**

- Spring IOC and Spring MVC

**process**

- 读取配置文件，扫描指定文件夹，创建bean的财产BeanDefinition
- 对创建的BeanDefinition进行保存
- 将所保存的BeanDefinition进行实例化 -> 注册
- 对所注册的BeanDefinition进行属性注入

**design**

- BeanFactory底层规范
- Application第二次规范
- AbstractApplicationContext规范实现者之一
- ClassPathXmlApplicationContext继承规范实现者，添加其他功能

**knowledge**

- 每一个规范的实现者，其遵循规范所创建出的功能**不同**



### Mybatis

**knowledge**

- 类.class.getClassLoader().getResourceStream()获取的是项目的classpath(**Source Root**)路径下的资源，一般即java文件夹下的资源文件

  ```
  InputStream inputStream = SqlSessionFactory.class.getClassLoader().getResourceAsStream(fileName);
  ```



### Tomcat

**process**

- java.util.Property的load()**解析**xml文件，创建key为url，val为相关实例的Map
- 创建NIO服务器对象，装配**自定义**触发逻辑，**监听**用户请求
- NIO服务器对象监听请求，**触发**相关逻辑
- ChannelHandlerContext作为管道实现响应消息的**写入**，响应用户请求

**knowledge**

- uri统一资源标识符、url统一资源定位符
- Sting对象的equalsIgnoreCase()，**忽略**两者的大小写，而进行字符串比较
- **java.util.Property**的load()，可以**解析xml文件**，解析格式以"="进行切割



## ClassLoader

**process**

- 重写findClass, 将类自定义加载成byte[]后，传递给defindClass

**knowledge**

- **将.class文件转换为jar**

  ```
  cd C:\Java\jdk1.8.0_311\bin
  
  jar cvf Hello.jar Hello.class
  ```

  