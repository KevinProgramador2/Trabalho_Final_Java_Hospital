package br.com.hospital.model;

import java.time.LocalDate;

import br.com.hospital.model.interfaces.Cliente;

public class Paciente extends Pessoa implements Cliente {
    private Integer id;

    public Paciente(String nome, String cpf, String telefone, String endereco, LocalDate dataNascimento, Integer id) {
        super(nome, cpf, telefone, endereco, dataNascimento);
        this.id = id;
    }

    public Integer getIdentificador() {
        return id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
