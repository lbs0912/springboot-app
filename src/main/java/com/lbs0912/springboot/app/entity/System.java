package com.lbs0912.springboot.app.entity;

public class System {

    private String name;

    public System(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "System{" +
                "name='" + name + '\'' +
                '}';
    }
}
