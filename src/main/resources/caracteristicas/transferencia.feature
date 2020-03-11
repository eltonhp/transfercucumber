#language: pt
@TransferenciaDinheiroTeste
  Funcionalidade: Testar a transferência de dinheiro de uma conta corrente para a conta poupança
    Restrições: Só libera a transferência se conta corrente têm saldo disponível

  Esquema do Cenário: Transferir dinheiro de uma conta corrente para a conta poupança
    Dado a conta corrente de saldo <saldoContaCorrente> e numero da conta <numeroContaCorrente>
    E conta poupança de saldo <saldoContaPoupanca> e numero da conta <numeroContaPoupanca>
    Quando quando transferir o valor de <valorTransferencia> a partir da conta corrente para a conta poupança
    Entao devera ter na conta corrente <valorContaCorrenteEsperado> e também ter na conta poupanca <valorContaPoupancaEsperado>

    Exemplos:
      |numeroContaCorrente|saldoContaCorrente|numeroContaPoupanca|saldoContaPoupanca|valorTransferencia|valorContaCorrenteEsperado|valorContaPoupancaEsperado|
      | 111               | 1000             | 444               | 2000             | 500              | 500                      | 2500                     |
      | 222               | 3000             | 555               | 5                | 3000             | 0                        |  3005                    |
