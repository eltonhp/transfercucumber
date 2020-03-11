package com.examplo.transferenciacucumber.financeiro;

import com.examplo.transferenciacucumber.modelo.Conta;
import com.examplo.transferenciacucumber.modelo.TipoConta;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

import static org.junit.Assert.assertTrue;


public class TransferenciaDinheiroTestePassos {

    Conta contaCorrente;
    Conta contaPoupanca;
    TransferenciaDinheiro transferenciaDinheiro;

    @Dado("^a conta corrente de saldo (\\d+) e numero da conta (\\d+)$")
    public void a_conta_corrente_de_saldo_e_numero_da_conta(Double saldo, int numeroConta) throws Throwable {
        this.contaCorrente = new Conta(saldo, numeroConta, TipoConta.CORRENTE);
    }

    @Dado("^conta poupança de saldo (\\d+) e numero da conta (\\d+)$")
    public void conta_poupança_de_saldo_e_numero_da_conta(Double saldo, int numeroConta) throws Throwable {
        this.contaPoupanca = new Conta(saldo, numeroConta, TipoConta.POUPANCA);
    }

    @Quando("^quando transferir o valor de (\\d+) a partir da conta corrente para a conta poupança$")
    public void quando_transferir_o_valor_de_a_partir_da_conta_corrente_para_a_conta_poupança(Double valorTransferencia) throws Throwable {
        this.transferenciaDinheiro = new TransferenciaDinheiro(this.contaCorrente, this.contaPoupanca);
        boolean result = true;
        String msg = "";

        try {
            transferenciaDinheiro.transferirDinheiroParaContaPoupanca(valorTransferencia);
        } catch (Exception e) {
            msg = e.getMessage();
            result = false;
        }
        assertTrue(msg, result);
    }

    @Entao("^devera ter na conta corrente (\\d+) e também ter na conta poupanca (\\d+)$")
    public void devera_ter_na_conta_corrente_e_também_ter_na_conta_poupanca(Double valorContaCorrenteEsperado, Double valorContaPoupancaEsperado) throws Throwable {
        assertTrue("O valor da conta corrente está incompatível ", this.contaCorrente.getSaldo().equals(valorContaCorrenteEsperado) &&
                this.contaPoupanca.getSaldo().equals(valorContaPoupancaEsperado));
    }



}
