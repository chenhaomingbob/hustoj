///* Verwandlung Online Judge - A cross-platform judge online system
// * Copyright (C) 2018 Haozhe Xie <cshzxie@gmail.com>
// *
// * This program is free software: you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation, either version 3 of the License, or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License
// * along with this program.  If not, see <http://www.gnu.org/licenses/>.
// *
// *
// *                              _ooOoo_
// *                             o8888888o
// *                             88" . "88
// *                             (| -_- |)
// *                             O\  =  /O
// *                          ____/`---'\____
// *                        .'  \\|     |//  `.
// *                       /  \\|||  :  |||//  \
// *                      /  _||||| -:- |||||-  \
// *                      |   | \\\  -  /// |   |
// *                      | \_|  ''\---/''  |   |
// *                      \  .-\__  `-`  ___/-. /
// *                    ___`. .'  /--.--\  `. . __
// *                 ."" '<  `.___\_<|>_/___.'  >'"".
// *                | | :  `- \`.;`\ _ /`;.`/ - ` : | |
// *                \  \ `-.   \_ __\ /__ _/   .-` /  /
// *           ======`-.____`-.___\_____/___.-`____.-'======
// *                              `=---='
// *
// *                          HERE BE BUDDHA
// *
// */
//package com.zjgsu.messager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * 消息发送服务.
// * @author chm 神魔法
// * @date 2019/5/31 17:42
// */
//@Component
//public class MessageSender {
//	/**
//	 * 发送消息至消息队列.
//	 * @param mapMessage - Key-Value格式的消息
//	 */
//	public void sendMessage(final Map<String, Object> mapMessage) {
//		jmsTemplate.convertAndSend(mapMessage);
//	}
//
//	/**
//	 * 自动注入的JmsTemplate对象.
//	 * 用于发送消息至消息队列.
//	 */
//	@Autowired
//	private JmsTemplate jmsTemplate;
//}