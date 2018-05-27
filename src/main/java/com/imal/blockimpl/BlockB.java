package com.imal.blockimpl;

import com.imal.block.AbstractBlock;
import com.imal.ref.Referance;
import com.imal.ref.S3Ref;
import com.imal.ref.UrlRef;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

/**
 * Created by imal365 on 5/28/18.
 */
public class BlockB extends AbstractBlock {

    public BlockB(String id){
        super(id);
        setInputKeys(FEED.VIDEO, FEED.IMAGE_X);
        setOutputKeys(FEED.VIDEO_X);
    }

    public void process() {
        Referance video = findInputReferance(FEED.VIDEO);
        List<Referance> images = findMultipleInputReferance(FEED.IMAGE_X);

        System.out.println("I'm the block B and here are my inputs");
        System.out.println(video.toString());
        for (Referance image : images) {
            System.out.println(image.toString());
        }
        addOutputReferances(FEED.VIDEO+"_0", new S3Ref("com.bhagya.matta","cde/dedf/B_1_output.mov"));
        addOutputReferances(FEED.VIDEO+"_1", new UrlRef("http://imalhasaranga.com"));
    }
}
