package com.study.api.models;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Message {
    
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }



}
