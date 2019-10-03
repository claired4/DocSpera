package com.example.clairedong.docspera;

/**
 * Created by clairedong on 10/2/19.
 */

public class ColorItem {
    private String name;
    private String category;
    private String type;

    public ColorItem(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
