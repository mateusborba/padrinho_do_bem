/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package padrinhodobem.view.necessidade;

import padrinhodobem.view.crianca.*;
import padrinhodobem.entity.Crianca;
import padrinhodobem.Dao.UserDao;
import padrinhodobem.Dao.DaoInterface;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import padrinhodobem.Dao.CriancaDao;
import padrinhodobem.Dao.NecessidadeDao;
import padrinhodobem.entity.Necessidade;

/**
 *
 * @author herbert
 */
public class NecessidadeDashboardView extends javax.swing.JPanel {

    public Necessidade selectedNecessidade;
    
    NecessidadeDao necessidadeDao;

    
    private void updateTableData() {
        
        selectedNecessidade = null;
        
        jButtonEdit.setEnabled(selectedNecessidade != null);
        jButtonDelete.setEnabled(selectedNecessidade != null);
        
        var modelo = ((DefaultTableModel) jTable_necessidades.getModel());
        
        modelo.setRowCount(0);
                
        
        necessidadeDao = new NecessidadeDao();
        
        CriancaDao criancaDb = new CriancaDao();
       
        
        try {
           var necessidadeList =  necessidadeDao.getAll();
            
            for (int i = 0; i < necessidadeList.size(); i++) {
                Necessidade necessidade = necessidadeList.get(i);
                
                var crianca = criancaDb.get(necessidade.GetCriancaId());
                
                modelo.addRow(new Object[]{
                    necessidade.getId(),
                    necessidade.getTipo(),
                    crianca.get().getNome(),
                });
            }
           
        } catch (Exception ex) {
            Logger.getLogger(NecessidadeDashboardView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    /**
     * Creates new form UsuarioCrud
     */
    public NecessidadeDashboardView() {
        initComponents();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object [][] {},
            new String [] {
                "ID", "Tipo", "Nome Criança"
            }){
            
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
            
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            
            
        };
        
        jTable_necessidades.setModel(modelo);
        jTable_necessidades.getColumnModel().getColumn(0).setMaxWidth(100);  

        jTable_necessidades.doLayout(); // ToDo Isso faz alguma coisa?
        
        updateTableData();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_necessidades = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonAddUser = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonAddUser1 = new javax.swing.JButton();

        jTable_necessidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_necessidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_necessidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_necessidades);

        jPanel1.setPreferredSize(new java.awt.Dimension(102, 200));

        jButtonAddUser.setText("Adicionar");
        jButtonAddUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddUserActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Editar");
        jButtonEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Deletar");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonAddUser1.setText("Atualizar");
        jButtonAddUser1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddUser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(jButtonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAddUser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAddUser1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddUserActionPerformed
        NecessidadeEditorView editor = new NecessidadeEditorView();
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        editor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        editor.addWindowListener(new WindowAdapter(){
            public void windowClosed(WindowEvent e){
                topFrame.setEnabled(true);
                updateTableData();
            }
        });
        
        editor.setVisible(true);
        editor.requestFocus();
        
        topFrame.setEnabled(false);
        
    }//GEN-LAST:event_jButtonAddUserActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        NecessidadeDao db = new NecessidadeDao();
        
        try {
            db.delete(selectedNecessidade);
            JOptionPane.showMessageDialog(null, "Necessidade deletada com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar o necessidade!", "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(NecessidadeDashboardView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        updateTableData();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTable_necessidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_necessidadesMouseClicked
        // TODO add your handling code here:
        
//        System.out.println(jTable_criancas.getSelectedRow() + 1);
        
        int id = (int)jTable_necessidades.getValueAt(jTable_necessidades.getSelectedRow(), 0);
        
        
        try {
            var result = necessidadeDao.get(id);
            
            if(result.isPresent()){
                selectedNecessidade = result.get();
            }
        } catch (Exception ex) {
            Logger.getLogger(NecessidadeDashboardView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        jButtonEdit.setEnabled(selectedNecessidade != null);
        jButtonDelete.setEnabled(selectedNecessidade != null);

    }//GEN-LAST:event_jTable_necessidadesMouseClicked

    private void jButtonAddUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddUser1ActionPerformed
        updateTableData();
    }//GEN-LAST:event_jButtonAddUser1ActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        NecessidadeEditorView editor = new NecessidadeEditorView(selectedNecessidade);
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        editor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        editor.addWindowListener(new WindowAdapter(){
            public void windowClosed(WindowEvent e){
                topFrame.setEnabled(true);
                updateTableData();
            }
        });
        
        editor.setVisible(true);
        editor.requestFocus();
        
        topFrame.setEnabled(false);
    }//GEN-LAST:event_jButtonEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddUser;
    private javax.swing.JButton jButtonAddUser1;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_necessidades;
    // End of variables declaration//GEN-END:variables
}
