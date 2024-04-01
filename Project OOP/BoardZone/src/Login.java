
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;

public class Login implements ActionListener, MouseListener{
    private JFrame frame;
    private JPanel panel_l, panel_r, panel_t, panel_b, main;
    private JPanel input_username, input_password, under_logo ;
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private JLabel txt_user, txt_pass, err, logo, blank, createAcct;
    private JDesktopPane mainpanel;
    private JInternalFrame create;
    
    // create account frame attribute
    private JPanel cframe, cmain;
    private JPanel cFirstname, cLastname, cEmail, cPassword, cBlank1, cBlank2, cUsername;
    private JTextArea blank1, blank2, blank3, blank4;
    private JPanel caction, cerror, cbutton;
    private JTextField firstname, lastname, email, iusername;
    private JPasswordField pPassword, pConfirm;
    private JLabel tFirst, tLast, tEmail, tPassword, tConfirm, tUsername, terror, notice;
    private JButton createButton;

    public Login(){
//        try{ UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
//        catch (Exception e) { e.printStackTrace(); }
        
        frame = new JFrame("");
        mainpanel = new JDesktopPane();
        panel_l = new JPanel();
        panel_r = new JPanel();
        panel_t = new JPanel();
        panel_b = new JPanel();
        input_username = new JPanel();
        input_password = new JPanel();
        under_logo = new JPanel();
        main = new JPanel();
        txt_user = new JLabel("Username    : ");
        txt_pass = new JLabel("Password    : ");
        username = new JTextField(21);
        password = new JPasswordField(21);
        err = new JLabel("", JLabel.CENTER);
        blank = new JLabel();
        createAcct = new JLabel("create account", JLabel.HORIZONTAL);
        logo = new JLabel("", new ImageIcon("Logo.png"), JLabel.CENTER);
        login = new JButton("Login");
        mainpanel = new JDesktopPane();
        
        // create account frame
        create = new JInternalFrame("Create an account", false, true, false, false);
        cframe = new JPanel();
        cmain = new JPanel();
        cFirstname = new JPanel();
        cLastname = new JPanel();
        cEmail = new JPanel();
        cPassword = new JPanel();
        cUsername = new JPanel();
        cBlank1 = new JPanel();
        cBlank2 = new JPanel();
        cerror = new JPanel();
        cbutton = new JPanel();
        caction = new JPanel();
//        blank1 = new JTextArea();
//        blank2 = new JTextArea();
//        blank3 = new JTextArea();
//        blank4 = new JTextArea();
        firstname = new JTextField(32);
        lastname = new JTextField(32);
        email = new JTextField(32);
        iusername = new JTextField(32);
        pPassword = new JPasswordField(32);
        pConfirm = new JPasswordField(32);
        tFirst = new JLabel("Firstname :");
        tLast = new JLabel("Lastname :");
        tEmail = new JLabel("Email :");
        tUsername = new JLabel("Username :");
        tPassword = new JLabel("Password :");
        terror = new JLabel("", JLabel.CENTER);
//        tConfirm = new JLabel("Confirm password :");
        notice = new JLabel("Enter your Firstname, Lastname, Email, Username and Password");
        createButton = new JButton("Create account");
        
        create.setPreferredSize(new Dimension(440, 540));
        cBlank1.setPreferredSize(new Dimension(1080, 75));
        cBlank2.setPreferredSize(new Dimension(440, 75));
        
        createButton.addActionListener(this);
        
        cBlank1.setLayout(new FlowLayout());
        cframe.setLayout(new BorderLayout());
        cFirstname.setLayout(new BorderLayout());
        cLastname.setLayout(new BorderLayout());
        cEmail.setLayout(new BorderLayout());
        cUsername.setLayout(new BorderLayout());
        cPassword.setLayout(new BorderLayout());
//        cmain2.setLayout(new GridLayout(2,1));
        
        notice.setForeground(Color.WHITE);
        tFirst.setForeground(Color.WHITE);
        tLast.setForeground(Color.WHITE);
        tUsername.setForeground(Color.WHITE);
        tEmail.setForeground(Color.WHITE);
        tPassword.setForeground(Color.WHITE);
        
        notice.setFont(new Font("",Font.ROMAN_BASELINE ,12));
        tFirst.setFont(new Font("", Font.BOLD, 18));
        tLast.setFont(new Font("", Font.BOLD, 18));
        tUsername.setFont(new Font("", Font.BOLD, 18));
        tEmail.setFont(new Font("", Font.BOLD, 18));
        tPassword.setFont(new Font("", Font.BOLD, 18));
//        tConfirm.setFont(new Font("", Font.BOLD, 18));
        
        cBlank1.add(notice);
        cFirstname.add(tFirst);
        cFirstname.add(firstname, BorderLayout.SOUTH);
        cLastname.add(tLast);
        cLastname.add(lastname, BorderLayout.SOUTH);
        cEmail.add(tEmail);
        cEmail.add(email, BorderLayout.SOUTH);
        cUsername.add(tUsername);
        cUsername.add(iusername, BorderLayout.SOUTH);
        cPassword.add(tPassword);
        cPassword.add(pPassword, BorderLayout.SOUTH);
        cbutton.add(createButton);
        caction.add(terror);
        caction.add(cbutton);
        
        caction.setLayout(new BorderLayout());
        
        terror.setForeground(Color.RED);
        
        mainpanel.setBackground(new Color(5,5,5));
        cframe.setBackground(new Color(37,37,37));
        cmain.setBackground(new Color(37,37,37));
        cFirstname.setBackground(new Color(37,37,37));
        cLastname.setBackground(new Color(37,37,37));
        cEmail.setBackground(new Color(37,37,37));
        cUsername.setBackground(new Color(37,37,37));
        cPassword.setBackground(new Color(37,37,37));
        caction.setBackground(new Color(37,37,37));
        cerror.setBackground(new Color(37,37,37));
        cbutton.setBackground(new Color(37,37,37));
        cBlank1.setBackground(new Color(37,37,37));
        cBlank2.setBackground(new Color(37,37,37));
        
        caction.add(terror);
        caction.add(cbutton, BorderLayout.EAST);
        
        cmain.add(cBlank1);
        cmain.add(cFirstname);
//        main.add(blank1);
        cmain.add(cLastname);
//        main.add(blank2);
        cmain.add(cEmail);
//        main.add(blank3);
        cmain.add(cUsername);
        cmain.add(cPassword);
//        main.add(blank4);
        cmain.add(caction);
        cmain.add(cBlank2);
        
        cframe.add(cmain);
//        cframe.add(cBlank1, BorderLayout.BEFORE_FIRST_LINE);
        
        create.add(caction, BorderLayout.SOUTH);
        create.add(cframe);
        
//        cBlank.setBackground(Color.red);
        
        //END InternalFrame Setup
//        create.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            mainpanel.add(create);

        panel_l.setPreferredSize(new Dimension(320, 720));
        panel_r.setPreferredSize(new Dimension(320, 720));
        panel_t.setPreferredSize(new Dimension(1080, 100));
        panel_b.setPreferredSize(new Dimension(1080, 100));
        login.setPreferredSize(new Dimension(500, 50));

//        input_username.setLayout(new BorderLayout());
//        input_password.setLayout(new BorderLayout());
        input_username.setLayout(new FlowLayout());
        input_password.setLayout(new FlowLayout());
        under_logo.setLayout(new GridLayout(5, 1));
        login.setPreferredSize(new Dimension(100,  25));
        
        login.addActionListener(this);
        createAcct.addMouseListener(this);

        frame.setBackground(new Color(37, 37, 37));
        panel_l.setBackground(new Color(37, 37, 37));
        panel_r.setBackground(new Color(37, 37, 37));
        panel_t.setBackground(new Color(37, 37, 37));
        panel_b.setBackground(new Color(37, 37, 37));
        input_username.setBackground(new Color(37, 37, 37));
        input_password.setBackground(new Color(37,37,37));

        
        under_logo.setBackground(new Color(37, 37, 37));
        main.setBackground(new Color(37, 37, 37));
//       main.setBackground(Color.CYAN);
        
        txt_user.setForeground(Color.WHITE);
        txt_pass.setForeground(Color.WHITE);
        createAcct.setForeground(new Color(55, 159, 250)); // light blue harder
        err.setForeground(Color.RED);
        
        createAcct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        input_username.add(txt_user/*, BorderLayout.WEST*/);
        input_username.add(username);
        input_password.add(txt_pass/*, BorderLayout.WEST*/);
        input_password.add(password);
        
        under_logo.add(blank);
        under_logo.add(input_username);
        under_logo.add(input_password);
        under_logo.add(createAcct);
        under_logo.add(err);
        
        main.add(logo);
        main.add(under_logo);
        main.add(login);
        
        mainpanel.setLayout(new BorderLayout());
        mainpanel.add(main);

        frame.add(panel_l, BorderLayout.WEST);
        frame.add(panel_r, BorderLayout.EAST);
        frame.add(panel_t, BorderLayout.NORTH);
        frame.add(panel_b, BorderLayout.SOUTH);
        frame.add(mainpanel, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // set panel everytime who resize window
//        frame.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e){
//                super.componentResized(e);
//                panel_l.setSize((int) (frame.getWidth() / 2 - 200), frame.getHeight());
//                panel_r.setSize((int) (frame.getWidth() /2 - 200), frame.getHeight());
//                panel_t.setSize(frame.getWidth(), (int) (frame.getHeight() * 0.139));
//                panel_b.setSize(frame.getWidth(), (int) (frame.getHeight() * 0.139));
//            }
//        });
        
    }
    
    public boolean login(){
        String uusername = username.getText();
        String upassword = String.valueOf(password.getPassword());
        try {
            Database db = new Database();
            ResultSet rs = null;
            String sql = String.format("SELECT * FROM boardzone.Account WHERE username = '%s' and password = '%s'", uusername, upassword);

            rs = db.getSelect(sql);
            return rs.next();
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource().equals(login)){
            if (username.getText().equals("") || String.valueOf(password.getPassword()).equals("")){
                err.setText("Please input username or password.");
            } else if (login()) {
                System.out.println(username.getText() + " | " + String.valueOf(password.getPassword()));
                Account.username = username.getText();
                Account.setData();
                
                Home home = new Home();
                home.setSize(frame.getSize());
                home.setLocation(frame.getLocation());
                frame.dispose();
            } else {
                System.out.println(username.getText() + " | " + String.valueOf(password.getPassword()));
                err.setText("Invalid username or password");
            }
        }
        //MDI Create account action
        if (ae.getSource().equals(createButton)){
            String uusername = iusername.getText();
            String upassword = String.valueOf(pPassword.getPassword());
            String ufirstname = firstname.getText();
            String ulastname = lastname.getText();
            String uemail = email.getText();
            // show text when data don't have data on textField
            if (ufirstname.equals("") || ulastname.equals("")){
                terror.setText("Please input firstname and lastname");
            } else if (uemail.equals("")){
                terror.setText("Please input your Email");
            } else if (uusername.equals("") || upassword.equals("")){
                terror.setText("Please input username and password");
            } else {
                try {
                    Database db = new Database();
                    Connection cn = db.getConnection();
                    String sql = String.format("INSERT INTO boardzone.Account (username, password, email, firstname, lastname) VALUES ('%s','%s','%s','%s','%s');", 
                            uusername, upassword, uemail, ufirstname, ulastname);
                    db.update(sql);
                    // upload prodile picture to database
                    try (FileInputStream fis = new FileInputStream("poring.png")){ // set Default picture poring
                        PreparedStatement ps = cn.prepareStatement(String.format("UPDATE boardzone.Account SET img = ? WHERE username = '%s'", uusername));
                        ps.setBlob(1, fis);
                        ps.executeUpdate();
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
                    db.close();
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(create, "Created Account Success");
                
                //remove text on this page
                firstname.setText(""); lastname.setText(""); email.setText("");
                iusername.setText(""); pPassword.setText("");terror.setText("");
                
                create.setVisible(false);
                create.dispose();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(createAcct)){
//            create.setMaximumSize(new Dimension(50, 50));
            create.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
            create.setVisible(true);
            mainpanel.add(create);
            create.toFront();
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
    public void setSize(Dimension size) {
        frame.setSize(size);
    }

    public void setLocation(Point location) {
        frame.setLocation(location);
    }
//    public static void main(String[] args) {
//        new Login();
//    }
  
}
