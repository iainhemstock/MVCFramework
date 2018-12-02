package com.iainhemstock.mvc;

import java.util.HashMap;
import java.util.Map;

public class ResponseMap implements Response {

    private Map<String, Object> map;

    public ResponseMap() {
        this.map = new HashMap<>();
    }

    @Override
    public void setParameter(String key, Object value) {
        this.map.put(key, value);
    }

    @Override
    public Object getParameter(String key) {
        return this.map.get(key);
    }
}
