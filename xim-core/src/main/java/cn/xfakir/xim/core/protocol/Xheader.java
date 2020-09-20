package cn.xfakir.xim.core.protocol;

import lombok.Data;

import java.util.Map;

/**
 * 协议header
 *
 * +----------------------------------------------------+
 * |    名称    |    类型    |    长度    |      描述      |
 * +----------------------------------------------------+
 * | magicNumber | int |   16   | 固定数字，Netty消息验证码 |
 * +----------------------------------------------------+
 * | length  |   int   |   16   |      消息主体长度          |
 * +----------------------------------------------------+
 * |  token  | String | 32 | 用户token，用于保存用户登陆状态 |
 * +----------------------------------------------------+
 * | messageType | byte |    4    |  消息类型，详见字段注释 |
 * +----------------------------------------------------+
 * | attachments | Map | variable | 可选字段，用于拓展消息头 |
 * +----------------------------------------------------+
 */
@Data
public final class Xheader {
    /**
     * netty消息校检码
     */
    private int magicNumber;

    /**
     * 消息长度
     */
    private int length;

    /**
     * token验证
     */
    private String token;

    /**
     * 消息类型
     */
    private byte messageType;

    /**
     * 可选字段
     */
    // private Map<String, String> attachments;

}
