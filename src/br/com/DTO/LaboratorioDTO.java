
package br.com.DTO;


public class LaboratorioDTO {
    private int idLaboratorio;
    private String nSala;
    private String modelo;           
    private String numeroSerie;      
    private String statusEquipamento; 
    
    
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
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public String getStatusEquipamento() {
        return statusEquipamento;
    }
    public void setStatusEquipamento(String statusEquipamento) {
        this.statusEquipamento = statusEquipamento;
    }
}
