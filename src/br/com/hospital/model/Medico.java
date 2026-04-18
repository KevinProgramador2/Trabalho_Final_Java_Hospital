package br.com.hospital.model;

import java.time.LocalDate;

public class Medico extends Pessoa {

    public Medico(String nome, String cpf, String telefone, String endereco, LocalDate dataNascimento) {
        super(nome, cpf, telefone, endereco, dataNascimento);
    }

}
