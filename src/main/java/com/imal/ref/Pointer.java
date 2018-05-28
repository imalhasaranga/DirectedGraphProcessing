package com.imal.ref;

import java.util.Map;

/**
 * Created by imal365 on 5/28/18.
 */
public class Pointer implements Referance{

    private Map<String,Referance> params;
    private String key;

    public Pointer(Map<String,Referance> params, String key){
        this.params = params;
        this.key = key;
    }

    public Referance getReferance() {
        Referance r = params.get(key);
        if(r instanceof Pointer){
            throw new RuntimeException("There can't be non resolved Referances by the time getReferance() called");
        }
        return r;
    }
}
