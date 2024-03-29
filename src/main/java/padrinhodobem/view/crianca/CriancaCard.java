/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package padrinhodobem.view.crianca;

import padrinhodobem.entity.Crianca;
import padrinhodobem.entity.Usuario;

/**
 *
 * @author mundo
 */
public class CriancaCard extends javax.swing.JPanel {
    
  private Usuario usuarioLogado;
  private Crianca crianca;

    /**
     * Creates new form CriancaCard
     */
    public CriancaCard(Crianca crianca, Usuario usuario) {
        
        this.crianca = crianca;
        this.usuarioLogado = usuario;
        
        initComponents();
        
                
        labelNome.setText("Nome: " + crianca.getNome());
        labelIdade.setText("Idade: " + String.valueOf(crianca.getIdade()));
        labelLocal.setText("Local: " + crianca.getLocal());

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
        jList1 = new javax.swing.JList<>();
        labelNome = new javax.swing.JLabel();
        labelIdade = new javax.swing.JLabel();
        labelLocal = new javax.swing.JLabel();
        botaoDetalhes = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setMaximumSize(new java.awt.Dimension(302, 207));
        setMinimumSize(new java.awt.Dimension(302, 207));

        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome.setText("NOME");

        labelIdade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIdade.setText("IDADE");

        labelLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLocal.setText("LOCAL");

        botaoDetalhes.setText("Ver detalhes...");
        botaoDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDetalhesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(labelIdade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(labelIdade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(labelLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(botaoDetalhes)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDetalhesActionPerformed
       
       CriancaDetalhe detalhe = new CriancaDetalhe(crianca, usuarioLogado);

       detalhe.setVisible(true);
    }//GEN-LAST:event_botaoDetalhesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoDetalhes;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIdade;
    private javax.swing.JLabel labelLocal;
    private javax.swing.JLabel labelNome;
    // End of variables declaration//GEN-END:variables
}
