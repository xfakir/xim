package cn.xfakir.xim.core.protocol;

import lombok.Data;

/**
 * +-------+---------+
 * | header|  body   |
 * +-------+---------+
 */
@Data
public class Xprotocol {
    /**
     * 协议头
     */
    private Xheader xheader;

    /**
     * 消息主体内容
     */
    private String body;
}
