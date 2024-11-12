
package br.com.DTO;


public class PecaDTO {
    public int id_peca;
    private String nomePecas;           
    private String quantidadePecas;      
    private String tipoPecas;

    public int getId_peca() {
        return id_peca;
    }

    public void setId_peca(int id_peca) {
        this.id_peca = id_peca;
    }


    public String getNomePecas() {
        return nomePecas;
    }

    public void setNomePecas(String nomePecas) {
        this.nomePecas = nomePecas;
    }

    public String getQuantidadePecas() {
        return quantidadePecas;
    }

    public void setQuantidadePecas(String quantidadePecas) {
        this.quantidadePecas = quantidadePecas;
    }

    public String getTipoPecas() {
        return tipoPecas;
    }

    public void setTipoPecas(String tipoPecas) {
        this.tipoPecas = tipoPecas;
    }
}
