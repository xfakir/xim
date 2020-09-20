package cn.xfakir.xim.common.pojo.message;

import lombok.Data;

@Data
public abstract  class ChatMessage<T> implements Message<T>{
    private Long consumerId;
    private Long consumerServiceId;
    private T message;
}
