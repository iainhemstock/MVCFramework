package com.iainhemstock.mvc;

public interface Controller {
    void setViewActivator(ViewActivator viewActivator);
    void setView(View view);
    void updateView(Object viewModel);
}
