package com.iainhemstock.mvc;

public interface Presenter {
    void handleResponse(Response response);
    Object getViewModel();
}
