package br.com.hospital.model.enums;

import java.math.BigDecimal;

public enum ImpostosEnum {
    ISS(new BigDecimal("0.03")), //3%
    PIS(new BigDecimal("0.0065")), //0,65%
    COFINS(new BigDecimal("0.03")), //3%
    IRPJ(new BigDecimal("0.012")), //1,2%
    CSLL(new BigDecimal("0.0108")); //1,08%

    private BigDecimal valor;

    private ImpostosEnum(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
