import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BoardGameShowDetail implements MouseListener, ActionListener, WindowListener, Runnable{
    private JFrame frame;
    private JPanel headerPanel, bodyPanel, mainImagePanel, showImagePanel, outputPanel, namePanel, dnbPanel, detailPanel, footerPanel, buttonPanel, bottomImagePanel, statusPanel;
    private Home mainWindow;
    private JLabel xBtnLabel, nameLabel, ratingLabel;
    private JLabel imgLabel[] = new JLabel[4];;
    private JTextArea detailTA;
    private JButton borrowBtn, timeBtn, isAvailableBtn;
    private JScrollPane taScrollPane;
    
    private int boardGameID;
    private String name, detail, rating;
    private boolean isAvailable;
    
    public BoardGameShowDetail(Home mainWindow, int id){
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
        borrowBtn.addActionListener(this);
        showImagePanel.addMouseListener(this);
        frame.addWindowListener(this);
        
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
        
        
        showImagePanel.setBackground(new Color(126,126,126));
        showImagePanel.setLayout(new BorderLayout());
        bottomImagePanel.setLayout(new GridLayout(1, 3));
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
        nameLabel.setFont(xBtnLabel.getFont().deriveFont(24f));
        
        namePanel.setLayout(new BorderLayout());
        namePanel.add(new BlankPanel(38, 10, new Color(61, 61, 61)), BorderLayout.NORTH);
        namePanel.add(nameLabel);
        
        isAvailableBtn.setBackground(new Color(61, 61, 61));
        isAvailableBtn.setForeground(new Color(255, 255, 255));
        isAvailableBtn.setFont(isAvailableBtn.getFont().deriveFont(12f));
        isAvailableBtn.setRolloverEnabled(false);
        isAvailableBtn.setFocusPainted(false);
        ratingLabel.setForeground(new Color(255, 255, 255));
         
        statusPanel.setLayout(new GridLayout(1, 3));
        statusPanel.setBackground(new Color(61, 61, 61));
        statusPanel.add(ratingLabel);
        statusPanel.add(new BlankPanel(new Color(61, 61, 61)));
        statusPanel.add(isAvailableBtn);
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
        borrowBtn.setForeground(new Color(255, 255, 255));
        borrowBtn.setFont(borrowBtn.getFont().deriveFont(16f));
        borrowBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        timeBtn.setBackground(new Color(61, 61, 61));
        timeBtn.setForeground(new Color(255, 255, 255));
        timeBtn.setFont(timeBtn.getFont().deriveFont(16f));
        timeBtn.setRolloverEnabled(false);
        
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(xBtnLabel)){
            xBtnLabel.setBackground(new Color(61,61,61));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if (e.getSource().equals(frame)){
            Database db = new Database();
            try{
                System.out.println("Loading.");
                ResultSet rs = db.getSelect(String.format("SELECT * FROM boardzone.board_games WHERE board_game_id = '%s'", ""+boardGameID));
                System.out.println("Loading..");
                while((rs!=null) && (rs.next())){
                    name = rs.getString("name");
                    nameLabel.setText(name);

                    detail = rs.getString("detail");
                    detailTA.setText(detail);

                    isAvailable = rs.getBoolean("is_available");
                    if (isAvailable){
                        isAvailableBtn.setText("Available");
                        isAvailableBtn.setForeground(Color.CYAN);
                    }
                    else {
                        isAvailableBtn.setText("In use");
                        isAvailableBtn.setForeground(Color.RED);
                    }

                    rating = rs.getString("rating");
                    ratingLabel.setText(ratingLabel.getText()+rating);

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

                    System.out.println("Loading...");
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            db.close();
        }
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

