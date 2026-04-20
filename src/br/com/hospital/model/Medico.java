package br.com.hospital.model;

import java.time.LocalDate;

public class Medico extends Pessoa {
    private Integer id;
    private String crm;
    private String especialidade;
    
    public Medico(Integer id, String nome, String cpf, String telefone, String endereco, LocalDate dataNascimento,
            String crm, String especialidade) {
        super(nome, cpf, telefone, endereco, dataNascimento);
        this.id= id;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico [id=" + id + ", nome=" + super.getNome() + ", crm=" + crm + ", especialidade=" + especialidade + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
