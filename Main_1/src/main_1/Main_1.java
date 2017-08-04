/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_1;

import javax.swing.JFrame;

/**
 *
 * @author pc
 */
public class Main_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main_View view = new Main_View();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
}
