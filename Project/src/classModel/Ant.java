/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classModel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import view.Game_View;

/**
 *
 * @author pc
 */
public class Ant implements MoveAnt {

    private int salud;
    private int alcohol;
    private int poison;
    private String state;
    private int column;
    private int row;
    ArrayList moveX = new ArrayList();
    ArrayList moveY = new ArrayList();
    boolean bus = false;

    public Ant() {
        this.salud = 100;
        this.alcohol = 0;
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
        bus = false;
        switch (move) {
            case KeyEvent.VK_UP:
                upMove(move);
                break;

            case KeyEvent.VK_DOWN:
                downMove(move);
                break;

            case KeyEvent.VK_RIGHT:
                rightMove(move);
                break;

            case KeyEvent.VK_LEFT:
                leftMove(move);
                break;
        }

        if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[row - 1][column - 1]) {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/win.WAV"));
            Game_View.alert.play();
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoF.jpg")));
            
        }
        return bus;

    }


    @Override
    public boolean HipMoveAnt() {
        bus = false;
        int p = 0;
        while (p < 1) {
            Random rnd = new Random();
            int random = (int) (rnd.nextDouble() * 4 + 37);
            switch (random) {

                case KeyEvent.VK_UP:
                    upMove(random);
                    if (bus) {
                        p++;
                        break;
                    }

                case KeyEvent.VK_DOWN:
                    downMove(random);
                    if (bus) {
                        p++;
                        break;
                    }

                case KeyEvent.VK_RIGHT:
                    rightMove(random);
                    if (bus) {
                        p++;
                        break;
                    }

                case KeyEvent.VK_LEFT:
                    leftMove(random);
                    if (bus) {
                        p++;
                        break;
                    }

            }

        }
        if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[row - 1][column - 1]) {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/win.WAV"));
            Game_View.alert.play();
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoF.jpg")));
            
        }
        return bus;
    }
    
    public void upMove(int event) {
        
        if (event == Game_View.position) {
            bus = false;

        } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[0][Game_View.y]) {
            bus = false;

        } else {           
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
            Game_View.x--;
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
            verifyCubes();
            Game_View.position = KeyEvent.VK_DOWN;
            bus = true;

        }
    }

    public void downMove(int event) {
        
        if (event == Game_View.position) {
            bus = false;

        } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[row - 1][Game_View.y]) {
            bus = false;

        } else {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
            Game_View.x++;
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
            verifyCubes();
            Game_View.position = KeyEvent.VK_UP;
            bus = true;

        }
    }

    public void rightMove(int event) {
        
        if (KeyEvent.VK_RIGHT == Game_View.position) {
            bus = false;

        } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[Game_View.x][column - 1]) {
            bus = false;

        } else {   
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
            Game_View.y++;
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
            verifyCubes();
            Game_View.position = KeyEvent.VK_LEFT;
            bus = true;

        }
    }

    public void leftMove(int event) {
        
        if (KeyEvent.VK_LEFT == Game_View.position) {
            bus = false;

        } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[Game_View.x][0]) {
            bus = false;

        } else {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
            Game_View.y--;
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
            verifyCubes();
            Game_View.position = KeyEvent.VK_RIGHT;
            bus = true;

        }
    }
    
    public void verifyCubes(){
        switch (Game_View.labelsLogic[Game_View.x][Game_View.y]) {
            case 3:
                salud += 10;
                System.out.println(salud);
                break;
            case 4:
                alcohol += 1;
                System.out.println(alcohol);
                break;
            case 5:
                poison += 10;
                System.out.println(poison);
                break;
            default:
                break;
        }
    }
}
