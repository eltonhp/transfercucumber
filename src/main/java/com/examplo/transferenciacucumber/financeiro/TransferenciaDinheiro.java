package com.examplo.transferenciacucumber.financeiro;

import com.examplo.transferenciacucumber.excecao.ContaInexistenteException;
import com.examplo.transferenciacucumber.excecao.SaldoIndisponivelException;
import com.examplo.transferenciacucumber.modelo.Conta;

/**
 * @author Elton H. Paula
 */
public class TransferenciaDinheiro {
   Conta contaCorrente;
   Conta contaContaPoupanca;

   TransferenciaDinheiro(Conta contaA, Conta contaB) {
       this.contaCorrente = contaA;
       this.contaContaPoupanca = contaB;
   }

   public boolean transferirDinheiroParaContaPoupanca(Double valor) throws SaldoIndisponivelException, ContaInexistenteException {
      Boolean result = false;

      if(contaCorrente == null || contaContaPoupanca == null) {
          throw new RuntimeException("Conta não pode ser nulo");
      }

      if(contaCorrente.getSaldo() == null || contaContaPoupanca.getSaldo() == null) {
          throw new RuntimeException("O valor do Saldo não pode ser nulo");
      }

        return this.debitaConta(contaCorrente, valor) &&
               this.creditaConta(contaContaPoupanca, valor);



    }


    private boolean creditaConta(Conta contaContaPoupanca, Double valor) throws ContaInexistenteException, SaldoIndisponivelException {

        if(contaContaPoupanca == null) {
            throw new ContaInexistenteException("Conta poupança não encontrada");
        }

        if(valor == null) {
            throw new SaldoIndisponivelException("O valor não pode ser nulo");
        }

        Double saldo = contaContaPoupanca.getSaldo();
        contaContaPoupanca.setSaldo(saldo + valor);
        return true;

    }

    private boolean debitaConta(Conta contaCorrente, Double valor) throws SaldoIndisponivelException, ContaInexistenteException {
        Double saldo = contaCorrente.getSaldo();

        if(contaCorrente == null) {
            throw new ContaInexistenteException("Conta não encontrada");
        }

        if(saldo == null || saldo < valor) {
           throw new SaldoIndisponivelException("Saldo Abaixo do valor de transferencia de "+valor);
        }

        this.contaCorrente.setSaldo(saldo - valor);
        return true;

    }
}
