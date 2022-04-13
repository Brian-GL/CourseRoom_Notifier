/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package courseroom_notifier;

import com.formdev.flatlaf.FlatDarkLaf;
import frames.CourseRoom_Notifier_Frame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author LENOVO
 */
public class CourseRoom_Notifier {

    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatDarkLaf ui = new FlatDarkLaf();
        UIManager.setLookAndFeel(ui);
        CourseRoom_Notifier_Frame principal_Frame = new CourseRoom_Notifier_Frame();
        principal_Frame.setVisible(true);
    }
    
}
