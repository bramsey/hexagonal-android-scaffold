package io.pivotal.main;

public class Item {
    private String name;
    private String val;

    public Item(String name, String val) {
        this.name = name;
        this.val = val;
    }

    public String getName() {
        return name;
    }

    public String getVal() {
        return val;
    }
}
