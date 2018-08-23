package com.ddtech.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddtech.ticket.service.TicketService;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    //远程调用,生产者的服务实现方法
    @Reference
    TicketService ticketService;

    public  String  getTicket(){
        return ticketService.getTicket();
    }
}
