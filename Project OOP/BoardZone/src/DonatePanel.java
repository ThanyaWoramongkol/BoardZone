import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DonatePanel extends JPanel implements Runnable, MouseListener {
        private JPanel detailJP, imgPanel, nPanel, wPanel, ePanel, sPanel;
        private JLabel picJL, nameJL, detailJL, priceJL;
        private JLabel space1, space2;
        private int id;
        private String name;
        private String detail;
        private double price, fullprice;
        private ImageIcon img1, img2, img3, img4;
        
        public DonatePanel(int id, String name, String detail, double price, double fullprice, ImageIcon img1){
            this.id  = id;
            this.name = name;
            this.detail = detail;
            this.price = price;
            this.fullprice = fullprice;
            this.img1 = img1;
//            this.img2 = img2;
//            this.img3 = img3;
//            this.img4 = img4;
            nameJL = new JLabel(name);
            detailJL = new JLabel(detail);
            imgPanel = new JPanel();
            detailJP = new JPanel();
            priceJL  = new JLabel(price+"/"+fullprice);
            space1 = new JLabel();
            space2 = new JLabel();
            nPanel = new BlankPanel(16, 16, new Color(58, 56, 57));
            wPanel = new BlankPanel(16, 16, new Color(58, 56, 57));
            ePanel = new BlankPanel(16, 16, new Color(58, 56, 57));
            sPanel = new BlankPanel(16, 16, new Color(58, 56, 57));
            
            this.addMouseListener(this);
            
            System.out.println("creat panel");
            space1.setPreferredSize(new Dimension(3000, 0));
            space2.setPreferredSize(new Dimension(3000, 0));
            
            Image image = img1.getImage();
            ImageIcon icon = new ImageIcon(image.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH));
            picJL = new JLabel(icon);
            
            detailJP.setLayout(new FlowLayout(FlowLayout.LEFT));
            imgPanel.setLayout(new BorderLayout());
            imgPanel.add(nPanel, BorderLayout.NORTH);
            imgPanel.add(wPanel, BorderLayout.WEST);
            imgPanel.add(picJL);
            imgPanel.add(ePanel, BorderLayout.EAST);
            imgPanel.add(sPanel, BorderLayout.SOUTH);
            
            detailJP.add(nameJL);
            detailJP.add(space1);
            detailJP.add(detailJL);
            detailJP.add(space2);
            detailJP.add(priceJL);
            
            imgPanel.setBackground(new Color(126, 126, 126));
            picJL.setBackground(new Color(126, 126, 126));
            detailJP.setBackground(new Color(58, 56, 57));
            
            nameJL.setForeground(Color.white);
            detailJL.setForeground(Color.white);
            priceJL.setForeground(Color.white);
        
            this.setPreferredSize(new Dimension(850, 85));
            this.setBackground(new Color(58, 56, 57));
            this.setLayout(new BorderLayout());
            this.add(detailJP, BorderLayout.CENTER);
            this.add(imgPanel, BorderLayout.WEST);
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            System.out.println("Complet!");
        }
        
        public int getID(){
            return this.id;
        }
        public String getName(){
            return this.name;
        }
        public String getDetail(){
            return this.detail;
        }
        public double getPrice(){
            return this.price;
        }
        public double getFullPrice(){
            return this.fullprice;
        }
        public ImageIcon getImg1(){
            return this.img1;
        }
//        public ImageIcon getImg2(){
//            return this.img2;
//        }
//        public ImageIcon getImg3(){
//            return this.img3;
//        }
//        public ImageIcon getImg4(){
//            return this.img4;
//        }

    @Override
    public void run() {
        this.setLocation(90, 150);
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
        if (e.getSource().equals(this)){
            detailJP.setBackground(new Color(64, 63, 62));
            nPanel.setBackground(new Color(64, 63, 62));
            ePanel.setBackground(new Color(64, 63, 62));
            wPanel.setBackground(new Color(64, 63, 62));
            sPanel.setBackground(new Color(64, 63, 62));

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(this)){
            detailJP.setBackground(new Color(58, 56, 57));
            nPanel.setBackground(new Color(58, 56, 57));
            ePanel.setBackground(new Color(58, 56, 57));
            sPanel.setBackground(new Color(58, 56, 57));
            wPanel.setBackground(new Color(58, 56, 57));
        }
    }

}
