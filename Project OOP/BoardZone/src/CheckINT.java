
public abstract class CheckINT<T> {
    protected int limit;
    protected T content;
    protected int checkedT;

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
    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
    
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
