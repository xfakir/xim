package cn.xfakir.xim.core.coder;

import cn.xfakir.xim.core.protocol.Xheader;
import cn.xfakir.xim.core.protocol.Xprotocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

public class Xdecoder extends ByteToMessageDecoder{
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Xprotocol xprotocol = new Xprotocol();
        Xheader xheader = new Xheader();
        xheader.setMagicNumber(byteBuf.readInt());
        int length = byteBuf.readInt();
        xheader.setLength(length);
        xheader.setToken((String) byteBuf.readCharSequence(32, CharsetUtil.UTF_8));
        xheader.setMessageType(byteBuf.readByte());
        xprotocol.setXheader(xheader);
        xprotocol.setBody((String) byteBuf.readCharSequence(length,CharsetUtil.UTF_8));
        list.add(xprotocol);
    }
}
