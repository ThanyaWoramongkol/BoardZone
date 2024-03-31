
public class CheckINTOneDigit<T> extends CheckINT {
//    private final int limit = 1;
    private T content;
    private int checkedT;
    

    public CheckINTOneDigit(){
        super(1);
    }
    
    public CheckINTOneDigit(T content){
        super(1);
        this.content = content;
    }
    

    public void setContent(T content){
        this.content = content;
    }
    public T getContent() {
        return content;
    }
    @Override
    public int getCheckText() {
        try{
            checkedT = Integer.parseInt((String) content);
            if (String.valueOf(checkedT).length() > this.getLimit()){
                return Integer.parseInt(String.valueOf(checkedT).substring(0, this.getLimit()));
            } else {
                return checkedT;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
