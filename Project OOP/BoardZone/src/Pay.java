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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.sql.*;

public class Pay implements ActionListener {
    private JFrame jf;
    private JPanel jp ;
    private ImageIcon qr;
    private JLabel jl1, txt, priceJL;
    private JTextField priceTF;
    private JButton pay;
    private JLabel empty_line1, empty_line2, empty_line3;
    
    private String name;
    private double price, fullprice;
    private int id;
    
    public Pay(String name, double price, double fullprice, int id){
        System.out.println(price);
        this.id = id;
        this.price = price;
        this.fullprice = fullprice;
        jf = new JFrame();
        jp = new JPanel();
        qr = new ImageIcon("Easter egg.png");
        jl1 = new JLabel(qr, JLabel.CENTER);
        txt = new JLabel(name);
        priceJL = new JLabel(this.price+"/"+this.fullprice);
        priceTF = new JTextField();
        pay = new JButton("Pay");
        empty_line1 = new JLabel();
        empty_line2 = new JLabel();
        empty_line3 = new JLabel();
        
        empty_line1.setPreferredSize(new Dimension(3000,20));
        empty_line2.setPreferredSize(new Dimension(3000,0));
        empty_line3.setPreferredSize(new Dimension(3000,0));
        priceTF.setPreferredSize(new Dimension(100,20));
        
        jp.setLayout(new FlowLayout());
        
        jp.add(empty_line1);
        jp.add(jl1);
        jp.add(empty_line2);
        jp.add(txt);
        jp.add(empty_line3);
        jp.add(priceJL);
        jp.add(priceTF);
        jp.add(pay);
        
        jf.add(jp);
        
        jp.setBackground(new Color(101, 101, 101));
        pay.setBackground(Color.WHITE);
        
        pay.addActionListener(this);
        
        jf.setSize(400, 400);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(pay)){
            if (!priceTF.getText().equals("") ){
                System.out.println(this.price);
                Database db = new Database();
                db.update(String.format("UPDATE boardzone.donate_data  SET price = '%f' WHERE id = '%d' ",this.price+Double.parseDouble(priceTF.getText()), this.id));
                db.close();
                jf.dispose();
                JOptionPane.showMessageDialog(null, "We got your money :P");
                System.out.println(this.price);
        }
    }
}
}
