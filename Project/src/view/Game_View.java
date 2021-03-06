/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classModel.Ant;
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
import classModel.Label1;
import java.util.Random;

/**
 *
 * @author pc
 */
public class Game_View extends javax.swing.JFrame {

    String name = "";
    public int row = 7; //10 Max
    public int column = 7; //16 Max
    public int cube = 5; //11 Max
    public static Label1[][] labels;
    public static int[][] labelsLogic;
    public static int x = 0; //row
    public static int y = 0; //column
    public static AudioClip alert; //move sound
    public static AudioClip alert2; // win sound
    public static int movements = 0; //count move
    public static int position; // oppossitive position
    public static int[][] logicF;
    boolean bus = false;
    Border border = LineBorder.createBlackLineBorder();
    Ant ant = new Ant();

    public Game_View(int rows1, int columns1, int cubes1, String name1) {
        name = name1;
        row = rows1;
        column = columns1;
        cube = cubes1;
        labels = new Label1[row][column];
        labelsLogic = new int[row][column];
        logicF = new int[row][column];
        x = 0;
        y = 0;
        movements = 0;
        position = 0;
        initComponents();
        remove_backGround();
        labels();
        random();
        setAtri();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settingsButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabelPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        healthLabel = new javax.swing.JLabel();
        alcoholLabel = new javax.swing.JLabel();
        poisonLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        nickNameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        alcBar = new javax.swing.JProgressBar();
        heaBar = new javax.swing.JProgressBar();
        poiBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        settingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/settings (3).png"))); // NOI18N
        settingsButton.setFocusable(false);
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(settingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 100));

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/close (2).png"))); // NOI18N
        closeButton.setFocusable(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 50, 50));

        jLabelPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabelPanelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jLabelPanelLayout = new javax.swing.GroupLayout(jLabelPanel);
        jLabelPanel.setLayout(jLabelPanelLayout);
        jLabelPanelLayout.setHorizontalGroup(
            jLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        jLabelPanelLayout.setVerticalGroup(
            jLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        getContentPane().add(jLabelPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 1110, 660));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(176, 196, 222));
        jLabel2.setText("DRUNK ANT");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(176, 196, 222));
        jLabel3.setText("HEALTH :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 90, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(176, 196, 222));
        jLabel5.setText("ALCOHOL :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 100, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(176, 196, 222));
        jLabel6.setText("POISON :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 80, -1));

        healthLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        healthLabel.setForeground(new java.awt.Color(176, 196, 222));
        healthLabel.setText("100");
        getContentPane().add(healthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 50, 20));

        alcoholLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        alcoholLabel.setForeground(new java.awt.Color(176, 196, 222));
        alcoholLabel.setText("0");
        getContentPane().add(alcoholLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 40, 20));

        poisonLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        poisonLabel.setForeground(new java.awt.Color(176, 196, 222));
        poisonLabel.setText("0");
        getContentPane().add(poisonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, 40, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(176, 196, 222));
        jLabel7.setText("STATE :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, -1, -1));

        stateLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        stateLabel.setForeground(new java.awt.Color(176, 196, 222));
        stateLabel.setText("Sober");
        getContentPane().add(stateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 690, 100, -1));

        nickNameLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nickNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nickNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 150, 30));

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/game.png"))); // NOI18N
        jButton1.setText("New Game");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        alcBar.setForeground(new java.awt.Color(255, 255, 0));
        alcBar.setMaximum(50);
        alcBar.setFocusable(false);
        getContentPane().add(alcBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, 30));

        heaBar.setForeground(new java.awt.Color(0, 204, 0));
        heaBar.setMaximum(210);
        heaBar.setToolTipText("");
        heaBar.setValue(100);
        heaBar.setFocusable(false);
        getContentPane().add(heaBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, 30));

        poiBar.setForeground(new java.awt.Color(255, 0, 0));
        poiBar.setMaximum(3);
        poiBar.setFocusable(false);
        getContentPane().add(poiBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/background nature.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //This button close the program
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed

    //This button is to open setting view
    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        Setting_View view = new Setting_View(row, column, cube, name);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        dispose();
    }//GEN-LAST:event_settingsButtonActionPerformed

    //This method is to call move method
    private void jLabelPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabelPanelKeyPressed
        if (ant.getState() != "Dead") {
            if (ant.getState() != "Winner") {
                if (ant.getAlcohol() >= 10) {
                    if (evt.getKeyCode() == 37 || evt.getKeyCode() == 38 || evt.getKeyCode() == 39 || evt.getKeyCode() == 40) {
                        ant.HipMoveAnt();
                        movementsAnt();
                        setTexts();
                        bus = true;

                        return;
                    }
                }

                if (ant.moveAnt(evt.getKeyCode())) {
                    movementsAnt();
                    setTexts();
                    return;
                } else {
                    errorSound();
                    setTexts();
                    return;
                }

            }
        }

    }//GEN-LAST:event_jLabelPanelKeyPressed

    //This button is to open new game
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Game_View view = new Game_View(row, column, cube, name);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dispose();
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    //This method is to create labels
    public void labels() {
        int x = 0;
        int y = 0;

        for (int rows = 0; rows < row; rows++) {
            for (int columns = 0; columns < column; columns++) {
                if (rows == 0 & columns == 0) {
                    labelsLogic[rows][columns] = 1;
                    logicF[rows][columns] = 10;
                } else if (rows == row - 1 & columns == column - 1) {
                    labelsLogic[rows][columns] = 2;
                    logicF[rows][columns] = 10;
                } else {
                    labelsLogic[rows][columns] = 0;
                    logicF[rows][columns] = 0;
                }
                labels[rows][columns] = new Label1(x, y, 67, 65);
                labels[rows][columns].setBorder(border);
                labels[rows][columns].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fondoC.jpg")));
                jLabelPanel.add(labels[rows][columns]);
                x += 67;//-

            }
            y += 65;// |
            x = 0;
        }
        //Change the first position
        labels[0][0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/rigt.jpg")));
        //Chage the last position
        labels[row - 1][column - 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/meta1.jpg")));
    }

    //This method is to delete background
    public void remove_backGround() {
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorder(null);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorder(null);
        jLabelPanel.setFocusable(true);
        jLabelPanel.setOpaque(false);
        nickNameLabel.setText(name);
        setIconImage(new ImageIcon(getClass().getResource("../icones/game.png")).getImage());

    }

    //This method is to play error sound
    public void errorSound() {
        alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/error.wav"));
        alert.play();
    }

    //This method is to set movements
    public void movementsAnt() {
        movements++;
    }

    //This method is to set Text and set Bar
    public void setTexts() {
        if (ant.getHealth() == 0) {
            stateLabel.setText("DEAD");
        }
        healthLabel.setText(String.valueOf(ant.getHealth()));
        heaBar.setValue(ant.getHealth());

        if (ant.getAlcohol() >= 50) {
            stateLabel.setText("DEAD");
        }
        alcoholLabel.setText(String.valueOf(ant.getAlcohol()));
        alcBar.setValue(ant.getAlcohol());
        stateLabel.setText(ant.getState());
        if (ant.getState() == "Poisoned") {
            poisonLabel.setText(String.valueOf(ant.getPoison()));
            poiBar.setValue(ant.getPoison());
        }
        alert = java.applet.Applet.newAudioClip(getClass().getResource("/icones/move.WAV"));
        alert.play();

        if (ant.getState().equals("Dead") || ant.getState().equals("Winner")) {
            FinalView view = new FinalView(row, column, cube, name, movements);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
    }

    //This method is to create random cubes
    public void random() {
        int l = 1;
        int p = 1;
        int j = 1;
        //Is to create sugar cubes
        while (l <= cube) {
            int w = (int) (Math.random() * row) + 0;
            int i = (int) (Math.random() * column) + 0;
            if (labelsLogic[w][i] == 0) {
                labelsLogic[w][i] = 3; //Sugar
                logicF[w][i] = 3;
                l++;
            }
        }
        //Is to create alcohol cubes
        while (p <= cube) {
            int w = (int) (Math.random() * row) + 0;
            int i = (int) (Math.random() * column) + 0;
            if (labelsLogic[w][i] == 0) {
                labelsLogic[w][i] = 4; //Alcohol
                logicF[w][i] = 4;
                p++;
            }
        }
        //Is to create poison cubes
        while (j <= cube) {
            int w = (int) (Math.random() * row) + 0;
            int i = (int) (Math.random() * column) + 0;
            if (labelsLogic[w][i] == 0) {
                labelsLogic[w][i] = 5; //Poison
                logicF[w][i] = 5;
                j++;
            }
        }
    }


    //This method is to set all Atributes
    public void setAtri() {
        ant.setAlcohol(0);
        ant.setRow(row);
        ant.setColumn(column);
        ant.setHealth(100);
        ant.setMoveX(new ArrayList());
        ant.setMoveY(new ArrayList());
        ant.setState("Sober");
        ant.setPoison(3);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game_View(0, 0, 0, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar alcBar;
    private javax.swing.JLabel alcoholLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JProgressBar heaBar;
    private javax.swing.JLabel healthLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jLabelPanel;
    private javax.swing.JLabel nickNameLabel;
    private javax.swing.JProgressBar poiBar;
    private javax.swing.JLabel poisonLabel;
    private javax.swing.JButton settingsButton;
    private javax.swing.JLabel stateLabel;
    // End of variables declaration//GEN-END:variables

}
