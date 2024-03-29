
public class CheckINTTwoDigit<T> extends CheckINT {
//    private final int limit = 2;
    private T content;
    private int checkedT;
    
//    public int getLimit(){
//        return limit;
//    }
    public CheckINTTwoDigit(){}
    
    public CheckINTTwoDigit(T content){
        super(2);
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
//    TESTING
//    public static void main(String[] args) {
//        CheckINTTwoDigit<String> test = new CheckINTTwoDigit<>();
//        test.setContent("123");
//        System.out.println(""+test.getCheckText());
//    }
}
