
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fund implements MouseListener, ActionListener{
    private JFrame fundframe;
    private JPanel fundpanel;
    private JPanel left;
    private JPanel right;
    private JMenuBar fundbar;
    private JMenuBar menupanel;
    private JMenuBar space;
    private JMenuBar profilemenu;
    private JMenu homemenu;
    private JMenu lobbymenu;
    private JMenu fundmenu;
    private JMenu aboutmenu;
    private JMenu username;
    private JLabel picprofile;
    
    private JButton donateButton;
    private JPanel jp;

    public Fund(){
        fundframe = new JFrame("BoardZone");
        fundpanel = new JPanel();
        left = new JPanel();
        right = new JPanel();
        fundbar = new JMenuBar();
        menupanel = new JMenuBar();
        space = new JMenuBar();
        profilemenu = new JMenuBar();
        homemenu = new JMenu("Home");
        lobbymenu = new JMenu("Lobby");
        fundmenu = new JMenu("Funds");
        aboutmenu = new JMenu("About us");
        username = new JMenu(Account.getName());
        picprofile = new JLabel("", new ImageIcon("poring.png"), JLabel.CENTER);
        donateButton = new JButton("Creat post");
        jp = new JPanel();
        
        homemenu.addMouseListener(this);
        lobbymenu.addMouseListener(this);
        fundmenu.addMouseListener(this);
        aboutmenu.addMouseListener(this);
        username.addMouseListener(this);
        donateButton.addActionListener((ActionListener) this);
       
        fundframe.setJMenuBar(fundbar);
        fundbar.setLayout(new BorderLayout());
        menupanel.add(homemenu);
        menupanel.add(lobbymenu);
        menupanel.add(fundmenu);
        menupanel.add(aboutmenu);
        profilemenu.setLayout(new GridLayout(1,2));
        profilemenu.add(username);
        profilemenu.add(picprofile);
        fundbar.add(menupanel, BorderLayout.WEST);
        fundbar.add(space, BorderLayout.CENTER);
        fundbar.add(profilemenu, BorderLayout.EAST);
        jp.add(donateButton);

        left.setPreferredSize(new Dimension(100, 720));
        right.setPreferredSize(new Dimension(100, 720));
        
        fundframe.setLayout(new BorderLayout());
        fundframe.add(fundpanel, BorderLayout.CENTER);
        fundframe.add(left, BorderLayout.WEST);
        fundframe.add(right, BorderLayout.EAST);
        fundframe.add(jp, BorderLayout.SOUTH);
        
        fundbar.setBackground(new Color(43, 43, 43));
        menupanel.setBackground(new Color(43, 43, 43));
        space.setBackground(new Color(43, 43, 43));
        profilemenu.setBackground(new Color(43, 43, 43));
        fundframe.setBackground(new Color(101,101,101));
        left.setBackground(new Color(101,101,101));
        right.setBackground(new Color(101,101,101));
        fundpanel.setBackground(new Color(75,75,75));
        jp.setBackground(new Color(101,101,101));
        donateButton.setBackground(Color.WHITE);
        
        homemenu.setForeground(new Color(170, 170, 170));
        lobbymenu.setForeground(new Color(170, 170,170));
        fundmenu.setForeground(new Color(255, 255, 255));
        aboutmenu.setForeground(new Color(170, 170, 170));
        username.setForeground(new Color(170, 170, 170));
        
        fundframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fundframe.setSize(1080,720);
        fundframe.setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(homemenu)){
            Home home = new Home();
            home.setSize(fundframe.getSize());
            home.setLocation(fundframe.getLocation());
            fundframe.dispose();
        }
        else if (e.getSource().equals(lobbymenu)){
            Lobby lobby = new Lobby();
            lobby.setSize(fundframe.getSize());
            lobby.setLocation(fundframe.getLocation());
            fundframe.dispose();
        }
        else if (e.getSource().equals(fundmenu)){
            fundframe.setVisible(true);
        }
        else if (e.getSource().equals(aboutmenu)){
            About about = new About();
            about.setSize(fundframe.getSize());
            about.setLocation(fundframe.getLocation());
            fundframe.dispose();
        }
        else if (e.getSource().equals(username)){
            User user = new User();
            user.setSize(fundframe.getSize());
            user.setLocation(fundframe.getLocation());
            fundframe.dispose();
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
        fundframe.setSize(size);
    }

    public void setLocation(Point location) {
        fundframe.setLocation(location);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(donateButton)){
            Donate donate = new Donate();
            Thread thread = new Thread(donate);
            thread.start();
        }
    }

}
