
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

public class Donate extends javax.swing.JPanel implements Runnable, MouseListener, ActionListener{
    private JPanel jPanel1;
    private JButton post;
    private JTextArea priceta;
    private Fund mainWindow;
    
    private JLabel imgLabel[] = new JLabel[4];;
    private File imgFiles[];
    
    private JFrame donateframe;
    private JPanel gridpanel, leftPanel, rightPanel, rightPanell, donate;
    private JPanel donatebar, subPanel, leftSubright, rightSubright, headright, leftSubleft, underleft, top,bottomImagePanel, showImagePanel,mainImagePanel;
    private JTextArea head, discription;
    private JLabel jl1, jl2, jl3, sp1;
    private ImageIcon pic1;
    private Font fontHead;
    private JButton exitbutton ;
    private ImageIcon plusIcon;
    
    public String name = "", detail = "", stfullPrice = "";
    public double fullPrice = 0, price = 0;
//    private JButton postbutton;
//    private JTextField cost;
    
    public Donate(Fund mainWindow){
        this.mainWindow = mainWindow;
        imgLabel[0] = new JLabel();
        imgLabel[1] = new JLabel();
        imgLabel[2] = new JLabel();
        imgLabel[3] = new JLabel();
        bottomImagePanel = new JPanel();
        showImagePanel =new JPanel();
        mainImagePanel = new JPanel();
        
        jPanel1 = new JPanel();
        post = new JButton();
        priceta = new JTextArea("");

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        post.setText("Post");
        post.setBackground(Color.WHITE);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(post)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(priceta, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(priceta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(post)
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
        
        post.addActionListener(this);
        
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
        head = new JTextArea("");
        discription = new JTextArea("");
        jl1 = new JLabel(pic1, JLabel.CENTER);
        jl2 = new JLabel();
        sp1 = new JLabel("     Name : ");
        fontHead = new Font("Inter", Font.BOLD, 20);
        exitbutton = new JButton("X");
//        postbutton = new JButton("Post");
//        cost = new JTextField();
        
        donateframe.setLayout(new BorderLayout());
        gridpanel.setLayout(new GridLayout(1, 2));
        leftPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new BorderLayout());
        headright.setLayout(new BorderLayout());
        donatebar.setLayout(new BorderLayout());
        
        showImagePanel.addMouseListener(this);
        showImagePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        showImagePanel.setBackground(new Color(101,101,101));
        showImagePanel.setLayout(new BorderLayout());
        bottomImagePanel.setLayout(new GridLayout(1, 3));
        bottomImagePanel.setBackground(new Color(126,126,126));
        bottomImagePanel.add(imgLabel[1]);
        bottomImagePanel.add(imgLabel[2]);
        bottomImagePanel.add(imgLabel[3]);
        showImagePanel.add(imgLabel[0]);
        showImagePanel.add(bottomImagePanel, BorderLayout.SOUTH);
        
        exitbutton.addMouseListener(this);
        exitbutton.setOpaque(true);
        exitbutton.setForeground(new Color(255, 255, 255));
        exitbutton.setBackground(new Color(61,61,61));
        top.setPreferredSize(new Dimension(360 ,20));
        donatebar.setPreferredSize(new Dimension(360 ,150));
        leftSubright.setPreferredSize(new Dimension(40, 620));
        rightSubright.setPreferredSize(new Dimension(50, 620));
        underleft.setPreferredSize(new Dimension(360 ,70));
        leftSubleft.setPreferredSize(new Dimension(25 ,620));
        
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
        leftPanel.add(showImagePanel, BorderLayout.CENTER);
        leftPanel.add(underleft, BorderLayout.SOUTH);
        leftPanel.add(leftSubleft, BorderLayout.WEST);
        
        rightPanel.add(headright, BorderLayout.NORTH);
        rightPanel.add(discription, BorderLayout.CENTER);
        rightPanel.add(leftSubright, BorderLayout.WEST);
        rightPanel.add(rightSubright, BorderLayout.EAST);
        rightPanel.add(jPanel1, BorderLayout.SOUTH);
        
        Image plusImage = new ImageIcon("./resource/icons/plus.png").getImage();
        plusIcon = new ImageIcon(plusImage.getScaledInstance(48, 48,  java.awt.Image.SCALE_SMOOTH));
        imgLabel[0].setIcon(plusIcon);
        imgLabel[0].setHorizontalAlignment(JLabel.CENTER);
        showImagePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
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
//        postbutton.setBackground(Color.cyan);
        
        gridpanel.add(leftPanel);
        gridpanel.add(rightPanel);
        
        donateframe.add(gridpanel, BorderLayout.CENTER);
        donateframe.add(top, BorderLayout.NORTH);
        
        donateframe.setUndecorated(true);
        donateframe.setSize(900, 500);
        donateframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        donateframe.setVisible(true);
    }
    @Override
    public void run() {
        donateframe.setLocation(90, 150);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(exitbutton)){
            donateframe.dispose();
        }
        else if (e.getSource().equals(showImagePanel)){
            imgLabel[0].setIcon(plusIcon);
            imgLabel[1].setIcon(null);
            imgLabel[2].setIcon(null);
            imgLabel[3].setIcon(null);
            
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("image files", "jpg", "jpeg", "png");
            fc.setFileFilter(filter);
            fc.setMultiSelectionEnabled(true);
            fc.showOpenDialog(donateframe);
            File files[] = fc.getSelectedFiles();
            if (files.length > 1){
                System.out.println("maximum 4 images :C");
            }
            else{
                int i = 0;
                imgFiles = files.clone();
                for (File imgFile : files){
                    Image image = new ImageIcon(imgFile.getAbsolutePath()).getImage();
                    ImageIcon icon = null;
                    if (i == 0){
                        icon = new ImageIcon(image.getScaledInstance(590, 330,  java.awt.Image.SCALE_SMOOTH));
                    }
                    else{
                        icon = new ImageIcon(image.getScaledInstance(160, 100,  java.awt.Image.SCALE_SMOOTH));
                    }
                    imgLabel[i].setIcon(icon);
                    i++;
                }
            }
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
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
        else if (e.getSource().equals(showImagePanel)){
            showImagePanel.setBackground(new Color(150,150,150));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(exitbutton)){
            exitbutton.setBackground(new Color(61,61,61));
        }
        else if (e.getSource().equals(showImagePanel)){
            showImagePanel.setBackground(new Color(101,101,101));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(post)){
            if (!head.getText().equals("") && !discription.getText().equals("")){
                Database db = new Database();
                db.update(String.format("INSERT INTO boardzone.donate_data (name, detail, price,fullprice) VALUES ('%s', '%s', '%f', '%f')", head.getText(), discription.getText(), Double.parseDouble(priceta.getText())-Double.parseDouble(priceta.getText()), Double.parseDouble(priceta.getText())));
                db.close();
                Connection cn = db.getConnection();
                int i = 0;
                try {
                    for (File imgFile : imgFiles){

                        try(FileInputStream fis = new FileInputStream(imgFile)){
                            PreparedStatement ps = cn.prepareStatement(String.format("UPDATE boardzone.donate_data SET img%s = ? WHERE (name = ?)", ""+i));
                            ps.setBlob(1, fis);
                            ps.setString(2, head.getText());
                            ps.executeUpdate();
                            System.out.println("img"+ i + " added");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        i++;
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                db.close();
                donateframe.dispose();
                JOptionPane.showMessageDialog(null, "Your post has been successfully created!");
            }else if(e.getSource().equals(exitbutton)){
            donateframe.dispose();
            }
            else {
                donateframe.dispose();
                JOptionPane.showMessageDialog(null, "pls input name and detail");
            }
        }
        else if(e.getSource().equals(exitbutton)){
            donateframe.dispose();
        }
    }

    private void setLayout(GroupLayout layout) {
        
    }
}
