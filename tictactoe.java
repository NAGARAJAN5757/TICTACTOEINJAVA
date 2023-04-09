import java.util.*;

public class tictactoe{ 
    public static void printBoard(char[][] board){
        for (int row = 0; row < board.length ; row++){
            for ( int col = 0 ; col <board[row].length ; col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
    public static boolean haveWon(char[][] board ,char player){
        //checking each row
        for(int row =0; row < board.length ; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        //checking each column
        for(int col =0; col < board.length ; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        //checking diagonals
        if((board[0][0] == player && board[1][1]  == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player)){
            return true;
        }
        return false;
    }
    //checking for draw condition
    public static boolean haveDrawn(char[][] board){
        for(int row = 0; row <board.length ; row++){
            for(int col = 0; col <board[row].length ; col++){
                if(board[row][col] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
        char board[][] =new char[3][3] ;
        for(int row=0; row< board.length ; row++){
            for(int col = 0 ; col< board[row].length ; col++){
                board[row][col] = ' ';
            }
        }
        char player;
        int rowNumber;
        int colNumber;
        boolean gameOver = false;

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.print("Select first player sign X or O : ");
            player = scan.next().charAt(0);
            if(player == 'X' || player == 'O' )
                break;
            else
                System.out.println("Enter Valid Player Sign");
        }
        
        while(!gameOver){
            while(true){
                System.out.print("Player "+player + " select the position (Enter row colum) : ");
                rowNumber = scan.nextInt();
                colNumber = scan.nextInt();
                if(colNumber >2 || colNumber < 0 || rowNumber > 2 || rowNumber < 0 || board[rowNumber][colNumber] != ' ')
                    System.out.println("\nPlease enter an unoccupied or valid position");
                else
                    break;
            }
            board[rowNumber][colNumber] = player;
            printBoard(board);
            if(haveWon(board,player)){
                System.out.println("Player "+player+" has won the game");
                break;
            }
            else if(haveDrawn(board)){
                System.out.println("Match Drawn");
                break;
            }
            else{
                //changing player for next move
                player = player=='X' ? 'O' : 'X' ; 
            }   
        }
    }
}