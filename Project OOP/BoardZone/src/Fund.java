
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.sql.*;
import java.util.*;

public class Fund implements MouseListener, ActionListener {

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

    private JButton donateButton, refreshBtn;
    private JPanel jp;
    private JPanel post;
    private JPanel detailjp;
    private JLabel empty_line1, empty_line2;
    private JLabel jp1;

    private JLabel imgLabel[] = new JLabel[1];
    ;
    private Database db;
    private File imgFiles[];
    private ArrayList<DonatePanel> bgPanels;

    public Fund() {
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
        username = new JMenu(Account.username);
        picprofile = new JLabel("", new ImageIcon("poring.png"), JLabel.CENTER);
        donateButton = new JButton("Creat post");
        refreshBtn = new JButton("Refresh");
        jp = new JPanel();
        detailjp = new JPanel();
        post = new JPanel();
        empty_line1 = new JLabel();
        empty_line2 = new JLabel();
        db = new Database();
        imgLabel[0] = new JLabel();

        post.setLayout(new BorderLayout());
        empty_line1.setPreferredSize(new Dimension(3000, 0));
        empty_line2.setPreferredSize(new Dimension(3000, 0));

        homemenu.addMouseListener(this);
        lobbymenu.addMouseListener(this);
        fundmenu.addMouseListener(this);
        aboutmenu.addMouseListener(this);
        username.addMouseListener(this);
        
        donateButton.addActionListener( this);
        refreshBtn.addActionListener(this);
        

        fundpanel.setLayout(new FlowLayout());
        fundframe.setJMenuBar(fundbar);
        fundbar.setLayout(new BorderLayout());
        menupanel.add(homemenu);
        menupanel.add(lobbymenu);
        menupanel.add(fundmenu);
        menupanel.add(aboutmenu);
        profilemenu.setLayout(new GridLayout(1, 2));
        profilemenu.add(username);
        profilemenu.add(picprofile);
        fundbar.add(menupanel, BorderLayout.WEST);
        fundbar.add(space, BorderLayout.CENTER);
        fundbar.add(profilemenu, BorderLayout.EAST);
        jp.add(donateButton);
        jp.add(refreshBtn);
        detailjp.setLayout(new FlowLayout(FlowLayout.LEFT));

        post.add(imgLabel[0], BorderLayout.WEST);
        post.add(detailjp, BorderLayout.CENTER);

        left.setPreferredSize(new Dimension(100, 720));
        right.setPreferredSize(new Dimension(100, 720));

        fundframe.setLayout(new BorderLayout());
        fundframe.add(fundpanel, BorderLayout.CENTER);
        fundframe.add(left, BorderLayout.WEST);
        fundframe.add(right, BorderLayout.EAST);
        fundframe.add(jp, BorderLayout.SOUTH);

        post.setBackground(Color.WHITE);
        detailjp.setBackground(Color.WHITE);
        fundbar.setBackground(new Color(43, 43, 43));
        menupanel.setBackground(new Color(43, 43, 43));
        space.setBackground(new Color(43, 43, 43));
        profilemenu.setBackground(new Color(43, 43, 43));
        fundframe.setBackground(new Color(101, 101, 101));
        left.setBackground(new Color(101, 101, 101));
        right.setBackground(new Color(101, 101, 101));
        fundpanel.setBackground(new Color(75, 75, 75));
        jp.setBackground(new Color(101, 101, 101));
        donateButton.setBackground(Color.WHITE);
        refreshBtn.setBackground(Color.WHITE);

        homemenu.setForeground(new Color(170, 170, 170));
        lobbymenu.setForeground(new Color(170, 170, 170));
        fundmenu.setForeground(new Color(255, 255, 255));
        aboutmenu.setForeground(new Color(170, 170, 170));
        username.setForeground(new Color(170, 170, 170));

        fundframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fundframe.setSize(1080, 720);
        fundframe.setVisible(true);
    }
    
    public void refresh(){
        bgPanels = new ArrayList<DonatePanel>();
        Database db = new Database();
        try{
            System.out.println("Connecting to database...");
            ResultSet rs = db.getSelect("SELECT * FROM donate_data");
            while((rs!=null) && (rs.next())){
                    System.out.println("Loading Data....");
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String detail = rs.getString("detail");
                Double price = rs.getDouble("price");
                Double fullprice = rs.getDouble("fullprice");
                byte[] imgBytes = rs.getBytes("img0");
                ImageIcon img = new ImageIcon(imgBytes);
                bgPanels.add(new DonatePanel(id, name, detail, price, fullprice, img));
                
            }
            System.out.println("Loading complete!");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        db.close();
        for( DonatePanel bgPanel : bgPanels){
            fundpanel.add(bgPanel);
            bgPanel.addMouseListener(this);
        }
        fundpanel.setVisible(false);
        fundpanel.setPreferredSize(new Dimension(880, 310*((int)(bgPanels.size()/3)+1)));
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(homemenu)) {
            Home home = new Home();
            home.setSize(fundframe.getSize());
            home.setLocation(fundframe.getLocation());
            fundframe.dispose();
        } else if (e.getSource().equals(lobbymenu)) {
            Lobby lobby = new Lobby();
            lobby.setSize(fundframe.getSize());
            lobby.setLocation(fundframe.getLocation());
            fundframe.dispose();
        } else if (e.getSource().equals(fundmenu)) {
            fundframe.setVisible(true);
        } else if (e.getSource().equals(aboutmenu)) {
            About about = new About();
            about.setSize(fundframe.getSize());
            about.setLocation(fundframe.getLocation());
            fundframe.dispose();
        } else if (e.getSource().equals(username)) {
            User user = new User();
            user.setSize(fundframe.getSize());
            user.setLocation(fundframe.getLocation());
            fundframe.dispose();
        }
        for( DonatePanel bgPanel : bgPanels){
            if (e.getSource().equals(bgPanel)){
                System.out.println("DonateID:"+bgPanel.getID());
                new DonatePost(this, bgPanel.getID());
            }
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
        if (e.getSource().equals(donateButton)) {
            Donate donate = new Donate(this);
            Thread thread = new Thread(donate);
            thread.start();
        }
        else if (e.getSource().equals(refreshBtn)){
            fundpanel.removeAll();
            this.refresh();
        }
    }

    public static void main(String[] args) {
        new Fund();
    }

}
