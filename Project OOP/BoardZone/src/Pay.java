/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class Pay implements ActionListener {
    private JFrame jf;
    private JPanel jp ;
    private ImageIcon qr;
    private JLabel jl1, txt;
    private JTextField price;
    private JButton pay;
    private JLabel empty_line1, empty_line2, empty_line3;
    
    public Pay(){
        jf = new JFrame();
        jp = new JPanel();
        qr = new ImageIcon("Easter egg.png");
        jl1 = new JLabel(qr, JLabel.CENTER);
        txt = new JLabel("Amount of money");
        price = new JTextField();
        pay = new JButton("Pay");
        empty_line1 = new JLabel();
        empty_line2 = new JLabel();
        empty_line3 = new JLabel();
        
        empty_line1.setPreferredSize(new Dimension(3000,20));
        empty_line2.setPreferredSize(new Dimension(3000,0));
        empty_line3.setPreferredSize(new Dimension(3000,0));
        price.setPreferredSize(new Dimension(100,20));
        
        jp.setLayout(new FlowLayout());
        
        jp.add(empty_line1);
        jp.add(jl1);
        jp.add(empty_line2);
        jp.add(txt);
        jp.add(empty_line3);
        jp.add(price);
        jp.add(pay);
        
        jf.add(jp);
        
        jp.setBackground(new Color(101, 101, 101));
        pay.setBackground(Color.WHITE);
        
        pay.addActionListener(this);
        
        jf.setSize(400, 400);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new Pay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(pay)){
            jf.dispose();
        }
    }
}
