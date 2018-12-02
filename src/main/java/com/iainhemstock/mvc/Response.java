package com.iainhemstock.mvc;

public interface Response {
    void setParameter(String key, Object value);
    Object getParameter(String key);
}
