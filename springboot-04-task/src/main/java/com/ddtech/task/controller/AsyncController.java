package com.ddtech.task.controller;

import com.ddtech.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService bookService;

    @GetMapping("book")
    public String getBookByName(){
        bookService.getBookByName("西游记");
        return "success";
    }
}
