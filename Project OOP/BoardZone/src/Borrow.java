import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;
import javax.swing.border.*;

public class Borrow implements ActionListener, FocusListener, Runnable{
    private JFrame fr;
    private JPanel top, topright, topleft, topempty, topbelow;
    private JPanel middle, mleft, mleft1, mleft2, mleft3;
    private JPanel mright, mrightl, mrightr, mrighttopr;
    private JPanel westempty, eastempty, bottom;
    private JPanel phour, pmin, pmaxp, ploca;
    private JPanel mep1, mep2, mep3, mep4, mep5, mep6, mep7, mep8;
    private JButton bprivate, bpublic, bcancel, bconfirm, bexit;
    private JLabel ltime, lmaxp, lloca, lsp1, lsp2, lsp3, lsp4;
    private JTextField thour, tmin, tmaxp, tloca;
    private CheckINTTwoDigit<String> checkhour, checkmin, checkmaxp;
    
    public boolean ispublic;
    private int boardGameID;
    private String gamename;
    private String startTime;
    private int hourTime;
    private int minuteTime;
    
    public Borrow(int id){
        this.boardGameID = id;
        
        fr = new JFrame();
        top = new JPanel();
        topleft = new JPanel();
        topright = new JPanel();
        topempty = new JPanel();
        topbelow = new JPanel();
        middle = new JPanel();
        mleft = new JPanel();
        mleft1 = new JPanel();
        mleft2 = new JPanel();
        mleft3 = new JPanel();
        mright = new JPanel();
        mrightl = new JPanel();
        mrightr = new JPanel();
        mrighttopr = new JPanel();
        phour = new JPanel();
        pmin = new JPanel();
        pmaxp = new JPanel();
        ploca = new JPanel();
        bottom = new JPanel();
        westempty = new JPanel();
        eastempty = new JPanel();
        mep1 = new JPanel();
        mep2 = new JPanel();
        mep3 = new JPanel();
        mep4 = new JPanel();
        mep5 = new JPanel();
        mep6 = new JPanel();
        mep7 = new JPanel();
        mep8 = new JPanel();
        
        bprivate = new JButton("Private");
        bpublic = new JButton("Public");
        bcancel = new JButton("cancel ");
        bconfirm = new JButton("confirm");
        bexit = new JButton("X");
        ltime = new JLabel("Time");
        lmaxp = new JLabel("Max Player");
        lloca = new JLabel("Location");
        lsp1 = new JLabel(":");
        lsp2 = new JLabel(":");
        lsp3 = new JLabel(":");
        lsp4 = new JLabel(" : ");
        thour = new JTextField("Hour");
        tmin = new JTextField("Minute");
        tmaxp = new JTextField(2);
        tloca = new JTextField();
        
        checkhour = new CheckINTTwoDigit<>(thour.getText());
        checkmin = new CheckINTTwoDigit<>(tmin.getText());
        checkmaxp = new CheckINTTwoDigit<>(tmaxp.getText());

        
        
        top.setLayout(new BorderLayout());
        topleft.setLayout(new BorderLayout());
        topright.setLayout(new BorderLayout());
        mleft1.setLayout(new BorderLayout());
        mleft2.setLayout(new BorderLayout());
        mleft3.setLayout(new BorderLayout());
        mrighttopr.setLayout(new BorderLayout());
        phour.setLayout(new BorderLayout());
        pmaxp.setLayout(new BorderLayout());
        ploca.setLayout(new BorderLayout());
//        .setLayout(new BorderLayout());

        ltime.setFont(new Font("Arial", Font.BOLD, 28));
        lmaxp.setFont(new Font("Arial", Font.BOLD, 28));
        lloca.setFont(new Font("Arial", Font.BOLD, 28));
        lsp1.setFont(new Font("Arial", Font.BOLD, 28));
        lsp2.setFont(new Font("Arial", Font.BOLD, 28));
        lsp3.setFont(new Font("Arial", Font.BOLD, 28));
        lsp4.setFont(new Font("Arial", Font.PLAIN, 28));
        thour.setFont(new Font("Arial", Font.PLAIN, 28));
        tmin.setFont(new Font("Arial", Font.PLAIN, 28));
        tmaxp.setFont(new Font("Arial", Font.PLAIN, 28));
        tloca.setFont(new Font("Arial", Font.PLAIN, 20));
        bpublic.setFont(new Font("Arial", Font.BOLD, 20));
        bprivate.setFont(new Font("Arial", Font.BOLD, 20));
        bcancel.setFont(new Font("Arial", Font.BOLD, 20));
        bconfirm.setFont(new Font("Arial", Font.BOLD, 20));
        bexit.setFont(new Font("Arial", Font.PLAIN, 32));
        
        thour.setColumns(2);
        tmin.setColumns(2);
//        tmaxp.setColumns(2);
        
        westempty.setPreferredSize(new Dimension(80 ,100));
        eastempty.setPreferredSize(new Dimension(80 ,100));
        mep1.setPreferredSize(new Dimension(80 ,35));
        mep2.setPreferredSize(new Dimension(80 ,35));
        mep3.setPreferredSize(new Dimension(80 ,35));
        mep4.setPreferredSize(new Dimension(80 ,35));
        mep5.setPreferredSize(new Dimension(80 ,35));
        mep6.setPreferredSize(new Dimension(80 ,35));
        mep7.setPreferredSize(new Dimension(80 ,35));
        mep8.setPreferredSize(new Dimension(80 ,35));
        bcancel.setPreferredSize(new Dimension(110 ,35));
        bconfirm.setPreferredSize(new Dimension(110 ,35));
        topleft.setPreferredSize(new Dimension(110 ,35));
        topright.setPreferredSize(new Dimension(110 ,35));

        
//      top layout
        topleft.add(bprivate, BorderLayout.EAST);
        topright.add(bpublic, BorderLayout.WEST);
        topright.add(bexit, BorderLayout.EAST);
        topbelow.add(topleft); topbelow.add(topright);
        topbelow.setLayout(new GridLayout(1, 2));
//      topbelow.setLayout(new FlowLayout());
        top.add(topempty); top.add(topbelow);
        top.setLayout(new GridLayout(2, 1));
        
        bprivate.setPreferredSize(new Dimension(360 ,20));
        bpublic.setPreferredSize(new Dimension(360 ,20));
        thour.setPreferredSize(new Dimension(0 ,80));
        
//      middle left
        mleft1.add(ltime, BorderLayout.CENTER);
        mleft2.add(lmaxp, BorderLayout.CENTER);
        mleft3.add(lloca, BorderLayout.CENTER);
        mleft1.add(lsp1, BorderLayout.EAST);
        mleft2.add(lsp2, BorderLayout.EAST);
        mleft3.add(lsp3, BorderLayout.EAST);
        mleft.add(mleft1); mleft.add(mleft2); mleft.add(mleft3);
        mleft.setLayout(new GridLayout(3, 1));
        
//      middle right
//        phour.add(thour, BorderLayout.CENTER);
//        phour.add(tmaxp, BorderLayout.NORTH);
//        phour.add(tloca, BorderLayout.SOUTH);
        phour.add(thour, BorderLayout.CENTER);
        phour.add(mep1, BorderLayout.NORTH);
        phour.add(mep2, BorderLayout.SOUTH);
        pmaxp.add(tmaxp, BorderLayout.CENTER);
        pmaxp.add(mep3, BorderLayout.NORTH);
        pmaxp.add(mep4, BorderLayout.SOUTH);
        ploca.add(tloca, BorderLayout.CENTER);
        ploca.add(mep5, BorderLayout.NORTH);
        ploca.add(mep6, BorderLayout.SOUTH);

        
        mrightl.add(phour); mrightl.add(pmaxp); mrightl.add(ploca);
        mrightl.setLayout(new GridLayout(3, 1));
        mrighttopr.add(lsp4, BorderLayout.WEST);
        mrighttopr.add(tmin, BorderLayout.CENTER);
        mrighttopr.add(mep7, BorderLayout.NORTH);
        mrighttopr.add(mep8, BorderLayout.SOUTH);
        mrightr.add(mrighttopr);
        mrightr.setLayout(new GridLayout(3, 1));
        
        mright.add(mrightl); mright.add(mrightr);
        mright.setLayout(new GridLayout(1, 2));
        
        middle.add(mleft); middle.add(mright);
        middle.setLayout(new GridLayout(1, 2));
        
//      bottom layout
        bottom.add(bcancel); bottom.add(bconfirm);
        bottom.setLayout(new FlowLayout());
        

//        topbelow.setPreferredSize(new Dimension(360 ,50));
        
        fr.add(top, BorderLayout.NORTH);
        fr.add(westempty, BorderLayout.WEST);
        fr.add(eastempty, BorderLayout.EAST);
        fr.add(middle, BorderLayout.CENTER);
        fr.add(bottom, BorderLayout.SOUTH);
        
//        set color
        fr.setBackground(new Color(43, 43, 43));
        top.setBackground(new Color(43, 43, 43));
        topleft.setBackground(new Color(43, 43, 43));
        topright.setBackground(new Color(43, 43, 43));
        topempty.setBackground(new Color(43, 43, 43));
        topbelow.setBackground(new Color(43, 43, 43));
        middle.setBackground(new Color(43, 43, 43));
        mleft.setBackground(new Color(43, 43, 43));
        mleft1.setBackground(new Color(43, 43, 43));
        mleft2.setBackground(new Color(43, 43, 43));
        mleft3.setBackground(new Color(43, 43, 43));
        mright.setBackground(new Color(43, 43, 43));
        mrightl.setBackground(new Color(43, 43, 43));
        mrightr.setBackground(new Color(43, 43, 43));
        mrighttopr.setBackground(new Color(43, 43, 43));
        phour.setBackground(new Color(43, 43, 43));
        pmin.setBackground(new Color(43, 43, 43));
        pmaxp.setBackground(new Color(43, 43, 43));
        ploca.setBackground(new Color(43, 43, 43));
        bottom.setBackground(new Color(43, 43, 43));
        westempty.setBackground(new Color(43, 43, 43));
        eastempty.setBackground(new Color(43, 43, 43));
        mep1.setBackground(new Color(43, 43, 43));
        mep2.setBackground(new Color(43, 43, 43));
        mep3.setBackground(new Color(43, 43, 43));
        mep4.setBackground(new Color(43, 43, 43));
        mep5.setBackground(new Color(43, 43, 43));
        mep6.setBackground(new Color(43, 43, 43));
        mep7.setBackground(new Color(43, 43, 43));
        mep8.setBackground(new Color(43, 43, 43));
        bexit.setBackground(new Color(43, 43, 43));
        
        bexit.setForeground(Color.white);
        ltime.setForeground(Color.white);
        lmaxp.setForeground(Color.white);
        lloca.setForeground(Color.white);
        lsp1.setForeground(Color.white);
        lsp2.setForeground(Color.white);
        lsp3.setForeground(Color.white);
        lsp4.setForeground(Color.white);
        bexit.setForeground(Color.white);
        bcancel.setForeground(Color.red);
        bcancel.setBorder(new LineBorder(Color.red, 3));
        bcancel.setBackground(null);
        bconfirm.setForeground(Color.green);
        bconfirm.setBorder(new LineBorder(Color.green, 3));
        bconfirm.setBackground(null);
        bexit.setBorderPainted(false);
        bpublic.setForeground(new Color( 173, 207, 240));
        bpublic.setBackground(null);
        bpublic.setBorder(new LineBorder(new Color( 173, 207, 240), 3));
        bprivate.setForeground(new Color( 173, 207, 240));
        bprivate.setBackground(null);
        bprivate.setBorder(new LineBorder(new Color( 173, 207, 240), 3));
        thour.setForeground(Color.LIGHT_GRAY);
        tmin.setForeground(Color.LIGHT_GRAY);
        
        
        //add listener
        bprivate.addActionListener(this);
        bpublic.addActionListener(this);
        bexit.addActionListener(this);
        bcancel.addActionListener(this);
        bconfirm.addActionListener(this);
        thour.addFocusListener(this);
        tmin.addFocusListener(this);
        tmaxp.addFocusListener(this);
        
        
        
        fr.setSize(900, 500);
        fr.setLocationRelativeTo(null);
        fr.setUndecorated(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new Borrow(22); //only for TESTING
    }

    @Override
    public synchronized void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bpublic)) {
            ispublic = true;
            bpublic.setBackground(new Color( 173, 207, 240));
            bpublic.setForeground(Color.WHITE);
            bprivate.setForeground(new Color( 173, 207, 240));
            bprivate.setBackground(null);
            bpublic.setFont(new Font("Arial", Font.BOLD, 28));
            bprivate.setFont(new Font("Arial", Font.BOLD, 20));
        } else if(e.getSource().equals(bprivate)) {
            ispublic = false;
            bprivate.setBackground(new Color( 173, 207, 240));
            bprivate.setForeground(Color.WHITE);
            bpublic.setForeground(new Color( 173, 207, 240));
            bpublic.setBackground(null);
            bpublic.setFont(new Font("Arial", Font.BOLD, 20));
            bprivate.setFont(new Font("Arial", Font.BOLD, 28));
        } else if(e.getSource().equals(bconfirm)) {
            if (!bprivate.getBackground().equals(new Color( 173, 207, 240)) && !bpublic.getBackground().equals(new Color( 173, 207, 240))){
                JOptionPane.showMessageDialog(null, "Please choose Public or Private", "WARNING", JOptionPane.ERROR_MESSAGE);
            }
            else if (thour.getText().equals("Hour") && tmin.getText().equals("Minute")){
                JOptionPane.showMessageDialog(null, "Please input how long will you play", "WARNING", JOptionPane.ERROR_MESSAGE);
            }
            else if (tmaxp.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please input max player", "WARNING", JOptionPane.ERROR_MESSAGE);
            }
            else if (tloca.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please input Location you play", "WARNING", JOptionPane.ERROR_MESSAGE);
            }
            else {
//                START DATA BASE
                Database db = new Database();
                try{
                    System.out.println("Connecting to database...");

                    db.update(String.format("UPDATE boardzone.board_games\n" +
"SET is_available = !is_available\n" +
"WHERE board_game_id = '%s';", ""+boardGameID));
                    System.out.println("Success Update to database...");
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
                
                try{
                    System.out.println("Connecting to database...");
                    ResultSet rs = db.getSelect(String.format("SELECT * FROM boardzone.board_games WHERE board_game_id = '%s'", ""+boardGameID));
                    while((rs!=null) && (rs.next())){
                        gamename = rs.getString("name");
                    }
                    System.out.println("Loading complete!");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                db.close();
                
//                try {
//                    LocalTime time = LocalTime.now();
//                    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
//                    String formattime = time.format(format);
//                    this.startTime = formattime;
//                }
//                catch (Exception ex) {
//                    System.out.println(ex);
//                }
                if(thour.getText().equals("Hour")){
                    this.hourTime = 0;
                } else {
                    this.hourTime = Integer.parseInt(thour.getText());
                }
                if(tmin.getText().equals("Minute")){
                    this.minuteTime = 0;
                } else {
                    this.minuteTime = Integer.parseInt(tmin.getText());
                }
                

                BorrowItem item = new BorrowItem(boardGameID, gamename, Integer.parseInt(tmaxp.getText()),
                        hourTime, minuteTime, ispublic, tloca.getText());
                item.senttoDataBase();
                System.out.println(item.showTimeLeft(boardGameID));
                
//                THIS IS IMPORTENT
                JOptionPane.showMessageDialog(null, "Successfully Borrowed A Game");
//                new Lobby();
                fr.dispose();
            }
        } else {
            fr.dispose();
        }
    }


    
    @Override
    public synchronized void focusGained(FocusEvent e) {
        if (thour.getText().equals("Hour") && e.getSource().equals(thour)){
            thour.setText("");
            thour.setForeground(Color.BLACK);
        }
        if (tmin.getText().equals("Minute") && e.getSource().equals(tmin)){
            tmin.setText("");
            tmin.setForeground(Color.BLACK);
        }
    }

    @Override
    public synchronized void focusLost(FocusEvent e) {
        checkhour.setContent(thour.getText());
        checkmin.setContent(tmin.getText());
        checkmaxp.setContent(tmaxp.getText());
//        if (thour.getText().equals("")){
//            thour.setText("Hour");
//            thour.setForeground(Color.LIGHT_GRAY);
//        } else
        if(checkhour.getCheckText() < 0){
            thour.setText("Hour");
            thour.setForeground(Color.LIGHT_GRAY);
        } else {
            thour.setText("" + checkhour.getCheckText());
            thour.setForeground(Color.BLACK);
        }

        if(checkmin.getCheckText() < 0 || checkmin.getCheckText() >= 60){
            tmin.setText("Minute");
            tmin.setForeground(Color.LIGHT_GRAY);
        } else {
            tmin.setText("" + checkmin.getCheckText());
            tmin.setForeground(Color.BLACK);
        }
        
        if(checkmaxp.getCheckText() < 0){
            tmaxp.setText("");
        } else {
            tmaxp.setText("" + checkmaxp.getCheckText());
            tmaxp.setForeground(Color.BLACK);
        }

    }

    @Override
    public void run() {}
}
