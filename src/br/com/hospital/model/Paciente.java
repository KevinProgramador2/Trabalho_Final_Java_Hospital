package br.com.hospital.model;

import java.time.LocalDate;

public class Paciente extends Pessoa implements Pagador{
    private Integer id;
    
    public Paciente(String nome, String cpf, String telefone, String endereco, LocalDate dataNascimento, Integer id) {
        super(nome, cpf, telefone, endereco, dataNascimento);
        this.id= id;
    }


    @Override
    public Integer getIdentificador() {
        return id;
    }


    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }

}
