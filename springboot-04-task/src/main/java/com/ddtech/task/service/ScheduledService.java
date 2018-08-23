package com.ddtech.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //cron表达式
    @Scheduled(cron = "0/10 * * * * ? ")
    public void pritlnHello(){
        System.out.println("hello world ......");
    }
}
