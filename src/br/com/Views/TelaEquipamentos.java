package br.com.Views;

import br.com.DAO.ClienteDAO;
import br.com.DAO.ConexaoDAO;
import br.com.DTO.EquipamentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaEquipamentos extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaEquipamentos() {
        initComponents();
        conexao = ConexaoDAO.conector();
    }

    public void pesquisarEquipamentoNormal() {
        String sql = "select * from equipamento where id_equipamento = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdEquipamento.getText());
            rs = pst.executeQuery();

        if (rs.next()) {
            txtModelo.setText(rs.getString(2));
            txtFabricante.setText(rs.getString(3));
            txtNSerie.setText(rs.getString(4));
            txtStatus.setText(rs.getString(5));
            txtGarantia.setText(rs.getString(6));
            
        } else {
                JOptionPane.showMessageDialog(null, "Usuario não cadastrado!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Metodo pesquisar " + e);
        }
    }
    
    
    
    public void pesquisarEquipamento() {
        String sql = "select * from equipamento where id_equipamento = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdPesquisar.getText());
            rs = pst.executeQuery();

            tbEquipamento.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Metodo pesquisar " + e);
        }
    }

    public void setarCampos() {
        int setar = tbEquipamento.getSelectedRow();
        txtModelo.setText(tbEquipamento.getModel().getValueAt(setar, 1).toString());
        txtFabricante.setText(tbEquipamento.getModel().getValueAt(setar, 2).toString());
        txtNSerie.setText(tbEquipamento.getModel().getValueAt(setar, 3).toString());
        txtStatus.setText(tbEquipamento.getModel().getValueAt(setar, 4).toString());
        txtGarantia.setText(tbEquipamento.getModel().getValueAt(setar, 5).toString());
    }

    public void limpar() {
        txtFabricante.setText(null);
        txtGarantia.setText(null);
        txtIdEquipamento.setText(null);
        txtModelo.setText(null);
        txtStatus.setText(null);
        txtNSerie.setText(null);
        txtFabricante.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtFabricante = new javax.swing.JTextField();
        txtNSerie = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtGarantia = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbEquipamento = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtIdPesquisar = new javax.swing.JTextField();
        txtIdEquipamento = new javax.swing.JTextField();
        btnPesquisarNormal = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID do equipamento");

        jLabel2.setText("Modelo");

        jLabel3.setText("Fabricante");

        jLabel4.setText("N° de Serie");

        jLabel5.setText("Status");

        jLabel6.setText("Garantia");

        btnEditar.setText("editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnDeletar.setText("deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        tbEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID equipamento", "Modelo", "Fabricante", "N° de Serie", "Status", "Garantia"
            }
        ));
        tbEquipamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEquipamentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbEquipamento);

        jLabel7.setText("Digite o id que voce quer pesquisar na tabela");

        txtIdPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdPesquisarKeyReleased(evt);
            }
        });

        txtIdEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEquipamentoActionPerformed(evt);
            }
        });

        btnPesquisarNormal.setText("Pesquisar");
        btnPesquisarNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarNormalActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnVoltar.setText("voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeletar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFabricante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNSerie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(83, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnPesquisarNormal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisarNormal)
                        .addComponent(btnVoltar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnAdicionar)
                    .addComponent(btnDeletar)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String id_equipamento = txtIdEquipamento.getText();
        String modelo = txtModelo.getText();
        String fabricante = txtFabricante.getText();
        String numeroSerie = txtNSerie.getText();
        String statusEquipamento = txtStatus.getText();
        String garantia = txtGarantia.getText();

        EquipamentoDTO objDTO = new EquipamentoDTO();
        objDTO.setId_equipamento(Integer.parseInt(id_equipamento));
        objDTO.setModelo(modelo);
        objDTO.setFabricante(fabricante);
        objDTO.setNumeroSerie(numeroSerie);
        objDTO.setStatusEquipamento(statusEquipamento);
        objDTO.setGarantia(garantia);

        ClienteDAO objEquipamentoDAO = new ClienteDAO();
        objEquipamentoDAO.editarEquipamento(objDTO);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String modelo = txtModelo.getText();
        String fabricante = txtFabricante.getText();
        String numeroSerie = txtNSerie.getText();
        String statusEquipamento = txtStatus.getText();
        String garantia = txtGarantia.getText();

        EquipamentoDTO objDTO = new EquipamentoDTO();
        objDTO.id_equipamento = Integer.parseInt(txtIdEquipamento.getText());
        objDTO.setModelo(modelo);
        objDTO.setFabricante(fabricante);
        objDTO.setNumeroSerie(numeroSerie);
        objDTO.setStatusEquipamento(statusEquipamento);
        objDTO.setGarantia(garantia);

        ClienteDAO objEquipamentoDAO = new ClienteDAO();
        boolean inserir = objEquipamentoDAO.inserirEquipamento(objDTO);

        if (inserir) {
            JOptionPane.showMessageDialog(null, "O Equipamento foi inserido com sucesso ");
            limpar();
        } else {
            JOptionPane.showMessageDialog(null, "O Equipamento não foi inserido");
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        String id_equipamento = txtIdEquipamento.getText();

        EquipamentoDTO objDTO = new EquipamentoDTO();
        objDTO.setId_equipamento(Integer.parseInt(id_equipamento));

        ClienteDAO objEquipamentoDAO = new ClienteDAO();
        objEquipamentoDAO.deletarEquipamento(objDTO);
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtIdPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdPesquisarKeyReleased
        pesquisarEquipamento();
    }//GEN-LAST:event_txtIdPesquisarKeyReleased

    private void tbEquipamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEquipamentoMouseClicked

    }//GEN-LAST:event_tbEquipamentoMouseClicked

    private void txtIdEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEquipamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEquipamentoActionPerformed

    private void btnPesquisarNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarNormalActionPerformed
        pesquisarEquipamentoNormal();
    }//GEN-LAST:event_btnPesquisarNormalActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
         TelaPrincipal tPrincipal = new TelaPrincipal();
        tPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEquipamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEquipamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEquipamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEquipamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEquipamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisarNormal;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbEquipamento;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtIdEquipamento;
    private javax.swing.JTextField txtIdPesquisar;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNSerie;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
