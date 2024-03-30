
import java.awt.*;
import javax.swing.*;
import java.sql.ResultSet;

public class Account {
    public static String username;
    public static String firstname;
    public static String lastname;
    public static String email;
    public static String phone;
    public static String year;
    public static String faculty;
    public static int id;
    public static ImageIcon profile;
    public static Image images;
    
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
    
    public static void setUsername(String firstname){
        try {
            Database db = new Database();
            String sql = String.format("UPDATE boardzone.Account SET username = '%s' "
                    + "WHERE id = %s;", firstname, id);

            db.update(sql);
            db.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void setLastname(String lastname){
        try {
            Database db = new Database();
            String sql = String.format("UPDATE boardzone.Account SET lastname = '%s' WHERE id = '%s';", lastname, id);

            db.update(sql);
            db.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void setEmail(String email){
        try {
            Database db = new Database();
            String sql = String.format("UPDATE boardzone.Account SET email = '%s' WHERE id = %s;", email, id);

            db.update(sql);
            db.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void setPhone(String phone){
        try {
            Database db = new Database();
            String sql = String.format("UPDATE boardzone.Account SET phone = '%s' WHERE id = %s;", phone, id);

            db.update(sql);
            db.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    
    public static void setYear(String year){
        try {
            Database db = new Database();
            String sql = String.format("UPDATE boardzone.Account SET year = '%s' WHERE id = %s;", year, id);

            db.update(sql);
            db.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void setFaculty(String faculty){
        try {
            Database db = new Database();
            String sql = String.format("UPDATE boardzone.Account SET faculty = '%s' WHERE id' = %s;", faculty, id);

            db.update(sql);
            db.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
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
