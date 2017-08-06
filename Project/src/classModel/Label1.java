
package classModel;


import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author pc
 */
public class Label1 extends JLabel {
    
    public Label1(int posX, int posY, int ancho, int largo){
        setBounds(posX, posY, ancho, largo);
        
    }
     
}
