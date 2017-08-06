/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classModel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Ant {
    private int salud;
    private int alcohol;
    private int poison;
    private String state;
    private int column;
    private int row;
    ArrayList moveX = new ArrayList();
    ArrayList moveY = new ArrayList();

    public Ant() {
        this.salud = 100;
        this.alcohol = 0;
        this.poison = 0;
        this.state = "Sober";
        this.column = column;
        this.row = row;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public ArrayList getMoveX() {
        return moveX;
    }

    public void setMoveX(ArrayList moveX) {
        this.moveX = moveX;
    }

    public ArrayList getMoveY() {
        return moveY;
    }

    public void setMoveY(ArrayList moveY) {
        this.moveY = moveY;
    }
    
    
    
   
}
