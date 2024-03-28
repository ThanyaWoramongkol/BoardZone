import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CreatePost implements MouseListener, Runnable{
    private JFrame frame;
    private JPanel headerPanel, bodyPanel, imagePanel, showImagePanel, addImagePanel, inputPanel, namePanel, dnbPanel, detailPanel, footerPanel, postPanel;
    private Home mainWindow;
    private JLabel xBtnLabel, nameLabel, plusLabel;
    private JTextField nameTF;
    private JTextArea detailTA;
    private JButton postBtn;
    public CreatePost(Home mainWindow){
        
        this.mainWindow = mainWindow;
        frame = new JFrame();
        headerPanel = new JPanel();
        bodyPanel = new JPanel();
        imagePanel = new JPanel();
        showImagePanel = new JPanel();
        addImagePanel = new JPanel();
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
        
        
        //ImagePanel
        Image plusImage = new ImageIcon("./resource/icons/plus.png").getImage();
        ImageIcon plusIcon = new ImageIcon(plusImage.getScaledInstance(48, 48,  java.awt.Image.SCALE_SMOOTH));
        plusLabel = new JLabel(plusIcon);
        imagePanel.setBackground(new Color(61,61,61));
        addImagePanel.setLayout(new BorderLayout());
        addImagePanel.setBackground(new Color(126,126,126));
        addImagePanel.add(plusLabel);
        
        imagePanel.setLayout(new BorderLayout());
        imagePanel.add(new BlankPanel(20, 50, new Color(61, 61, 61)), BorderLayout.EAST);
        imagePanel.add(addImagePanel);
        //ImagePanel
        
        
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
        
        
        
        detailTA.setBackground(new Color(86, 86, 86));
        detailTA.setForeground(new Color(255, 255, 255));
        detailPanel.add(detailTA);
        dnbPanel.setLayout(new BorderLayout());
        dnbPanel.add(new BlankPanel(38, 32, new Color(61, 61, 61)), BorderLayout.NORTH);
        dnbPanel.add(detailPanel);
        detailPanel.setBackground(new Color(61, 61, 61));

        postBtn.setBackground(new Color(61, 61, 61));
        postBtn.setForeground(new Color(255, 255, 255));
        postBtn.setFont(postBtn.getFont().deriveFont(16f));
        
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
        bodyPanel.add(imagePanel);
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
    
}
