package br.com.hospital.model;

import java.time.LocalDateTime;

public class Laudo {
    private Integer id;
    private Resultado resultado;
    private String descricao;
    private Object anexo;
    private LocalDateTime dataResultado;
    
    // o anexo não é obrigatório, por isso não está aqui
    public Laudo(Integer id, Resultado resultado, String descricao, LocalDateTime dataResultado) {
        this.id= id;
        this.resultado = resultado;
        this.descricao = descricao;
        this.dataResultado = dataResultado;
    }

    @Override
    public String toString() {
        return "Laudo [id=" + id + ", resultado=" + resultado + ", descricao=" + descricao + ", anexo=" + anexo + ", dataResultado="
                + dataResultado + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Object getAnexo() {
        return anexo;
    }

    public void anexarArquivo(Object anexo) {
        this.anexo = anexo;
    }

    public LocalDateTime getDataResultado() {
        return dataResultado;
    }

    public void setDataResultado(LocalDateTime dataResultado) {
        this.dataResultado = dataResultado;
    }

}
