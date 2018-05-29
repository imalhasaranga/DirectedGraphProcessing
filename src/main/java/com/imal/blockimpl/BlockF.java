package com.imal.blockimpl;

import com.imal.block.AbstractIOBlock;
import com.imal.ref.Referance;
import com.imal.ref.S3Ref;

import java.util.List;

/**
 * Created by imal365 on 5/29/18.
 */
public class BlockF extends AbstractIOBlock{

    public BlockF(String id){
        super(id);
        setInputKeys(FEED.IMAGE_X);
        setOutputKeys(AbstractIOBlock.FEED.VIDEO);
    }

    public void process() {
        List<Referance> videos = findMultipleInputReferance(AbstractIOBlock.FEED.VIDEO_X);

        System.out.println("I'm the block F and here are my inputs");
        for (Referance video : videos) {
            System.out.println(video.toString());
        }
        addOutputReferances(AbstractIOBlock.FEED.VIDEO, new S3Ref("com.bhagya.matta.blockF","cde/dedf/C_1_output.mov"));
    }
}
