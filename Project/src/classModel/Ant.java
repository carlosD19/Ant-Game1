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
    ArrayList moveX = new ArrayList();//rows
    ArrayList moveY = new ArrayList();//columns
    boolean bus = false;
    int poisonCont = 0;

    //Ant´s constructor
    public Ant() {
        this.nickName = nickName;
        this.health = 100;
        this.alcohol = 0;
        this.poison = 3;
        this.state = "Sober";
        this.column = column;
        this.row = row;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    //This method is to move the ant when it is in a sober state
    @Override
    public boolean moveAnt(int move) {
        bus = false;
        switch (move) {
            case KeyEvent.VK_UP://Move the ant up
                upMove(move);
                break;

            case KeyEvent.VK_DOWN://Move the ant down
                downMove(move);
                break;

            case KeyEvent.VK_RIGHT://Move the ant right
                rightMove(move);
                break;

            case KeyEvent.VK_LEFT://Move the ant left
                leftMove(move);
                break;
        }
        //Verify if the ant wins
        if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[row - 1][column - 1]) {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.logicF[Game_View.x][Game_View.y] = 10;
            Game_View.alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/win.WAV"));
            Game_View.alert.play();
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/leftcorona.jpg")));
            state = "Winner";
        }
        return bus;

    }

    //This method is to move the ant when it is in a drunk state(random move)
    @Override
    public boolean HipMoveAnt() {
        bus = false;
        int p = 0;
        while (p < 1) {
            //Random move
            Random rnd = new Random();
            int random = (int) (rnd.nextDouble() * 4 + 37);
            switch (random) {

                case KeyEvent.VK_UP://Move the ant up
                    upMove(random);
                    if (bus) {
                        p++;
                        break;
                    }

                case KeyEvent.VK_DOWN://Move the ant down
                    downMove(random);
                    if (bus) {
                        p++;
                        break;
                    }

                case KeyEvent.VK_RIGHT://Move the ant right
                    rightMove(random);
                    if (bus) {
                        p++;
                        break;
                    }

                case KeyEvent.VK_LEFT://Move the ant left
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
            Game_View.logicF[Game_View.x][Game_View.y] = 10;
            Game_View.alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/win.WAV"));
            Game_View.alert.play();
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/leftcorona.jpg")));
            state = "Winner";
        }
        return bus;
    }

    //This method is to move the ant upwards
    public void upMove(int event) {

        if (event == Game_View.position) {
            bus = false;

        } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[0][Game_View.y]) {
            if (state == "Poisoned") {
                if (health >= 20) {
                    health -= 20;
                } else {
                    state = "Dead";
                    health = 0;
                }
                if (health <= 0) {
                    state = "Dead";
                    health = 0;
                }
            }
            bus = false;

        } else {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
            Game_View.x--;

            upCubes();
            verifyCubes();
            Game_View.position = KeyEvent.VK_DOWN;
            bus = true;

        }
    }

    //This method is to move the ant down
    public void downMove(int event) {

        if (event == Game_View.position) {
            bus = false;

        } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[row - 1][Game_View.y]) {
            if (state == "Poisoned") {
                if (health >= 20) {
                    health -= 20;
                } else {
                    state = "Dead";
                    health = 0;
                }
                if (health <= 0) {
                    state = "Dead";
                    health = 0;
                }
            }
            bus = false;

        } else {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
            Game_View.x++;

            downCubes();
            verifyCubes();
            Game_View.position = KeyEvent.VK_UP;
            bus = true;

        }
    }

    //This method is to move the ant right
    public void rightMove(int event) {

        if (KeyEvent.VK_RIGHT == Game_View.position) {
            bus = false;

        } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[Game_View.x][column - 1]) {
            if (state == "Poisoned") {
                if (health >= 20) {
                    health -= 20;
                } else {
                    state = "Dead";
                    health = 0;
                }
                if (health <= 0) {
                    state = "Dead";
                    health = 0;
                }

            }
            bus = false;

        } else {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
            Game_View.y++;

            rightCubes();
            verifyCubes();
            Game_View.position = KeyEvent.VK_LEFT;
            bus = true;

        }
    }

    //This method is to move the ant left
    public void leftMove(int event) {

        if (KeyEvent.VK_LEFT == Game_View.position) {
            bus = false;

        } else if (Game_View.labels[Game_View.x][Game_View.y] == Game_View.labels[Game_View.x][0]) {
            if (state == "Poisoned") {
                if (health >= 20) {
                    health -= 20;
                } else {
                    state = "Dead";
                    health = 0;
                }
                if (health <= 0) {
                    state = "Dead";
                    health = 0;
                }
            }
            bus = false;

        } else {
            moveX.add(Game_View.x);
            moveY.add(Game_View.y);
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
            Game_View.y--;
            leftCubes();
            verifyCubes();

            Game_View.position = KeyEvent.VK_RIGHT;
            bus = true;

        }
    }

    //This method verifies if in the box that the ant is a terron of sugar, poison or wine
    public void verifyCubes() {
        int i = 0;
        //If state is poisoned
        if (state == "Poisoned") {

            if (poisonCont < 3) {

                if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 0) {
                    health += 10;
                    if (alcohol >= 10) {
                        alcohol -= 10;
                    }
                    poisonCont++;
                    poison--;
                    Game_View.logicF[Game_View.x][Game_View.y] = 10;
                } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 3) {
                    if (alcohol >= 10) {
                        alcohol -= 10;
                    }
                    health += 20;
                    poisonCont++;
                    poison--;
                    Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                    Game_View.logicF[Game_View.x][Game_View.y] = 6;
                } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 4) {
                    state = "Dead";
                    Game_View.logicF[Game_View.x][Game_View.y] = 7;
                    Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;

                } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5) {
                    state = "Dead";
                    Game_View.logicF[Game_View.x][Game_View.y] = 8;
                    Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                }
            } else {
                poisonCont = 0;
                poison = 3;
                if (alcohol >= 0) {
                    state = "Durnk";
                } else {
                    state = "Sober";
                }

            }

