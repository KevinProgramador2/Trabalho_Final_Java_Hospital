package br.com.hospital.model;

import java.time.LocalDate;

public class PlanoSaude implements Pagador{
    private Integer id;
    private String nome;
    private String telefone;
    private CoberturaPlano cobertura;
    private LocalDate dataCredenciamento;
    
    public PlanoSaude(Integer id, String nome, String telefone, CoberturaPlano cobertura, LocalDate dataCredenciamento) {
        this.id= id;
        this.nome = nome;
        this.telefone = telefone;
        this.cobertura = cobertura;
        this.dataCredenciamento = dataCredenciamento;
    }

    @Override
    public String toString() {
        return "PlanoSaude [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", cobertura=" + cobertura
                + ", dataCredenciamento=" + dataCredenciamento + "]";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public CoberturaPlano getCobertura() {
        return cobertura;
    }

    public void setCobertura(CoberturaPlano cobertura) {
        this.cobertura = cobertura;
    }

    public LocalDate getDataCredenciamento() {
        return dataCredenciamento;
    }

    public void setDataCredenciamento(LocalDate dataCredenciamento) {
        this.dataCredenciamento = dataCredenciamento;
    }
    
    @Override
    public Integer getIdentificador() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }


    
}
