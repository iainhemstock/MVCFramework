package com.iainhemstock.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ViewManager implements ViewActivator {

    private enum ObjectType {
        VIEW, PRESENTER, CONTROLLER
    }

    private Map<String, Map<ObjectType, Class>> viewMap;
    private Controller controller;
    private Presenter presenter;
    private View view;
    private ViewLoader loader;
    private ParentView parentView;

    public ViewManager(ViewLoader loader, ParentView parentView) {
        this.loader = loader;
        this.parentView = parentView;
        this.viewMap = new HashMap<>();
    }

    public void addClassGroup(String viewKey, Class viewClass, Class presenterClass, Class controllerClass) {
        Map<ObjectType, Class> map = Map.of(
                ObjectType.VIEW, viewClass,
                ObjectType.PRESENTER, presenterClass,
                ObjectType.CONTROLLER, controllerClass);
        viewMap.put(viewKey, map);
    }

    @Override
    public void activateView(String viewKey, Response response) {
        loadView(viewKey);
        loadPresenter(viewKey);
        loadController(viewKey);
        this.controller.setView(view);
        this.controller.setViewActivator(this);
        this.view.setController(controller);

        loader.setLocation(getClass().getResource(view.getFxmlName()));
        loader.setController(view);
        loader.setRoot(view);
        loader.load();

        this.presenter.handleResponse(response);
        this.controller.updateView(presenter.getViewModel());
        this.parentView.setChildView(view);
    }

    private Object initializeObjectFromClass(String viewKey, ObjectType objType) {
        Object obj = null;
        Class newClass = viewMap.get(viewKey).get(objType);
        try {
            obj = newClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private void loadView(String viewKey) {
        this.view = (View) initializeObjectFromClass(viewKey, ObjectType.VIEW);
    }

    private void loadPresenter(String viewKey) {
        this.presenter = (Presenter) initializeObjectFromClass(viewKey, ObjectType.PRESENTER);
    }

    private void loadController(String viewKey) {
        this.controller = (Controller) initializeObjectFromClass(viewKey, ObjectType.CONTROLLER);
    }
}
