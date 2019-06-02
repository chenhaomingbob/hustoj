package com.zjgsu.messager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息发送服务.
 * @author chm 神魔法
 * @date 2019/5/31 17:42
 */
@Component
public class MessageSender {
	/**
	 * 发送消息至消息队列.
	 * @param mapMessage - Key-Value格式的消息
	 */
	public void sendMessage(final Map<String, Object> mapMessage) {
		jmsTemplate.convertAndSend(mapMessage);
	}

	/**
	 * 自动注入的JmsTemplate对象.
	 * 用于发送消息至消息队列.
	 */
	@Autowired
	private JmsTemplate jmsTemplate;
}