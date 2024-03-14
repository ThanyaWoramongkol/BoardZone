
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home implements MouseListener{
    private JFrame homeframe;
    private JPanel homepanel;
    private JPanel left;
    private JPanel right;
    private JMenuBar homebar;
    private JMenuBar menupanel;
    private JMenuBar space;
    private JMenuBar profilemenu;
    private JMenu homemenu;
    private JMenu lobbymenu;
    private JMenu fundmenu;
    private JMenu aboutmenu;
    private JMenu username;
    private JLabel picprofile;

    public Home(){
        homeframe = new JFrame("BoardZone");
        homepanel = new JPanel();
        left = new JPanel();
        right = new JPanel();
        homebar = new JMenuBar();
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

        
        homeframe.setJMenuBar(homebar);
        homebar.setLayout(new BorderLayout());
        menupanel.add(homemenu);
        menupanel.add(lobbymenu);
        menupanel.add(fundmenu);
        menupanel.add(aboutmenu);
        profilemenu.setLayout(new GridLayout(1,2));
        profilemenu.add(username);
        profilemenu.add(picprofile);
        homebar.add(menupanel, BorderLayout.WEST);
        homebar.add(space, BorderLayout.CENTER);
        homebar.add(profilemenu, BorderLayout.EAST);

        left.setPreferredSize(new Dimension(100, 720));
        right.setPreferredSize(new Dimension(100, 720));
        
        homeframe.setLayout(new BorderLayout());
        homeframe.add(homepanel, BorderLayout.CENTER);
        homeframe.add(left, BorderLayout.WEST);
        homeframe.add(right, BorderLayout.EAST);   
                
        homebar.setBackground(new Color(43, 43, 43));
        menupanel.setBackground(new Color(43, 43, 43));
        space.setBackground(new Color(43, 43, 43));
        profilemenu.setBackground(new Color(43, 43, 43));
        homeframe.setBackground(new Color(101,101,101));
        left.setBackground(new Color(101,101,101));
        right.setBackground(new Color(101,101,101));
        homepanel.setBackground(new Color(75,75,75));
        
        homemenu.setForeground(new Color(255, 255, 255));
        lobbymenu.setForeground(new Color(170, 170, 170));
        fundmenu.setForeground(new Color(170, 170, 170));
        aboutmenu.setForeground(new Color(170, 170, 170));
        username.setForeground(new Color(170, 170, 170));
        
        homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeframe.setSize(1080,720);
        homeframe.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(homemenu)){
            homeframe.setVisible(true);    
        }
        else if (e.getSource().equals(lobbymenu)){
            Lobby lobby = new Lobby();
            lobby.setSize(homeframe.getSize());
            lobby.setLocation(homeframe.getLocation());
            homeframe.dispose();
        }
        else if (e.getSource().equals(fundmenu)){
            Fund fund = new Fund();
            fund.setSize(homeframe.getSize());
            fund.setLocation(homeframe.getLocation());
            homeframe.dispose();
        }
        else if (e.getSource().equals(aboutmenu)){
            About about = new About();
            about.setSize(homeframe.getSize());
            about.setLocation(homeframe.getLocation());
            homeframe.dispose();
        }
        else if (e.getSource().equals(username)){
            User user = new User();
            user.setSize(homeframe.getSize());
            user.setLocation(homeframe.getLocation());
            homeframe.dispose();
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
        homeframe.setSize(size);
    }

    public void setLocation(Point location) {
        homeframe.setLocation(location);
    }
}
