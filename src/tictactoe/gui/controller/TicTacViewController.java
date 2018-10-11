/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tictactoe.bll.GameBoard;
import tictactoe.bll.IGameModel;

/**
 *
 * @author Stegger
 */
public class TicTacViewController implements Initializable
{

    @FXML
    private Label lblPlayer;

    @FXML
    private Button btnNewGame;

    @FXML
    private GridPane gridPane;
    
    private static final String TXT_PLAYER = "Player: ";
    private IGameModel game;
    private boolean loop = false;
    public boolean pvp = true;
    private Button rbtn;
    private boolean endGame = false;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;

    public Button randomValue() {

    List<Button> randomValue = new ArrayList<>();
    randomValue.add(btn1);
    randomValue.add(btn2);
    randomValue.add(btn3);
    randomValue.add(btn4);
    randomValue.add(btn5);
    randomValue.add(btn6);
    randomValue.add(btn7);
    randomValue.add(btn8);
    randomValue.add(btn9);

    Random random = new Random();

    return randomValue.get(random.nextInt(randomValue.size()));
}
    
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            loop = false;
            if(pvp == true){
                Button btn = (Button) event.getSource();
                Integer row = GridPane.getRowIndex((Node) event.getSource());
                Integer col = GridPane.getColumnIndex((Node) event.getSource());
                int r = (row == null) ? 0 : row;
                int c = (col == null) ? 0 : col;
                int player = game.getNextPlayer()=="O" ? 0 : 1;
                if (game.play(c, r) && endGame==false)
                {
                    if (game.isGameOver()==0)
                    {
                        String winner = game.getWinner();
                        displayWinner(winner);
                        btn.setText(winner);
                        endGame = true;
                    }
                    else if (game.isGameOver()==1)
                    {

                        String xOrO = player == 0 ? "X" : "O";
                        btn.setText(xOrO);
                        game.getNextPlayer();
                        setPlayer();
                    }
                    else if (game.isGameOver()==-1)
                    {
                        displayWinner("");
                        btn.setText(game.getNextPlayer());
                    }
                }
            }
            if(pvp == false){
                Button btn = (Button) event.getSource();
                Integer row = GridPane.getRowIndex((Node) event.getSource());
                Integer col = GridPane.getColumnIndex((Node) event.getSource());
                int r = (row == null) ? 0 : row;
                int c = (col == null) ? 0 : col;
                int player = game.getNextPlayer()=="O" ? 0 : 1;
                if (game.play(c, r) && endGame==false)
                setPlayer();
                {
                    if (game.isGameOver()==0)
                    {
                        String winner = game.getWinner();
                        displayWinner(winner);
                        btn.setText(winner);
                        endGame = true;
                    }
                    else if (game.isGameOver()==1 && "".equals(btn.getText()))
                    {

                        String xOrO = player == 0 ? "X" : "O";
                        btn.setText(xOrO);
                        
                        
                        
                        while(!loop){
                            
                            rbtn = randomValue();
                        
                            if("".equals(rbtn.getText())){
                                String opposite = "X".equals(xOrO) ? "O" : "X";
                               rbtn.setText(opposite);
                               loop = true;
                            }
                        }
                    }
                    else if (game.isGameOver()==-1)
                    {
                        displayWinner("");
                        btn.setText(game.getNextPlayer());
                    }
                }
            }
            
            
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();
        endGame=false;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoard();
        setPlayer();
        game.newGame();
        endGame = false;
    }

    private void setPlayer()
    {
        lblPlayer.setText(TXT_PLAYER + game.getNextPlayer());
    }

    private void displayWinner(String winner)
    {
        String message = "";
        switch (winner)
        {
            case "":
                message = "It's a draw :-(";
                break;
            default:
                message = "Player " + winner + " wins!!!";
                break;
        }
        lblPlayer.setText(message);
    }

    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
        }
    }

    

    public void setPvpFalse() {
       pvp = false;
    }
    
}
