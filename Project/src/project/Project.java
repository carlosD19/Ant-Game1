/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import view.Game_View;
import javax.swing.JFrame;

/**
 *
 * @author pc
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game_View view = new Game_View(12,22,5);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
}
