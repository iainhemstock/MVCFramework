package com.iainhemstock.mvc;

public interface Request {
    void setParameter(String key, Object value);
    Object getParameter(String key);
}
