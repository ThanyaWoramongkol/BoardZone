import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorrowItem implements Item{
    private Image img;
    private String name;
    private int maxp;
    private int timestart;
    private int timehour;
    private int timemin;
    private boolean ispublic;
    private String loca;
    private boolean canjoin;
    
//    default
    public BorrowItem(){
        this("", 0, 0, 0, 0, true, "");
    }
//    no location (choose private)
    public BorrowItem(String name, int maxplayer, int timestart, int timehour,
            int timemin, boolean ispublic){
        this(name, maxplayer, timestart, timehour, timemin, ispublic, "");
    }
//    no minute time
    public BorrowItem(String name, int maxplayer, int timestart,
            int timemin, boolean ispublic, String location){
        this(name, maxplayer, timestart, 0, timemin, ispublic, location);
    }
//    public BorrowItem(String location, String name, int maxplayer, int timestart,
//            int timehour, boolean ispublic){
//        this("", name, maxplayer, timestart, timehour, 0, ispublic);
//    }
    
//    have all
    public BorrowItem(String name, int maxplayer, int timestart,
            int timehour, int timemin, boolean ispublic, String location){
//        this.img = img;
        this.name = name;
        this.maxp = maxplayer;
        this.timestart = timestart;
        this.timehour = timehour;
        this.timemin = timemin;
        this.ispublic = ispublic;
        this.loca = location;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setMaxPlayer(int maxplayer){
        this.maxp = maxplayer;
    }
    public void setTimeStart(int timestart){
        this.timestart = timestart;
    }
    public void setTimeHour(int timehour){
        this.timehour = timehour;
    }
    public void setTimeMin(int timemin){
        this.timemin = timemin;
    }
    public void setIsPublic(boolean ispublic){
        this.ispublic = ispublic;
    }
    public void setLocation(String location){
        this.loca = location;
    }
    
    public String getName(){
        return this.name;
    }
    public int getMaxPlayer(){
        return this.maxp;
    }
    public int getTimeStart(){
        return this.timestart;
    }
    public int getTimeHour(){
        return this.timehour;
    }
    public int getTimeMin(){
        return this.timemin;
    }
    public boolean getIsPublic(){
        return this.ispublic;
    }
    public String getLocation(){
        return this.loca;
    }

    @Override
    public boolean CanJoin() {
        return this.getIsPublic();
    }

    
    
}
