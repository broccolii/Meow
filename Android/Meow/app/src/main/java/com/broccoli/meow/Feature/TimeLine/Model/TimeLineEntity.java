package com.broccoli.meow.Feature.TimeLine.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Broccoli on 2017/8/8.
 */

public class TimeLineEntity {

    /**
     * url : https://media1.giphy.com/media/iTOS89Y0gD1ny/giphy.gif
     * width : 245
     * height : 196
     * size : 928237
     * frames : 24
     * mp4 : https://media1.giphy.com/media/iTOS89Y0gD1ny/giphy.mp4
     * mp4_size : 141670
     * webp : https://media1.giphy.com/media/iTOS89Y0gD1ny/giphy.webp
     * webp_size : 335514
     */

    @SerializedName("url")
    private String gifURL;
    private Double width;
    private Double height;
    @SerializedName("size")
    private Double gifSize;
    @SerializedName("mp4")
    private String mp4URL;
    @SerializedName("mp4_size")
    private Double mp4Size;
    @SerializedName("webp")
    private String webpURL;
    @SerializedName("webp_size")
    private Double webpSize;

    public String getGifURL() {
        return gifURL;
    }

    public void setGifURL(String gifURL) {
        this.gifURL = gifURL;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getGifSize() {
        return gifSize;
    }

    public void setGifSize(Double gifSize) {
        this.gifSize = gifSize;
    }

    public String getMp4URL() {
        return mp4URL;
    }

    public void setMp4URL(String mp4URL) {
        this.mp4URL = mp4URL;
    }

    public Double getMp4Size() {
        return mp4Size;
    }

    public void setMp4Size(Double mp4Size) {
        this.mp4Size = mp4Size;
    }

    public String getWebpURL() {
        return webpURL;
    }

    public void setWebpURL(String webpURL) {
        this.webpURL = webpURL;
    }

    public Double getWebpSize() {
        return webpSize;
    }

    public void setWebpSize(Double webpSize) {
        this.webpSize = webpSize;
    }
}
