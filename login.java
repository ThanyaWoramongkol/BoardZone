import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class login implements ActionListener{
    private JFrame frame;
    private JPanel panel_l, panel_r, panel_t, panel_b, main;
    private JPanel input_username, input_password, under_logo ;
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private JLabel txt_user, txt_pass, err, logo, blank;

    public login(){
        frame = new JFrame("");
        panel_l = new JPanel();
        panel_r = new JPanel();
        panel_t = new JPanel();
        panel_b = new JPanel();
        input_username = new JPanel();
        input_password = new JPanel();
        under_logo = new JPanel();
        main = new JPanel();
        txt_user = new JLabel("       UserName    : ");
        txt_pass = new JLabel("       Password    : ");
        username = new JTextField(21);
        password = new JPasswordField(21);
        err = new JLabel();
        blank = new JLabel();
        logo = new JLabel("", new ImageIcon("Logo.png"), JLabel.CENTER);
        login = new JButton("Login");

        panel_l.setPreferredSize(new Dimension(320, 720));
        panel_r.setPreferredSize(new Dimension(320, 720));
        panel_t.setPreferredSize(new Dimension(1080, 100));
        panel_b.setPreferredSize(new Dimension(1080, 100));

        input_username.setLayout(new BorderLayout());
        input_password.setLayout(new BorderLayout());
        under_logo.setLayout(new GridLayout(4, 1));
        
        login.setPreferredSize(new Dimension(100,  25));
        login.addActionListener(this);

        frame.setBackground(new Color(37, 37, 37));
        panel_l.setBackground(new Color(37, 37, 37));
        panel_r.setBackground(new Color(37, 37, 37));
        panel_t.setBackground(new Color(37, 37, 37));
        panel_b.setBackground(new Color(37, 37, 37));
        input_username.setBackground(new Color(37, 37, 37));
        input_password.setBackground(new Color(37,37,37));
        under_logo.setBackground(new Color(37, 37, 37));
        main.setBackground(new Color(37, 37, 37));
        
        txt_user.setForeground(Color.WHITE);
        txt_pass.setForeground(Color.WHITE);
        err.setForeground(Color.RED);

        input_username.add(txt_user, BorderLayout.WEST);
        input_username.add(username);
        input_password.add(txt_pass, BorderLayout.WEST);
        input_password.add(password);
        
        under_logo.add(blank);
        under_logo.add(input_username);
        under_logo.add(input_password);
        under_logo.add(err);
//        under_logo.add(login);

        main.add(logo);
        main.add(under_logo);
        main.add(login);

        frame.add(panel_l, BorderLayout.WEST);
        frame.add(panel_r, BorderLayout.EAST);
        frame.add(panel_t, BorderLayout.NORTH);
        frame.add(panel_b, BorderLayout.SOUTH);
        frame.add(main);

        frame.setVisible(true);
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(login)){
            if (username.getText().equals("") || password.getText().equals("")){
                err.setText("                        Please input username or password.");
            } else {
                Account.username = username.getText();
                Home home = new Home();
                home.setSize(frame.getSize());
                home.setLocation(frame.getLocation());
                frame.dispose();
            }
        }
    }
    
    public static void main(String[] args) {
        new login();
    }

    
}
