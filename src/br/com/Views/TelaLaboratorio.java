package br.com.Views;

import br.com.DAO.ConexaoDAO;
import br.com.DAO.LaboratorioDAO;
import br.com.DTO.LaboratorioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaLaboratorio extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaLaboratorio() {
        initComponents();
        conexao = ConexaoDAO.conector();
    }

    // Método para pesquisar um laboratório específico
public void pesquisarLaboratorioPorId(int idLaboratorio) {
    String sql = "SELECT l.nome AS Laboratório, "
            + "COUNT(m.id_maquina) AS quantidade_maquinas, "
            + "SUM(CASE WHEN m.status = 'funcionando' THEN 1 ELSE 0 END) AS maquinas_funcionando, "
            + "SUM(CASE WHEN m.status = 'em_manutencao' THEN 1 ELSE 0 END) AS maquinas_em_manutencao, "
            + "SUM(CASE WHEN m.status = 'fora_de_uso' THEN 1 ELSE 0 END) AS maquinas_fora_de_uso "
            + "FROM laboratorios l "
            + "LEFT JOIN maquinas m ON l.id_laboratorio = m.id_laboratorio "
            + "WHERE l.id_laboratorio = ? "
            + "GROUP BY l.id_laboratorio, l.nome";

    try {
        // Conectando ao banco
        conexao = ConexaoDAO.conector();
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, idLaboratorio); // Definindo o id do laboratório na consulta
        rs = pst.executeQuery();

        if (rs.next()) {
            // Exibindo os dados no formulário
            txtNSala.setText(rs.getString("Laboratório"));
            txtQtdMaquina.setText(rs.getString("quantidade_maquinas"));
            txtMaquinasFuncionando.setText(rs.getString("maquinas_funcionando"));
            txtMaquinasManutencao.setText(rs.getString("maquinas_em_manutencao"));
            txtMaquinasForaUso.setText(rs.getString("maquinas_fora_de_uso"));
        } else {
            JOptionPane.showMessageDialog(null, "Laboratório não encontrado!");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao pesquisar laboratório: " + e);
    }
}   


    private void pesquisarEquipamentoTabela() {
    String sql = "SELECT l.nome AS Laboratório, "
               + "COUNT(m.id_maquina) AS quantidade_maquinas, "
               + "SUM(CASE WHEN m.status = 'funcionando' THEN 1 ELSE 0 END) AS maquinas_funcionando, "
               + "SUM(CASE WHEN m.status = 'em_manutencao' THEN 1 ELSE 0 END) AS maquinas_em_manutencao, "
               + "SUM(CASE WHEN m.status = 'fora_de_uso' THEN 1 ELSE 0 END) AS maquinas_fora_de_uso "
               + "FROM laboratorios l "
               + "LEFT JOIN maquinas m ON l.id_laboratorio = m.id_laboratorio "
               + "GROUP BY l.id_laboratorio, l.nome "
               + "ORDER BY quantidade_maquinas DESC";

    try {
        pst = conexao.prepareStatement(sql);

        rs = pst.executeQuery();

        tbLaboratorio.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao pesquisar equipamentos: " + e.getMessage());
    }
}

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNumerolab = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLaboratorio = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdLab = new javax.swing.JTextField();
        txtNSala = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtQtdMaquina = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaquinasFuncionando = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaquinasManutencao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaquinasForaUso = new javax.swing.JTextField();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID Laboratorio tabela");

        txtNumerolab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumerolabActionPerformed(evt);
            }
        });
        txtNumerolab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumerolabKeyReleased(evt);
            }
        });

        tbLaboratorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Laboratorio", "Quantidade Maquinas", "Maquinas Funcionando", "Maquinas em Manutenção", "Maquinas Fora de Uso"
            }
        ));
        jScrollPane1.setViewportView(tbLaboratorio);

        jLabel2.setText("ID Laboratorio");

        jLabel3.setText("Labin");

        txtIdLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdLabActionPerformed(evt);
            }
        });

        txtNSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNSalaActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade Maquinas");

        txtQtdMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdMaquinaActionPerformed(evt);
            }
        });

        jLabel5.setText("Maquinas Funcionando");

        txtMaquinasFuncionando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaquinasFuncionandoActionPerformed(evt);
            }
        });

        jLabel6.setText("Maquinas em Manutenção");

        jLabel7.setText("Maquinas Fora de Uso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNumerolab, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdLab, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNSala, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPesquisar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(32, 32, 32)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtQtdMaquina)
                                        .addComponent(txtMaquinasFuncionando, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMaquinasManutencao, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addComponent(txtMaquinasForaUso)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQtdMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaquinasFuncionando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaquinasManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaquinasForaUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnEditar)
                    .addComponent(btnLimpar))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumerolab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumerolabKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumerolabKeyReleased
        pesquisarEquipamentoTabela();
    }//GEN-LAST:event_txtNumerolabKeyReleased

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        int idLab = Integer.parseInt(txtIdLab.getText()); // Campo onde o usuário informa o ID
    pesquisarLaboratorioPorId(idLab);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    
       // Pega os dados dos campos de texto
String idLaboratorio = txtIdLab.getText();
    String nomeLaboratorio = txtNSala.getText();
    String quantidadeMaquinas = txtQtdMaquina.getText();
    String maquinasFuncionando = txtMaquinasFuncionando.getText();
    String maquinasManutencao = txtMaquinasManutencao.getText();
    String maquinasForaUso = txtMaquinasForaUso.getText();

    LaboratorioDTO objDTO = new LaboratorioDTO();
    objDTO.setIdLaboratorio(Integer.parseInt(idLaboratorio));
    objDTO.setnSala(nomeLaboratorio);
    objDTO.setQuantidadeMaquinas(quantidadeMaquinas);
    objDTO.setMaquinasFuncionando(maquinasFuncionando);
    objDTO.setMaquinasManutencao(maquinasManutencao);
    objDTO.setMaquinasForaUso(maquinasForaUso);

    LaboratorioDAO labDAO = new LaboratorioDAO();
    labDAO.editarLab(objDTO);


    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtIdLab.setText(null);
        txtQtdMaquina.setText(null);
        txtNSala.setText(null);
        txtMaquinasForaUso.setText(null);
        txtNumerolab.setText(null);
        txtMaquinasFuncionando.setText(null);
        txtMaquinasManutencao.setText(null);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaPrincipal tPrincipal = new TelaPrincipal();
        tPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNumerolabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumerolabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumerolabActionPerformed

    private void txtNSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNSalaActionPerformed

    private void txtIdLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdLabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdLabActionPerformed

    private void txtQtdMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdMaquinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdMaquinaActionPerformed

    private void txtMaquinasFuncionandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaquinasFuncionandoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaquinasFuncionandoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLaboratorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLaboratorio;
    private javax.swing.JTextField txtIdLab;
    private javax.swing.JTextField txtMaquinasForaUso;
    private javax.swing.JTextField txtMaquinasFuncionando;
    private javax.swing.JTextField txtMaquinasManutencao;
    private javax.swing.JTextField txtNSala;
    private javax.swing.JTextField txtNumerolab;
    private javax.swing.JTextField txtQtdMaquina;
    // End of variables declaration//GEN-END:variables
}
