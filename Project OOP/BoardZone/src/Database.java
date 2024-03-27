import java.sql.*;
public class Database {
    private Connection connect = null;
    private Statement statement = null;
    private final String host = "jdbc:mysql://boardzonedb.c5qcagsicxet.ap-southeast-2.rds.amazonaws.com/boardzone";
    private final String user = "root";
    private final String password = "password1234";

    public ResultSet getSelect(String sql){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(host,user,password);
            statement = connect.createStatement();
            ResultSet rec = statement.executeQuery(sql);
            return rec;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public void update(String sql){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(host,user,password);
            statement = connect.createStatement();
            statement.executeUpdate(sql);
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void close(){
        try {
                if (connect != null) {
                    statement.close();
                    connect.close();
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
}
