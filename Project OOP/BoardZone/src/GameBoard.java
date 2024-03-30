
public class GameBoard {
    private char[][] board;
    private int placed = 0; 
    private boolean running = false;
    private int gameState = DRAW;
    private char playingMark = 'O';
    private boolean withAI = false;
    
    public static final int DRAW = 0;
    public static final int O_WIN = 1;
    public static final int X_WIN = 2;
    
    public static final char EMPTY = '\u0000';
    
    public GameBoard() {
        board = new char[3][3];
        running = true;
    }
    
    public void setBoard(char[][] board) {
        this.board = board;
    }
    
    public char[][] getBoard() {
        return this.board;
    }
    
    public void setMarkPlaced(int placed) {
        this.placed = placed;
    }
    
    public int getMarkPlaced() {
        return this.placed;
    }
    
    public void setRunningState(boolean running) {
        this.running = running;
    }
    
    public boolean isRunning() {
        return this.running;
    }
    
    public void setGameState(int gameState) {
        this.gameState = gameState;
    }
    
    public int getGameState() {
        return this.gameState;
    }
    
    public void setPlayingMark(char mark) {
        this.playingMark = mark;
    }
    
    public char getPlayingMark() {
        return this.playingMark;
    }
    
    public void setWithAI(boolean withAI){
        this.withAI = withAI;
    }
    
    public boolean getWithAI() {
        return this.withAI;
    }
    
    public void placeMark(int row, int col) {
        if (running && placed < 9) {
            if (board[row][col] == EMPTY){
                board[row][col] = playingMark;
                placed++;
                int winState = checkWin(board, row, col);
                if (winState != 0 || placed == 9) {
                    running = false;
                    if (winState == 1) {
                        gameState = O_WIN;
                    } else if (winState == -1) {
                        gameState = X_WIN;
                    } else {
                        gameState = DRAW;
                    }
                } else {
                    if (playingMark == 'O') {
                        playingMark = 'X';
                    } else {
                        playingMark = 'O';
                    }
                }
                if (placed < 9 && withAI && playingMark == 'X') {
                    moveAI();
                }
            }
        }
    }
    
    public int checkWin(char[][] board, int row, int col) {
        char mark = board[row][col];
        //Row Check
        boolean rowWin = true;
        for (int c = 0; c < 3; c++) {
            if (board[row][c] != mark) {
                rowWin = false;
                break;
            }
        }
        
        //Column Check
        boolean colWin = true;
        for (int r = 0; r < 3; r++) {
            if (board[r][col] != mark) {
                colWin = false;
                break;
            }
        }
        
        //Diagonal check
        boolean diagLRWin = false;
        if (row == col) { 
            diagLRWin = true;
            for (int i = 0; i < 3; i++) {
                if (board[i][i] != mark) {
                    diagLRWin = false;
                }
            }
        }
        boolean diagRLWin = false;
        if (row == 2 - col) {
            diagRLWin = true;
            for (int i = 0; i < 3; i++) {
                if (board[i][2 - i] != mark) {
                    diagRLWin = false;
                }
            }
        }
        
        if (rowWin || colWin || diagLRWin || diagRLWin) {
            if (mark == 'O') {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }
    
    public void newGame(boolean withAI) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
        running = true;
        placed = 0;
        playingMark = 'O';
        this.withAI = withAI;
        
    }
    
    public void moveAI() {
        int[][] testTable = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                testTable[i][j] = 10;
            }
        }
        char[][] tempBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(board[i], 0, tempBoard[i], 0, 3);
        }
        int minVal = Integer.MAX_VALUE;
        int val;
        int bestRow = 0, bestCol = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tempBoard[i][j] == EMPTY) {
                    tempBoard[i][j] = 'X';
                    val = miniMax(tempBoard, i, j, placed + 1, true);
                    tempBoard[i][j] = EMPTY;
                    testTable[i][j] = val;
                    if (val < minVal) {
                        minVal = val;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }
        placeMark(bestRow, bestCol);
    }
    
    private int miniMax(char[][] board, int row, int col, int depth, boolean maxTurn) {
        int winState = checkWin(board, row, col);
        
        if (depth == 9 || (depth < 9 && winState != 0)) {
           return winState * depth;
        }
        
        if (maxTurn) {
            int maxVal = -2;
            int val;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = 'O';
                        val = miniMax(board, i, j, depth + 1, false);
                        board[i][j] = EMPTY;
                        if (val > maxVal){
                            maxVal = val;
                        }
                    }
                }
            }
            return maxVal;
        } else {
            int minVal = 2;
            int val;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = 'X';
                        val = miniMax(board, i, j, depth + 1, true);
                        board[i][j] = EMPTY;
                        if (val < minVal){
                            minVal = val;
                        }
                    }
                }
            }
            return minVal;
        }
    }
    
    
    
}
