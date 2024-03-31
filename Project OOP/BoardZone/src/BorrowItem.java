import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.*;

public class BorrowItem implements Item{
    private int gameid;
    private String name;
    private int maxp;
    private String timestart;
    private int timehour;
    private int timemin;
    private boolean ispublic;
    private String loca;
    
//    default
    public BorrowItem(int id){
        this(id, "", 0, 0, 0, true, "");
    }

//    no minute time
    public BorrowItem(int id, String name, int maxplayer,
            int timemin, boolean ispublic, String location){
        this(id, name, maxplayer, 0, timemin, ispublic, location);
    }
//    public BorrowItem(String location, String name, int maxplayer, int timestart,
//            int timehour, boolean ispublic){
//        this("", name, maxplayer, timestart, timehour, 0, ispublic);
//    }
    
//    have all
    public BorrowItem(int id, String name, int maxplayer,
            int timehour, int timemin, boolean ispublic, String location){
        this.gameid = id;
        this.name = name;
        this.maxp = maxplayer;
//        this.timestart = timestart;
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
    public void setTimeStart(String timestart){
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
    public String getTimeStart(){
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
    
    public void deleteBorrowData(){}
    
    public String showTimeLeft(int id){
        Database db = new Database();
        try{
            System.out.println("Connecting to database...");
            ResultSet rs = db.getSelect(String.format("SELECT * FROM boardzone.Borrow_item WHERE idboradgame = '%s'", ""+id));
            while((rs!=null) && (rs.next())){
                this.timestart = rs.getString("Borrow_at");

                System.out.println("Loading isAvailable complete!");
                System.out.println(timestart);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        db.close();
        
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
//        String formattime = timestart.format(format);
//            this.setText(formattime);
//        this.setTimeStart(timestart);
//        return "HH:mm";
        return timestart;
    }
//    public static void main(String[] args) {
//        System.out.println(this.showTimeLeft(6));
//        
//    }

    @Override
    public boolean CanJoin() {
        return this.getIsPublic();
    }

    @Override
    public void senttoDataBase() {
        Database db = new Database();
        try{
            int intispublic = this.ispublic ? 1 : 0;
            db.update(String.format("INSERT INTO boardzone.Borrow_item (item_name, location, ispublic,\n" +
    "Maxplayer, EndHour, EndMin, idboradgame)\n" +
    "VALUES ('%s', '%s', '%d', '%d', '%d', '%d', '%d');"
                        , this.name, this.loca, intispublic, this.maxp, this.timehour, this.timemin, this.gameid));
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        db.close();
    }

    
    
}
