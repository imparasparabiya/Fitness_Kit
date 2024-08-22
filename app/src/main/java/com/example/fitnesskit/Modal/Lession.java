package com.example.fitnesskit.Modal;

import java.io.Serializable;

public class Lession implements Serializable {
    private String title;
    private String duartion;
    private String link;
    private String picPath;

    public Lession(String title, String duartion, String link, String picPath) {
        this.title = title;
        this.duartion = duartion;
        this.link = link;
        this.picPath = picPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuartion() {
        return duartion;
    }

    public void setDuartion(String duartion) {
        this.duartion = duartion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
