/**
 * Created by imal365 on 5/27/18.
 */
public class Block extends AbstractBlock {

    Block(String id){
        super(id);
    }

    public void process() {
        System.out.println("I'm processed : "+getId());
    }
}
