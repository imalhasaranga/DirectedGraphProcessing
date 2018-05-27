import java.util.ArrayList;
import java.util.List;

/**
 * Created by imal365 on 5/27/18.
 */
public abstract class AbstractBlock implements IBlock {

    private List<AbstractBlock> parents = new ArrayList<AbstractBlock>();
    private List<AbstractBlock> childran = new ArrayList<AbstractBlock>();
    private String id;
    private boolean isProcessed = false;

    public AbstractBlock(){

    }

    public AbstractBlock(String id){
        this.id = id;
    }

    public void doprocess() {
        if(canProcess()){
            process();
            isProcessed = true;
            for (AbstractBlock block : childran) {
                block.doprocess();
            }
        }
    }

    public abstract void process();

    public void addChild(AbstractBlock block){
        this.childran.add(block);
        block.addParent(this);
    }

    public void addParent(AbstractBlock block){
        this.parents.add(block);
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

    public boolean canProcess(){
        for (AbstractBlock parent : this.parents) {
            if(!parent.isProcessed()){
                return false;
            }
        }
        return true;
    }
}