//            return;
            //If state is sober
        } else if (state == "Sober") {

            if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 3) {
                health += 10;
                Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                Game_View.logicF[Game_View.x][Game_View.y] = 6;
            } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 4) {
                alcohol += 20;
                if (health >= 10) {
                    health -= 10;
                }
                if (health <= 0) {
                    state = "Dead";
                } else {
                    state = "Drunk";
                }
                Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                Game_View.logicF[Game_View.x][Game_View.y] = 7;
            } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 0) {
                Game_View.logicF[Game_View.x][Game_View.y] = 10;
            }
//            return;
            //If state is drunk
        } else if (state == "Drunk") {

            if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 0) {
                if (alcohol >= 10) {
                    alcohol -= 10;
                    state = "Drunk";
                } else {
                    state = "Sober";
                }
                Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                Game_View.logicF[Game_View.x][Game_View.y] = 10;
            } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 3) {
                health += 10;
                if (alcohol >= 10) {
                    alcohol -= 10;
                    state = "Drunk";
                } else {
                    state = "Sober";
                }
                Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                Game_View.logicF[Game_View.x][Game_View.y] = 6;
            } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 4) {
                alcohol += 20;
                if (health >= 0) {
                    health -= 20;
                    state = "Drunk";
                }
                if (health <= 0) {
                    health = 0;
                    state = "Dead";
                }
                if (alcohol >= 50) {
                    state = "Dead";
                }

                Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                Game_View.logicF[Game_View.x][Game_View.y] = 7;
            } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5) {
                if (health >= 0) {
                    health -= 50;
                    state = "Poisoned";
                    i = 1;
                    Game_View.labelsLogic[Game_View.x][Game_View.y] = 0;
                    Game_View.logicF[Game_View.x][Game_View.y] = 8;
                } else {
                    state = "Dead";
                    Game_View.logicF[Game_View.x][Game_View.y] = 10;
                }
                if (health <= 0) {
                    state = "Dead";
                }
            }

        }
        //Change the state

        if (state == "Dead") {
            state = "Dead";
        } else if (state == "Poisoned") {
            state = "Poisoned";
        } else if (alcohol > 0) {
            state = "Drunk";
        } else {
            state = "Sober";
        }
        return;
    }

    //this method is to change the image of the ant if up
    public void upCubes() {
        if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5 & state.equals("Drunk")) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/upPoi.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5 & state.equals("Poisoned")) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/upPoi.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 3) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/upAzu.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 4) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/upAlc.jpg")));
        } else {
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/up.jpg")));
        }
    }

    //this method is to change the image of the ant if down
    public void downCubes() {
        if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5 & state.equals("Drunk")) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/downPoi.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5 & state.equals("Poisoned")) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/downPoi.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 3) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/downAzu.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 4) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/downAlc.jpg")));
        } else {
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/down.jpg")));
        }
    }

    //this method is to change the image of the ant if right
    public void rightCubes() {
        if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5 & state.equals("Drunk")) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/rightPoi.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5 & state.equals("Poisoned")) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/rightPoi.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 3) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/rightAzu.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 4) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/rightAlc.jpg")));
        } else {
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/rigt.jpg")));
        }
    }

    //this method is to change the image of the ant if right
    public void leftCubes() {
        if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5 & state.equals("Drunk")) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/leftPoi.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 5 & state.equals("Poisoned")) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/leftPoi.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 3) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/leftAzu.jpg")));
        } else if (Game_View.labelsLogic[Game_View.x][Game_View.y] == 4) {

            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/leftAlc.jpg")));
        } else {
            Game_View.labels[Game_View.x][Game_View.y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/left.jpg")));
        }
    }
}
