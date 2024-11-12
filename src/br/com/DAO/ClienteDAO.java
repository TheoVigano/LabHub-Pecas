package br.com.DAO;

import br.com.DTO.EquipamentoDTO;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClienteDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

  


    
    
    public void editarEquipamento(EquipamentoDTO objDTO) {
        String sql = "UPDATE equipamento SET modelo = ?, fabricante = ?, numeroSerie = ?, statusEquipamento = ?, garantia = ? WHERE id_equipamento = ?";

        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objDTO.getModelo());
            pst.setString(2, objDTO.getFabricante());
            pst.setString(3, objDTO.getNumeroSerie());
            pst.setString(4, objDTO.getStatusEquipamento());
            pst.setString(5, objDTO.getGarantia());
            pst.setInt(6, objDTO.getId_equipamento());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Equipamento editado com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Editar: " + e);
            e.printStackTrace(); // Para depuração
        } finally {
            try {
                if (pst != null) pst.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e);
            }
        }
    }

    public void deletarEquipamento(EquipamentoDTO objDTO) {
        String sql = "DELETE FROM equipamento WHERE id_equipamento = ?";

        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objDTO.getId_equipamento());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Equipamento excluído com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método apagar: " + e);
            e.printStackTrace(); // Para depuração
        } finally {
            try {
                if (pst != null) pst.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e);
            }
        }
    }

    public boolean inserirEquipamento(EquipamentoDTO objDTO) {
        String sql = "INSERT INTO equipamento(modelo, fabricante, numeroSerie, statusEquipamento, garantia) VALUES(?, ?, ?, ?, ?)";

        try {
            conexao = new ConexaoDAO().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objDTO.getModelo());
            pst.setString(2, objDTO.getFabricante());
            pst.setString(3, objDTO.getNumeroSerie());
            pst.setString(4, objDTO.getStatusEquipamento());
            pst.setString(5, objDTO.getGarantia());
            pst.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inserir equipamento: " + e);
            e.printStackTrace(); // Para depuração
            return false;
        } finally {
            try {
                if (pst != null) pst.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e);
            }
        }
    }
}
