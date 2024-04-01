
public class CheckINTTwoDigit<T> extends CheckINT {
    public CheckINTTwoDigit(){
        super(2);
    }
    
    public CheckINTTwoDigit(T content){
        this();
        this.content = content;
    }
}
