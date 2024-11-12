package br.com.DAO;

import br.com.DTO.LaboratorioDTO;
import br.com.DTO.PecaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LaboratorioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void deletarLab(LaboratorioDTO objDTO) {
        String sql = "DELETE l, e FROM laboratorio l "
                + "JOIN equipamento e ON l.id_equipamento = e.id_equipamento "
                + "WHERE l.id_laboratorio = ?";

        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objDTO.getIdLaboratorio());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Equipamento excluído com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método apagar: " + e);
            e.printStackTrace(); // Para depuração
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e);
            }
        }

    }

    public void editarLab(LaboratorioDTO objDTO) {

        String sql = "UPDATE laboratorio l "
                + "JOIN equipamento e ON l.id_equipamento = e.id_equipamento "
                + "SET l.numeroDaSala = ?, e.modelo = ?, e.numeroSerie = ?, e.statusEquipamento = ? "
                + "WHERE l.id_laboratorio = ?";

        try {

            conexao = ConexaoDAO.conector();

            pst = conexao.prepareStatement(sql);

            pst.setString(1, objDTO.getnSala());
            pst.setString(2, objDTO.getModelo());
            pst.setString(3, objDTO.getNumeroSerie());
            pst.setString(4, objDTO.getStatusEquipamento());
            pst.setInt(5, objDTO.getIdLaboratorio());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Laboratório e Equipamento atualizados com sucesso!");
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
