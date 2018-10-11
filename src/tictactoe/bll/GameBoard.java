/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{

    int currentPlayer = 0;
    int board[][] = new int[3][3];
    int drawCounter = 0;
    
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public String getNextPlayer()
    {
        if(currentPlayer==1)
        {
            currentPlayer=0;
            return "O";
        } else {
            currentPlayer=1;
            return "X";
        }
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        if(board[row][col]==-1)
        {
            board[row][col]= currentPlayer;
            drawCounter++;
            return true;
        } else {
            return false;
        }
    }

    public int isGameOver()
    {
        for(int i = 0; i < 3; i++)
        {
            if((board[i][0] != -1) && (board[i][0] == board[i][1]) && (board[i][1] == board[i][2]))
                return 0;
            else if((board[0][i] != -1) && (board[0][i] == board[1][i]) && (board[1][i] == board[2][i]))
                return 0;
        }
            if((board[0][0] != -1) && (board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
                return 0;
            else if((board[2][0] != -1) && (board[2][0] == board[1][1]) && (board[1][1] == board[0][2]))
                return 0;
            else if(drawCounter == 9)
                return -1;
            else 
                return 1;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public String getWinner()
    {
        String winner = currentPlayer == 1 ? "O" : "X";
        return winner;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        drawCounter = 0;
        for(int k=0; k<3; k++)
        {
            for(int j=0; j<3; j++)
            {
                board[k][j] = -1;
            }
        }
    }

}
