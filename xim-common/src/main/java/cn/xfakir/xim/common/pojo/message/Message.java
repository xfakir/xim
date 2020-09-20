package cn.xfakir.xim.common.pojo.message;

public interface Message<T> {
    void send();
    void receive();
    ChatMessage<T> getAllByConsumer(Long consumerId);
}
