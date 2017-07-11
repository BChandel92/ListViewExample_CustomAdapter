package com.example.aditichandel.listviewexample;

/**
 * Created by Aditi CHANDEL on 10-07-2017.
 */

public class Model {

    private String web;
    private Integer imageId;

    public Model(String web, Integer imageId) {
        this.web = web;
        this.imageId = imageId;
    }

    public String getWeb() {
        return web;
    }

    public Integer getImageId() {
        return imageId;
    }


    public void setWeb(String web) {
        this.web = web;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
