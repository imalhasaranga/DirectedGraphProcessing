package com.imal.ref;

/**
 * Created by imal365 on 5/27/18.
 */
public class S3Ref implements Referance {

    private String bucket;
    private String object_key;

    public S3Ref(String bucket, String object_key){
        this.bucket = bucket;
        this.object_key = object_key;
    }

    @Override
    public String toString() {
        return bucket+":"+object_key;
    }
}
