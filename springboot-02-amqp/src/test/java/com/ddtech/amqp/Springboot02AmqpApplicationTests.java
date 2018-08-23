package com.ddtech.amqp;

import com.ddtech.amqp.bean.Book;
import com.ddtech.amqp.util.WebStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	/**
	 * 单播 -点对点
	 */
	@Test
	public void send() {
		//rabbitTemplate.send(exchange,rootingkey,message);
		String exchange="ddtech.direct";
		String routkey="ddtech.news";
		Map<String,Object> message=new HashMap<>();
		message.put("msg","第一个消息");
		message.put("msg2", Arrays.asList("hello",123,true));
		rabbitTemplate.convertAndSend(exchange,routkey,message);
	}
	@Test
	public void  revice(){
		Object message = rabbitTemplate.receiveAndConvert("ddtech.news");
		System.out.println(message.getClass());
		System.out.println(message);

	}
	/**
	 * 广播
	 */
	@Test
	public  void  fanoutSend(){
		String exchange="ddtech.fanout";
		String routkey="ddtech.news";
		rabbitTemplate.convertAndSend(exchange,routkey,new Book("西游记","吴承恩"));
	}
	/**
	 * 交互器,队列创建和2者绑定
	 */
	@Test
	public void createInfo(){
		//创建交换器
/*		Exchange  adminExchange=new DirectExchange("amqpadmin.exchange");
		amqpAdmin.declareExchange(adminExchange);*/
		//创建队列true持久化
	/*	Queue queue=new Queue("amqpadmin.queue",true);
		amqpAdmin.declareQueue(queue);*/
 	 //绑定(队列名称，绑定类型，交换器，路由规则，其他参数)
		Binding binding=new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","ddtech.hello",null);
		amqpAdmin.declareBinding(binding);


	}
	@Test
	public void enumTest(){
		System.out.println("success="+WebStatus.SUCCESS.getStatus());
		System.out.println("error="+WebStatus.ERROR.getStatus());

	}
}
