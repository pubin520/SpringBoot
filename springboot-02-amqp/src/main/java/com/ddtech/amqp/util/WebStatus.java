package com.ddtech.amqp.util;

public enum WebStatus {
    SUCCESS("400"),ERROR("500");
    private String status;

      WebStatus(String status){
        this.status=status;
    }
    public String getStatus() {
        return status;
    }
}
