import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameClient implements ActionListener, MouseListener, Runnable {
    private JFrame frame;
    private JPanel gamePanel, gameState, newGamePanel;
    private JLabel[][] marks;
    private JLabel playerText, newGameText;
    private JButton newGameWithAIBtn, newGameWithoutAIBtn;
    private GameBoard game;
    
    public static final Color MENU_COLOR = new Color(42, 43, 43);
    public static final Color BG_COLOR = new Color(58, 56, 56);
    public static final Color BORDER_COLOR = new Color(75, 75, 75);
    public static final Color FONT_COLOR = new Color(202, 202, 202);
    public static final Color O_COLOR = new Color(68, 117, 201);
    public static final Color X_COLOR = new Color(222, 103, 103);
    public static final String fontName = "Source Code Pro";
    
    public GameClient() {
        frame = new JFrame();
        gamePanel = new JPanel();
        gameState = new JPanel();
        newGamePanel = new JPanel();
        marks = new JLabel[3][3];
        playerText = new JLabel();
        newGameText = new JLabel("New Game : ");
        newGameWithAIBtn = new JButton("Against AI");
        newGameWithoutAIBtn = new JButton("2 Players");
        game = new GameBoard();
        
        frame.add(gamePanel);
        gamePanel.setBackground(BG_COLOR);
        gamePanel.setPreferredSize(new Dimension(600, 600));
        gamePanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = new JLabel();
                marks[i][j].setBackground(BG_COLOR);
                marks[i][j].setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 3));
                marks[i][j].setHorizontalAlignment(JLabel.CENTER);
                marks[i][j].setVerticalAlignment(JLabel.CENTER);
                marks[i][j].setFont(new Font(fontName, Font.BOLD, 128));
                gamePanel.add(marks[i][j]);
            }
        }
        
        gamePanel.addMouseListener(this);
        
        frame.add(gameState, BorderLayout.NORTH);
        gameState.add(playerText);
        playerText.setFont(new Font(fontName, Font.PLAIN, 32));
        playerText.setForeground(FONT_COLOR);
        gameState.setBackground(MENU_COLOR);
        
        frame.add(newGamePanel, BorderLayout.SOUTH);
        newGamePanel.add(newGameText);
        newGameText.setFont(new Font(fontName, Font.PLAIN, 32));
        newGameText.setForeground(FONT_COLOR);
        newGamePanel.add(newGameWithAIBtn);
        newGameWithAIBtn.setFont(new Font(fontName, Font.PLAIN, 24));
        newGameWithAIBtn.addActionListener(this);
        newGameWithAIBtn.setForeground(FONT_COLOR);
        newGameWithAIBtn.setBackground(BG_COLOR);
        newGameWithAIBtn.setBorderPainted(false);
        newGamePanel.setBackground(MENU_COLOR);
        newGamePanel.add(newGameWithoutAIBtn);
        newGameWithoutAIBtn.setFont(new Font(fontName, Font.BOLD, 24));
        newGameWithoutAIBtn.addActionListener(this);
        newGameWithoutAIBtn.setForeground(FONT_COLOR);
        newGameWithoutAIBtn.setBackground(BORDER_COLOR);
        newGameWithoutAIBtn.setBorderPainted(false);
        newGamePanel.setBackground(MENU_COLOR);
        
        Thread t = new Thread(this);
        t.start();
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void updatePosition(int row, int col) {
        char[][] board = game.getBoard();
        if (board[row][col] == 'O') {
            marks[row][col].setForeground(O_COLOR);
            marks[row][col].setText("O");
        } else if (board[row][col] == 'X') {
            marks[row][col].setForeground(X_COLOR);
            marks[row][col].setText("X");
        } else {
            marks[row][col].setText("");
        }
    }
    
    public void updateAll() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                updatePosition(i, j);
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int posX = e.getX() * 3 / gamePanel.getWidth();
        int posY = e.getY() * 3 / gamePanel.getHeight();
        game.placeMark(posY, posX);
//        if (game.getMarkPlaced() < 8) {
//            game.moveAI();
//        }
        this.updateAll();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void run() {
        while (true) {
            if (!game.getWithAI()){
                if (game.isRunning()) {
                    char playingMark = game.getPlayingMark();
                    if (playingMark == 'O') {
                        playerText.setText("O's Turn");
                    } else {
                        playerText.setText("X's Turn");
                    }
                    updateAll();
                } else {
                    int winState = game.getGameState();
                    if (winState == GameBoard.DRAW) {
                        playerText.setText("Draw!");
                    } else if (winState == GameBoard.O_WIN) {
                        playerText.setText("O Win!");
                    } else {
                        playerText.setText("X Win!");
                    }
                }
            } else {
                if (game.isRunning()) {
                    char playingMark = game.getPlayingMark();
                    if (playingMark == 'O') {
                        playerText.setText("Your turn...");
                    }
                    updateAll();
                } else {
                    int winState = game.getGameState();
                    if (winState == GameBoard.DRAW) {
                        playerText.setText("Draw!");
                    } else if (winState == GameBoard.O_WIN) {
                        playerText.setText("You Win!");
                    } else {
                        playerText.setText("AI Win!");
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newGameWithAIBtn)) {
            game.newGame(true);
            newGameWithAIBtn.setFont(new Font(fontName, Font.BOLD, 24));
            newGameWithoutAIBtn.setFont(new Font(fontName, Font.PLAIN, 24));
            newGameWithAIBtn.setBackground(BORDER_COLOR);
            newGameWithoutAIBtn.setBackground(BG_COLOR);
            updateAll();
        } else if (e.getSource().equals(newGameWithoutAIBtn)) {
            game.newGame(false);
            newGameWithoutAIBtn.setFont(new Font(fontName, Font.BOLD, 24));
            newGameWithAIBtn.setFont(new Font(fontName, Font.PLAIN, 24));
            newGameWithAIBtn.setBackground(BG_COLOR);
            newGameWithoutAIBtn.setBackground(BORDER_COLOR);
            updateAll();
        }
    }
    
}
