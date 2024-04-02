
import java.awt.*;
import javax.swing.*;
import java.sql.ResultSet;

public class Account {
    private static String username;
    private static String firstname;
    private static String lastname;
    private static String email;
    private static String phone;
    private static String year;
    private static String faculty;
    private static int id;
    private static ImageIcon profile;
    private static Image images;
    
    public static void setData(){
        try {
            Database db = new Database();
            String sql = String.format("SELECT * FROM boardzone.Account WHERE username = '%s';", Account.username);
            ResultSet rs = db.getSelect(sql);
            if (rs.next()){
                id = rs.getInt("id");
                firstname = rs.getString("firstname");
                lastname = rs.getString("lastname");
                email = rs.getString("email");
                phone = rs.getString("phone");
                year = rs.getString("year");
                faculty = rs.getString("faculty");
                
                byte[] imgBytes = rs.getBytes(String.format("img"));
                Image image = new ImageIcon(imgBytes).getImage();
                ImageIcon icon = new ImageIcon(image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH));
                profile = icon;
                images = image;
            }
            
            db.close();
            System.out.println(username + " | " + firstname + " " + lastname + id);
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void setDataPlus(String username, String firstname, String lastname, String email, String phone, String year, String faculty){
        try {
            Database db = new Database();
            String sql = String.format("UPDATE boardzone.Account set username = '%s', firstname = '%s', lastname = '%s', email = '%s', phone = '%s', year = '%s', faculty = '%s' WHERE id = %s;", 
                    username, firstname, lastname, email, phone, year, faculty, Account.id);
            
            db.update(sql);
            db.close();
            
            System.out.println("Save.");
            
            Account.username = username; Account.firstname = firstname; Account.lastname = lastname;
            Account.email = email; Account.phone = phone; Account.year = year; Account.faculty = faculty;

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static String getUsername(){
        return username;
    }
    
    public static void setUsername(String username){
        Account.username = username;
    }
    
    public static String getFirstname(){
        return firstname;
    }
    
    public static void setFirstname(String firstname){
        Account.firstname = firstname;
    }
    
    public static String getLastname(){
        return lastname;
    }
    
    public static void setLastname(String lastname){
        Account.lastname = lastname;
    }
    
    public static String getEmail(){
        return email;
    }
    
    public static void setEmail(String email){
        Account.email = email;
    }
    
    public static String getPhone(){
        return phone;
    }
    
    public static void setPhone(String phone){
        Account.phone = phone;
    }
    
    public static String getYear(){
        return year;
    }
    
    public static void setYear(String year){
        Account.year = year;
    }
    
    public static String getFaculty(){
        return faculty;
    }
    
    public static int getID(){
        return id;
    }
    
    public static void setID(int id){
        Account.id = id;
    }
    
    public static ImageIcon getProfile(){
        return profile;
    }
    
    public static Image getImage(){
        return images;
    }
    
    public static void setImage(){
        try {
            Database db = new Database();
            String sql = String.format("SELECT * FROM boardzone.Account WHERE username = '%s';", Account.username);
            ResultSet rs = db.getSelect(sql);
            if (rs.next()){
            byte[] imgBytes = rs.getBytes(String.format("img"));
            Image image = new ImageIcon(imgBytes).getImage();
            ImageIcon icon = new ImageIcon(image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH));

//                Account picture = new Account();
            profile = icon;
            images = image;
            }
            db.close();
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
