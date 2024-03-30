import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;
public class CreatePost implements MouseListener, ActionListener, Runnable{
    private JFrame frame;
    private JPanel headerPanel, bodyPanel, mainImagePanel, showImagePanel, inputPanel, namePanel, dnbPanel, detailPanel, footerPanel, postPanel, bottomImagePanel;
    private Home mainWindow;
    private JLabel xBtnLabel, nameLabel, plusLabel;
    private JLabel imgLabel[] = new JLabel[4];;
    private JTextField nameTF;
    private JTextArea detailTA;
    private JButton postBtn;
    private File imgFiles[];
    private ImageIcon plusIcon;
    private JScrollPane taScrollPane;
    public CreatePost(Home mainWindow){
        
        this.mainWindow = mainWindow;
        frame = new JFrame();
        headerPanel = new JPanel();
        bodyPanel = new JPanel();
        mainImagePanel = new JPanel();
        showImagePanel = new JPanel();
        inputPanel = new JPanel();
        footerPanel = new JPanel();
        nameTF = new JTextField();
        detailTA = new JTextArea(16, 37);
        namePanel = new JPanel();
        dnbPanel = new JPanel();
        nameLabel = new JLabel("Name:   ");
        postBtn = new JButton("Post");
        postPanel = new JPanel();
        detailPanel = new JPanel();
        imgLabel[0] = new JLabel();
        imgLabel[1] = new JLabel();
        imgLabel[2] = new JLabel();
        imgLabel[3] = new JLabel();
        plusLabel = new JLabel();
        bottomImagePanel = new JPanel();
        taScrollPane = new JScrollPane(detailTA);
        
        postBtn.addActionListener(this);
        postBtn.addMouseListener(this);
        showImagePanel.addMouseListener(this);
        
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
        Image plusImage = new ImageIcon("./resource/icons/plus.png").getImage();
        plusIcon = new ImageIcon(plusImage.getScaledInstance(48, 48,  java.awt.Image.SCALE_SMOOTH));
        imgLabel[0].setIcon(plusIcon);
        imgLabel[0].setHorizontalAlignment(JLabel.CENTER);
        imgLabel[0].setHorizontalAlignment(JLabel.CENTER);
        imgLabel[0].setBorder(new LineBorder(new Color(126,126,126), 3));
        imgLabel[1].setBorder(new LineBorder(new Color(126,126,126), 3));
        imgLabel[2].setBorder(new LineBorder(new Color(126,126,126), 3));
        imgLabel[3].setBorder(new LineBorder(new Color(126,126,126), 3));
        showImagePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
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
        nameLabel.setFont(xBtnLabel.getFont().deriveFont(16f));
        nameTF.setBackground(new Color(86, 86, 86));
        nameTF.setForeground(new Color(255, 255, 255));
        nameTF.setBorder(BorderFactory.createEmptyBorder());
        
        namePanel.setLayout(new BorderLayout());
        namePanel.add(new BlankPanel(38, 10, new Color(61, 61, 61)), BorderLayout.NORTH);
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(nameTF);
        
        taScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        taScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        taScrollPane.getVerticalScrollBar().setUnitIncrement(15);
        taScrollPane.getVerticalScrollBar().setBackground(new Color(75,75,75));
        taScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI());
        taScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8, 1));
        taScrollPane.setBorder(BorderFactory.createEmptyBorder());
        
        detailTA.setLineWrap(true);
        detailTA.setBackground(new Color(86, 86, 86));
        detailTA.setForeground(new Color(255, 255, 255));
        detailPanel.add(taScrollPane);
        dnbPanel.setLayout(new BorderLayout());
        dnbPanel.add(new BlankPanel(38, 32, new Color(61, 61, 61)), BorderLayout.NORTH);
        dnbPanel.add(detailPanel);
        detailPanel.setBackground(new Color(61, 61, 61));

        postBtn.setBackground(new Color(61, 61, 61));
        postBtn.setFont(postBtn.getFont().deriveFont(16f));
        postBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        postBtn.setForeground(new Color( 173, 207, 240));
        postBtn.setBorder(new LineBorder(new Color( 173, 207, 240)));
        postBtn.setPreferredSize(new Dimension(91, 31));
        postBtn.setFocusPainted(false);
        
        postPanel.setLayout(new BorderLayout());
        postPanel.add(new BlankPanel(new Color(61, 61, 61)), BorderLayout.CENTER);
        postPanel.add(postBtn, BorderLayout.EAST);
        postPanel.setBackground(new Color(61, 61, 61));
        
        dnbPanel.add(postPanel, BorderLayout.SOUTH);
        
        
        inputPanel.setBackground(new Color(61,61,61));
        
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(namePanel, BorderLayout.NORTH);
        inputPanel.add(dnbPanel);
        //inputPanel
        
        
        //bodyPanel
        bodyPanel.setLayout(new GridLayout(1, 2));
        bodyPanel.add(mainImagePanel);
        bodyPanel.add(inputPanel);
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
        else if (e.getSource().equals(showImagePanel)){
            imgLabel[0].setIcon(plusIcon);
            imgLabel[1].setIcon(null);
            imgLabel[2].setIcon(null);
            imgLabel[3].setIcon(null);
            
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("image files", "jpg", "jpeg", "png");
            fc.setFileFilter(filter);
            fc.setMultiSelectionEnabled(true);
            fc.showOpenDialog(frame);
            File files[] = fc.getSelectedFiles();
            if (files.length > 4){
                JOptionPane.showMessageDialog(null, "maximum 4 images :C");
            }
            else{
                int i = 0;
                imgFiles = files.clone();
                for (File imgFile : files){
                    Image image = new ImageIcon(imgFile.getAbsolutePath()).getImage();
                    ImageIcon icon = null;
                    if (i == 0){
                        icon = new ImageIcon(image.getScaledInstance(586, 330,  java.awt.Image.SCALE_SMOOTH));
                    }
                    else{
                        icon = new ImageIcon(image.getScaledInstance(160, 90,  java.awt.Image.SCALE_SMOOTH));
                    }
                    imgLabel[i].setIcon(icon);
                    i++;
                }
            }
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
        else if (e.getSource().equals(showImagePanel)){
            showImagePanel.setBackground(new Color(150,150,150));
        }
        else if (e.getSource().equals(postBtn)){
            postBtn.setBorder(new LineBorder(new Color( 173, 207, 240), 3));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(xBtnLabel)){
            xBtnLabel.setBackground(new Color(61,61,61));
        }
        else if (e.getSource().equals(showImagePanel)){
            showImagePanel.setBackground(new Color(126,126,126));
        }
        else if (e.getSource().equals(postBtn)){
            postBtn.setBorder(new LineBorder(new Color( 173, 207, 240), 1));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(postBtn)){
            if (!nameTF.getText().equals("") && !detailTA.getText().equals("")){
                Database db = new Database();
                db.update(String.format("INSERT INTO boardzone.board_games (name, detail, created_by) VALUES ('%s', '%s', '%s')", nameTF.getText(), detailTA.getText(), Account.username));
                db.close();
                
                Connection cn = db.getConnection();
                int i = 0;
                try {
                    for (File imgFile : imgFiles){

                        try(FileInputStream fis = new FileInputStream(imgFile)){
                            PreparedStatement ps = cn.prepareStatement(String.format("UPDATE boardzone.board_games SET img%s = ? WHERE (name = ?)", ""+i));
                            ps.setBlob(1, fis);
                            ps.setString(2, nameTF.getText());
                            ps.executeUpdate();
                            System.out.println("img"+ i + " added");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        i++;
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                db.close();
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Your post has been successfully created!");
            }
            else {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "pls input name and detail");
            }
            
        }
    }
    
}
