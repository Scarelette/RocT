package com.happy.replyon;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

public class RocTMessageEncoder extends MessageToByteEncoder<RocTMessage>{
	//将RocTmessage转化为byte 发送出去
	@Override
	protected void encode(ChannelHandlerContext ctx, RocTMessage msg, ByteBuf out) throws Exception {
		//字节数组缓冲区
		//System.out.println("encode-begin");
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try( DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);){
			//在缓冲区中写入RocMessage的类型
			//type
			RocTMessageType roctmessageType = msg.getType();
			dataOutputStream.writeInt(roctmessageType.getCode());
			//port
			dataOutputStream.writeInt(msg.getPort());
			//result
			byte[] resultBytes = msg.getResult().getBytes(CharsetUtil.UTF_8);
			dataOutputStream.writeInt(resultBytes.length);
			dataOutputStream.write(resultBytes);
			//pwd
			byte[] pwdBytes = msg.getPassword().getBytes(CharsetUtil.UTF_8);
			dataOutputStream.writeInt(pwdBytes.length);
			dataOutputStream.write(pwdBytes);

			byte[] reasonBytes = msg.getReason().getBytes(CharsetUtil.UTF_8);
			dataOutputStream.writeInt(reasonBytes.length);
			dataOutputStream.write(reasonBytes);

			byte[] ChannelIdBytes = msg.getChannelId().getBytes(CharsetUtil.UTF_8);
			dataOutputStream.writeInt(ChannelIdBytes.length);
			dataOutputStream.write(ChannelIdBytes);
			//System.out.println("data1");

			//System.out.println("data2");
			//如果有数据也写入缓冲区
			/**
			 if (msg.getData() != null) {
			 dataOutputStream.write(msg.getData().length);
			 dataOutputStream.write(msg.getData());
			 }
			 else {
			 dataOutputStream.write(0);
			 }
			 */
			if (msg.getData() != null && msg.getData().length > 0) {
				dataOutputStream.write(msg.getData());
			}
			byte[] data = byteArrayOutputStream.toByteArray();
			out.writeInt(data.length);
			out.writeBytes(data);
			//System.out.println("encode-success");
		}
	}
}
