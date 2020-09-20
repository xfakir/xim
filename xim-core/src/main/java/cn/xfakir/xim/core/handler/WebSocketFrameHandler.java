package cn.xfakir.xim.core.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

public class WebSocketFrameHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    private final ChannelGroup group;

    public WebSocketFrameHandler(ChannelGroup group) {
        this.group = group;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame) throws Exception {
        if (webSocketFrame instanceof TextWebSocketFrame) {
            String message = ((TextWebSocketFrame) webSocketFrame).text();
            System.out.println(message);
            channelHandlerContext.channel().writeAndFlush(message);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
