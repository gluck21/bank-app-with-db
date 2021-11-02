package com.example.bankappwithdb.dto;


import lombok.Data;

@Data
public class ResponseBody<T> {
    private String message;
    private T data;

    public ResponseBody(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ResponseBody() {

    }
}
