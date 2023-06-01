/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package padrinhodobem.view;

/**
 *
 * @author herbert
 */
public class AdminDashboard extends javax.swing.JFrame {
    

    /**
     * Creates new form DashboardUsuario
     * 
     * 
     */
    public AdminDashboard() {
        initComponents();
        this.setTitle("Usuários");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        usuarioCrud1 = new padrinhodobem.view.usuario.UserDashboardView();
        criancaDashboardView1 = new padrinhodobem.view.crianca.CriancaDashboardView();
        necessidadeDashboardView1 = new padrinhodobem.view.necessidade.NecessidadeDashboardView();
        usuarioCrud4 = new padrinhodobem.view.usuario.UserDashboardView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.addTab("Usuários", usuarioCrud1);
        jTabbedPane1.addTab("Criança", criancaDashboardView1);
        jTabbedPane1.addTab("Necessidade", necessidadeDashboardView1);
        jTabbedPane1.addTab("Apadrinhamentos", usuarioCrud4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Usuários");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private padrinhodobem.view.crianca.CriancaDashboardView criancaDashboardView1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private padrinhodobem.view.necessidade.NecessidadeDashboardView necessidadeDashboardView1;
    private padrinhodobem.view.usuario.UserDashboardView usuarioCrud1;
    private padrinhodobem.view.usuario.UserDashboardView usuarioCrud4;
    // End of variables declaration//GEN-END:variables
}
