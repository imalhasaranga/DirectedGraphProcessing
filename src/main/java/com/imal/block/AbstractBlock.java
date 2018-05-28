package com.imal.block;

import com.imal.ref.Pointer;
import com.imal.ref.Referance;
import com.sun.org.apache.regexp.internal.RE;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by imal365 on 5/27/18.
 */
public abstract class AbstractBlock{

    private List<AbstractBlock> parents = new ArrayList<AbstractBlock>();
    private List<AbstractBlock> childran = new ArrayList<AbstractBlock>();


    private String id;
    private boolean isProcessed = false;

    public AbstractBlock(){}

    public AbstractBlock(String id){
        this.id = id;
    }

    public void doprocess() throws BlockException {
        if(canProcess()){
            process();
            isProcessed = true;
            for (AbstractBlock block : childran) {
                block.doprocess();
            }
        }
    }

    public abstract void process() throws BlockException;

    public void addChild(AbstractBlock block){
        this.childran.add(block);
        block.addParent(this);
    }


    public void addParent(AbstractBlock block){
        this.parents.add(block);
    }



    public boolean canProcess(){
        for (AbstractBlock parent : this.parents) {
            if(!parent.isProcessed()){
                return false;
            }
        }
        return true;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public boolean isProcessed(){
        return isProcessed;
    }




    public List<AbstractBlock> getParents() {
        return parents;
    }

    public List<AbstractBlock> getChildran() {
        return childran;
    }
}
