package com.examplo.transferenciacucumber.financeiro;

import com.examplo.transferenciacucumber.modelo.Banco;
import com.examplo.transferenciacucumber.modelo.Conta;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.spring.CucumberContextConfiguration;


import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@CucumberContextConfiguration
public class BancoTestePassos {
    private Banco banco;
    private int totalContas;
    private Double totalDinheiro;

    @Dado("^que as contas sao do \"(.*?)\"$")
    public void que_as_contas_sao_do(String nome, DataTable datatable) throws Throwable {
        // Definição do banco e associando as contas
        List<Conta> listaDeContas = datatable.cells()
                 .stream()
                 .skip(1)
                 .map(campos -> new Conta(campos.get(0),Integer.parseInt(campos.get(1)), Double.parseDouble(campos.get(2))))
                 .collect(Collectors.toList());

        banco = new Banco(nome, listaDeContas);

    }

    @Dado("^o calculo do total de contas criadas$")
    public void o_calculo_do_total_de_contas_criadas() throws Throwable {
        totalContas = banco.getListaDeContas().size();
    }

    @Entao("^o total de contas e (\\d+)$")
    public void o_total_de_contas_e(int totalContasEsperado) throws Throwable {
        assertEquals("O cálculo do total de contas está incorreto",
                totalContasEsperado, totalContas);
    }

    @Dado("^o calculo do total de dinheiro$")
    public void o_calculo_do_total_de_dinheiro() throws Throwable {
        totalDinheiro = banco.getListaDeContas().stream().mapToDouble
                (c -> c.getSaldo()).sum();
    }

    @Entao("^o total de dinheiro no banco e (\\d+)$")
    public void o_total_de_dinheiro_no_banco_e(Double totalDinheiroEsperado)
            throws Throwable {

        assertEquals("O cálculo do total de dinheiro no banco " + banco.getNome()
                        + " está incorreto",
                totalDinheiroEsperado, totalDinheiro);
    }
}
