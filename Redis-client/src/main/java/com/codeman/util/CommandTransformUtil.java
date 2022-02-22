package com.codeman.util;

import com.codeman.Redis.Command;
import com.codeman.Redis.Protocol;

/**
 * @author hdgaadd
 * Created on 2022/02/22
 *
 * 将命令转换为Redis可识别的命令
 */
public class CommandTransformUtil {

    public static String commandTransform(Command command, byte[]... bytes) {
        StringBuilder sb = new StringBuilder();

        // 指令数量
        sb.append(Protocol.STAR)
                .append(1 + bytes.length)
                .append(Protocol.LINE);

        // 指令类型字符数
        sb.append(Protocol.STRING_LENGTH)
                .append(command.toString().length())
                .append(Protocol.LINE);

        // 指令类型
        sb.append(command.toString())
                .append(Protocol.LINE);

        // 添加具体指令
        for (byte[] b : bytes) {
            sb.append(Protocol.STRING_LENGTH)
                    .append(b.length)
                    .append(Protocol.LINE);

            sb.append(new String(b)) // 必须new String，而不能b.toString()
                    .append(Protocol.LINE);
        }
        return sb.toString();
    }
}
