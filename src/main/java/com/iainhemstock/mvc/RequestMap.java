package com.iainhemstock.mvc;

import java.util.HashMap;
import java.util.Map;

public class RequestMap implements Request {

    private Map<String, Object> map;

    public RequestMap() {
        this.map = new HashMap<>();
    }

    @Override
    public void setParameter(String key, Object value) {
        map.put(key, value);
    }

    @Override
    public Object getParameter(String key) {
        return map.get(key);
    }
}
