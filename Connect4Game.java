import java.util.*;

public class Connect4Game
{
    /** An enumeration to signify the color of the piece, or 
     * that there is no piece at a particular location.
     */
    public enum Piece {RED, BLACK, EMPTY};

    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int size, dropCol;
        Piece[][] board;
        Piece current;
        boolean winner;

        //get board size and create the default board.
        do
        {
            System.out.println("What size board are we playing with?");
            size = in.nextInt();
        }
        while (!isValidSize(size));

        board = createDefaultBoard(size);
        current = Piece.BLACK;
        
        //Now take turns playing until someone wins.
        do
        {
            current = swapCurrent(current);
            printBoard(board);

            do
            {
                System.out.println("What column do you want to drop into?");
                dropCol = in.nextInt();
            }
            while (!isValidLocation(board, dropCol));
            
            drop(board, dropCol, current);
            winner = isWinner(board, current);
        }
        while (!winner && hasEmptySpace(board));

        //print out the winner
        if (winner)
            System.out.println((current == Piece.RED ? "RED" : "BLACK") +" won.");
        else
            System.out.println("Tied game!");
    }

    public static void printBoard(Piece[][] board)
    {
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                Piece piece = board[row][col];
                char displayPiece = piece == Piece.RED ? 'R' : 
                                    piece == Piece.BLACK ? 'B' : '.';
                System.out.print(displayPiece);
            }
            System.out.println();
        }
    }

    /**
     * @param the size to check
     * @return true if the size is greater than or equal to 4, false otherwise.
     */
    public static boolean isValidSize(int size)
    {
        return size >= 4;
    }

    /**
     * @param size The size of the board, which must be equal to or greater than 4.
     * @return A new square 2D array of Pieces, of the size specified. All the elements
     * should be set to Piece.EMPTY;
     * Difficulty: easy
     */
    public static Piece[][] createDefaultBoard(int size)
    {
        //TODO!
        Piece[][] arr = new Piece[size][size];
        
        for (int row = 0; row < arr.length; row++)
        {
            for (int col = 0; col < arr[row].length; col++)
                arr[row][col] = Piece.EMPTY;
        }
        
        return null;
    }

    /**
     * @param board The board to check a valid location for
     * @param dropCol The column we want to drop in to.
     * @return true if the dropCol is within the size of the board AND
     * there is an empty space to drop in to. 
     * Difficulty: easy
     */
    public static boolean isValidLocation(Piece[][] board, int dropCol)
    {
        for (int row = 0; row < board.length; row++)
        {
            if (board[row][dropCol] == Piece.EMPTY)
                return true;
        }
        //TODO!
        return false;
    }

    /**
     * After this method is called, the bottommost empty piece in selected column
     * will be piece passed in.
     * @param board The board to drop a piece in to.
     * @param column The column to drop a piece in to. This is already assumed
     * to be a valid column, that is, isValidLocation was already checked to be true.
     * @param player The piece to drop in
     * Difficulty: medium
     */
    public static void drop(Piece[][] board, int column, Piece player)
    {
        for (int row = board.length; row > 0; row--)
        {
            if (board[row][column] == Piece.EMPTY)
            {
                board[row][column] = player;
                return;
            }
                
        }
        //TODO!
		
		/**
		*You'll need to go to the column in question and walk through the rows
		*looking for the first empty spot. You may find it easiest to start
		*at the bottom and walk up.
		*/
    }

    /**
     * @param currentPlayer A piece the represents the current player.
     * @return the Piece that represents the other player. That is, if the current
     * player is red, return black.
     * Difficulty: easy
     */
    public static Piece swapCurrent(Piece currentPlayer)
    {
        
        //TODO!
        return Piece.EMPTY;
    }

    /**
     * @param board the board to check.
     * @param currentPlayer the current player
     * @return true if currentPlayer has won the game by having 4 pieces in a row
     * or 4 pieces in a column. 
     * Difficulty: hard
     * CHALLENGE PROBLEM:
     * Have this method also return true in the case of a diagonal win! The robot
     * will not check for this. If you believe you have completed it though, let the
     * professor know.
     */
    public static boolean isWinner(Piece[][] board, Piece currentPlayer)
    {
        for (int row = 0; row < board.length; row ++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                if (board[row][col] == board[row][col + 1]
                    && board[row][col + 1] == board[row][col + 2]
                    && board[row][col + 2] == board[row][col + 3]
                    && board[row][col + 3] == board[row][col + 4])
                    return;
            }
        }
        
        for (int col = 0; col < board.length; col++)
        {
            for (int row = 0; row < board[col].length; row++)
            {
                if (board[row][col] == board[row + 1][col]
                    && board[row + 1][col] == board[row + 2][col]
                    && board[row + 2][col] == board[row + 3][col]
                    && board[row + 3][col] == board[row + 4][col])
                    return;
            }
        }
        //TODO!
		/**
		*check through the rows first, looking to see if there are 4 columns in a row with
		*the same color as the currentPlayer.
		*I actually created a variable to track how many matching pieces I had seen so far.
		
		*You should get the rows working first and test it out.
		*Once you get it working for that part, checking columns is straightforward.
		*/
        return false;
    }

    /**
     * @param board the board to check for an empty space
     * @return true if there is still an open column to drop in to, false if
     * the board is full.
     * Difficulty: medium
     */
    public static boolean hasEmptySpace(Piece[][] board)
    {
        //TODO!
		//You don't need to walk through the entire 2D array.
		//Think of a faster way to determine whether there is an empty
		//space when playing Connect4.
        return false;
    }
    
}