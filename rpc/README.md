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
