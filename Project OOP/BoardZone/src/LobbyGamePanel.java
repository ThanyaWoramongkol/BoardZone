
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LobbyGamePanel extends JPanel implements MouseListener{
    private JLabel imgLabel, nameLabel, playerLabel, positionLabel;
    private JPanel imgPanel, detailPanel, namePanel, playerPanel, nameNplayerPanel, posNjoinPanel, positionPanel, joinPanel;
    private JPanel blankN, blankW, blankE, blankS, blankName;
    private JButton joinBtn;
    private int boardGameID;
    private Color bgColor;
    
    public LobbyGamePanel(/*int boardGameID, String name, ImageIcon img*/){
        this.boardGameID = boardGameID;
        nameLabel = new JLabel("");
        positionLabel = new JLabel("");
        playerLabel = new JLabel("");
        imgPanel = new JPanel();
        namePanel = new JPanel();
        playerPanel = new JPanel();
        nameNplayerPanel = new JPanel();
        posNjoinPanel = new JPanel();
        detailPanel = new JPanel();
        positionPanel = new JPanel();
        joinBtn = new JButton("Join");
        joinPanel = new JPanel();
        bgColor = new Color(58, 56, 57);
        
        blankN = new BlankPanel(16, 16, bgColor);
        blankW = new BlankPanel(16, 16, bgColor);
        blankE = new BlankPanel(16, 16, bgColor);
        blankS = new BlankPanel(16, 16, bgColor);
        blankName = new BlankPanel(16, 16, bgColor);
        
        this.addMouseListener(this);
        //get Image
//        Image image = img.getImage();
//        ImageIcon icon = new ImageIcon(image.getScaledInstance(224, 126, java.awt.Image.SCALE_SMOOTH));
//        imgLabel = new JLabel(icon);
        //set ImgPanel
        imgPanel.setLayout(new BorderLayout());
        imgPanel.add(blankN, BorderLayout.NORTH);
        imgPanel.add(blankE, BorderLayout.EAST);
        imgPanel.add(blankW, BorderLayout.WEST);
        imgPanel.add(blankS, BorderLayout.SOUTH);
//        imgPanel.add(imgLabel);
        //set namePanel
        namePanel.setLayout(new BorderLayout());
        nameLabel.setFont(nameLabel.getFont().deriveFont(16f));
        namePanel.add(blankName, BorderLayout.WEST);
        namePanel.add(nameLabel);
        //set playerPanel
        playerPanel.add(playerLabel);
        //set positionlabel
        positionPanel.add(positionLabel);
        //set joinBtn
        /////----------- you should put na -----------//////
        joinPanel.add(joinBtn);
        
        // main Container setup
        detailPanel.setLayout(new GridLayout(2, 1));
        nameNplayerPanel.setLayout(new GridLayout(1, 2));
        posNjoinPanel.setLayout(new GridLayout(1, 2));

        nameNplayerPanel.add(namePanel); nameNplayerPanel.add(playerPanel);
        posNjoinPanel.add(positionPanel); posNjoinPanel.add(joinBtn);
        nameNplayerPanel.setPreferredSize(new Dimension(224, 40));
        posNjoinPanel.setPreferredSize(new Dimension(224, 40));
        
        //add Container to detailPanel
        detailPanel.add(nameNplayerPanel);
        detailPanel.add(posNjoinPanel);
       
        //setBackground Color
        imgPanel.setBackground(new Color(126, 126, 126));
        nameNplayerPanel.setBackground(bgColor);
        namePanel.setBackground(bgColor);
        playerPanel.setBackground(bgColor);
        posNjoinPanel.setBackground(bgColor);
        positionPanel.setBackground(bgColor);
        //set Font Color
        nameLabel.setForeground(Color.WHITE);
        playerLabel.setForeground(Color.WHITE);
        positionLabel.setForeground(Color.WHITE);
        
        //setup this.Panel
        this.setPreferredSize(new Dimension(224, 256));
        this.setBackground(bgColor);
        this.setLayout(new BorderLayout());
        this.add(imgPanel);
        this.add(detailPanel, BorderLayout.SOUTH);
    }
    
    public int getID(){
        return this.boardGameID;
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        LobbyGamePanel panel = new LobbyGamePanel();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
}
