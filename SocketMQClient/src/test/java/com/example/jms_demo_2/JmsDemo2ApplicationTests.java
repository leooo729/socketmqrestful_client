package com.example.jms_demo_2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

@SpringBootTest
class JmsDemo2ApplicationTests {
	@Autowired
	private Queue requestQueue;
	@Autowired
	JmsMessagingTemplate jmsMessagingTemplate;
	@Test
	void getTargetMgni() {
		String message = "{\"requestType\":\"1\",\"request\":{\"id\":\"MGI20221021100412897\"}}";
		jmsMessagingTemplate.convertAndSend(requestQueue, message);
	}

	@Test
	void createMgni() {
		String message = "{\"requestType\":\"3\",\"request\":{\"cmNo\":\"3\",\"kacType\":\"1\",\"bankNo\":\"003\",\"ccy\":\"TWD\",\"pvType\":\"1\",\"bicaccNo\":\"0000000\",\"accAmt\":[{\"acc\":\"1\",\"amt\":1000},{\"acc\":\"2\",\"amt\":700}],\"ctName\":\"Leo\",\"ctTel\":\"26262626\"}}";
		jmsMessagingTemplate.convertAndSend(requestQueue, message);
	}
	@Test
	void updateMgni() {
		String message = "{\"requestType\":\"4\",\"id\":\"MGI20221021163130128\",\"request\":{\"cmNo\":\"7\",\"kacType\":\"1\",\"bankNo\":\"599\",\"ccy\":\"TWD\",\"pvType\":\"1\",\"bicaccNo\":\"0000000\",\"accAmt\":[{\"acc\":\"5\",\"amt\":7000},{\"acc\":\"8\",\"amt\":890}],\"ctName\":\"Leo\",\"ctTel\":\"26262626\"}}";
		jmsMessagingTemplate.convertAndSend(requestQueue, message);
	}
	@Test
	void detlteMgni() {
		String message = "{\"requestType\":\"5\",\"request\":{\"id\":\"MGI20221021152429465\"}}";
		jmsMessagingTemplate.convertAndSend(requestQueue, message);
	}


}
