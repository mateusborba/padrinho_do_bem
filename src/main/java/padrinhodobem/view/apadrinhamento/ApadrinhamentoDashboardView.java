/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package padrinhodobem.view.apadrinhamento;

import padrinhodobem.view.necessidade.*;
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
import padrinhodobem.Dao.ApadrinhamentoDao;
import padrinhodobem.Dao.CriancaDao;
import padrinhodobem.Dao.NecessidadeDao;
import padrinhodobem.entity.Apadrinhamento;
import padrinhodobem.entity.Necessidade;
import padrinhodobem.entity.Usuario;

/**
 *
 * @author herbert
 */
public class ApadrinhamentoDashboardView extends javax.swing.JPanel {

    public Apadrinhamento selectedApadrinhamento;
    
    ApadrinhamentoDao apadrinhamentoDao;
    
    public Usuario usuarioLogado;
    
    public void updateTableData() {
        
        selectedApadrinhamento = null;

        
        var modelo = ((DefaultTableModel) jTable_apadrinhamento.getModel());
        
        modelo.setRowCount(0);
                
        
        apadrinhamentoDao = new ApadrinhamentoDao();
        
        CriancaDao criancaDb = new CriancaDao();
        NecessidadeDao necessidadeDb = new NecessidadeDao();

        try {
           var apadrinhamentoList =  apadrinhamentoDao.getApadrinhamentosUsuario(usuarioLogado);
            
            for (Apadrinhamento apadrinhamento: apadrinhamentoList) {
                
                var crianca = criancaDb.get(apadrinhamento.getCriancaId()).get();
                
                var necessidade = necessidadeDb.get(apadrinhamento.getNecessidadeId()).get();


                modelo.addRow(new Object[]{
                    apadrinhamento.getId(),
                    apadrinhamento.getTempoString(),
                    crianca.getNome(),
                    necessidade.getTipo()
                });
            }
           
        } catch (Exception ex) {
            Logger.getLogger(ApadrinhamentoDashboardView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    /**
     * Creates new form UsuarioCrud
     */
    public ApadrinhamentoDashboardView(Usuario usuario) {
        initComponents();
        
        this.usuarioLogado = usuario;
        
        DefaultTableModel modelo = new DefaultTableModel(new Object [][] {},
            new String [] {
                "ID", "Período ", "Nome Criança", "Tipo de apadrinhamento"
            }){
            
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class,  java.lang.String.class
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
        
        jTable_apadrinhamento.setModel(modelo);
        jTable_apadrinhamento.getColumnModel().getColumn(0).setMaxWidth(100);  

        jTable_apadrinhamento.doLayout(); // ToDo Isso faz alguma coisa?
        
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
        jTable_apadrinhamento = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonAddUser1 = new javax.swing.JButton();

        jTable_apadrinhamento.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_apadrinhamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_apadrinhamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_apadrinhamento);

        jPanel1.setPreferredSize(new java.awt.Dimension(102, 200));

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
                .addComponent(jButtonAddUser1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAddUser1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jTable_apadrinhamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_apadrinhamentoMouseClicked
        // TODO add your handling code here:
        
//        System.out.println(jTable_criancas.getSelectedRow() + 1);
        
        int id = (int)jTable_apadrinhamento.getValueAt(jTable_apadrinhamento.getSelectedRow(), 0);
        
        
        try {
            var result = apadrinhamentoDao.get(id);
            
            if(result.isPresent()){
                selectedApadrinhamento = result.get();
            }
        } catch (Exception ex) {
            Logger.getLogger(ApadrinhamentoDashboardView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
   

    }//GEN-LAST:event_jTable_apadrinhamentoMouseClicked

    private void jButtonAddUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddUser1ActionPerformed
        updateTableData();
    }//GEN-LAST:event_jButtonAddUser1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddUser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_apadrinhamento;
    // End of variables declaration//GEN-END:variables
}
