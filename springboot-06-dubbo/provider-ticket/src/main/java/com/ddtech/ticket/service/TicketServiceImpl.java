package com.ddtech.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

//@Service是dubbo的注解,意思是讲此服务发布出去
@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《大话西游》";
    }
}
