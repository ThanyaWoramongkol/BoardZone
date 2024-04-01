
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class LobbyGamePanel extends JPanel implements MouseListener{
    private JLabel imgLabel, nameLabel, playerLabel, positionLabel;
    private JPanel imgPanel, detailPanel, namePanel, playerPanel, nameNplayerPanel, posNjoinPanel, positionPanel, joinPanel;
    private JPanel blankN, blankW, blankE, blankS, blankName, blankPlayer;
    private JButton joinBtn;
    private int boardGameID;
    private Color bgColor;
    
    private int playercount;
    private int maxplayer;
    private boolean ispublic;
    
    public LobbyGamePanel(int boardGameID, String name, String location, int maxp, boolean ispublic, ImageIcon img, int playercount){
        this.ispublic = ispublic;
        this.maxplayer = maxp;
        this.playercount = playercount;
        
        this.boardGameID = boardGameID;
        nameLabel = new JLabel(name);
        positionLabel = new JLabel(location);
        playerLabel = new JLabel("Max: " + this.playercount + " / " + maxplayer);
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
        blankPlayer = new BlankPanel(16, 16, bgColor);
        
        this.addMouseListener(this);
        joinBtn.addMouseListener(this);
        //get Image
       Image image = img.getImage();
       ImageIcon icon = new ImageIcon(image.getScaledInstance(224, 126, java.awt.Image.SCALE_SMOOTH));
       imgLabel = new JLabel(icon);
        //set ImgPanel
        imgPanel.setLayout(new BorderLayout());
        imgPanel.add(blankN, BorderLayout.NORTH);
        imgPanel.add(blankE, BorderLayout.EAST);
        imgPanel.add(blankW, BorderLayout.WEST);
        imgPanel.add(blankS, BorderLayout.SOUTH);
       imgPanel.add(imgLabel);
        //set namePanel
        namePanel.setLayout(new BorderLayout());
        nameLabel.setFont(nameLabel.getFont().deriveFont(16f));
        namePanel.add(blankName, BorderLayout.WEST);
        namePanel.add(nameLabel, BorderLayout.CENTER);
        //set playerPanel
        playerPanel.setLayout(new BorderLayout());
        playerPanel.add(playerLabel, BorderLayout.CENTER);
        playerPanel.add(blankPlayer, BorderLayout.EAST);
        //set positionlabel
        positionPanel.add(positionLabel);
        //set joinBtn
        /////----------- you should put na -----------//////
        joinPanel.add(joinBtn);
        
        // main Container setup
        detailPanel.setLayout(new GridLayout(2, 1));
        nameNplayerPanel.setLayout(new BorderLayout());
        posNjoinPanel.setLayout(new GridLayout(1, 2));

        nameNplayerPanel.add(namePanel, BorderLayout.CENTER); nameNplayerPanel.add(playerPanel, BorderLayout.EAST);
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
        
        playerLabel.setFont(new Font("Arial", Font.BOLD, 13));
        joinBtn.setFont(new Font("Arial", Font.BOLD, 20));
         if (!ispublic) {
            joinBtn.setText("Private");
            joinBtn.setRolloverEnabled(false);
            playerLabel.setText("Max: " + this.maxplayer);
            joinBtn.setBackground(this.bgColor);
            joinBtn.setForeground(Color.RED);
            joinBtn.setBorder(new LineBorder(Color.RED, 3));
        } else if (this.playercount >= maxplayer){
            joinBtn.setText("Max");
            joinBtn.setRolloverEnabled(false);
            joinBtn.setBackground(this.bgColor);
            joinBtn.setForeground(Color.RED);
            joinBtn.setBorder(new LineBorder(Color.RED, 3));
        } else {
            joinBtn.setBackground(new Color( 173, 207, 240));
            joinBtn.setForeground(Color.WHITE);
            
        }
    }
    
    public int getID(){
        return this.boardGameID;
    }
    
//    TESTING GROUND
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        LobbyGamePanel panel = new LobbyGamePanel(22, "NAME1NAME2NAME3", "location", 5, false, new ImageIcon("poring.png"), 2);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(joinBtn)){
            if (ispublic){
                if (playercount < maxplayer){
                    Database db = new Database();
                    db.update(String.format("UPDATE boardzone.Borrow_item\n" +
    "SET player = player+1\n" +
    "WHERE idboradgame = '%s' LIMIT 5;", ""+boardGameID));
                    ++playercount;
                }
                if (playercount >= maxplayer){
                    joinBtn.setText("Max");
                    joinBtn.setRolloverEnabled(false);
                    joinBtn.setBackground(this.bgColor);
                    joinBtn.setForeground(Color.RED);
                    joinBtn.setBorder(new LineBorder(Color.RED, 3));
                }
                playerLabel.setText("Max: " + playercount + " / " + maxplayer);
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
        if (e.getSource().equals(joinBtn)){
            joinBtn.setFont(new Font("Arial", Font.BOLD, 24));
            if (playercount >= maxplayer){
                playerLabel.setFont(new Font("Arial", Font.BOLD, 16));
            }
        } else {
            detailPanel.setBackground(new Color(64, 63, 62));
            namePanel.setBackground(new Color(64, 63, 62));
            playerPanel.setBackground(new Color(64, 63, 62));
            nameNplayerPanel.setBackground(new Color(64, 63, 62));
            posNjoinPanel.setBackground(new Color(64, 63, 62));
            positionPanel.setBackground(new Color(64, 63, 62));
            joinPanel.setBackground(new Color(64, 63, 62));
            blankN.setBackground(new Color(64, 63, 62));
            blankW.setBackground(new Color(64, 63, 62));
            blankE.setBackground(new Color(64, 63, 62));
            blankS.setBackground(new Color(64, 63, 62));
            blankName.setBackground(new Color(64, 63, 62));
            blankPlayer.setBackground(new Color(64, 63, 62));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(joinBtn)){
            joinBtn.setFont(new Font("Arial", Font.BOLD, 20));
            if (playercount >= maxplayer){
                playerLabel.setFont(new Font("Arial", Font.BOLD, 13));
            }
        } else {
            detailPanel.setBackground(this.bgColor);
            namePanel.setBackground(this.bgColor);
            playerPanel.setBackground(this.bgColor);
            nameNplayerPanel.setBackground(this.bgColor);
            posNjoinPanel.setBackground(this.bgColor);
            positionPanel.setBackground(this.bgColor);
            joinPanel.setBackground(this.bgColor);
            blankN.setBackground(this.bgColor);
            blankW.setBackground(this.bgColor);
            blankE.setBackground(this.bgColor);
            blankS.setBackground(this.bgColor);
            blankName.setBackground(this.bgColor);
            blankPlayer.setBackground(this.bgColor);
        } 
    }
}
