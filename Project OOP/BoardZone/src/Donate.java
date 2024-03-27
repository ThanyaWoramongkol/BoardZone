
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Donate extends javax.swing.JPanel implements Runnable, MouseListener, ActionListener{
    private JPanel jPanel1;
    private JButton jButton1;
    private JTextField jTextField1;
    
    private JFrame donateframe;
    private JPanel gridpanel, leftPanel, rightPanel, rightPanell;
    private JPanel donatebar, subPanel, leftSubright, rightSubright, headright, leftSubleft, underleft, top;
    private JTextField cost;
    private JTextArea head, discription;
    private JLabel jl1, jl2, jl3, sp1;
    private ImageIcon pic1;
    private Font fontHead;
    private JButton picturebutton, exitbutton, postbutton;
    
    public Donate(){
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));

        jButton1.setText("Post");
        jButton1.setBackground(Color.WHITE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        
        jButton1.addActionListener(this);
        jTextField1.addActionListener(this);
        
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
        discription = new JTextArea("Detail");
        pic1 = new ImageIcon("poring.png");
        jl1 = new JLabel(pic1, JLabel.CENTER);
        jl2 = new JLabel();
        sp1 = new JLabel("     Name : ");
        fontHead = new Font("Inter", Font.BOLD, 20);
        picturebutton = new JButton(pic1);
        exitbutton = new JButton("X");
        postbutton = new JButton("Post");
        cost = new JTextField();
        
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
        
        head.setFont(fontHead);
        head.setForeground(Color.WHITE);
        head.setOpaque(false);
        exitbutton.setForeground(Color.WHITE);
        sp1.setFont(fontHead.deriveFont(36));
        sp1.setForeground(Color.WHITE);
        postbutton.setForeground(Color.WHITE);
        
        donatebar.add(cost, BorderLayout.NORTH);
        donatebar.add(postbutton, BorderLayout.EAST);
        
        headright.add(sp1, BorderLayout.WEST); headright.add(head, BorderLayout.CENTER); headright.add(exitbutton, BorderLayout.EAST);
        
        subPanel.add(jl2);
        leftPanel.add(picturebutton, BorderLayout.CENTER);
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
        picturebutton.setBackground(new Color(101,101,101));
        postbutton.setBackground(Color.cyan);
        
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
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    public static void main(String[] args) {
        new Donate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(exitbutton)){
            System.exit(JFrame.DISPOSE_ON_CLOSE);
        }
        else if(e.getSource().equals(jButton1)){
            
        }
    }

    private void setLayout(GroupLayout layout) {
        
    }
}
