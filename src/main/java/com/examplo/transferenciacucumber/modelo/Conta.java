package com.examplo.transferenciacucumber.modelo;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Conta {

    private String dono;
    private Integer numero;
    private Double saldo;
    private Double limite;
    private TipoConta tipoConta;

    public Conta(Double saldo, Integer numeroConta, TipoConta tipoConta) {
        this(null,numeroConta, saldo, null, tipoConta);
    }

    public boolean transferir(Double valor) {
        boolean resultado = false;
        if (saldo > valor) {
            this.saldo = this.saldo - valor.doubleValue();
            resultado = true;
        }
        return resultado;
    }

    public boolean sacar(Double valor) {
        if (saldo <= valor) {
            // Não pode sacar
            return false;
        } else {
            // Pode sacar
            saldo = saldo - valor;
            return true;
        }
    }
    public boolean depositar(Double quantidade) {

        if (limite <= quantidade + saldo) {
            // Não pode depositar
            return false;
        } else {
            // Pode depositar
            saldo += quantidade;
            return true;
        }
    }
}