package com.zjgsu.messager;

import com.zjgsu.service.zjgsu.JudgeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import static com.zjgsu.util.JudgeCenterConstant.QUESTION_WAITING_JUDGE;


/**
 * 消息接收服务
 *
 * @author chm 神魔法
 * @date 2019/5/31 17:42
 */
@Component
public class MessageReceiver implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof MapMessage) {
            final MapMessage mapMessage = (MapMessage) message;

            try {
                String event = mapMessage.getString("event");

                if (QUESTION_WAITING_JUDGE.equals(event)) {
                    newSubmissionHandler(mapMessage);
                } else {
                    //    String.format("Unknown Event Received. [Event = %s]",event)
                    Logger.warn("Unknown Event Received. [Event = " + event + "]");
                }
            } catch (Exception ex) {
                Logger.catching(ex);
            }
        }
    }

    /**
     * 处理新提交请求.
     *
     * @param mapMessage - 消息队列中收到的MapMessage对象
     * @throws JMSException
     */
    private void newSubmissionHandler(MapMessage mapMessage) throws JMSException {
        int submissionId = mapMessage.getInt("submissionId");
        //  String.format("Received new submission task #%d",submissionId)
        Logger.info("Received new submission task #" + submissionId);
        //TODO
//        judgeService.judgeQuestion(submissionId);
    }

    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(MessageReceiver.class);
}
