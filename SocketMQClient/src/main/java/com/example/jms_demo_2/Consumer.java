package com.example.jms_demo_2;

import com.example.jms_demo_2.activeMQ.ActivemqClient;
import com.example.jms_demo_2.restful.RestfulService;
import com.example.jms_demo_2.tcpSocket.SocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Component //项目启动之后就立即执行的操作
public class Consumer implements CommandLineRunner {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue requestQueue;
    @Autowired
    ActivemqClient activemqClient;


    @Override
    public void run(String... args) throws Exception {
        while (true) {
            Scanner data = new Scanner(System.in);
            System.out.println("輸入 mq or socket or restful");
            String sendDataType = data.next();
            String requestBody = "";
            switch (sendDataType){
                case "mq": {
                    System.out.println("mq request : ");
                    requestBody = data.next();
                    activemqClient.send(requestBody);
//                    jmsMessagingTemplate.convertAndSend(requestQueue,requestBody);
                    break;
                }
                case "socket": {
                    System.out.println("socket request : ");
                    requestBody = data.next();
                    SocketClient.sendRequest(requestBody);
                    break;
                }case "restful": {
                    System.out.println("resful request : ");
                    requestBody = data.next();
                    RestfulService.getResponse(requestBody);
                    break;
                } default:{
                    System.out.println("請輸入正確資料");
                }
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
}