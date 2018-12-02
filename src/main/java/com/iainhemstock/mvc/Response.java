package com.iainhemstock.mvc;

public class Response {
    private String body;
    private int statusCode;

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setBody(String json) {
        this.body = json;
    }

    public String getBody() {
        return this.body;
    }
}
