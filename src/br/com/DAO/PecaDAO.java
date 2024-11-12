package br.com.DAO;

import br.com.DTO.PecaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class PecaDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public PecaDAO() {
        conexao = ConexaoDAO.conector();
    }

    public void editarPeca(PecaDTO objDTO) {
        String sql = "UPDATE pecas SET nomePecas = ?, quantidadePecas = ?, tipoPecas = ? WHERE id_pecas = ?";
        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);

            pst.setString(1, objDTO.getNomePecas());
            pst.setString(2, objDTO.getQuantidadePecas());
            pst.setString(3, objDTO.getTipoPecas());
            pst.setInt(4, objDTO.getId_peca());
            int add = pst.executeUpdate();
            System.out.println(pst);
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Peça atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Nenhum dado foi atualizado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

}
