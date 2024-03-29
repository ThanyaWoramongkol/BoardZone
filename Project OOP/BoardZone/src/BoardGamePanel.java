import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardGamePanel extends JPanel implements MouseListener{
    private JLabel imgLabel, nameLabel, ratingLabel;
    private JPanel imgPanel, detailPanel, namePanel, ratingNStatusPanel, statusPanel, nPanel, wPanel, ePanel, sPanel;
    private JButton statusBtn;
    private int boardGameID;
    public BoardGamePanel(int boardGameID, String name, String rating, boolean isAvailable, ImageIcon img){
        this.boardGameID = boardGameID;
        nameLabel = new JLabel(name);
        ratingLabel = new JLabel("      Rating: " + rating);
        imgPanel = new JPanel();
        detailPanel = new JPanel();
        namePanel = new JPanel();
        ratingNStatusPanel = new JPanel();
        statusBtn = new JButton();
        statusPanel = new JPanel();
        nPanel = new BlankPanel(16, 16, new Color(58, 56, 57));
        wPanel = new BlankPanel(16, 16, new Color(58, 56, 57));
        ePanel = new BlankPanel(16, 16, new Color(58, 56, 57));
        sPanel = new BlankPanel(16, 16, new Color(58, 56, 57));
        
        this.addMouseListener(this);
        
        Image image = img.getImage();
        ImageIcon icon = new ImageIcon(image.getScaledInstance(192, 108,  java.awt.Image.SCALE_SMOOTH));
        imgLabel = new JLabel(icon);
        
        imgPanel.setLayout(new BorderLayout());
        imgPanel.add(nPanel, BorderLayout.NORTH);
        imgPanel.add(wPanel, BorderLayout.WEST);
        imgPanel.add(imgLabel);
        imgPanel.add(ePanel, BorderLayout.EAST);
        imgPanel.add(sPanel, BorderLayout.SOUTH);
        
        namePanel.add(nameLabel);      
        
        if (isAvailable){
            statusBtn.setText("Available");
            statusBtn.setForeground(Color.CYAN);
        }
        else{
            statusBtn.setText("In use");
            statusBtn.setForeground(Color.RED);
        }
        statusBtn.setFocusPainted(false);
        statusBtn.setRolloverEnabled(false);
        statusPanel.add(statusBtn);
        
        detailPanel.setLayout(new GridLayout(2, 1));
        ratingNStatusPanel.setLayout(new GridLayout(1, 2));
        ratingNStatusPanel.add(ratingLabel);
        ratingNStatusPanel.add(statusPanel);
        
        detailPanel.add(namePanel);
        detailPanel.add(ratingNStatusPanel);
        
        imgPanel.setBackground(new Color(126, 126, 126));
        namePanel.setBackground(new Color(58, 56, 57));
        ratingNStatusPanel.setBackground(new Color(58, 56, 57));
        statusBtn.setBackground(new Color(58, 56, 57));
        statusPanel.setBackground(new Color(58, 56, 57));
        
        nameLabel.setForeground(Color.white);
        ratingLabel.setForeground(Color.white);
        
        
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
        }
    }
}
