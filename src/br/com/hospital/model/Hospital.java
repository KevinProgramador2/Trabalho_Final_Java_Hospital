package br.com.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
<<<<<<< HEAD
    protected Integer id;
    protected String cnpj;
    protected List<Ala> alas;
    protected List<PlanoSaude> planosSaude;


    
    public Hospital(Integer id, String cnpj) {
        this.id= id;
=======
    private Integer id;
    private String nome;
    private String cnpj;
    private List<Ala> alas = new ArrayList<>();
    private List<Credenciamento> credenciamentos = new ArrayList<>();

    public Hospital(Integer id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
>>>>>>> f61cb4486e6f5c63747563fdc9a53fb73ee94e89
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Hospital [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", alas=" + alas + "]";
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
<<<<<<< HEAD

    public String getCpnj() {
        return cnpj;
    }

    public void setCpnj(String cnpj) {

=======
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
>>>>>>> f61cb4486e6f5c63747563fdc9a53fb73ee94e89
        this.cnpj = cnpj;
    }
    
    public List<Ala> getAlas() {
        return alas;
    }
    
    public void setAlas(List<Ala> alas) {
        this.alas = alas;
    }
    
    public List<Credenciamento> getCredenciamentos() {
        return credenciamentos;
    }
    
    public void setCredenciamentos(List<Credenciamento> credenciamentos) {
        this.credenciamentos = credenciamentos;
    }

    public void addCredenciamento(Credenciamento credenciamento) {
        
        this.credenciamentos.add(credenciamento);
    }
    
    public void addAla(Ala ala) {
        this.alas.add(ala);
    }

}