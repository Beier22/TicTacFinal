/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mads_
 */
public class StartWindowController implements Initializable {

    @FXML
    private Button pvpButton;
    @FXML
    private Button pveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pvpStart(ActionEvent event) throws IOException {
        Stage st = (Stage) pveButton.getScene().getWindow();
        st.close();
        
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/TicTacView.fxml"));
        stage.setScene(new Scene(loader.load()));
        
        stage.show();
    }

    @FXML
    private void pveStart(ActionEvent event) throws IOException {
        Stage st = (Stage) pvpButton.getScene().getWindow();
        st.close();
        
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/TicTacView.fxml"));
        stage.setScene(new Scene(loader.load()));
        TicTacViewController window = loader.<TicTacViewController>getController();
        window.setPvpFalse();
        stage.show();
    }
    
}
