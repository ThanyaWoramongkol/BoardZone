
public class CheckINTOneDigit<T> extends CheckINT {
    public CheckINTOneDigit(){
        super(1);
    }
    
    public CheckINTOneDigit(T content){
        this();
        this.content = content;
    }
}
