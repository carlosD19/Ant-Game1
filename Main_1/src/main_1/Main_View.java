/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_1;

import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.applet.AudioClip;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class Main_View extends javax.swing.JFrame implements Runnable {

    public static int row = 11; //11 Max
    public static int column = 21; //21 Max
    public static int cubes = 5; //11 Max
    Label1[][] labels = new Label1[row][column];
    int[][] labelsLogic = new int[row][column];
    Border border = LineBorder.createBlackLineBorder();

    int movements = 0;
    int i = 0;
    Thread h1, t;
    int x = 0; //row
    int y = 0; //column
    AudioClip alert;
    AudioClip alert2;
    int position = 0;
    int pX = 0;
    ArrayList moveX = new ArrayList();
    ArrayList moveY = new ArrayList();

    /**
     * Creates new form Main_View
     */
    public Main_View() {
        initComponents();
        labels();
        remove_backGround();
        h1 = new Thread(this);
        printLogicLabels();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        settingsButton = new javax.swing.JButton();
        jLabelPanel = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        movesJLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(176, 196, 222));
        jLabel1.setText("DRUNK ANT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/close_1.png"))); // NOI18N
        closeButton.setFocusable(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 40, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(176, 196, 222));
        jLabel2.setText("TIME:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 250, -1, -1));

        time.setEditable(false);
        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        time.setForeground(new java.awt.Color(176, 196, 222));
        time.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        time.setText(" 0:00");
        time.setBorder(null);
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 250, 60, -1));

        settingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/settings (3).png"))); // NOI18N
        settingsButton.setFocusable(false);
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(settingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 120));

        javax.swing.GroupLayout jLabelPanelLayout = new javax.swing.GroupLayout(jLabelPanel);
        jLabelPanel.setLayout(jLabelPanelLayout);
        jLabelPanelLayout.setHorizontalGroup(
            jLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );
        jLabelPanelLayout.setVerticalGroup(
            jLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        getContentPane().add(jLabelPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 1120, 670));

        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/play.png"))); // NOI18N
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        playButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                playButtonKeyPressed(evt);
            }
        });
        getContentPane().add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 110, 70, 70));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(176, 196, 222));
        jLabel4.setText("MOVEMENTS:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 290, -1, -1));

        movesJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        movesJLabel.setForeground(new java.awt.Color(176, 196, 222));
        movesJLabel.setText("0");
        getContentPane().add(movesJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 290, 30, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/background nature.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        Setting_View view = new Setting_View();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dispose();

    }//GEN-LAST:event_settingsButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void playButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playButtonKeyPressed

        switch (evt.getExtendedKeyCode()) {
            case KeyEvent.VK_UP:
                if (KeyEvent.VK_UP == position) {
                    verifyMovement();
                    break;
                } else if (labels[x][y] == labels[0][y]) {
                    errorSound();
                    break;
                } else {
                    moveX.add(x);
                    moveY.add(y);
                    movementsAnt();
                    labels[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
                    x--;
                    labels[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
                    position = KeyEvent.VK_DOWN;
                    break;
                }

            case KeyEvent.VK_DOWN:
                if (KeyEvent.VK_DOWN == position) {
                    verifyMovement();
                    break;
                } else if (labels[x][y] == labels[row - 1][y]) {
                    errorSound();
                    break;
                } else {
                    moveX.add(x);
                    moveY.add(y);
                    movementsAnt();
                    labels[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
                    x++;
                    labels[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
                    position = KeyEvent.VK_UP;
                    break;
                }

            case KeyEvent.VK_RIGHT:
                if (KeyEvent.VK_RIGHT == position) {
                    verifyMovement();
                    break;
                } else if (labels[x][y] == labels[x][column - 1]) {
                    errorSound();
                    break;
                } else {
                    moveX.add(x);
                    moveY.add(y);
                    movementsAnt();
                    labels[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
                    y++;
                    labels[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
                    position = KeyEvent.VK_LEFT;
                    break;
                }

            case KeyEvent.VK_LEFT:
                if (KeyEvent.VK_LEFT == position) {
                    verifyMovement();
                    break;
                } else if (labels[x][y] == labels[x][0]) {
                    errorSound();
                    break;
                } else {
                    moveX.add(x);
                    moveY.add(y);
                    movementsAnt();
                    labels[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
                    y--;
                    labels[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
                    position = KeyEvent.VK_RIGHT;
                    break;
                }
        }

        if (labels[x][y] == labels[row - 1][column - 1]) {
            moveX.add(x);
            moveY.add(y);
            alert2.stop();
            alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/win.WAV"));
            alert.play();
            labels[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoF.jpg")));
            JOptionPane.showMessageDialog(null, "¡¡¡YOU WIN!!!");
            printMatriz();
            return;
        }

    }//GEN-LAST:event_playButtonKeyPressed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        alert2 = java.applet.Applet.newAudioClip(getClass().getResource("/icones/gameSound.wav"));
        alert2.loop();
        run();
        h1.start();

    }//GEN-LAST:event_playButtonActionPerformed

    public void labels() {
        int x = 50;
        int y = 55;

        for (int rows = 0; rows < row; rows++) {
            for (int columns = 0; columns < column; columns++) {
                if (rows == 0 & columns == 0) {
                    labelsLogic[rows][columns] = 1;
                } else if (rows == row-1 & columns == column-1) {
                    labelsLogic[rows][columns] = 2;
                } else {
                    labelsLogic[rows][columns] = 0;
                }
                labels[rows][columns] = new Label1(x, y, 50, 55);
                labels[rows][columns].setBorder(border);
                labels[rows][columns].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
                jLabelPanel.add(labels[rows][columns], null);
                x += 50;

            }
            y += 55;
            x = 50;
        }

        labels[0][0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ant.jpg")));
        labels[row - 1][column - 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/hormiguero.jpg")));
    }

    public void errorSound() {
        alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/error.wav"));
        alert.play();
    }

    public void verifyMovement() {
        alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/error.wav"));
        alert.play();
    }

    public void remove_backGround() {
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorder(null);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorder(null);
        playButton.setContentAreaFilled(false);
        playButton.setBorder(null);
        time.setOpaque(false);
        jLabelPanel.setFocusable(true);
        jLabelPanel.setOpaque(false);
        setIconImage(new ImageIcon(getClass().getResource("../icones/game.png")).getImage());

    }

    public void run() {

        Thread ct = Thread.currentThread();
        int contador = 0;
        while (ct == h1) {
            i = i + 1;

            if (i >= 60) {
                i = 0;
                contador += 1;
                time.setText(contador + ":0" + i);

            } else if (i <= 9) {
                time.setText(contador + ":0" + i);
            } else {
                time.setText(contador + ":" + i);
            }
            if (labels[row - 1][column - 1] == labels[x][y]) {
                h1.suspend();

                //Ant.setTime(time.getText());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    //METODO DE IMPRIMIR PARA VERIFICAR
    public void printMatriz() {
        for (int i = 0; i < movements + 1; i++) {
            System.out.println("[ " + moveX.get(i) + ", " + moveY.get(i) + " ]");
        }
    }

    public void movementsAnt() {
        movements++;
        movesJLabel.setText(String.valueOf(movements));
        alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/move.WAV"));
        alert.play();
    }
    //METODO DE IMPRIMIR PARA VERIFICAR
    public void printLogicLabels() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println(labelsLogic[i][j]);
            }
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jLabelPanel;
    private javax.swing.JLabel movesJLabel;
    private javax.swing.JButton playButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
