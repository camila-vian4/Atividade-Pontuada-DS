package com.example.atividade_pontuada.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_entregadores")
public class EntregadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String placa;
    private String tipoVeiculo;
    private String endereco;
}
