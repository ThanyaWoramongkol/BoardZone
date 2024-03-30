
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Lobby implements MouseListener, ActionListener, WindowListener{
    private JFrame lobbyframe;
    private JPanel lobbypanel;
    private JPanel left;
    private JPanel right;
    private JPanel bottompanel;
    private JMenuBar lobbybar;
    private JMenuBar menupanel;
    private JMenuBar space;
    private JMenuBar profilemenu;
    private JMenu homemenu;
    private JMenu lobbymenu;
    private JMenu fundmenu;
    private JMenu aboutmenu;
    private JMenu username;
    private JLabel picprofile;
    private JLabel loading;
    private JButton funbutton;
    private JInternalFrame oxgame;
    private ArrayList<BoardGamePanel> bgPanels;

    public Lobby(){
        lobbyframe = new JFrame("BoardZone");
        lobbypanel = new JPanel();
        left = new JPanel();
        right = new JPanel();
        bottompanel = new JPanel();
        lobbybar = new JMenuBar();
        menupanel = new JMenuBar();
        space = new JMenuBar();
        profilemenu = new JMenuBar();
        homemenu = new JMenu("Home");
        lobbymenu = new JMenu("Lobby");
        fundmenu = new JMenu("Funds");
        aboutmenu = new JMenu("About us");
        username = new JMenu(Account.username);
        picprofile = new JLabel("", new ImageIcon("poring.png"), JLabel.CENTER);
        funbutton = new JButton("Play MiniGame");
        loading = new JLabel("Loading...");
        
        
        homemenu.addMouseListener(this);
        lobbymenu.addMouseListener(this);
        fundmenu.addMouseListener(this);
        aboutmenu.addMouseListener(this);
        username.addMouseListener(this);
        funbutton.addActionListener(this);

        lobbypanel.setLayout(new FlowLayout());
        lobbyframe.setJMenuBar(lobbybar);
        lobbybar.setLayout(new BorderLayout());
        menupanel.add(homemenu);
        menupanel.add(lobbymenu);
        menupanel.add(fundmenu);
        menupanel.add(aboutmenu);
        profilemenu.setLayout(new GridLayout(1,2));
        profilemenu.add(username);
        profilemenu.add(picprofile);
        lobbybar.add(menupanel, BorderLayout.WEST);
        lobbybar.add(space, BorderLayout.CENTER);
        lobbybar.add(profilemenu, BorderLayout.EAST);
        bottompanel.add(funbutton);

        left.setPreferredSize(new Dimension(100, 720));
        right.setPreferredSize(new Dimension(100, 720));
        
        lobbyframe.setLayout(new BorderLayout());
        lobbyframe.add(lobbypanel, BorderLayout.CENTER);
        lobbyframe.add(left, BorderLayout.WEST);
        lobbyframe.add(right, BorderLayout.EAST);
        lobbyframe.add(bottompanel, BorderLayout.SOUTH);
                
        lobbybar.setBackground(new Color(43, 43, 43));
        menupanel.setBackground(new Color(43, 43, 43));
        space.setBackground(new Color(43, 43, 43));
        profilemenu.setBackground(new Color(43, 43, 43));
        lobbyframe.setBackground(new Color(101,101,101));
        left.setBackground(new Color(101,101,101));
        right.setBackground(new Color(101,101,101));
        bottompanel.setBackground(new Color(101,101,101));
        lobbypanel.setBackground(new Color(75,75,75));
        
        homemenu.setForeground(new Color(170, 170, 170));
        lobbymenu.setForeground(new Color(255, 255, 255));
        fundmenu.setForeground(new Color(170, 170, 170));
        aboutmenu.setForeground(new Color(170, 170, 170));
        username.setForeground(new Color(170, 170, 170));
        
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        funbutton.setForeground(new Color(red, green, blue));
        funbutton.setBorder(new LineBorder(new Color(red, green, blue)));
        funbutton.setBackground(null);
        funbutton.setFont(new Font("Arial", Font.BOLD, 20));
        
        lobbyframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lobbyframe.setSize(1080,720);
        lobbyframe.setVisible(true);
    }
    
    public void refresh(){
        bgPanels = new ArrayList<BoardGamePanel>();
        Database db = new Database();
        try{
            System.out.println("Connecting to database...");
            ResultSet rs = db.getSelect("SELECT * FROM board_games");
            while((rs!=null) && (rs.next())){
                    System.out.println("Loading Data....");
                int boardGameID = rs.getInt("board_game_id");
                String name = rs.getString("name");
                boolean isAvailable = rs.getBoolean("is_available");
                String rate = rs.getString("rating");
                double rating = Double.parseDouble(rate);
                byte[] imgBytes = rs.getBytes("img0");
                ImageIcon img = new ImageIcon(imgBytes);
                bgPanels.add(new BoardGamePanel(boardGameID, name, rating, isAvailable, img));
                
            }
            System.out.println("Loading complete!");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        db.close();
        for( BoardGamePanel bgPanel : bgPanels){
            lobbypanel.add(bgPanel);
            bgPanel.addMouseListener(this);
        }
        loading.setVisible(false);
        lobbypanel.setPreferredSize(new Dimension(880, 310*((int)(bgPanels.size()/3)+1)));
    }
    
    public static void main(String[] args) {
        new Lobby();
    }
    

    
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(homemenu)){
            Home home = new Home();
            home.setSize(lobbyframe.getSize());
            home.setLocation(lobbyframe.getLocation());
            lobbyframe.dispose();
        }
        else if (e.getSource().equals(lobbymenu)){
            lobbyframe.setVisible(true);
        }
        else if (e.getSource().equals(fundmenu)){
            Fund fund = new Fund(); 
            fund.setSize(lobbyframe.getSize());
            fund.setLocation(lobbyframe.getLocation());
            lobbyframe.dispose();
        }
        else if (e.getSource().equals(aboutmenu)){
            About about = new About();
            about.setSize(lobbyframe.getSize());
            about.setLocation(lobbyframe.getLocation());
            lobbyframe.dispose();
        }
        else if (e.getSource().equals(username)){
            User user = new User();
            user.setSize(lobbyframe.getSize());
            user.setLocation(lobbyframe.getLocation());
            lobbyframe.dispose();
        }
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

    public void setSize(Dimension size) {
        lobbyframe.setSize(size);
    }

    public void setLocation(Point location) {
        lobbyframe.setLocation(location);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(funbutton)){
            new GameClient();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.refresh();
    }

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
