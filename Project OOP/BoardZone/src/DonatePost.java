
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class DonatePost extends javax.swing.JPanel implements Runnable, MouseListener, ActionListener{
    private JPanel jPanel1;
    private JButton donate;
    private JTextField priceJT;
    
    private JFrame donateframe;
    private JPanel gridpanel, leftPanel, rightPanel, rightPanell;
    private JPanel donatebar, subPanel, leftSubright, rightSubright, headright, leftSubleft, underleft, top;
    private JTextArea head, discription;
    private JLabel jl1, jl2, jl3, sp1;
    private Font fontHead;
    private JButton exitbutton ;
    private JLabel imgLabel[] = new JLabel[4];;
    
//    private JButton postbutton;
//    private JTextField cost;
    
    private Fund mainWindow;
    private String name, detail;
    private double price, fullprice;
    private DonateData data;
    private ImageIcon img1;
    private int id;
    
    public DonatePost(Fund mainWindow, String name, String detail, double price, double fullprice, ImageIcon img1, int id){
        this.id = id;
        this.mainWindow = mainWindow;
        jPanel1 = new JPanel();
        donate = new JButton("Donate");
        priceJT = new JTextField(price+"/"+fullprice);
        imgLabel[0] = new JLabel();
        imgLabel[1] = new JLabel();
        imgLabel[2] = new JLabel();
        imgLabel[3] = new JLabel();

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));
        
        donate.setBackground(Color.WHITE);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(donate)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(priceJT, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceJT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(donate)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        
        donate.addActionListener(this);
        priceJT.addActionListener(this);
        
        donateframe = new JFrame();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        subPanel = new JPanel();
        leftSubright = new JPanel();
        rightSubright = new JPanel();
        donatebar = new JPanel();
        headright = new JPanel();
        leftSubleft = new JPanel();
        underleft = new JPanel();
        top = new JPanel();
        gridpanel = new JPanel();
        head = new JTextArea(name);
        discription = new JTextArea(detail);
         Image image = img1.getImage();
        ImageIcon icon = new ImageIcon(image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH));
        jl1 = new JLabel(icon, JLabel.CENTER);
        jl2 = new JLabel();
        sp1 = new JLabel("     Name : ");
        fontHead = new Font("Inter", Font.BOLD, 20);
        exitbutton = new JButton("X");
//        postbutton = new JButton("Post");
//        cost = new JTextField();
        exitbutton.setBorderPainted(false);
        
        exitbutton.addActionListener(this);
        
        donateframe.setLayout(new BorderLayout());
        gridpanel.setLayout(new GridLayout(1, 2));
        leftPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new BorderLayout());
        headright.setLayout(new BorderLayout());
        donatebar.setLayout(new BorderLayout());
        
        top.setPreferredSize(new Dimension(360 ,20));
        donatebar.setPreferredSize(new Dimension(360 ,150));
        leftSubright.setPreferredSize(new Dimension(40, 620));
        rightSubright.setPreferredSize(new Dimension(50, 620));
        underleft.setPreferredSize(new Dimension(360 ,70));
        leftSubleft.setPreferredSize(new Dimension(25 ,620));
        
        head.setEditable(false);
        discription.setEditable(false);
        priceJT.setEditable(false);
        head.setFont(fontHead);
        head.setForeground(Color.WHITE);
        head.setOpaque(false);
        exitbutton.setForeground(Color.WHITE);
        sp1.setFont(fontHead.deriveFont(36));
        sp1.setForeground(Color.WHITE);
//        postbutton.setForeground(Color.WHITE);
        
//        donatebar.add(cost, BorderLayout.NORTH);
//        donatebar.add(postbutton, BorderLayout.EAST);
        
        headright.add(sp1, BorderLayout.WEST); headright.add(head, BorderLayout.CENTER); headright.add(exitbutton, BorderLayout.EAST);
        
        subPanel.add(jl2);
        leftPanel.add(jl1, BorderLayout.CENTER);
        leftPanel.add(underleft, BorderLayout.SOUTH);
        leftPanel.add(leftSubleft, BorderLayout.WEST);
        
        rightPanel.add(headright, BorderLayout.NORTH);
        rightPanel.add(discription, BorderLayout.CENTER);
        rightPanel.add(leftSubright, BorderLayout.WEST);
        rightPanel.add(rightSubright, BorderLayout.EAST);
        rightPanel.add(jPanel1, BorderLayout.SOUTH);
        
        top.setBackground(new Color(43, 43, 43));
        exitbutton.setBackground(new Color(43, 43, 43));
        donateframe.setBackground(new Color(43, 43, 43));
        gridpanel.setBackground(new Color(43, 43, 43));
        headright.setBackground(new Color(43, 43, 43));
        leftPanel.setBackground(new Color(43, 43, 43));
        rightPanel.setBackground(new Color(43, 43, 43));
        leftSubright.setBackground(new Color(43, 43, 43));
        rightSubright.setBackground(new Color(43, 43, 43));
        subPanel.setBackground(new Color(43, 43, 43));
        donatebar.setBackground(new Color(43, 43, 43));
        underleft.setBackground(new Color(43, 43, 43));
        leftSubleft.setBackground(new Color(43, 43, 43));
        discription.setBackground(new Color(101,101,101));
        jl1.setBackground(new Color(101,101,101));
//        postbutton.setBackground(Color.cyan);
        
        gridpanel.add(leftPanel);
        gridpanel.add(rightPanel);
        
        donateframe.add(gridpanel, BorderLayout.CENTER);
        donateframe.add(top, BorderLayout.NORTH);
        
        donateframe.setUndecorated(true);
        donateframe.setSize(900, 500);
        donateframe.setLocation((int)mainWindow.getFrame().getX()+((mainWindow.getFrame().getWidth()-donateframe.getWidth())/2), (int)mainWindow.getFrame().getY()+((mainWindow.getFrame().getHeight()-donateframe.getHeight())/2));
        donateframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        donateframe.setVisible(true);
        
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
//        donateframe.setLocation(90, 150);
        while (true) {
            if(mainWindow.getFrame().isFocused()){
                donateframe.setLocation((int)mainWindow.getFrame().getX()+((mainWindow.getFrame().getWidth()-donateframe.getWidth())/2), (int)mainWindow.getFrame().getY()+((mainWindow.getFrame().getHeight()-donateframe.getHeight())/2));
                donateframe.setAlwaysOnTop(true);
            }
            else {
                donateframe.setAlwaysOnTop(false);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(exitbutton)){
            exitbutton.setBackground(Color.red);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(exitbutton)){
            exitbutton.setBackground(new Color(61,61,61));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(exitbutton)){
            donateframe.dispose();
        }
        else if(e.getSource().equals(donate)){
            new Pay(name, price, fullprice, this.id);
        }
    }

    private void setLayout(GroupLayout layout) {
        
    }
}

