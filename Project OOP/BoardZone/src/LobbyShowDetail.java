import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;

public class LobbyShowDetail implements MouseListener, ActionListener, WindowListener, Runnable{
    private JFrame frame;
    private JPanel headerPanel, bodyPanel, mainImagePanel, showImagePanel, outputPanel, namePanel, dnbPanel, detailPanel, footerPanel, buttonPanel, bottomImagePanel, statusPanel, ratingPanel, status2Panel;
    private Lobby mainWindow;
    private JLabel xBtnLabel, nameLabel, ratingLabel;
    private JLabel imgLabel[] = new JLabel[4];;
    private JTextArea detailTA;
    private JButton borrowBtn, timeBtn, isAvailableBtn, saveBtn;
    private JScrollPane taScrollPane;
    private JComboBox ratingComboBox;
    
    private int boardGameID;
    private String name, detail;
    private double rating;
    private boolean isAvailable;
    private boolean haveRated = false;
    
    public LobbyShowDetail(Lobby mainWindow, int id){
        this.boardGameID = id;
        this.mainWindow = mainWindow; 
        frame = new JFrame();
        headerPanel = new JPanel();
        bodyPanel = new JPanel();
        mainImagePanel = new JPanel();
        showImagePanel = new JPanel();
        outputPanel = new JPanel();
        footerPanel = new JPanel();
        detailTA = new JTextArea("Loading...",16, 37);
        namePanel = new JPanel();
        dnbPanel = new JPanel();
        nameLabel = new JLabel("Loading...");
        borrowBtn = new JButton("Borrow");
        buttonPanel = new JPanel();
        detailPanel = new JPanel();
        bottomImagePanel = new JPanel();
        imgLabel[0] = new JLabel();
        imgLabel[1] = new JLabel();
        imgLabel[2] = new JLabel();
        imgLabel[3] = new JLabel();
        isAvailableBtn = new JButton("Available");
        timeBtn = new JButton("00:00");
        statusPanel = new JPanel();
        ratingLabel = new JLabel("Rating: ");
        taScrollPane = new JScrollPane(detailTA);
        taScrollPane.setBorder(BorderFactory.createEmptyBorder());
        ratingPanel = new JPanel();
        status2Panel = new JPanel();
        ratingComboBox = new JComboBox();
        saveBtn = new JButton("Save");
        
        borrowBtn.addActionListener(this);
        borrowBtn.addMouseListener(this);
        showImagePanel.addMouseListener(this);
        frame.addWindowListener(this);
        saveBtn.addActionListener(this);
        
        //Header
        Image image = new ImageIcon("./resource/icons/times.png").getImage();
        ImageIcon xIcon = new ImageIcon(image.getScaledInstance(32, 32,  java.awt.Image.SCALE_SMOOTH));
        xBtnLabel = new JLabel(xIcon);
        xBtnLabel.addMouseListener(this);
        
        xBtnLabel.setForeground(new Color(255, 255, 255));
        xBtnLabel.setBackground(new Color(61,61,61));
        xBtnLabel.setOpaque(true);
        
        headerPanel.setBackground(new Color(61,61,61));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.add(new BlankPanel(new Color(61,61,61)));
        headerPanel.add(xBtnLabel, BorderLayout.EAST);
        //Header
        
        
        //mainImagePanel
        imgLabel[0].setHorizontalAlignment(JLabel.CENTER);
        imgLabel[0].setBorder(new LineBorder(new Color(126,126,126), 3));
        imgLabel[1].setBorder(new LineBorder(new Color(126,126,126), 3));
        imgLabel[2].setBorder(new LineBorder(new Color(126,126,126), 3));
        imgLabel[3].setBorder(new LineBorder(new Color(126,126,126), 3));
        
          
        showImagePanel.setBackground(new Color(126,126,126));
        showImagePanel.setLayout(new BorderLayout());
        bottomImagePanel.setLayout(new GridLayout(1, 3));
        bottomImagePanel.setBackground(new Color(126,126,126));
        bottomImagePanel.add(imgLabel[1]);
        bottomImagePanel.add(imgLabel[2]);
        bottomImagePanel.add(imgLabel[3]);
        showImagePanel.add(imgLabel[0]);
        showImagePanel.add(bottomImagePanel, BorderLayout.SOUTH);
        
        mainImagePanel.setLayout(new BorderLayout());
        mainImagePanel.add(new BlankPanel(20, 50, new Color(61, 61, 61)), BorderLayout.EAST);
        mainImagePanel.add(showImagePanel);
        //mainImagePanel
        
        
        //inputPanel
        nameLabel.setBackground(new Color(61, 61, 61));
        nameLabel.setForeground(new Color(255, 255, 255));
        nameLabel.setOpaque(true);
        nameLabel.setFont(nameLabel.getFont().deriveFont(24f));
        
        namePanel.setLayout(new BorderLayout());
        namePanel.add(new BlankPanel(38, 10, new Color(61, 61, 61)), BorderLayout.NORTH);
        namePanel.add(nameLabel);
        
        isAvailableBtn.setBackground(new Color(61, 61, 61));
        isAvailableBtn.setForeground(new Color(255, 255, 255));
        isAvailableBtn.setFont(isAvailableBtn.getFont().deriveFont(12f));
        isAvailableBtn.setRolloverEnabled(false);
        isAvailableBtn.setFocusPainted(false);
        ratingLabel.setForeground(new Color(180, 180, 180));
        
        ratingLabel.setHorizontalTextPosition(JLabel.LEFT);
        Image starImg = new ImageIcon("./resource/icons/star.png").getImage();
        ImageIcon starIcon = new ImageIcon(starImg.getScaledInstance(12, 12,  java.awt.Image.SCALE_SMOOTH));
        ratingLabel.setIcon(starIcon);
        ratingLabel.setFont(ratingLabel.getFont().deriveFont(12f));
         
        ratingComboBox.addItem("0");
        ratingComboBox.addItem("1");
        ratingComboBox.addItem("2");
        ratingComboBox.addItem("3");
        ratingComboBox.addItem("4");
        ratingComboBox.addItem("5");
        
        saveBtn.setFont(saveBtn.getFont().deriveFont(12f));
        saveBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ratingComboBox.setBackground(new Color(61, 61, 61));
        ratingComboBox.setForeground(Color.WHITE);
        saveBtn.setBackground(new Color(61, 61, 61));
        saveBtn.setForeground(new Color(180, 180, 180));
        
        ratingComboBox.setPreferredSize(new Dimension(35, 18));
        saveBtn.setPreferredSize(new Dimension(70, 18));
        
        
        ratingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ratingPanel.add(ratingLabel);
        ratingPanel.add(ratingComboBox);
        ratingPanel.add(saveBtn);
        ratingPanel.setBackground(new Color(61, 61, 61));
        
        status2Panel.setBackground(new Color(61, 61, 61));
        status2Panel.setLayout(new GridLayout(1, 2));
        status2Panel.add(new BlankPanel(new Color(61, 61, 61)));
        status2Panel.add(isAvailableBtn);
        
        statusPanel.setLayout(new GridLayout(1, 2));
        statusPanel.setBackground(new Color(61, 61, 61));
        statusPanel.add(ratingPanel);
        statusPanel.add(status2Panel);
        namePanel.add(statusPanel, BorderLayout.SOUTH);
        
        taScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        taScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        taScrollPane.getVerticalScrollBar().setUnitIncrement(15);
        taScrollPane.getVerticalScrollBar().setBackground(new Color(75,75,75));
        taScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI());
        taScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8, 1));
        
        detailTA.setLineWrap(true);
        detailTA.setBackground(new Color(86, 86, 86));
        detailTA.setForeground(new Color(255, 255, 255));
        detailTA.setEditable(false);
        detailPanel.add(taScrollPane);
        dnbPanel.setLayout(new BorderLayout());
        dnbPanel.add(new BlankPanel(38, 32, new Color(61, 61, 61)), BorderLayout.NORTH);
        dnbPanel.add(detailPanel);
        detailPanel.setBackground(new Color(61, 61, 61));

        borrowBtn.setBackground(new Color(61, 61, 61));
        borrowBtn.setFont(borrowBtn.getFont().deriveFont(16f));
        borrowBtn.setForeground(new Color( 173, 207, 240));
        borrowBtn.setBorder(new LineBorder(new Color( 173, 207, 240)));
        borrowBtn.setPreferredSize(new Dimension(91, 31));
        borrowBtn.setFocusPainted(false);
        borrowBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        timeBtn.setBackground(new Color(61, 61, 61));
        timeBtn.setForeground(new Color(255, 255, 255));
        timeBtn.setFont(timeBtn.getFont().deriveFont(16f));
        timeBtn.setRolloverEnabled(false);
        timeBtn.setFocusPainted(false);
        
        buttonPanel.add(borrowBtn);
        buttonPanel.add(timeBtn);
        buttonPanel.setBackground(new Color(61, 61, 61));
        
        dnbPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        
        outputPanel.setBackground(new Color(61,61,61));
        
        outputPanel.setLayout(new BorderLayout());
        outputPanel.add(namePanel, BorderLayout.NORTH);
        outputPanel.add(dnbPanel);
        //inputPanel
        
        
        //bodyPanel
        bodyPanel.setLayout(new GridLayout(1, 2));
        bodyPanel.add(mainImagePanel);
        bodyPanel.add(outputPanel);
        //bodyPanel
        
        
        
        //footerPanel
        footerPanel.setBackground(new Color(61,61,61));
        footerPanel.setPreferredSize(new Dimension(854, 32));
        //footerPanel
        
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(new BlankPanel(16, 416, new Color(61, 61, 61)), BorderLayout.WEST);
        frame.add(bodyPanel);
        frame.add(new BlankPanel(16, 416, new Color(61, 61, 61)), BorderLayout.EAST);
        frame.add(footerPanel, BorderLayout.SOUTH);
        
        frame.setAlwaysOnTop(true);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setSize(854, 480);
        frame.setLocation((int)mainWindow.getFrame().getX()+((mainWindow.getFrame().getWidth()-frame.getWidth())/2), (int)mainWindow.getFrame().getY()+((mainWindow.getFrame().getHeight()-frame.getHeight())/2));
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        

        Thread t = new Thread(this);
        t.start();
    }   

    @Override
    public void run() {
        while (true) {
            if(mainWindow.getFrame().isFocused()){
                frame.setLocation((int)mainWindow.getFrame().getX()+((mainWindow.getFrame().getWidth()-frame.getWidth())/2), (int)mainWindow.getFrame().getY()+((mainWindow.getFrame().getHeight()-frame.getHeight())/2));
                frame.setAlwaysOnTop(true);
            }
            else {
                frame.setAlwaysOnTop(false);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(xBtnLabel)){
            frame.dispose();
            Database db = new Database();
            db.update(String.format("UPDATE boardzone.board_games SET rating = '%s' WHERE board_game_id = '%s'", this.rating , ""+this.boardGameID));
            db.close();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(xBtnLabel)){
            xBtnLabel.setBackground(Color.red);
        }
        else if (e.getSource().equals(borrowBtn)){
//            ADD by Title to change if NOT AAvailable
            if (isAvailable) {
                borrowBtn.setBorder(new LineBorder(new Color( 173, 207, 240), 3));
            } else {
                borrowBtn.setBorder(new LineBorder(new Color( 237, 135, 136), 3));
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(xBtnLabel)){
            xBtnLabel.setBackground(new Color(61,61,61));
        }
        else if (e.getSource().equals(borrowBtn)){
//            ADD by Title to change if NOT AAvailable
            if (isAvailable){
                borrowBtn.setBorder(new LineBorder(new Color( 173, 207, 240), 1));
            } else {
                borrowBtn.setBorder(new LineBorder(new Color( 237, 135, 136), 1));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        ADD by Title to make button cant use if NOT Available and dispose if in use
        if (e.getSource().equals(borrowBtn) && isAvailable){
            Database db = new Database();
            try{
                System.out.println("Connecting to database...");
                ResultSet rs = db.getSelect(String.format("SELECT * FROM boardzone.board_games WHERE board_game_id = '%s'", ""+boardGameID));
                while((rs!=null) && (rs.next())){
                    isAvailable = rs.getBoolean("is_available");
                    if (isAvailable){
//                        ADD by Title change the BorrowBtn
                        borrowBtn.setText("Borrow");
                        borrowBtn.setBorder(new LineBorder(new Color( 173, 207, 240), 1));
                        borrowBtn.setForeground(new Color( 173, 207, 240));
                        isAvailableBtn.setText("Available");
                        isAvailableBtn.setForeground(new Color( 173, 207, 240));
                        isAvailableBtn.setBorder(new LineBorder(new Color( 173, 207, 240)));
                        isAvailableBtn.setPreferredSize(new Dimension(85, 26));
                    }
                    else {
//                        ADD by Title change the BorrowBtn
                        borrowBtn.setText("Wait");
                        borrowBtn.setBorder(new LineBorder(new Color( 237, 135, 136), 1));
                        borrowBtn.setForeground(new Color( 237, 135, 136));
                        isAvailableBtn.setText("In use");
                        isAvailableBtn.setForeground(new Color( 237, 135, 136));
                        isAvailableBtn.setBorder(new LineBorder(new Color( 237, 135, 136)));
                        isAvailableBtn.setPreferredSize(new Dimension(85, 26));
                    }

                    System.out.println("Loading isAvailable complete!");
                    System.out.println(isAvailable);
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            db.close();
            
            if (isAvailable){
                new Borrow(this.boardGameID);
                frame.dispose();
                Database db2 = new Database();
                db2.update(String.format("UPDATE boardzone.board_games SET rating = '%s' WHERE board_game_id = '%s'", this.rating , ""+this.boardGameID));
                db2.close();
            }
        }
        if (e.getSource().equals(saveBtn)){
            try {
                Database db = new Database();
                if (haveRated){
                    db.update(String.format("UPDATE boardzone.board_game_ratings SET rating = '%s' WHERE user_id = '%s'", (String)ratingComboBox.getSelectedItem(), ""+Account.id));
                }
                else{
                    db.update(String.format("INSERT INTO boardzone.board_game_ratings (user_id, rating, board_game_id) VALUES ('%s', '%s', '%s')", ""+Account.id, (String)ratingComboBox.getSelectedItem(), this.boardGameID));
                }
                ResultSet rs = db.getSelect(String.format("SELECT * FROM boardzone.board_game_ratings WHERE board_game_id = '%s'", ""+boardGameID));
                int totalRating = 0;
                int numRating = 0;
                while ((rs!=null) && (rs.next())){
                    totalRating += rs.getInt("rating");
                    numRating++;
                }
                db.close();
                this.rating = (double)totalRating/numRating;
                ratingLabel.setText("Rating: "+String.format("%.02f", this.rating));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
//        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if (e.getSource().equals(frame)){
            Database db = new Database();
            try{
                System.out.println("Connecting to database...");
                ResultSet rs = db.getSelect(String.format("SELECT * FROM boardzone.board_games WHERE board_game_id = '%s'", ""+boardGameID));
                while((rs!=null) && (rs.next())){
                    System.out.println("Loading data...");
                    name = rs.getString("name");
                    nameLabel.setText(name);

                    detail = rs.getString("detail");
                    detailTA.setText(detail);

                    isAvailable = rs.getBoolean("is_available");
                    if (isAvailable){
//                        ADD by Title change the BorrowBtn
                        borrowBtn.setText("Borrow");
                        borrowBtn.setBorder(new LineBorder(new Color( 173, 207, 240), 1));
                        borrowBtn.setForeground(new Color( 173, 207, 240));
                        isAvailableBtn.setText("Available");
                        isAvailableBtn.setForeground(new Color( 173, 207, 240));
                        isAvailableBtn.setBorder(new LineBorder(new Color( 173, 207, 240)));
                        isAvailableBtn.setPreferredSize(new Dimension(85, 26));
                    }
                    else {
//                        ADD by Title change the BorrowBtn
                        borrowBtn.setText("Wait");
                        borrowBtn.setBorder(new LineBorder(new Color( 237, 135, 136), 1));
                        borrowBtn.setForeground(new Color( 237, 135, 136));
                        isAvailableBtn.setText("In use");
                        isAvailableBtn.setForeground(new Color( 237, 135, 136));
                        isAvailableBtn.setBorder(new LineBorder(new Color( 237, 135, 136)));
                        isAvailableBtn.setPreferredSize(new Dimension(85, 26));
                    }

                    rating = rs.getDouble("rating");
                    ratingLabel.setText(ratingLabel.getText()+String.format("%.02f", rating));

                    for (int i=0; i<4; i++){
                        byte[] imgBytes = rs.getBytes(String.format("img%s", ""+i));
                        if (imgBytes == null){
                            break;
                        }
                        Image image = new ImageIcon(imgBytes).getImage();
                        ImageIcon icon = null;
                        if (i == 0){
                            icon = new ImageIcon(image.getScaledInstance(586, 330,  java.awt.Image.SCALE_SMOOTH));
                        }
                        else{
                            icon = new ImageIcon(image.getScaledInstance(160, 90,  java.awt.Image.SCALE_SMOOTH));
                        }
                        imgLabel[i].setIcon(icon);
                    }

                    System.out.println("Loading complete!");
                }
                
                ResultSet rrs = db.getSelect(String.format("SELECT * FROM boardzone.board_game_ratings WHERE board_game_id = '%s'", ""+boardGameID));
                while ((rrs!=null) && (rrs.next())){
                    if (Account.id == rrs.getInt("user_id")){
                        haveRated = true;
                        ratingComboBox.setSelectedItem(""+rrs.getInt("rating"));
                        break;
                    }
                }
            
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            db.close();
        }
        
    }

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
    
}

