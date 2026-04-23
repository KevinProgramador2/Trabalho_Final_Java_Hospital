package br.com.hospital.model;

import java.time.LocalDateTime;

import br.com.hospital.model.enums.ResultadoExameEnum;

public class Laudo {
    private Integer id;
    private ResultadoExameEnum resultado;
    private String descricao;
    private LocalDateTime dataResultado;
    private Exame exame;
    
    public Laudo(Integer id, ResultadoExameEnum resultado, String descricao, LocalDateTime dataResultado, Exame exame) {
        this.id = id;
        this.resultado = resultado;
        this.descricao = descricao;
        this.dataResultado = dataResultado;
        this.exame = exame;
    }

    @Override
    public String toString() {
        return "Laudo [id=" + id + ", resultado=" + resultado + ", descricao=" + descricao + ", dataResultado="
                + dataResultado + ", exame=" + exame + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResultadoExameEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoExameEnum resultado) {
        this.resultado = resultado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataResultado() {
        return dataResultado;
    }

    public void setDataResultado(LocalDateTime dataResultado) {
        this.dataResultado = dataResultado;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }
    
}
