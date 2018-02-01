/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author JordanWieberg
 */
public class CheckerFXMLController implements Initializable, Startable{
    
    @FXML
    private AnchorPane checkerboard;
    
    private CheckerBoardClass checkers;
    private Stage stage;
    
    @FXML
    private void defaultColor(ActionEvent event) {
        checkers.setLightColor(Color.RED);
        checkers.setDarkColor(Color.BLACK);
        checkerboard = checkers.getBoard(checkerboard);
    }
    
    @FXML 
    private void blueColor(ActionEvent event) {
        checkers.setLightColor(Color.SKYBLUE);
        checkers.setDarkColor(Color.DARKBLUE);
        checkerboard = checkers.getBoard(checkerboard);
    }
    
    @FXML
    private void sixteen(ActionEvent event) {
        checkers.setNumRows(16);
        checkers.setNumCols(16);
        checkerboard = checkers.getBoard(checkerboard);
    } 
    
    @FXML
    private void ten(ActionEvent event) {
        checkers.setNumRows(10);
        checkers.setNumCols(10);
        checkerboard = checkers.getBoard(checkerboard);
    }
    
    @FXML
    private void eight(ActionEvent event) {
        checkers.setNumRows(8);
        checkers.setNumCols(8);
        checkerboard = checkers.getBoard(checkerboard);
    }
    
    @FXML
    private void three(ActionEvent event) {
        checkers.setNumRows(3);
        checkers.setNumCols(3);
        checkerboard = checkers.getBoard(checkerboard);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        checkers = new CheckerBoardClass(8, 8, checkerboard.getWidth(), checkerboard.getHeight());
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            checkers = new CheckerBoardClass(checkers.getNumCols(), checkers.getNumRows(), stage.getWidth(), 
                    stage.getHeight()-51, checkers.getLightColor(), checkers.getDarkColor());
            checkerboard = checkers.getBoard(checkerboard);
        };

        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        checkerboard = checkers.getBoard(checkerboard);
    }
    
}
