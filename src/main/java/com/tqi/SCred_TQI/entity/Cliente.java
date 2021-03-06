package com.tqi.SCred_TQI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String CPF;
    @NotNull
    private String RG;
    @NotNull
    private String senha;

    @NotNull
    private Integer renda;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    public Cliente(String nome, String email, String CPF, String RG, String senha, Integer renda) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
        this.RG = RG;
        this.senha = senha;
        this.renda = renda;

    }
}
