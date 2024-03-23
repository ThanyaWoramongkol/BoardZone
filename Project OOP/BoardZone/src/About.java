
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About implements MouseListener{
    private JFrame aboutframe;
    private JPanel aboutpanel;
    private JPanel left;
    private JPanel right;
    private JMenuBar aboutbar;
    private JMenuBar menupanel;
    private JMenuBar space;
    private JMenuBar profilemenu;
    private JMenu homemenu;
    private JMenu lobbymenu;
    private JMenu fundmenu;
    private JMenu aboutmenu;
    private JMenu username;
    private JLabel picprofile;

    public About(){
        aboutframe = new JFrame("BoardZone");
        aboutpanel = new JPanel();
        left = new JPanel();
        right = new JPanel();
        aboutbar = new JMenuBar();
        menupanel = new JMenuBar();
        space = new JMenuBar();
        profilemenu = new JMenuBar();
        homemenu = new JMenu("Home");
        lobbymenu = new JMenu("Lobby");
        fundmenu = new JMenu("Funds");
        aboutmenu = new JMenu("About us");
        username = new JMenu(Account.getName());
        picprofile = new JLabel("", new ImageIcon("poring.png"), JLabel.CENTER);
        
        homemenu.addMouseListener(this);
        lobbymenu.addMouseListener(this);
        fundmenu.addMouseListener(this);
        aboutmenu.addMouseListener(this);
        username.addMouseListener(this);

        
        aboutframe.setJMenuBar(aboutbar);
        aboutbar.setLayout(new BorderLayout());
        menupanel.add(homemenu);
        menupanel.add(lobbymenu);
        menupanel.add(fundmenu);
        menupanel.add(aboutmenu);
        profilemenu.setLayout(new GridLayout(1,2));
        profilemenu.add(username);
        profilemenu.add(picprofile);
        aboutbar.add(menupanel, BorderLayout.WEST);
        aboutbar.add(space, BorderLayout.CENTER);
        aboutbar.add(profilemenu, BorderLayout.EAST);

        left.setPreferredSize(new Dimension(100, 720));
        right.setPreferredSize(new Dimension(100, 720));
        
        aboutframe.setLayout(new BorderLayout());
        aboutframe.add(aboutpanel, BorderLayout.CENTER);
        aboutframe.add(left, BorderLayout.WEST);
        aboutframe.add(right, BorderLayout.EAST);   
                
        aboutbar.setBackground(new Color(43, 43, 43));
        menupanel.setBackground(new Color(43, 43, 43));
        space.setBackground(new Color(43, 43, 43));
        profilemenu.setBackground(new Color(43, 43, 43));
        aboutframe.setBackground(new Color(101,101,101));
        left.setBackground(new Color(101,101,101));
        right.setBackground(new Color(101,101,101));
        aboutpanel.setBackground(new Color(75,75,75));
        
        homemenu.setForeground(new Color(170, 170, 170));
        lobbymenu.setForeground(new Color(170, 170,170));
        fundmenu.setForeground(new Color(170, 170, 170));
        aboutmenu.setForeground(new Color(255, 255, 255));
        username.setForeground(new Color(170, 170, 170));
        
        aboutframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutframe.setSize(1080,720);
        aboutframe.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(homemenu)){
            Home home = new Home();
            home.setSize(aboutframe.getSize());
            home.setLocation(aboutframe.getLocation());
            aboutframe.dispose();
        }
        else if (e.getSource().equals(lobbymenu)){
            Lobby lobby = new Lobby();
            lobby.setSize(aboutframe.getSize());
            lobby.setLocation(aboutframe.getLocation());
            aboutframe.dispose();
        }
        else if (e.getSource().equals(fundmenu)){
            Fund fund = new Fund();
            fund.setSize(aboutframe.getSize());
            fund.setLocation(aboutframe.getLocation());
            aboutframe.dispose();
        }
        else if (e.getSource().equals(aboutmenu)){
            aboutframe.setVisible(true);
        }
        else if (e.getSource().equals(username)){
            User user = new User();
            user.setSize(aboutframe.getSize());
            user.setLocation(aboutframe.getLocation());
            aboutframe.dispose();
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
       aboutframe.setSize(size);
    }

    public void setLocation(Point location) {
        aboutframe.setLocation(location);
    }
}
