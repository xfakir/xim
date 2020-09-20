package cn.xfakir.xim.core.coder;

import cn.xfakir.xim.core.protocol.Xprotocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

public class Xencoder extends MessageToByteEncoder<Xprotocol> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Xprotocol xprotocol, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(xprotocol.getXheader().getMagicNumber());
        byteBuf.writeInt(xprotocol.getXheader().getLength());
        byteBuf.writeCharSequence(xprotocol.getXheader().getToken(), CharsetUtil.UTF_8);
        byteBuf.writeByte(xprotocol.getXheader().getMessageType());
        byteBuf.writeCharSequence(xprotocol.getBody(),CharsetUtil.UTF_8);
    }
}
