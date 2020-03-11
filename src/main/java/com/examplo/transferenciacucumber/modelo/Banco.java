package com.examplo.transferenciacucumber.modelo;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Banco {
    private String nome;
    private List<Conta> listaDeContas;
}