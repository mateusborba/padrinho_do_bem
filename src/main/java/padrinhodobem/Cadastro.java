/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package padrinhodobem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import padrinhodobem.utils.ValidadorCPF;
import padrinhodobem.utils.ValidadorEmail;

/**
 *
 * @author mundo
 */
public class Cadastro extends javax.swing.JFrame {
    
     private boolean passwordStatus = false;

    /**
     * Creates new form Login
     */
    public Cadastro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tituloModal = new javax.swing.JLabel();
        botaoCadastro = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        inputNome = new javax.swing.JTextField();
        inputEmail = new javax.swing.JTextField();
        inputCPF = new javax.swing.JTextField();
        jPanelPassword = new javax.swing.JPanel();
        jPanelPassProgress = new javax.swing.JPanel();
        inputSenha = new javax.swing.JPasswordField();
        botaoToggle = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        jTextField1.setText("jTextField1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        tituloModal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tituloModal.setForeground(new java.awt.Color(255, 255, 255));
        tituloModal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloModal.setText("TELA DE CADASTRO");

        botaoCadastro.setText("CADASTRO");
        botaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastroActionPerformed(evt);
            }
        });

        botaoSair.setText("SAIR");

        inputNome.setBackground(new java.awt.Color(153, 153, 255));
        inputNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        inputEmail.setBackground(new java.awt.Color(153, 153, 255));
        inputEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        inputCPF.setBackground(new java.awt.Color(153, 153, 255));
        inputCPF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanelPassword.setBackground(new java.awt.Color(153, 153, 255));
        jPanelPassword.setLayout(new javax.swing.BoxLayout(jPanelPassword, javax.swing.BoxLayout.LINE_AXIS));

        jPanelPassProgress.setLayout(new javax.swing.BoxLayout(jPanelPassProgress, javax.swing.BoxLayout.PAGE_AXIS));
        jPanelPassword.add(jPanelPassProgress);

        inputSenha.setBackground(new java.awt.Color(153, 153, 255));
        inputSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        inputSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSenhaActionPerformed(evt);
            }
        });
        inputSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputSenhaKeyTyped(evt);
            }
        });
        jPanelPassword.add(inputSenha);

        botaoToggle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/padrinhodobem/eye.png"))); // NOI18N
        botaoToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoToggleActionPerformed(evt);
            }
        });
        jPanelPassword.add(botaoToggle);

        jProgressBar1.setForeground(new java.awt.Color(255, 102, 102));
        jProgressBar1.setValue(70);
        jProgressBar1.setBorderPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloModal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputNome)
                        .addComponent(inputCPF)
                        .addComponent(inputEmail)
                        .addComponent(jPanelPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(botaoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(tituloModal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSenhaActionPerformed
        jProgressBar1.setValue(inputSenha.getPassword().length);
    }//GEN-LAST:event_inputSenhaActionPerformed

    private void inputSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputSenhaKeyTyped
        jProgressBar1.setValue(inputSenha.getPassword().length * 11);
    }//GEN-LAST:event_inputSenhaKeyTyped

    private void botaoToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoToggleActionPerformed
        passwordStatus = !passwordStatus;

        inputSenha.setEchoChar((passwordStatus)? (char)0 : '*');

    }//GEN-LAST:event_botaoToggleActionPerformed

    
    private void botaoCadastroActionPerformed(java.awt.event.ActionEvent evt){
        String novaSenha = String.copyValueOf(this.inputSenha.getPassword());
        String novoCpf = inputCPF.getText();
        String novoNome = inputNome.getText();
        String novoEmail = inputEmail.getText();
        
        
        // ToDo: Validar o CPF, Email e Senha
        if(! ValidadorCPF.validarCPF(novoCpf)){
            JOptionPane.showMessageDialog(null,"CPF Invalido, verifique e tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!ValidadorEmail.validarEmail(novoEmail)){
            JOptionPane.showMessageDialog(null,"e-mail Invalido, verifique e tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(novaSenha.length() < 5) {
            JOptionPane.showMessageDialog(null,"Senha Invalida, tente uma senha mais segura !", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Usuario novoUsuario = new Usuario(novoEmail, novoCpf, novoNome, novaSenha);
 
        UsuarioDao db =  new UsuarioDao();       
        try {
            Login login = new Login();
            db.save(novoUsuario);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            login.setCredencial(novoCpf, novaSenha);
            login.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados do usuario no banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(UsuarioEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
    };
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastro;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoToggle;
    private javax.swing.JTextField inputCPF;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputNome;
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelPassProgress;
    private javax.swing.JPanel jPanelPassword;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel tituloModal;
    // End of variables declaration//GEN-END:variables
}
