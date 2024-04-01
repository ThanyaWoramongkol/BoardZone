
public class CheckINTOneDigit<T> extends CheckINT {
//    private final static int limit = 1;
    public CheckINTOneDigit(){
        super(1);
    }
    
    public CheckINTOneDigit(T content){
        this();
        this.content = content;
    }
}
