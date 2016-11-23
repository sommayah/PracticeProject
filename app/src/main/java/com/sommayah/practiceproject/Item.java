package com.sommayah.practiceproject;

import java.io.Serializable;

/**
 * Created by sommayahsoliman on 11/22/16.
 */

public class Item implements Serializable {
    private String name;
    private String image;

    public Item(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
