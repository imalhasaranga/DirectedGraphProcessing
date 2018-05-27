package com.imal.ref;

/**
 * Created by imal365 on 5/27/18.
 */
public class UrlRef implements Referance {

    private String url;

    public UrlRef(String url){
        this.url = url;
    }

    @Override
    public String toString() {
        return this.url;
    }
}
