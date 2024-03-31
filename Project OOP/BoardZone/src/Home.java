
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class Home implements MouseListener, ActionListener, WindowListener{
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
    private JPanel footerPanel;
    private JScrollPane homeScrollPane;
    private JLabel loading;
    private JButton createBtn, refreshBtn;
    private ArrayList<BoardGamePanel> bgPanels;

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
        username = new JMenu(Account.username);
        picprofile = new JLabel("", Account.profile, JLabel.CENTER);
        createBtn = new JButton("Create Post");
        refreshBtn = new JButton("Refresh");
        footerPanel = new JPanel();
        homeScrollPane = new JScrollPane(homepanel);
        loading = new JLabel("Loading...");
        
        homemenu.addMouseListener(this);
        lobbymenu.addMouseListener(this);
        fundmenu.addMouseListener(this);
        aboutmenu.addMouseListener(this);
        username.addMouseListener(this);
        createBtn.addActionListener(this);
        refreshBtn.addActionListener(this);
        homeframe.addWindowListener(this);

        
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
        
        ((FlowLayout)homepanel.getLayout()).setHgap(24);
        ((FlowLayout)homepanel.getLayout()).setVgap(24);
        
        
//        homepanel.setPreferredSize(new Dimension(880, 2000));
        loading.setForeground(Color.WHITE);
        homepanel.add(loading);

        homeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        homeScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        homeScrollPane.getVerticalScrollBar().setUnitIncrement(15);
        homeScrollPane.getVerticalScrollBar().setBackground(new Color(75,75,75));
        homeScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI());
        homeScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8, 1));
        homeScrollPane.setBorder(BorderFactory.createEmptyBorder());
        
        refreshBtn.setFocusPainted(false);
        createBtn.setFocusPainted(false);
        createBtn.setFont(createBtn.getFont().deriveFont(13f));
        refreshBtn.setFont(createBtn.getFont().deriveFont(13f));
        footerPanel.add(createBtn);
        footerPanel.add(refreshBtn);
        
        homeframe.setLayout(new BorderLayout());
        homeframe.add(homeScrollPane, BorderLayout.CENTER);
        homeframe.add(left, BorderLayout.WEST);
        homeframe.add(right, BorderLayout.EAST); 
        homeframe.add(footerPanel, BorderLayout.SOUTH);
                
        homebar.setBackground(new Color(43, 43, 43));
        menupanel.setBackground(new Color(43, 43, 43));
        space.setBackground(new Color(43, 43, 43));
        profilemenu.setBackground(new Color(43, 43, 43));
        homeframe.setBackground(new Color(101,101,101));
        left.setBackground(new Color(101,101,101));
        right.setBackground(new Color(101,101,101));
        footerPanel.setBackground(new Color(101,101,101));
        createBtn.setBackground(new Color(88,88,88));
        refreshBtn.setBackground(new Color(88,88, 88));
        homepanel.setBackground(new Color(75,75,75));
        
        createBtn.setForeground(new Color(255, 255, 255));
        refreshBtn.setForeground(new Color(233, 233, 233));
        homemenu.setForeground(new Color(255, 255, 255));
        lobbymenu.setForeground(new Color(170, 170, 170));
        fundmenu.setForeground(new Color(170, 170, 170));
        aboutmenu.setForeground(new Color(170, 170, 170));
        username.setForeground(new Color(170, 170, 170));
        
        createBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refreshBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeframe.setSize(1080,720);
        homeframe.setVisible(true);
    }
    public JFrame getFrame(){
        return this.homeframe;
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
                double rating = rs.getDouble("rating");
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
            homepanel.add(bgPanel);
            bgPanel.addMouseListener(this);
        }
        loading.setVisible(false);
        homepanel.setPreferredSize(new Dimension(880, 310*((int)(bgPanels.size()/3)+1)));
    }
    public static void main(String[] args) {
        new Home();
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
        for( BoardGamePanel bgPanel : bgPanels){
            if (e.getSource().equals(bgPanel)){
                System.out.println("boardGameID:"+bgPanel.getID());
                new BoardGameShowDetail(this, bgPanel.getID());
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
        homeframe.setSize(size);
    }

    public void setLocation(Point location) {
        homeframe.setLocation(location);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(createBtn)){
            new CreatePost(this);
        }
        else if (e.getSource().equals(refreshBtn)){
            homepanel.removeAll();
            this.refresh();
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
