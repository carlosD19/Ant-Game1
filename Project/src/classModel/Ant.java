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

    private String nickName;
    private int health;
    private int alcohol;
    private int poison;
    private String state;
    private int column;
    private int row;
    ArrayList moveX = new ArrayList();
    ArrayList moveY = new ArrayList();
    boolean bus = false;
    int poisonCont = 0;

    public Ant() {
        this.nickName = nickName;
        this.health = 100;
        this.alcohol = 0;
        this.poison = 3;
        this.state = "Sober";
        this.column = column;
        this.row = row;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
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

    public void verifyCubes() {
        int i = 0;
        if (state == "Poisoned") {
            
            if (poisonCont <= 3) {
                poisonCont++;
                
                if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 0) {
                    health += 10;
                    poisonCont++;
                    poison --;
                } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 3) {
                    health += 20;
                    poisonCont++;
                    poison--;
                    Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 4 || Game_View.labelsLogic[Game_View.x][Game_View.y] == 5) {
                    state = "Died";
                    Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                }
            } else {
                poisonCont = 0;
                if(alcohol >= 0){
                    state = "Durnk"; 
                }
                else{
                    state = "Sober";
                }
                
            }
        }
        else if (alcohol == 0) {

            if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 3) {
                health += 10;
                Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                return;
            } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 4) {
                alcohol += 20;
                if (health >= 10) {
                    health -= 10;
                }
                Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                state = "Drunk";
                return;
            }
        } else if (alcohol > 0) {

            if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 0) {
                if (alcohol >= 10) {
                    alcohol -= 10;
                }
            } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 3) {
                health += 10;
                if (alcohol >= 10) {
                    alcohol -= 10;
                }
                Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
            } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 4) {
                alcohol += 20;
                if (health >= 20) {
                    health -= 20;
                }
                Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
            } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5) {
                if (health >= 50) {
                    health -= 50;
                    state = "Poisoned";
                    i = 1;
                }
                Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
            }
        } 
        if(state == "Died"){
            state = "Died";
            return;
        }
        else if(state == "Poisoned" ){
            state = "Poisoned";
            return;
        }
        else if (alcohol > 0) {
            state = "Drunk";
            return;
        }
        else if (alcohol == 0) {
            state = "Sober";
            return;
        }
        
    }
}
