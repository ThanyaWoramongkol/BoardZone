import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardGamePanel extends JPanel {
    private JLabel imgLabel, nameLabel, ratingLabel;
    private JPanel imgPanel, detailPanel, namePanel, ratingNStatusPanel, statusPanel;
    private JButton statusBtn;
    public BoardGamePanel(String name, String rating, boolean isAvailable, ImageIcon img){
        nameLabel = new JLabel(name);
        ratingLabel = new JLabel("      Rating: " + rating);
        imgPanel = new JPanel();
        detailPanel = new JPanel();
        namePanel = new JPanel();
        ratingNStatusPanel = new JPanel();
        statusBtn = new JButton();
        statusPanel = new JPanel();
        
        Image image = img.getImage();
        ImageIcon icon = new ImageIcon(image.getScaledInstance(192, 108,  java.awt.Image.SCALE_SMOOTH));
        imgLabel = new JLabel(icon);
        
        imgPanel.setLayout(new BorderLayout());
        imgPanel.add(new BlankPanel(16, 16, new Color(58, 56, 57)), BorderLayout.NORTH);
        imgPanel.add(new BlankPanel(16, 16, new Color(58, 56, 57)), BorderLayout.WEST);
        imgPanel.add(imgLabel);
        imgPanel.add(new BlankPanel(16, 16, new Color(58, 56, 57)), BorderLayout.EAST);
        imgPanel.add(new BlankPanel(16, 16, new Color(58, 56, 57)), BorderLayout.SOUTH);
        
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
    }
}
