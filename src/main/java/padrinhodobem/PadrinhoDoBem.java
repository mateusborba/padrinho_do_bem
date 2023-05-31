/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package padrinhodobem;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import padrinhodobem.view.Login;

/**
 *
 * @author infra
 */
public class PadrinhoDoBem {

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        
//        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//            
//                System.out.println(info.getName());
//                
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        JOptionPane.showConfirmDialog(null, "oi");
        
        Login lg = new Login();
        lg.setVisible(true);

        System.out.println("Hello World!");
    }
}
