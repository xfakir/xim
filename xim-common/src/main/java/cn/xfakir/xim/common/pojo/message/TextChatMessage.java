package cn.xfakir.xim.common.pojo.message;

public class TextChatMessage extends ChatMessage<String>{
    @Override
    public void send() {
    }

    @Override
    public void receive() {

    }

    @Override
    public ChatMessage<String> getAllByConsumer(Long consumerId) {
        return null;
    }
}
