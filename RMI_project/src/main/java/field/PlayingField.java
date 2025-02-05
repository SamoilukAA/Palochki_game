/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field;

import java.io.*;

/**
 *
 * @author Lenovo
 */
public class PlayingField implements Serializable{
    
    String cells[][];
    String hlines[][];
    String vlines[][];
    int score[];
    
    public int rows;
    public int cols;
    
    public int whoMove;
    
    public PlayingField(int rows, int cols) {
        whoMove = 1;
        this.rows = rows; this.cols = cols;
        cells = new String[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                cells[i][j] = "EMPTY";
        hlines = new String[rows][cols + 1];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols + 1; j++)
                hlines[i][j] = "BLACK";
        vlines = new String[rows + 1][cols];
        for (int i = 0; i < rows + 1; i++)
            for (int j = 0; j < cols; j++)
                vlines[i][j] = "BLACK";
        score = new int[2];
        score[0] = 0;
        score[1] = 0;
    }
    
    public String getCellState(int row, int col){
        return cells[row][col];
    }
    
    public void setCellState(int row, int col, String cState){
        if (cState.equals("A"))
            cells[row][col] = "A";
        if (cState.equals("B"))
            cells[row][col] = "B";
    }
    
    public String getHlineState(int row, int col){
        return hlines[row][col];
    }
    
    public String getVlineState(int row, int col){
        return vlines[row][col];
    }
    
    public void setHlineState(int row, int col, String hState){
        hlines[row][col] = hState;
    }
    
    public void setVlineState(int row, int col, String vState){
        vlines[row][col] = vState;
    }
    
    public void countScore() {
        score[0] = 0;
        score[1] = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++){
                if (cells[i][j].equals("A")){
                    score[0]++;
                }
                if (cells[i][j].equals("B")){
                    score[1]++;
                }
            }
        }
    }
    
    public int[] getScore() {
        return score;
    }
    
    public int switchMove() {
        if (whoMove == 1) {
            return 2;
        } else return 1;
    }
    
    public boolean needToSetSymbol () {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                if (!hlines[i][j].equals("BLACK") & !hlines[i][j + 1].equals("BLACK") & 
                        !vlines[i][j].equals("BLACK") & !vlines[i + 1][j].equals("BLACK")) {
                    if (cells[i][j].equals("EMPTY")){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
