/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package padrinhodobem;

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            
                System.out.println(info.getName());
                
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//        JOptionPane.showConfirmDialog(null, "oi");
        
        Login lg = new Login();
        lg.setVisible(true);

        System.out.println("Hello World!");
    }
}
