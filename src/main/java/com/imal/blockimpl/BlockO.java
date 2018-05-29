package com.imal.blockimpl;

import com.imal.block.AbstractIOBlock;
import com.imal.ref.Referance;
import com.imal.ref.S3Ref;

import java.util.List;

/**
 * Created by imal365 on 5/29/18.
 */
public class BlockO extends AbstractIOBlock {

    public BlockO(String id){
        super(id);
        setInputKeys(FEED.IMAGE_X,FEED.VIDEO_X,FEED.AUDIO_X);
        setOutputKeys(FEED.IMAGE_X,FEED.VIDEO_X,FEED.AUDIO_X);
    }

    public void process() {
        List<Referance> videos = findMultipleInputReferance(AbstractIOBlock.FEED.VIDEO_X);

        System.out.println("I'm the block O and here are my inputs");

        int i = 0;
        for (Referance video : videos) {
            System.out.println(video.toString());

            addOutputReferances("VIDEO_"+i,video);
            ++i;
        }

    }
}
