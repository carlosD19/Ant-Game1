/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.io.IOException;
import view.Game_View;
import javax.swing.JFrame;
import view.NewGame;

/**
 *
 * @author pc
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        createFile();
        //Open the New Game view
        NewGame view = new NewGame();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    //This Method is to create a file
    public static void createFile(){
        File file;
        try{
            file = new File("Setting.txt");
            if (file.createNewFile()){
                System.out.println("File was create");
            }
        }
        catch(IOException e){
            System.out.println("File wasn´t create" + e);
        }
    }
    
}
