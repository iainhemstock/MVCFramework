package com.iainhemstock.mvc;

import java.net.URL;

public interface ViewLoader {

    void setLocation(URL resource);
    void setController(View view);
    void setRoot(View view);
    void load();

}
