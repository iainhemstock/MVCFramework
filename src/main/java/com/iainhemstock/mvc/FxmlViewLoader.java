package com.iainhemstock.mvc;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;

public class FxmlViewLoader implements ViewLoader {

    private FXMLLoader loader;

    public FxmlViewLoader() {
        this.loader = new FXMLLoader();
    }

    @Override
    public void setLocation(URL resource) {
        this.loader.setLocation(resource);
    }

    @Override
    public void setController(View view) {
        this.loader.setController(view);
    }

    @Override
    public void setRoot(View view) {
        this.loader.setRoot(view);
    }

    @Override
    public void load() {
        try {
            this.loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
