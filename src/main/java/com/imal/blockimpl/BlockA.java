package com.imal.blockimpl;

import com.imal.block.AbstractBlock;
import com.imal.block.AbstractIOBlock;
import com.imal.ref.Referance;
import com.imal.ref.S3Ref;

/**
 * Created by imal365 on 5/28/18.
 */
public class BlockA extends AbstractIOBlock {

    public BlockA(String id){
        super(id);
        setOutputKeys(FEED.VIDEO, FEED.IMAGE_X);
    }

    public void process() {

        System.out.println("I'm A and I don't have any inputs, I produce them");

        addOutputReferances(FEED.VIDEO, new S3Ref("com.bhagya.matta","cde/dedf/imal.mov"));
        addOutputReferances(FEED.IMAGE+"_0", new S3Ref("com.bhagya.matta","dedf/imal_0.jpg"));
        addOutputReferances(FEED.IMAGE+"_1", new S3Ref("com.bhagya.matta","dedf/imal_1.jpg"));
        addOutputReferances(FEED.IMAGE+"_2", new S3Ref("com.bhagya.matta","dedf/imal_2.jpg"));
        addOutputReferances(FEED.IMAGE+"_3", new S3Ref("com.bhagya.matta","dedf/imal_3.jpg"));

    }
}
