package com.smelnikov.libs.dto;

import java.io.Serializable;
import java.util.Arrays;

public class Product implements Serializable {
    private long id;
    private String product_name;
    private String description;
    private byte[] picture;
    private String type;

    public long getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", type='" + type + '\'' +
                '}';
    }
}
