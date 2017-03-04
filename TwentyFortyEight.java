import java.util.Random;
import java.util.Scanner;

public class TwentyFortyEight {
    //This instance variable represents the board. Use this to make changes.
    private int[][] board;
    //This variable keeps track of the current score.
    private int score;
    private int boardWidth;

    //Constructor
    public TwentyFortyEight(int boardWidth){
        this.boardWidth = boardWidth;
        board = new int[boardWidth][boardWidth];
        score = 0;
        placeRandom();
    }

    //This function resets the board to its initial state
    public void reset() {
        board = new int[boardWidth][boardWidth];
        score = 0;
        placeRandom();
    }

    //This function returns the total number of blank spaces on the board
    public int numBlanks() {
        int blankCount = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 0){
                    blankCount++;
                }
            }
        }
        return blankCount;
    }

    public void updateScore(int a){
        score+=a;
    }

    //This function places a 2 at a random blank space on the board.
    //It does nothing if there are no blank spaces.
    public void placeRandom(){
        Random rand = new Random();
        if(numBlanks() == 0){
            return;
        }else{
            int randomVal = rand.nextInt(numBlanks());
            int blankCount = 0;
            for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 0){
                    blankCount++;
                    if(blankCount == randomVal){
                        board[i][j] = 2;
                    }
                }
            }
        }
        }
    }

    //This function attempts to move a cell at coordinates fromRow,fromCol to
    //the cell toRow,toCol. Refer to the handout for movement rules.
    public boolean moveTo(int fromRow, int fromCol, int toRow, int toCol) {
        if((fromRow < board.length && fromRow >= board[0].length)&&
            (toRow < board.length && toRow >= board[0].length)&&
            (fromCol < board.length && fromCol >= board[0].length)&&
            (toCol < board.length && toCol >= board[0].length)){
            if(board[fromRow][fromCol] == 0){
                return false;
            }else if(board[toRow][toCol] == 0){
                board[toRow][toCol] = board[fromRow][fromCol];
                board[fromRow][fromCol] = 0;
                return true;
            }else if(board[toRow][toCol] == board[fromRow][fromCol]){
                board[toRow][toCol] *= 2;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    //The following four functions move the board in a single direction.
    public boolean moveUp(){
        for(int i = 0; i < board.length; i++){
            for(int j = 1; j <board.length 0; j++){
                if(board[i][j] == 0)
            }
        }
        return false;
    }

    public boolean moveDown() {
        // TODO
        return false;
    }

    public boolean moveRight() {
        // TODO
        return false;
    }

    public boolean moveLeft() {
        // TODO
        return false;
    }

    ////////////////////////////////////////////////////////////////////////
    // Do not edit the methods below, they are for testing and running the
    // program.
    ////////////////////////////////////////////////////////////////////////
    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] newBoard) {
        board = newBoard;
    }


    /**
     * The main will allow you to play the game.
     *
     * @param args
     */
    public static void main(String args[]) {
        TwentyFortyEight tfe = new TwentyFortyEight(4);


        Scanner s = new Scanner(System.in);
        int bestScore = 0;
        boolean resetFlag = false;

        while(true) {
            System.out.println("Current score: " + tfe.getScore() + " | Best score: " + bestScore);
            tfe.showBoard();

            System.out.println("Enter up, down, left or right to move in that direction.");
            System.out.println("Enter reset to reset the game or quit to exit.");
            String line = s.nextLine();

            switch(line){
                case "up":
                    while(tfe.moveUp()){
                        // do nothing
                    }
                    break;
                case "down":
                    while(tfe.moveDown()){
                        // do nothing
                    }
                    break;
                case "left":
                    while(tfe.moveLeft()){
                        // do nothing
                    }
                    break;
                case "right":
                    while(tfe.moveRight()){
                        // do nothing
                    }
                    break;
                case "reset":
                    tfe.reset();
                    resetFlag = true;
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Invalid move, Please try again!!!!\n");
                    continue;

            }

            bestScore = Math.max(bestScore, tfe.getScore());
            if(!resetFlag) {
                tfe.placeRandom();
                resetFlag = false;
            }
        }
    }



    public void showBoard() {
        for(int x = 0; x < boardWidth * 6 + 1; x++){
            System.out.print("-");
        }
        System.out.println();

        for(int x = 0; x < boardWidth; x++) {
            for(int y = 0; y < boardWidth; y++) {
                String square = (board[x][y] == 0)? "":board[x][y] + "";
                System.out.printf("|%5s", square);
            }
            System.out.println("|");

            for(int y = 0; y < boardWidth * 6 + 1; y++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public int getScore() {
        return score;
    }

}
