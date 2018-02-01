/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author JordanWieberg
 */
public class CheckerBoardClass {
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    
    public CheckerBoardClass(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = Color.RED;
        this.darkColor = Color.BLACK;
    }
    public CheckerBoardClass(int numRows, int numCols, double boardWidth, 
            double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    public AnchorPane build(AnchorPane checker) {
        checker.getChildren().clear();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Rectangle space = new Rectangle(getRectangleWidth()*col, getRectangleHeight()*row, 
                        getRectangleWidth(), getRectangleHeight());
                if((row+col)%2 == 0)
                    space.setFill(lightColor);
                else
                    space.setFill(darkColor);
                
                checker.getChildren().add(space);
            }
        }
        return checker;
    }
    public AnchorPane getBoard(AnchorPane board) {
        board = build(board);
        if (board == null)
            return null;
        else
            return board;
    }
    public int getNumRows() {
        return this.numRows;
    }
    public void setNumRows(int rows) {
        this.numRows = rows;
    }
    public int getNumCols() {
        return this.numCols;
    }
    public void setNumCols(int columns) {
        this.numCols = columns;
    }
    public double getWidth() {
        return this.boardWidth;
    }
    public double getHeight() {
        return this.boardHeight;
    }
    public Color getLightColor() {
        return this.lightColor;
    }
    public void setLightColor(Color light) {
        this.lightColor = light;
    }
    public Color getDarkColor() {
        return this.darkColor;
    }
    public void setDarkColor(Color dark) {
        this.darkColor = dark;
    }
    public double getRectangleWidth() {
        return Math.ceil(boardWidth/numCols);
    }
    public double getRectangleHeight() {
        return Math.ceil(boardHeight/numRows);
    }
}
