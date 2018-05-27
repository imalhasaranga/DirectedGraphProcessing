package com.imal.block;

import com.imal.ref.Referance;
import com.imal.ref.S3Ref;

import java.util.List;

/**
 * Created by imal365 on 5/27/18.
 */
public class Block extends AbstractBlock {

    public Block(String id){
        super(id);
    }

    public void process() {
        System.out.println("I'm processed : "+getId());
    }
}
