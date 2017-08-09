/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classModel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.Game_View;

/**
 *
 * @author pc
 */
public class Ant implements MoveAnt {

    private int salud;
    private int alcohol = 8;
    private int poison;
    private String state;
    private int column;
    private int row;
    ArrayList moveX = new ArrayList();
    ArrayList moveY = new ArrayList();
    boolean bus = false;

    public Ant() {
        this.salud = 100;
        this.alcohol = 8;
        this.poison = 0;
        this.state = "Sober";
        this.column = column;
        this.row = row;
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

    @Override
    public boolean moveAnt(int move) {

        switch (move) {
            case KeyEvent.VK_UP:
                upMove(move);
                break;
            case KeyEvent.VK_DOWN:
                downMove(move);
                break;

            case KeyEvent.VK_RIGHT:
                if (KeyEvent.VK_RIGHT == Game_View.position) {
                    bus = false;
                    break;
                } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[Game_View.x][column - 1]) {
                    bus = false;
                    break;
                } else {
                    moveX.add(Game_View.x);
                    moveY.add(Game_View.y);
                    Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
                    Game_View.y++;
                    Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
                    Game_View.position = KeyEvent.VK_LEFT;
                    bus = true;
                    break;
                }

            case KeyEvent.VK_LEFT:
                if (KeyEvent.VK_LEFT == Game_View.position) {
                    bus = false;
                    break;
                } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[Game_View.x][0]) {
                    bus = false;
                    break;
                } else {
                    moveX.add(Game_View.x);
                    moveY.add(Game_View.y);
                    Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
                    Game_View.y--;
                    Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
                    Game_View.position = KeyEvent.VK_RIGHT;
                    bus = true;
                    break;
                }
        }

        if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[row - 1][column - 1]) {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.alert2.stop();
            Game_View.alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/win.WAV"));
            Game_View.alert.play();
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoF.jpg")));
            JOptionPane.showMessageDialog(null, "¡¡¡YOU WIN!!!");

        }
        return bus;

    }

    @Override
    public boolean moveHipAnt(int move) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void upMove(int event) {
        if (event == Game_View.position) {
            bus = false;
            return;
        } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[0][Game_View.y]) {
            bus = false;
            return;
        } else {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
            Game_View.x--;
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
            Game_View.position = KeyEvent.VK_DOWN;
            bus = true;
            return;
        }
    }

    public void downMove(int event) {
        if (event == Game_View.position) {
            bus = false;
            return;
        } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[row - 1][Game_View.y]) {
            bus = false;
            return;
        } else {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
            Game_View.x++;
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
            Game_View.position = KeyEvent.VK_UP;
            bus = true;
            return;
        }
    }
}
