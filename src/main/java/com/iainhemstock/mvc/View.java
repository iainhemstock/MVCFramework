package com.iainhemstock.mvc;

public interface View {
    String getFxmlName();
    void setController(Controller controller);
    void update(Object viewModel);
}
