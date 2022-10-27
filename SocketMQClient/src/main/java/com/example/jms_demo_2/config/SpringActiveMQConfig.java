package com.example.jms_demo_2.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class SpringActiveMQConfig {
    //  配置Bean 如同spring框架下的applicationcontext.xml
    @Value("${requestQueue}")
    private String requestQueue;
    @Value("${topic}")
    private String testTopic;

    @Bean
    public Queue requestQueue() {
        return new ActiveMQQueue(requestQueue);
    }
    @Bean
    public Topic topic() {
        return new ActiveMQTopic(testTopic);
    }

}
