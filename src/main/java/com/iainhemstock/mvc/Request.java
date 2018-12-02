package com.iainhemstock.mvc;

public class Request {
    private String body;

    public void setBody(String json) {
        this.body = json;
    }

    public String getBody() {
        return body;
    }
}
