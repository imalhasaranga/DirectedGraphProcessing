package com.imal.blockimpl;

import com.imal.block.AbstractIOBlock;
import com.imal.ref.Referance;
import com.imal.ref.S3Ref;

import java.util.List;

/**
 * Created by imal365 on 5/28/18.
 */
public class BlockD extends AbstractIOBlock {

    public BlockD(String id){
        super(id);
        setInputKeys(FEED.VIDEO);
        setOutputKeys(FEED.VIDEO);
    }

    public void process() {
        List<Referance> videos = findMultipleInputReferance(FEED.VIDEO_X);

        System.out.println("I'm the block D and here are my inputs");
        for (Referance video : videos) {
            System.out.println(video.toString());
        }
        addOutputReferances(FEED.VIDEO, new S3Ref("com.bhagya.matta.dblock","cde/dedf/C_1_output.mov"));
    }
}
