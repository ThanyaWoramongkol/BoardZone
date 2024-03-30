import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class BoardGamePanel extends JPanel implements MouseListener{
    private JLabel imgLabel, nameLabel, ratingLabel;
    private JPanel imgPanel, detailPanel, namePanel, ratingNStatusPanel, statusPanel, nPanel, wPanel, ePanel, sPanel, w2Panel;
    private JButton statusBtn;
    private int boardGameID;
    public BoardGamePanel(int boardGameID, String name, double rating, boolean isAvailable, ImageIcon img){
        this.boardGameID = boardGameID;
        nameLabel = new JLabel(name);
        ratingLabel = new JLabel(String.format("      Rating: %.02f", rating));
        imgPanel = new JPanel();
        detailPanel = new JPanel();
        namePanel = new JPanel();
        ratingNStatusPanel = new JPanel();
        statusBtn = new JButton();
        statusPanel = new JPanel();
        nPanel = new BlankPanel(16, 16, new Color(58, 56, 57));
        wPanel = new BlankPanel(16, 16, new Color(58, 56, 57));
        ePanel = new BlankPanel(16, 16, new Color(58, 56, 57));
        sPanel = new BlankPanel(16, 7, new Color(58, 56, 57));
        w2Panel = new BlankPanel(18, 18, new Color(58, 56, 57));
        
        this.addMouseListener(this);
        
        Image image = img.getImage();
        ImageIcon icon = new ImageIcon(image.getScaledInstance(224, 126,  java.awt.Image.SCALE_SMOOTH));
        imgLabel = new JLabel(icon);
        
        imgPanel.setLayout(new BorderLayout());
        imgPanel.add(nPanel, BorderLayout.NORTH);
        imgPanel.add(wPanel, BorderLayout.WEST);
        imgPanel.add(imgLabel);
        imgPanel.add(ePanel, BorderLayout.EAST);
        imgPanel.add(sPanel, BorderLayout.SOUTH);
        
        namePanel.setLayout(new BorderLayout());
        nameLabel.setFont(nameLabel.getFont().deriveFont(16f));
        namePanel.add(w2Panel, BorderLayout.WEST);
        namePanel.add(nameLabel); 
        
        
        if (isAvailable){
            statusBtn.setText("Available");
            statusBtn.setForeground(new Color( 173, 207, 240));
            statusBtn.setBorder(new LineBorder(new Color( 173, 207, 240)));
            statusBtn.setPreferredSize(new Dimension(85, 26));
        }
        else{
            statusBtn.setText("In use");
            statusBtn.setForeground(new Color( 237, 135, 136));
            statusBtn.setBorder(new LineBorder(new Color( 237, 135, 136)));
            statusBtn.setPreferredSize(new Dimension(85, 26));
        }
        statusBtn.setFocusPainted(false);
        statusBtn.setRolloverEnabled(false);
        statusPanel.add(statusBtn);
        
        ratingLabel.setHorizontalTextPosition(JLabel.LEFT);
        Image starImg = new ImageIcon("./resource/icons/star.png").getImage();
        ImageIcon starIcon = new ImageIcon(starImg.getScaledInstance(12, 12,  java.awt.Image.SCALE_SMOOTH));
        ratingLabel.setIcon(starIcon);
        
        detailPanel.setLayout(new GridLayout(2, 1));
        ratingNStatusPanel.setLayout(new GridLayout(1, 2));
        ratingNStatusPanel.add(ratingLabel);
        ratingNStatusPanel.add(statusPanel);
        ratingNStatusPanel.setPreferredSize(new Dimension(224, 40));
        
        detailPanel.add(namePanel);
        detailPanel.add(ratingNStatusPanel);
        
        imgPanel.setBackground(new Color(126, 126, 126));
        namePanel.setBackground(new Color(58, 56, 57));
        ratingNStatusPanel.setBackground(new Color(58, 56, 57));
        statusBtn.setBackground(new Color(58, 56, 57));
        statusPanel.setBackground(new Color(58, 56, 57));
        
        nameLabel.setForeground(Color.white);
        ratingLabel.setForeground(new Color(180, 180, 180));
        
        
        this.setPreferredSize(new Dimension(224, 256));
        this.setBackground(new Color(58, 56, 57));
        this.setLayout(new BorderLayout());
        this.add(imgPanel);
        this.add(detailPanel, BorderLayout.SOUTH);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    public int getID(){
        return this.boardGameID;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(this)){
            namePanel.setBackground(new Color(64, 63, 62));
            ratingNStatusPanel.setBackground(new Color(64, 63, 62));
            statusBtn.setBackground(new Color(64, 63, 62));
            statusPanel.setBackground(new Color(64, 63, 62));
            nPanel.setBackground(new Color(64, 63, 62));
            ePanel.setBackground(new Color(64, 63, 62));
            wPanel.setBackground(new Color(64, 63, 62));
            sPanel.setBackground(new Color(64, 63, 62));
            w2Panel.setBackground(new Color(64, 63, 62));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(this)){
            namePanel.setBackground(new Color(58, 56, 57));
            ratingNStatusPanel.setBackground(new Color(58, 56, 57));
            statusBtn.setBackground(new Color(58, 56, 57));
            statusPanel.setBackground(new Color(58, 56, 57));
            nPanel.setBackground(new Color(58, 56, 57));
            ePanel.setBackground(new Color(58, 56, 57));
            sPanel.setBackground(new Color(58, 56, 57));
            wPanel.setBackground(new Color(58, 56, 57));
            w2Panel.setBackground(new Color(58, 56, 57));
        }
    }
}
