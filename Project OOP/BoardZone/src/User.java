
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import java.sql.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class User implements MouseListener, ActionListener{
    private JFrame userframe;
    private JPanel userpanel;
    private JPanel left;
    private JPanel right;
    private JMenuBar userbar;
    private JMenuBar menupanel;
    private JMenuBar space;
    private JMenuBar profilemenu;
    private JMenu homemenu;
    private JMenu lobbymenu;
    private JMenu fundmenu;
    private JMenu aboutmenu;
    private JMenu username;
    private JLabel picprofile;
    private JPanel userprofile;
    private JPanel userprofileleft;
    private JPanel userprofileright;
    private JPanel backgroudpicture;
    private JPanel stupidpanel1;
    private JPanel stupidpanel2;
    private JPanel stupidpanel3;
    private JPanel stupidpanel4;
    private JButton changepicture;
    private JPanel changepicturepanel;
    private JLabel pictureframe;
    private JPanel rightpanel1;
    private JPanel rightpanel2;
    private JPanel rightpanel3;
    private JPanel rightpanel4;
    private JPanel rightpanel5;
    private JPanel rightpanel6;
    private JPanel rightpanel7;
    private JPanel rightpanel8;
    private JPanel rightpanel9;
    private JPanel rightpanel10;
    private JPanel rightpanel11;
    private JPanel rightpanel12;
    private JPanel stupidback1;
    private JPanel stupidback2;
    private JPanel stupidback3;
    private JPanel stupidback4;
    private JPanel stupidback5;
    private JPanel stupidback6;
    private JPanel finalbutton1;
    private JPanel finalbutton2;
    private JPanel blankp1, blankp2, blankp3;
    private JLabel name;
    private JLabel surname; 
    private JLabel usernameprofile; 
    private JLabel email; 
    private JLabel phone;
    private JLabel academic;
    private JLabel faculty;
    private JTextField textname;
    private JTextField textsurname;
    private JTextField textusername;
    private JTextField textphone;
    private JTextField textemail;
    private JTextField textacademic;
    private JTextField textfaculty;
    private JButton logout;
    private JButton save;
    
    private File imgFile[];

    public User(){
        userframe = new JFrame("BoardZone");
        userpanel = new JPanel();
        left = new JPanel();
        right = new JPanel();
        userbar = new JMenuBar();
        menupanel = new JMenuBar();
        space = new JMenuBar();
        profilemenu = new JMenuBar();
        homemenu = new JMenu("Home");
        lobbymenu = new JMenu("Lobby");
        fundmenu = new JMenu("Funds");
        aboutmenu = new JMenu("About us");
        username = new JMenu(Account.username);
        picprofile = new JLabel("", new ImageIcon("poring.png"), JLabel.CENTER);     
        
        userprofile = new JPanel();
        userprofileleft = new JPanel();
        userprofileright = new JPanel();
        backgroudpicture = new JPanel();
        pictureframe = new JLabel("", new ImageIcon("poring.png"), JLabel.CENTER);
        changepicturepanel = new JPanel();
        changepicture = new JButton("Change Picture Here");
        blankp1 = new JPanel(); blankp2 = new JPanel(); blankp3 = new JPanel();
        stupidpanel1 = new JPanel();
        stupidpanel2 = new JPanel();
        stupidpanel3 = new JPanel();
        stupidpanel4 = new JPanel();
        rightpanel1 = new JPanel();
        rightpanel2 = new JPanel();
        rightpanel3 = new JPanel();
        rightpanel4 = new JPanel();
        rightpanel5 = new JPanel();
        rightpanel6 = new JPanel();
        rightpanel7 = new JPanel();
        rightpanel8 = new JPanel();
        rightpanel9 = new JPanel();
        rightpanel10 = new JPanel();
        rightpanel11= new JPanel();
        rightpanel12= new JPanel();
        stupidback1 = new JPanel();
        stupidback2 = new JPanel();
        stupidback3 = new JPanel();
        stupidback4 = new JPanel();
        stupidback5 = new JPanel();
        stupidback6 = new JPanel();
        finalbutton1 = new JPanel();
        finalbutton2 = new JPanel();
        name = new JLabel("Name :");
        surname = new JLabel("Surname :");
        usernameprofile = new JLabel("Username :");
        phone = new JLabel("Phone Number :");
        email = new JLabel("Email :");
        academic = new JLabel("Academic Year :");
        faculty = new JLabel("Faculty :");
        textname = new JTextField(Account.firstname,16);
        textsurname = new JTextField(Account.lastname, 16);
        textusername = new JTextField(Account.username, 48);
        textphone = new JTextField(Account.phone, 48);
        textemail = new JTextField(Account.email, 48);
        textacademic = new JTextField(Account.year, 16);
        textfaculty = new JTextField(Account.faculty, 16);
        logout = new JButton("Logout");
        save = new JButton("Save");
        
        homemenu.addMouseListener(this);
        lobbymenu.addMouseListener(this);
        fundmenu.addMouseListener(this);
        aboutmenu.addMouseListener(this);
        username.addMouseListener(this);
        
        changepicture.addActionListener(this);
        logout.addActionListener(this);
        save.addActionListener(this);
        
        userframe.setJMenuBar(userbar);
        userbar.setLayout(new BorderLayout());
        menupanel.add(homemenu);
        menupanel.add(lobbymenu);
        menupanel.add(fundmenu);
        menupanel.add(aboutmenu);
        profilemenu.setLayout(new GridLayout(1,2));
        profilemenu.add(username);
        profilemenu.add(picprofile);
        userbar.add(menupanel, BorderLayout.WEST);
        userbar.add(space, BorderLayout.CENTER);
        userbar.add(profilemenu, BorderLayout.EAST);

        left.setPreferredSize(new Dimension(100, 720));
        right.setPreferredSize(new Dimension(100, 720));
        
        userframe.setLayout(new BorderLayout());
        userframe.add(userpanel, BorderLayout.CENTER);
        userframe.add(left, BorderLayout.WEST);
        userframe.add(right, BorderLayout.EAST);   
                
        userbar.setBackground(new Color(43, 43, 43));
        menupanel.setBackground(new Color(43, 43, 43));
        space.setBackground(new Color(43, 43, 43));
        profilemenu.setBackground(new Color(43, 43, 43));
        userframe.setBackground(new Color(101,101,101));
        left.setBackground(new Color(101,101,101));
        right.setBackground(new Color(101,101,101));
        userpanel.setBackground(new Color(75,75,75));
        
        homemenu.setForeground(new Color(170, 170, 170));
        lobbymenu.setForeground(new Color(170, 170, 170));
        fundmenu.setForeground(new Color(170, 170, 170));
        aboutmenu.setForeground(new Color(170, 170, 170));
        username.setForeground(new Color(255, 255, 255)); 

        blankp1.setBackground(new Color(75, 75, 75));
        blankp2.setBackground(new Color(75, 75, 75));
        blankp3.setBackground(new Color(75, 75, 75));
        
        userframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userframe.setSize(1080,720);
        userframe.setVisible(true);  
                
        userpanel.setLayout(new GridLayout(1,2));
        userpanel.add(userprofile);
        userprofile.setLayout(new GridLayout(1,2));
        userprofile.add(userprofileleft);
        userprofile.add(userprofileright);
        userprofileleft.setBackground(new Color(126,126,126));
        userprofileright.setBackground(new Color(75,75,75));
        
        userprofileleft.setLayout(new BorderLayout());
        userprofileleft.add(pictureframe,BorderLayout.CENTER);
        backgroudpicture.setPreferredSize(new Dimension(userprofileleft.getWidth()-30, userprofileleft.getHeight()-30));
        
        userprofileleft.add(blankp1, BorderLayout.NORTH);
        userprofileleft.add(blankp2, BorderLayout.EAST);
        userprofileleft.add(blankp3, BorderLayout.WEST);
        
        userprofileleft.add(changepicturepanel,BorderLayout.SOUTH);
        changepicturepanel.setSize(userprofileleft.getWidth()-50, userprofileleft.getHeight()-50);
        
        changepicturepanel.setLayout(new BorderLayout());
        changepicturepanel.add(changepicture, BorderLayout.CENTER);
        changepicturepanel.add(stupidpanel1, BorderLayout.SOUTH);
        changepicturepanel.add(stupidpanel2, BorderLayout.WEST);
        changepicturepanel.add(stupidpanel3, BorderLayout.EAST);
        changepicturepanel.add(stupidpanel4, BorderLayout.NORTH);
        stupidpanel1.setPreferredSize(new Dimension(userprofileleft.getWidth(), 50));
        stupidpanel2.setPreferredSize(new Dimension(100, userprofileleft.getHeight()));
        stupidpanel3.setPreferredSize(new Dimension(100, userprofileleft.getHeight()));
        stupidpanel4.setPreferredSize(new Dimension(userprofileleft.getWidth(), 50));
          
        changepicturepanel.setBackground(new Color(75,75,75));
        stupidpanel1.setBackground(new Color(75,75,75));
        stupidpanel2.setBackground(new Color(75,75,75));
        stupidpanel3.setBackground(new Color(75,75,75));
        stupidpanel4.setBackground(new Color(75,75,75));
        
        userprofileright.setLayout(new GridLayout(8,1));
        userprofileright.add(rightpanel6);
        userprofileright.add(rightpanel1);
        userprofileright.add(rightpanel2);
        userprofileright.add(rightpanel4);
        userprofileright.add(rightpanel3);
        userprofileright.add(rightpanel5);
        userprofileright.add(rightpanel7);
        userprofileright.add(rightpanel12);
        
        
        rightpanel1.setLayout(new GridLayout());
        rightpanel1.add(rightpanel8);
        rightpanel8.setLayout(new GridLayout(2,1));
        rightpanel8.add(name);
        rightpanel8.add(textname);
        name.setFont(new Font("Arial", Font.PLAIN, 18));
        textname.setFont(new Font("Arial", Font.PLAIN, 18));
        rightpanel1.add(rightpanel9);
        rightpanel9.setLayout(new GridLayout(2,1));
        rightpanel9.add(surname);
        rightpanel9.add(textsurname);
        surname.setFont(new Font("Arial", Font.PLAIN, 18));
        textsurname.setFont(new Font("Arial", Font.PLAIN, 18));
        
        rightpanel2.setLayout(new GridLayout(2,1));
        rightpanel2.add(usernameprofile);
        rightpanel2.add(textusername);
        usernameprofile.setFont(new Font("Arial", Font.PLAIN, 18));
        textusername.setFont(new Font("Arial", Font.PLAIN, 18));
        
        rightpanel3.setLayout(new GridLayout(2,1));
        rightpanel3.add(phone);
        rightpanel3.add(textphone);
        phone.setFont(new Font("Arial", Font.PLAIN, 18));
        textphone.setFont(new Font("Arial", Font.PLAIN, 18));
        
        rightpanel4.setLayout(new GridLayout(2,1));
        rightpanel4.add(email);
        rightpanel4.add(textemail);
        email.setFont(new Font("Arial", Font.PLAIN, 18));
        textemail.setFont(new Font("Arial", Font.PLAIN, 18));
        
        rightpanel5.setLayout(new GridLayout());
        rightpanel5.add(rightpanel10);
        rightpanel10.setLayout(new GridLayout(2,1));
        rightpanel10.add(academic);
        rightpanel10.add(textacademic);
        academic.setFont(new Font("Arial", Font.PLAIN, 18));
        textacademic.setFont(new Font("Arial", Font.PLAIN,18));
        rightpanel5.add(rightpanel11);
        rightpanel11.setLayout(new GridLayout(2,1));
        rightpanel11.add(faculty);
        rightpanel11.add(textfaculty);
        faculty.setFont(new Font("Arial", Font.PLAIN, 18));
        textfaculty.setFont(new Font("Arial", Font.PLAIN, 18));
        
        rightpanel12.setLayout(new GridLayout(1,4));
        rightpanel12.add(stupidback1);
        rightpanel12.add(stupidback2);
        rightpanel12.add(finalbutton1);
        rightpanel12.add(finalbutton2);
        
        finalbutton1.setLayout(new GridLayout(3,1));
        finalbutton1.add(stupidback3);
        finalbutton1.add(logout);
        finalbutton1.add(stupidback4);
        
        finalbutton2.setLayout(new GridLayout(3,1));
        finalbutton2.add(stupidback5);
        finalbutton2.add(save);
        finalbutton2.add(stupidback6);
        
        name.setForeground(new Color(255, 255, 255));
        surname.setForeground(new Color(255, 255, 255));
        usernameprofile.setForeground(new Color(255, 255, 255));
        phone.setForeground(new Color(255, 255, 255));
        email.setForeground(new Color(255, 255, 255));
        academic.setForeground(new Color(255, 255, 255));
        faculty.setForeground(new Color(255, 255, 255));
        
        rightpanel1.setBackground(new Color(75,75,75));
        rightpanel2.setBackground(new Color(75,75,75));
        rightpanel3.setBackground(new Color(75,75,75));
        rightpanel4.setBackground(new Color(75,75,75));       
        rightpanel5.setBackground(new Color(75,75,75));
        rightpanel6.setBackground(new Color(75,75,75));
        rightpanel7.setBackground(new Color(75,75,75));
        rightpanel8.setBackground(new Color(75,75,75));
        rightpanel9.setBackground(new Color(75,75,75));
        rightpanel10.setBackground(new Color(75,75,75));       
        rightpanel11.setBackground(new Color(75,75,75));
        rightpanel12.setBackground(new Color(75,75,75));
        stupidback1.setBackground(new Color(75,75,75));
        stupidback2.setBackground(new Color(75,75,75));
        stupidback3.setBackground(new Color(75,75,75));
        stupidback4.setBackground(new Color(75,75,75));
        stupidback5.setBackground(new Color(75,75,75));
        stupidback6.setBackground(new Color(75,75,75));
        finalbutton1.setBackground(new Color(75,75,75));
        finalbutton2.setBackground(new Color(75,75,75));
        
        System.out.println(pictureframe.getWidth() + "|" + pictureframe.getHeight());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(logout)){
            Login login = new Login();
            login.setSize(userframe.getSize());
            login.setLocation(userframe.getLocation());
            userframe.dispose();
        } else if (e.getSource().equals(save)){
            String tusername = textusername.getText(); String tfirstname = textname.getText(); 
            String tsurname = textsurname.getText(); String temail = textemail.getText();
//            String terror = "Please input ";
//            int error = false;
            if (tusername.equals("") || tfirstname.equals("") || tsurname.equals("") || temail.equals("")){
                JOptionPane.showMessageDialog(userframe, "Please input firstname, lastname, username and email");
            }
            else {
                Account.setDataPlus(tusername, tfirstname, tsurname, 
                    temail, textphone.getText(), textacademic.getText(), textfaculty.getText());
                JOptionPane.showMessageDialog(userframe, "Account successfully updated.");
            }
        } else if (e.getSource().equals(changepicture)){
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("image files", "jpg", "jpeg", "png");
            fc.setFileFilter(filter);
            fc.setMultiSelectionEnabled(true);
            fc.showOpenDialog(userframe);
            File files[] = fc.getSelectedFiles();
            
            imgFile = files.clone();
            for (File imgFile : files){
                Image image = new ImageIcon(imgFile.getAbsolutePath()).getImage();
                ImageIcon icon = null;
                icon = new ImageIcon(image.getScaledInstance(412, 473, java.awt.Image.SCALE_SMOOTH));
                pictureframe.setIcon(icon);
                break;
            }
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(homemenu)){
            Home home = new Home();
            home.setSize(userframe.getSize());
            home.setLocation(userframe.getLocation());
            userframe.dispose();
        }
        else if (e.getSource().equals(lobbymenu)){
            Lobby lobby = new Lobby();
            lobby.setSize(userframe.getSize());
            lobby.setLocation(userframe.getLocation());
            userframe.dispose();
        }
        else if (e.getSource().equals(fundmenu)){
            Fund fund = new Fund(); 
            fund.setSize(userframe.getSize());
            fund.setLocation(userframe.getLocation());
            userframe.dispose();
        }
        else if (e.getSource().equals(aboutmenu)){
            About about = new About();
            about.setSize(userframe.getSize());
            about.setLocation(userframe.getLocation());
            userframe.dispose();
        }
        else if (e.getSource().equals(username)){
            userframe.setVisible(true);
        }
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

    public void setSize(Dimension size) {
        userframe.setSize(size);
    }

    public void setLocation(Point location) {
        userframe.setLocation(location);
    }
    
    public static void main(String[] args) {
        new User();
    }

}
