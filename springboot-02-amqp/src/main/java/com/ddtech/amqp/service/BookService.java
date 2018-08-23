package com.ddtech.amqp.service;

import com.ddtech.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "ddtech.news")
    public  void bookRecive(Book book){
        System.out.println(book.toString());
    }

    @RabbitListener(queues = "ddtech.news")
    public  void bookReciveMessage(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());

    }
}
