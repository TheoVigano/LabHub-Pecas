package br.com.DTO;

public class LaboratorioDTO {

    private int idLaboratorio;
    private String nSala;
    private String QuantidadeMaquinas;
    private String MaquinasFuncionando;
    private String MaquinasManutencao;
    private String MaquinasForaUso;

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getnSala() {
        return nSala;
    }

    public void setnSala(String nSala) {
        this.nSala = nSala;
    }

    public String getQuantidadeMaquinas() {
        return QuantidadeMaquinas;
    }

    public void setQuantidadeMaquinas(String QuantidadeMaquinas) {
        this.QuantidadeMaquinas = QuantidadeMaquinas;
    }

    public String getMaquinasFuncionando() {
        return MaquinasFuncionando;
    }

    public void setMaquinasFuncionando(String MaquinasFuncionando) {
        this.MaquinasFuncionando = MaquinasFuncionando;
    }

    public String getMaquinasManutencao() {
        return MaquinasManutencao;
    }

    public void setMaquinasManutencao(String MaquinasManutencao) {
        this.MaquinasManutencao = MaquinasManutencao;
    }

    public String getMaquinasForaUso() {
        return MaquinasForaUso;
    }

    public void setMaquinasForaUso(String MaquinasForaUso) {
        this.MaquinasForaUso = MaquinasForaUso;
    }

}
