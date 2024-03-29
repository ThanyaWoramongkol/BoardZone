
public abstract class CheckINT {
    protected int limit;

    public CheckINT(){
        this(20);
    }
    public CheckINT(int limit){
        this.limit = limit;
    }
    
    public void setLimit(int limit){
        this.limit = limit;
    }
    public int getLimit(){
        return limit;
    }
    
    //    origin code
    public abstract int getCheckText();

}
