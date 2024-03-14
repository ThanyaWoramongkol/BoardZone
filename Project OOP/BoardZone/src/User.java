
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class User implements MouseListener{
    private JFrame userframe;
    private JPanel userpanel;
    private JPanel left;
    private JPanel right;
    private JMenuBar userbar;
    private JMenuBar menupanel;
    private JMenuBar space;
    private JMenuBar profilemenu;
    private JMenu homemenu;
    private JMenu lobbymenu;
    private JMenu fundmenu;
    private JMenu aboutmenu;
    private JMenu username;
    private JLabel picprofile;

    public User(){
        userframe = new JFrame("BoardZone");
        userpanel = new JPanel();
        left = new JPanel();
        right = new JPanel();
        userbar = new JMenuBar();
        menupanel = new JMenuBar();
        space = new JMenuBar();
        profilemenu = new JMenuBar();
        homemenu = new JMenu("Home");
        lobbymenu = new JMenu("Lobby");
        fundmenu = new JMenu("Funds");
        aboutmenu = new JMenu("About us");
        username = new JMenu("UserName");
        picprofile = new JLabel("", new ImageIcon("poring.png"), JLabel.CENTER);
        
        homemenu.addMouseListener(this);
        lobbymenu.addMouseListener(this);
        fundmenu.addMouseListener(this);
        aboutmenu.addMouseListener(this);
        username.addMouseListener(this);
        
        userframe.setJMenuBar(userbar);
        userbar.setLayout(new BorderLayout());
        menupanel.add(homemenu);
        menupanel.add(lobbymenu);
        menupanel.add(fundmenu);
        menupanel.add(aboutmenu);
        profilemenu.setLayout(new GridLayout(1,2));
        profilemenu.add(username);
        profilemenu.add(picprofile);
        userbar.add(menupanel, BorderLayout.WEST);
        userbar.add(space, BorderLayout.CENTER);
        userbar.add(profilemenu, BorderLayout.EAST);

        left.setPreferredSize(new Dimension(100, 720));
        right.setPreferredSize(new Dimension(100, 720));
        
        userframe.setLayout(new BorderLayout());
        userframe.add(userpanel, BorderLayout.CENTER);
        userframe.add(left, BorderLayout.WEST);
        userframe.add(right, BorderLayout.EAST);   
                
        userbar.setBackground(new Color(43, 43, 43));
        menupanel.setBackground(new Color(43, 43, 43));
        space.setBackground(new Color(43, 43, 43));
        profilemenu.setBackground(new Color(43, 43, 43));
        userframe.setBackground(new Color(101,101,101));
        left.setBackground(new Color(101,101,101));
        right.setBackground(new Color(101,101,101));
        userpanel.setBackground(new Color(75,75,75));
        
        homemenu.setForeground(new Color(170, 170, 170));
        lobbymenu.setForeground(new Color(170, 170, 170));
        fundmenu.setForeground(new Color(170, 170, 170));
        aboutmenu.setForeground(new Color(170, 170, 170));
        username.setForeground(new Color(255, 255, 255));
        
        userframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userframe.setSize(1080,720);
        userframe.setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(homemenu)){
            Home home = new Home();
            home.setSize(userframe.getSize());
            home.setLocation(userframe.getLocation());
            userframe.dispose();
        }
        else if (e.getSource().equals(lobbymenu)){
            Lobby lobby = new Lobby();
            lobby.setSize(userframe.getSize());
            lobby.setLocation(userframe.getLocation());
            userframe.dispose();
        }
        else if (e.getSource().equals(fundmenu)){
            Fund fund = new Fund(); 
            fund.setSize(userframe.getSize());
            fund.setLocation(userframe.getLocation());
            userframe.dispose();
        }
        else if (e.getSource().equals(aboutmenu)){
            About about = new About();
            about.setSize(userframe.getSize());
            about.setLocation(userframe.getLocation());
            userframe.dispose();
        }
        else if (e.getSource().equals(username)){
            userframe.setVisible(true);
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
        userframe.setSize(size);
    }

    public void setLocation(Point location) {
        userframe.setLocation(location);
    }
}
