package com.imal.block;

import java.util.List;

/**
 * Created by imal365 on 5/27/18.
 */
public interface IBlock {

    public void process();

    public boolean canProcess();

    public boolean isProcessed();
}
