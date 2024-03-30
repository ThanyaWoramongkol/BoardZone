import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DonatePanel extends JPanel implements MouseListener {
        private JPanel detailJP;
        private JLabel picJL, nameJL, detailJL, priceJL;
        private JLabel space1, space2;
        private int id;
        
        public DonatePanel(int id, String name, String detail, double price, double fullprice, ImageIcon img){
            this.id  = id;
            nameJL = new JLabel(name);
            detailJL = new JLabel(detail);
            priceJL  = new JLabel(price+"/"+fullprice);
            detailJP = new JPanel();
            space1 = new JLabel();
            space2 = new JLabel();
            
            space1.setPreferredSize(new Dimension(3000, 0));
            space2.setPreferredSize(new Dimension(3000, 0));
            
            detailJP.setLayout(new FlowLayout());
            
            detailJP.add(nameJL);
            detailJP.add(space1);
            detailJP.add(detailJL);
            detailJP.add(space2);
            detailJP.add(priceJL);
            
            Image image = img.getImage();
            ImageIcon icon = new ImageIcon(image.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH));
            picJL = new JLabel(icon);
            
            detailJP.setBackground(new Color(58, 56, 57));
            
            this.addMouseListener(this);
            
            this.setPreferredSize(new Dimension(850, 85));
            this.setBackground(new Color(58, 56, 57));
            this.setLayout(new BorderLayout());
            this.add(picJL, BorderLayout.WEST);
            this.add(detailJP, BorderLayout.CENTER);
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        
        public int getID(){
            return this.id;
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
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(this)){
            detailJP.setBackground(new Color(58, 56, 57));
        }
    }
}
