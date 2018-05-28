package com.imal.block;

import com.imal.ref.Pointer;
import com.imal.ref.Referance;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by imal365 on 5/28/18.
 */
public abstract  class AbstractIOBlock extends AbstractBlock {

    private Map<String, Referance> inputs = new HashMap<String, Referance>();
    private Map<String, Referance> outputs = new HashMap<String, Referance>();

    private List<String> inputKeys = new ArrayList<String>();
    private List<String> outputKeys = new ArrayList<String>();

    public AbstractIOBlock(String id){
        super(id);
    }

    public void addChild(AbstractIOBlock block, String[] bindings){
        this.getChildran().add(block);
        block.addParent(this);
        for (String binding : bindings) {    /* ex : image, image_%, image_0, image_1  */
            if(block.isValidInputKey(binding)){
                block.getInputs().put(binding,new Pointer(this.getOutputs(),binding));
            }else{
                throw new RuntimeException("Invalid key");
            }
        }
    }



    public Referance findInputReferance(String key){  /* image */
        Referance ref = this.getInputs().get(key);
        if(ref != null && ref instanceof Pointer){
            return ((Pointer)ref).getReferance();
        }
        throw new RuntimeException(String.format("Key %s not found",key));
    }

    public List<Referance> findMultipleInputReferance(String key){  /* image_% */
        List<Referance> referances = new ArrayList<Referance>();
        for(Map.Entry<String,Referance> input : this.getInputs().entrySet()){
            if(isMatchingKey(key,input.getKey())){
                referances.add(((Pointer)input.getValue()).getReferance());
            }
        }
        return referances;
    }

    public void addOutputReferances(String key, Referance value){
        if(isValidOutputKey(key)){
            this.outputs.put(key,value);
        }else{
            throw new RuntimeException("Output value not found....");
        }
    }


    public boolean isValidInputKey(String key){
        return isValidKey(this.getInputKeys(),key);
    }

    public boolean isValidOutputKey(String key){
        return isValidKey(this.getOutputKeys(),key);
    }


    public Map<String, Referance> getInputs() {
        return inputs;
    }

    public Map<String, Referance> getOutputs() {
        return outputs;
    }

    public List<String> getInputKeys() {
        return inputKeys;
    }

    public List<String> getOutputKeys() {
        return outputKeys;
    }

    public void setInputKeys(String... inputKeys) {
        this.inputKeys = Arrays.asList(inputKeys);
    }

    public void setOutputKeys(String... outputKeys) {
        this.outputKeys = Arrays.asList(outputKeys);
    }



    private boolean isValidKey(List<String> keys, String key){
        if(keys.contains(key)){
            return true;
        }else{
            for (String inputKey : keys) {
                if(isMatchingKey(inputKey,key)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMatchingKey(String inputKey, String checkingKey){
        inputKey = inputKey.replace(AbstractIOBlock.FEED.DELEMETER,"");
        Pattern pattern = Pattern.compile(inputKey+"_[0-9]+", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(checkingKey);
        return matcher.find();
    }

    /* unable to use enums because of the uniqe names */
    public static class FEED{
        private static final String FIXED = "_";
        private static final String REPLACED = "%";

        private static final String DELEMETER = FIXED+REPLACED;

        public static final String VIDEO = "video";
        public static final String AUDIO = "audio";
        public static final String IMAGE = "image";
        public static final String IMAGE_X = IMAGE+DELEMETER;
        public static final String VIDEO_X = VIDEO+DELEMETER;
        public static final String AUDIO_X = AUDIO+DELEMETER;

        public static String gN(String Feed, int number){
            return Feed+FIXED+number;
        }

    }
}
