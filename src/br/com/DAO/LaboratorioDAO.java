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

    public void editarLab(LaboratorioDTO objDTO) {
    String sql = "UPDATE laboratorios SET nome = ?, quantidade_maquinas = ?, maquinas_funcionando = ?, maquinas_em_manutencao = ?, maquinas_fora_de_uso = ? WHERE id_laboratorio = ?";

    try {
        conexao = ConexaoDAO.conector();
        pst = conexao.prepareStatement(sql);

        pst.setString(1, objDTO.getnSala());
        pst.setString(2, objDTO.getQuantidadeMaquinas());
        pst.setString(3, objDTO.getMaquinasFuncionando());
        pst.setString(4, objDTO.getMaquinasManutencao());
        pst.setString(5, objDTO.getMaquinasForaUso());
        
        pst.setInt(6, 2);

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
            if (pst != null) pst.close();
            if (conexao != null) conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
        }
    }
}

}




    


