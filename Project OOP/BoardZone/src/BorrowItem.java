import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.*;
import java.time.*;

public class BorrowItem implements Item{
    private int gameid;
    private String name;
    private int maxp;
    private String timestart; //ex. 12:55
    private int timehour; //ex. hour
    private int timemin; // ex. min
    private boolean ispublic;
    private String loca;
    
    private int starthour; // ex. 12
    private int startmin; // ex. 55
    private LocalTime timenow;
    private int nowhour;
    private int nowmin;
    private LocalTime timeend; // ex. endhour:endmin
    private int endhour; // ex. 12 + hour % 24 - 24
    private int endmin; // ex. 55 + min % 60 - 60
    private long hourleft;
    private long minuteleft;
    private String TimeLeft;
    private boolean checkdelete;
    
    
//    default
    public BorrowItem(int id, String timestart){
        this(id, "", 0, timestart, 0, 0, true, "");
    }

    
//    have all
    public BorrowItem(int id, String name, int maxplayer, String timestart,
            int timehour, int timemin, boolean ispublic, String location){
        this.gameid = id;
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
    
    public void deleteBorrowData(int id){
        Database db = new Database();
        try{
            System.out.println("Connecting to database...");
            db.update(String.format("DELETE FROM boardzone.Borrow_item WHERE idboradgame = '%s' LIMIT 5", ""+id));
            System.out.println("Delete data complete!");
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        db.close();
    }
    
    public String showTimeLeft(int id){
        checkdelete = false;
        Database db = new Database();
        try{
            System.out.println("Connecting to database...");
            ResultSet rs = db.getSelect(String.format("SELECT * FROM boardzone.Borrow_item WHERE idboradgame = '%s'", ""+id));
            while((rs!=null) && (rs.next())){
                this.timestart = rs.getString("Borrow_at");
                System.out.println("Loading isAvailable complete!");
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        db.close();
        
        String[] cuttime = this.timestart.split(":"); // 12:55
        this.starthour = Integer.parseInt(cuttime[0]); // Hour 12
        this.startmin = Integer.parseInt(cuttime[1]); // Minute 55
        
        LocalTime time = LocalTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        String formattime = time.format(format);
        String[] cutnowtime = formattime.split(":"); // 12:55
        this.nowhour = Integer.parseInt(cutnowtime[0]);
        this.nowmin = Integer.parseInt(cutnowtime[1]);
        
        this.endhour = ((this.starthour + this.timehour) + ((this.startmin + this.timemin) / 60)) % 24;
        this.endmin = (this.startmin + this.timemin) % 60;
        System.out.println("End Time: " + endhour + ":" + endmin);
        
        
        this.timenow = LocalTime.of(nowhour, nowmin); //start localtime
        this.timeend = LocalTime.of(endhour, endmin); //end settime
        
        Duration duration = Duration.between(this.timenow, this.timeend);
        if (nowhour <= endhour){
            this.hourleft = duration.toHours(); // Extract the number of hours
            this.minuteleft = duration.toMinutes() % 60; // Extract the number of minutes
//            System.out.println("First");
            if(nowhour < starthour){
                checkdelete = true;
//                System.out.println("mark1");
            } else if (nowhour == starthour && nowmin < startmin) {
                checkdelete = true;
//                System.out.println("mark2");
            } else if (nowhour == endhour && nowmin > endmin) {
                checkdelete = true;
//                System.out.println("mark3");
            }
        } else {
            this.hourleft = 24 + duration.toHours() ;
            this.minuteleft =(60 + (duration.toMinutes() % 60)) % 60;
            if (nowmin != endmin){
                this.hourleft = this.hourleft - 1;
            }
            System.out.println("Secone");
            if (starthour > nowhour && nowhour > endhour){
                checkdelete = true;
//                System.out.println("1mark");
            } else if (nowhour == starthour && nowmin < startmin) {
                checkdelete = true;
//                System.out.println("2mark");
            } else if (nowhour == endhour && nowmin > endmin) {
                checkdelete = true;
//                System.out.println("3mark");
            }
        }
        this.TimeLeft = String.format("%02d:%02d", this.hourleft, this.minuteleft);
        System.out.println("Time Left: " + this.TimeLeft);
        
        if (TimeLeft.equals("00:00") || hourleft < 0 || minuteleft < 0){
            Database db2 = new Database();
            try{
            System.out.println("Connecting to database...");

            db2.update(String.format("UPDATE boardzone.board_games\n" +
"SET is_available = 1\n" +
"WHERE board_game_id = '%s';", ""+this.gameid));
                System.out.println("Success Update to database...");
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            db.close();
            this.deleteBorrowData(this.gameid);
        }
        
        return TimeLeft;
    }


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
    "Borrow_at, Maxplayer, EndHour, EndMin, idboradgame)\n" +
    "VALUES ('%s', '%s', '%d', '%s', '%d', '%d', '%d', '%d');"
                        , this.name, this.loca, intispublic, this.timestart, this.maxp, this.timehour, this.timemin, this.gameid));
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        db.close();
    }

    
    
}
