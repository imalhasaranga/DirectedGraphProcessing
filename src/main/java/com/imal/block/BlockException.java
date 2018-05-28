package com.imal.block;

/**
 * Created by imal365 on 5/28/18.
 */
public class BlockException extends Exception {
    public BlockException(Throwable t){
        super(t);
    }

    public BlockException(String t){
        super(t);
    }
}
