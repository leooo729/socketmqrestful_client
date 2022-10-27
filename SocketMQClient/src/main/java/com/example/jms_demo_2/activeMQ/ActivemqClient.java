package com.example.jms_demo_2.activeMQ;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

@Component
public class ActivemqClient {
    @Autowired
    JmsTemplate jmsTemplate;

    public void send(String msg) throws JMSException {
        String uid=java.util.UUID.randomUUID().toString();
        jmsTemplate.send("request.queue", messageCreator -> {
            TextMessage message = messageCreator.createTextMessage();
            message.setText(msg);
            message.setStringProperty("uid", uid);
            return message;
        });
        System.out.println("send request");
        Message jmsMessage=jmsTemplate.receiveSelected("response.queue", "uid='"+uid+"'");
        if (jmsMessage==null) {
            System.out.println("receive time out ");
        }
        else {
            TextMessage textMsg=(TextMessage)jmsMessage;
            System.out.println("uid="+jmsMessage.getStringProperty("uid"));
            System.out.println("reponsemsg="+textMsg.getText());
        }
    }







//    @JmsListener(destination = "response.queue", containerFactory = "queueConnectionFactory")
//    public void consumeMessage(String message) {
//        System.out.println("============================================\n");
//        System.out.println("Message received from activemq queue---\n" + message);
//    }

}
