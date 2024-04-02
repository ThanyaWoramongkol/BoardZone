
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About implements MouseListener{
    private JFrame aboutframe;
    private JPanel aboutpanel;
    private JPanel left;
    private JPanel right;
    private JMenuBar aboutbar;
    private JMenuBar menupanel;
    private JMenuBar space;
    private JMenuBar profilemenu;
    private JMenu homemenu;
    private JMenu lobbymenu;
    private JMenu fundmenu;
    private JMenu aboutmenu;
    private JMenu username;
    private JLabel picprofile;
    private JScrollPane scroll;
    //person panel
    private JPanel t33093, moss, nados, aeaey, ktle, huana, isun, ihtle;
    // picture frame panel
    private JPanel pf33093, pfmoss, pfnados, pfaeaey, pfktle, pfhuana, pfsun, pftle;
    private JPanel margin1, margin2, margin3, margin4, margin5, margin6, margin7, margin8
            , margin9, margin10, margin11, margin12, margin13, margin14, margin15, margin16
            , margin17, margin18, margin19, margin20, margin21, margin22, margin23, margin24
            , margin25, margin26, margin27, margin28, margin29, margin30, margin31, margin32
            , margin33, margin34, margin35, margin36, margin37, margin38, margin39, margin40
            , margin41, margin42, margin43, margin44, margin45, margin46, margin47, margin48
            , margin49, margin50, margin51, margin52, margin53, margin54, margin55, margin56
            , margin57, margin58, margin59, margin60, margin61, margin62, margin63, margin64;
    //text panel
    private JPanel tt33093, tmoss, tnados, taeaey, tktle, thuana, tisun, tihtle;
    //grid panel
    private JPanel g33093, gmoss, gnados, gaeaey, gktle, ghuana, gisun, gihtle;
    //border panel
    private JPanel b33093, bmoss, bnados, baeaey, bktle, bhuana, bisun, bihtle;
    private JPanel b133093, b1moss, b1nados, b1aeaey, b1ktle, b1huana, b1isun, b1ihtle;
    //picture
    private JLabel p33093, pmoss, pnados, paeaey, ptle, phuana, psun, pitle;
    //name
    private JLabel n33093, nmoss, nnados, naeaey, ntle, nhuana, nisun, nitle;
    //id
    private JLabel d33093, dmoss, dnados, daeaey, dtle, dhuana, disun, ditle;
    private JLabel pos33093, posmoss, posnados, posaeaey, postle, poshuana, posisun, positle;
    private Color background, text;
    private Font name, id, position;

    public About(){
        aboutframe = new JFrame("BoardZone");
        aboutpanel = new JPanel();
        left = new JPanel();
        right = new JPanel();
        aboutbar = new JMenuBar();
        menupanel = new JMenuBar();
        space = new JMenuBar();
        profilemenu = new JMenuBar();
        homemenu = new JMenu("Home");
        lobbymenu = new JMenu("Lobby");
        fundmenu = new JMenu("Funds");
        aboutmenu = new JMenu("About us");
        username = new JMenu(Account.getUsername());
        picprofile = new JLabel("", Account.getProfile(), JLabel.CENTER);
        scroll = new JScrollPane(aboutpanel);
        background = new Color(75, 75, 75);
        text  = new Color(232, 232, 232);
        name = new Font("Arial", Font.BOLD, 24);
        id = new Font("Arial", Font.BOLD, 18);
        position = new Font("Arial", Font.BOLD, 16);
        
        t33093 = new JPanel(); moss = new JPanel(); nados = new JPanel();
        aeaey = new JPanel(); ktle = new JPanel(); huana = new JPanel();
        isun = new JPanel(); ihtle = new JPanel();
        //create picture frame
        pf33093 = new JPanel(); pfmoss = new JPanel(); pfnados = new JPanel(); 
        pfaeaey = new JPanel(); pfktle = new JPanel(); pfhuana = new JPanel(); 
        pfsun = new JPanel(); pftle = new JPanel();
        //create text panel
        tt33093 = new JPanel(); tmoss = new JPanel(); tnados = new JPanel(); 
        taeaey = new JPanel(); tktle = new JPanel(); thuana = new JPanel(); 
        tisun = new JPanel(); tihtle = new JPanel();
        // grid text panel
        g33093 = new JPanel(); gmoss = new JPanel(); gnados = new JPanel(); gaeaey = new JPanel();
        gktle = new JPanel(); gisun = new JPanel(); ghuana = new JPanel(); gihtle = new JPanel();
        //border panel
        b33093 = new JPanel(); bmoss = new JPanel(); bnados = new JPanel(); baeaey = new JPanel();
        bktle = new JPanel(); bisun = new JPanel(); bhuana = new JPanel(); bihtle = new JPanel();
        b133093 = new JPanel(); b1moss = new JPanel(); b1nados = new JPanel(); b1aeaey = new JPanel();
        b1ktle = new JPanel(); b1isun = new JPanel(); b1huana = new JPanel(); b1ihtle = new JPanel();
        //create magin
        margin1 = new JPanel(); margin2 = new JPanel(); margin3 = new JPanel(); margin4 = new JPanel(); 
        margin5 = new JPanel(); margin6 = new JPanel(); margin7 = new JPanel(); margin8 = new JPanel(); 
        margin9 = new JPanel(); margin10 = new JPanel(); margin11 = new JPanel(); margin12 = new JPanel(); 
        margin13 = new JPanel(); margin14 = new JPanel(); margin15 = new JPanel(); margin16 = new JPanel(); 
        margin17 = new JPanel(); margin18 = new JPanel(); margin19 = new JPanel(); margin20 = new JPanel(); 
        margin21 = new JPanel(); margin22 = new JPanel(); margin23 = new JPanel(); margin24 = new JPanel();
        margin25 = new JPanel(); margin26 = new JPanel(); margin27 = new JPanel(); margin28 = new JPanel();
        margin29 = new JPanel(); margin30 = new JPanel(); margin31 = new JPanel(); margin32 = new JPanel();
        margin33 = new JPanel(); margin34 = new JPanel(); margin35 = new JPanel(); margin36 = new JPanel();
        margin37 = new JPanel(); margin38 = new JPanel(); margin39 = new JPanel(); margin40 = new JPanel();
        margin41 = new JPanel(); margin42 = new JPanel(); margin43 = new JPanel(); margin44 = new JPanel();
        margin45 = new JPanel(); margin46 = new JPanel(); margin47 = new JPanel(); margin48 = new JPanel();
        margin49 = new JPanel(); margin50 = new JPanel(); margin51 = new JPanel(); margin52 = new JPanel();
        margin53 = new JPanel(); margin54 = new JPanel(); margin55 = new JPanel(); margin56 = new JPanel();
        margin57 = new JPanel(); margin58 = new JPanel(); margin59 = new JPanel(); margin60 = new JPanel();
        margin61 = new JPanel(); margin62 = new JPanel(); margin63 = new JPanel(); margin64 = new JPanel();
        //get picture
        p33093 = new JLabel(new ImageIcon("./member/title33093.png"));
        pmoss = new JLabel(new ImageIcon("./member/moss.png"));
        pnados = new JLabel(new ImageIcon("./member/nados.png"));
        paeaey = new JLabel(new ImageIcon("./member/aeaey.png"));
        ptle = new JLabel(new ImageIcon("./member/tle.png"));
        phuana = new JLabel(new ImageIcon("./member/tawan.png"));
        psun = new JLabel(new ImageIcon("./member/sunja.png"));
        pitle = new JLabel(new ImageIcon("./member/title.png"));
        // name
        n33093 = new JLabel("Achira Suntonbooranasuk"); nmoss = new JLabel("Thanya Woramongkol");
        nnados = new JLabel("Peerach Mincharoen"); naeaey = new JLabel("Supanut Arun");
        nhuana = new JLabel("Witchayagorn Nakngam"); nisun = new JLabel("Pusrik Purimongkol");
        ntle = new JLabel("Worawich Choonpicharn"); nitle = new JLabel("Pongsapak Tangkaanan");
        // id
        d33093 = new JLabel("ID: 66070214"); dmoss = new JLabel("ID: 66070091"); dnados = new JLabel("ID: 66070301"); 
        daeaey = new JLabel("ID: 66070198"); dtle = new JLabel("ID: 66070180"); dhuana = new JLabel("ID: 66070185"); 
        disun = new JLabel("ID: 66070165"); ditle = new JLabel("ID: 66070294");
        //position
        pos33093 = new JLabel("Project Manager, UI Designer"); posmoss = new JLabel("Account Programming, Figma"); 
        posnados = new JLabel("Home Screen and Home Programming"); posaeaey = new JLabel("Fund Screen and Fund Programming");
        postle = new JLabel("Lobby Screen and Lobby Programming"); poshuana = new JLabel("Minigame Programming (tic tac toe)");
        posisun = new JLabel("All template Screen and User Screen"); positle = new JLabel("Support every side");
        //main panel each person
        aboutpanel.setLayout(new GridLayout(8, 1));
        t33093.setLayout(new BorderLayout());
        moss.setLayout(new BorderLayout());
        nados.setLayout(new BorderLayout());
        aeaey.setLayout(new BorderLayout());
        ktle.setLayout(new BorderLayout());
        huana.setLayout(new BorderLayout());
        isun.setLayout(new BorderLayout());
        ihtle.setLayout(new BorderLayout());
        //picture frame
        pf33093.setLayout(new BorderLayout());
        pfmoss.setLayout(new BorderLayout());
        pfnados.setLayout(new BorderLayout());
        pfaeaey.setLayout(new BorderLayout());
        pfktle.setLayout(new BorderLayout());
        pfhuana.setLayout(new BorderLayout());
        pfsun.setLayout(new BorderLayout());
        pftle.setLayout(new BorderLayout());
        //text frame
        tt33093.setLayout(new BorderLayout());
        tmoss.setLayout(new BorderLayout());
        tnados.setLayout(new BorderLayout());
        taeaey.setLayout(new BorderLayout());
        tktle.setLayout(new BorderLayout());
        thuana.setLayout(new BorderLayout());
        tisun.setLayout(new BorderLayout());
        tihtle.setLayout(new BorderLayout());
        //grid text frame
        g33093.setLayout(new GridLayout(2, 1));
        gmoss.setLayout(new GridLayout(2, 1));
        gnados.setLayout(new GridLayout(2, 1));
        gaeaey.setLayout(new GridLayout(2, 1));
        gktle.setLayout(new GridLayout(2, 1));
        ghuana.setLayout(new GridLayout(2, 1));
        gisun.setLayout(new GridLayout(2, 1));
        gihtle.setLayout(new GridLayout(2, 1));
        //boarder panel
        b33093.setLayout(new BorderLayout()); bmoss.setLayout(new BorderLayout());
        bnados.setLayout(new BorderLayout()); baeaey.setLayout(new BorderLayout());
        bktle.setLayout(new BorderLayout()); bisun.setLayout(new BorderLayout());
        bhuana.setLayout(new BorderLayout()); bihtle.setLayout(new BorderLayout());
        b133093.setLayout(new BorderLayout()); b1moss.setLayout(new BorderLayout());
        b1nados.setLayout(new BorderLayout()); b1aeaey.setLayout(new BorderLayout());
        b1ktle.setLayout(new BorderLayout()); b1isun.setLayout(new BorderLayout());
        b1huana.setLayout(new BorderLayout()); b1ihtle.setLayout(new BorderLayout());

        //add picture on picture frame
        pf33093.add(p33093); pfmoss.add(pmoss); pfnados.add(pnados);
        pfaeaey.add(paeaey); pfktle.add(ptle); pfhuana.add(phuana);
        pfsun.add(psun); pftle.add(pitle);
        //add picture frame on each person
        t33093.add(pf33093, BorderLayout.WEST); huana.add(pfhuana, BorderLayout.WEST);
        moss.add(pfmoss, BorderLayout.WEST); nados.add(pfnados, BorderLayout.WEST);
        aeaey.add(pfaeaey, BorderLayout.WEST); ktle.add(pfktle, BorderLayout.WEST); 
        isun.add(pfsun, BorderLayout.WEST); ihtle.add(pftle, BorderLayout.WEST);
        
        //add margin on picture frame
        pf33093.add(margin1, BorderLayout.NORTH);
        pf33093.add(margin2, BorderLayout.WEST); pf33093.add(margin3, BorderLayout.EAST);
        pfmoss.add(margin4, BorderLayout.NORTH);
        pfmoss.add(margin5, BorderLayout.WEST); pfmoss.add(margin6, BorderLayout.EAST);
        pfnados.add(margin7, BorderLayout.NORTH);
        pfnados.add(margin8, BorderLayout.WEST); pfnados.add(margin9, BorderLayout.EAST);
        pfaeaey.add(margin10, BorderLayout.NORTH);
        pfaeaey.add(margin11, BorderLayout.WEST); pfaeaey.add(margin12, BorderLayout.EAST);
        pfktle.add(margin13, BorderLayout.NORTH);
        pfktle.add(margin14, BorderLayout.WEST); pfktle.add(margin15, BorderLayout.EAST);
        pfhuana.add(margin16, BorderLayout.NORTH);
        pfhuana.add(margin17, BorderLayout.WEST); pfhuana.add(margin18, BorderLayout.EAST);
        pfsun.add(margin19, BorderLayout.NORTH);
        pfsun.add(margin20, BorderLayout.WEST); pfsun.add(margin21, BorderLayout.EAST);
        pftle.add(margin22, BorderLayout.NORTH);
        pftle.add(margin23, BorderLayout.WEST); pftle.add(margin24, BorderLayout.EAST);
        //add margin on text panel
        tt33093.add(margin25, BorderLayout.NORTH);
        tt33093.add(margin26, BorderLayout.WEST); tt33093.add(margin27, BorderLayout.EAST);
        tmoss.add(margin28, BorderLayout.NORTH);
        tmoss.add(margin29, BorderLayout.WEST); tmoss.add(margin30, BorderLayout.EAST);
        tnados.add(margin31, BorderLayout.NORTH);
        tnados.add(margin32, BorderLayout.WEST); tnados.add(margin33, BorderLayout.EAST);
        taeaey.add(margin34, BorderLayout.NORTH);
        taeaey.add(margin35, BorderLayout.WEST); taeaey.add(margin36, BorderLayout.EAST);
        tktle.add(margin37, BorderLayout.NORTH);
        tktle.add(margin38, BorderLayout.WEST); tktle.add(margin39, BorderLayout.EAST);
        thuana.add(margin40, BorderLayout.NORTH);
        thuana.add(margin41, BorderLayout.WEST); thuana.add(margin42, BorderLayout.EAST);
        tisun.add(margin43, BorderLayout.NORTH);
        tisun.add(margin44, BorderLayout.WEST); tisun.add(margin45, BorderLayout.EAST);
        tihtle.add(margin46, BorderLayout.NORTH);
        tihtle.add(margin47, BorderLayout.WEST); tihtle.add(margin48, BorderLayout.EAST);
        //add margin on border
        b33093.add(margin49); bmoss.add(margin50); bnados.add(margin51);
        baeaey.add(margin52); bktle.add(margin53); bhuana.add(margin54);
        bisun.add(margin55); bihtle.add(margin56);
        //add id to border1
        b133093.add(pos33093); b1moss.add(posmoss); b1nados.add(posnados);
        b1aeaey.add(posaeaey); b1ktle.add(postle); b1huana.add(poshuana);
        b1isun.add(posisun); b1ihtle.add(positle);
        //add name to border
        b33093.add(n33093, BorderLayout.SOUTH); bmoss.add(nmoss, BorderLayout.SOUTH);
        bnados.add(nnados, BorderLayout.SOUTH); baeaey.add(naeaey, BorderLayout.SOUTH);
        bktle.add(ntle, BorderLayout.SOUTH); bhuana.add(nhuana, BorderLayout.SOUTH);
        bisun.add(nisun, BorderLayout.SOUTH); bihtle.add(nitle, BorderLayout.SOUTH);
        //add id to border1
        b133093.add(d33093, BorderLayout.NORTH); b1moss.add(dmoss, BorderLayout.NORTH);
        b1nados.add(dnados, BorderLayout.NORTH); b1aeaey.add(daeaey, BorderLayout.NORTH);
        b1ktle.add(dtle, BorderLayout.NORTH); b1huana.add(dhuana, BorderLayout.NORTH);
        b1isun.add(disun, BorderLayout.NORTH); b1ihtle.add(ditle, BorderLayout.NORTH);
        //add Border to gridtext panel
        g33093.add(b33093); gmoss.add(bmoss);
        gnados.add(bnados); gaeaey.add(baeaey);
        gktle.add(bktle); ghuana.add(bhuana);
        gisun.add(bisun); gihtle.add(bihtle);
        //add id to gridtext panel
        g33093.add(b133093); gmoss.add(b1moss);
        gnados.add(b1nados); gaeaey.add(b1aeaey);
        gktle.add(b1ktle); ghuana.add(b1huana);
        gisun.add(b1isun); gihtle.add(b1ihtle);
        //add gridtext panel to text panel
        tt33093.add(g33093); tmoss.add(gmoss); tnados.add(gnados);
        taeaey.add(gaeaey); tktle.add(gktle); thuana.add(ghuana);
        tisun.add(gisun); tihtle.add(gihtle);
        //add panel each person to main panel
        t33093.add(tt33093); moss.add(tmoss); nados.add(tnados);
        aeaey.add(taeaey); ktle.add(tktle); huana.add(thuana);
        isun.add(tisun); ihtle.add(tihtle);
        //setBackground each person
        t33093.setBackground(background);
        moss.setBackground(background);
        nados.setBackground(background);
        aeaey.setBackground(background);
        ktle.setBackground(background);
        huana.setBackground(background);
        isun.setBackground(background);
        ihtle.setBackground(background);
        //setBackground pictureframe
        tt33093.setBackground(background);
        tmoss.setBackground(background);
        tnados.setBackground(background);
        taeaey.setBackground(background);
        tktle.setBackground(background);
        thuana.setBackground(background);
        tisun.setBackground(background);
        tihtle.setBackground(background);
        //setBackground text panel
        pf33093.setBackground(background);
        pfmoss.setBackground(background);
        pfnados.setBackground(background);
        pfaeaey.setBackground(background);
        pfktle.setBackground(background);
        pfhuana.setBackground(background);
        pfsun.setBackground(background);
        pftle.setBackground(background);
        //setBackground grid text panel
        g33093.setBackground(background);
        gmoss.setBackground(background);
        gnados.setBackground(background);
        gaeaey.setBackground(background);
        gktle.setBackground(background);
        ghuana.setBackground(background);
        gisun.setBackground(background);
        gihtle.setBackground(background);
        //setBackground border name
        b33093.setBackground(background);
        bmoss.setBackground(background);
        bnados.setBackground(background);
        baeaey.setBackground(background);
        bktle.setBackground(background);
        bhuana.setBackground(background);
        bisun.setBackground(background);
        bihtle.setBackground(background);
        //setBackground border id
        b133093.setBackground(background);
        b1moss.setBackground(background);
        b1nados.setBackground(background);
        b1aeaey.setBackground(background);
        b1ktle.setBackground(background);
        b1huana.setBackground(background);
        b1isun.setBackground(background);
        b1ihtle.setBackground(background);
        //setBackground margin
        margin1.setBackground(background); margin2.setBackground(background);
        margin3.setBackground(background); margin4.setBackground(background);
        margin5.setBackground(background); margin6.setBackground(background);
        margin7.setBackground(background); margin8.setBackground(background);
        margin9.setBackground(background); margin10.setBackground(background);
        margin11.setBackground(background); margin12.setBackground(background);
        margin13.setBackground(background); margin14.setBackground(background);
        margin15.setBackground(background); margin16.setBackground(background);
        margin17.setBackground(background); margin18.setBackground(background);
        margin19.setBackground(background); margin20.setBackground(background);
        margin21.setBackground(background); margin22.setBackground(background);
        margin23.setBackground(background); margin24.setBackground(background);
        margin25.setBackground(background); margin26.setBackground(background);
        margin27.setBackground(background); margin28.setBackground(background);
        margin29.setBackground(background); margin30.setBackground(background);
        margin31.setBackground(background); margin32.setBackground(background);
        margin33.setBackground(background); margin34.setBackground(background);
        margin35.setBackground(background); margin36.setBackground(background);
        margin37.setBackground(background); margin38.setBackground(background);
        margin39.setBackground(background); margin40.setBackground(background);
        margin41.setBackground(background); margin42.setBackground(background);
        margin43.setBackground(background); margin44.setBackground(background);
        margin45.setBackground(background); margin46.setBackground(background);
        margin47.setBackground(background); margin48.setBackground(background);
        margin49.setBackground(background); margin50.setBackground(background);
        margin51.setBackground(background); margin52.setBackground(background);
        margin53.setBackground(background); margin54.setBackground(background);
        margin55.setBackground(background); margin56.setBackground(background);
        /* margin57.setBackground(background); margin58.setBackground(background);
        margin59.setBackground(background); margin60.setBackground(background); */
        margin61.setBackground(background); margin62.setBackground(background);
        margin63.setBackground(background); margin64.setBackground(background);
        //set font name
        n33093.setFont(name); nmoss.setFont(name); nnados.setFont(name);
        naeaey.setFont(name); ntle.setFont(name); nhuana.setFont(name);
        nisun.setFont(name); nitle.setFont(name);
        //set font id
        d33093.setFont(id); dmoss.setFont(id); dnados.setFont(id);
        daeaey.setFont(id); dtle.setFont(id); dhuana.setFont(id);
        disun.setFont(id); ditle.setFont(id);
        //set font postion
        pos33093.setFont(position); posmoss.setFont(position); posnados.setFont(position);
        posaeaey.setFont(position); postle.setFont(position); poshuana.setFont(position);
        posisun.setFont(position); positle.setFont(position);
        //set Text Color name
        n33093.setForeground(text); nmoss.setForeground(text); nnados.setForeground(text);
        naeaey.setForeground(text); ntle.setForeground(text); nhuana.setForeground(text);
        nisun.setForeground(text); nitle.setForeground(text);
        //set Text Color id
        d33093.setForeground(text); dmoss.setForeground(text); dnados.setForeground(text);
        daeaey.setForeground(text); dtle.setForeground(text); dhuana.setForeground(text);
        disun.setForeground(text); ditle.setForeground(text);
        //set Text Color position
        pos33093.setForeground(text); posmoss.setForeground(text); posnados.setForeground(text);
        posaeaey.setForeground(text); postle.setForeground(text); poshuana.setForeground(text);
        posisun.setForeground(text); positle.setForeground(text);
        //add each person to main panel
        aboutpanel.add(t33093); aboutpanel.add(moss); aboutpanel.add(nados);
        aboutpanel.add(aeaey); aboutpanel.add(ktle); aboutpanel.add(huana);
        aboutpanel.add(isun); aboutpanel.add(ihtle);
        
        homemenu.addMouseListener(this);
        lobbymenu.addMouseListener(this);
        fundmenu.addMouseListener(this);
        aboutmenu.addMouseListener(this);
        username.addMouseListener(this);
        
        aboutframe.setJMenuBar(aboutbar);
        aboutbar.setLayout(new BorderLayout());
        menupanel.add(homemenu);
        menupanel.add(lobbymenu);
        menupanel.add(fundmenu);
        menupanel.add(aboutmenu);
        profilemenu.setLayout(new GridLayout(1,2));
        profilemenu.add(username);
        profilemenu.add(picprofile);
        aboutbar.add(menupanel, BorderLayout.WEST);
        aboutbar.add(space, BorderLayout.CENTER);
        aboutbar.add(profilemenu, BorderLayout.EAST);
        
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(15);
        scroll.getVerticalScrollBar().setBackground(new Color(75, 75, 75));
        scroll.getVerticalScrollBar().setUI(new ScrollBarUI());
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(8, 1));
        scroll.setBorder(BorderFactory.createEmptyBorder());

        left.setPreferredSize(new Dimension(100, 720));
        right.setPreferredSize(new Dimension(100, 720));
        
        aboutframe.setLayout(new BorderLayout());
        aboutframe.add(scroll, BorderLayout.CENTER);
        aboutframe.add(left, BorderLayout.WEST);
        aboutframe.add(right, BorderLayout.EAST);   
                
        aboutbar.setBackground(new Color(43, 43, 43));
        menupanel.setBackground(new Color(43, 43, 43));
        space.setBackground(new Color(43, 43, 43));
        profilemenu.setBackground(new Color(43, 43, 43));
        aboutframe.setBackground(new Color(101,101,101));
        left.setBackground(new Color(101,101,101));
        right.setBackground(new Color(101,101,101));
        aboutpanel.setBackground(new Color(75,75,75));
        
        homemenu.setForeground(new Color(170, 170, 170));
        lobbymenu.setForeground(new Color(170, 170,170));
        fundmenu.setForeground(new Color(170, 170, 170));
        aboutmenu.setForeground(new Color(255, 255, 255));
        username.setForeground(new Color(170, 170, 170));
        
        aboutframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutframe.setSize(1080,720);
        aboutframe.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(homemenu)){
            Home home = new Home();
            home.setSize(aboutframe.getSize());
            home.setLocation(aboutframe.getLocation());
            aboutframe.dispose();
        }
        else if (e.getSource().equals(lobbymenu)){
            Lobby lobby = new Lobby();
            lobby.setSize(aboutframe.getSize());
            lobby.setLocation(aboutframe.getLocation());
            aboutframe.dispose();
        }
        else if (e.getSource().equals(fundmenu)){
            Fund fund = new Fund();
            fund.setSize(aboutframe.getSize());
            fund.setLocation(aboutframe.getLocation());
            aboutframe.dispose();
        }
        else if (e.getSource().equals(aboutmenu)){
            aboutframe.setVisible(true);
        }
        else if (e.getSource().equals(username)){
            User user = new User();
            user.setSize(aboutframe.getSize());
            user.setLocation(aboutframe.getLocation());
            aboutframe.dispose();
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
       aboutframe.setSize(size);
    }

    public void setLocation(Point location) {
        aboutframe.setLocation(location);
    }
    
    public static void main(String[] args) {
        new About();
    }
}
