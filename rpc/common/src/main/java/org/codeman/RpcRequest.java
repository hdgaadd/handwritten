package org.codeman;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RpcRequest implements Serializable {
    // 与ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream()).readObject()的成员变量一致

    private String interfaceName;
    private String methodName;
    private Object[] parameters;
    private Class<?>[] paramTypes;

}
