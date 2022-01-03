package com.tqi.SCred_TQI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String rua;
    @NotNull
    private String bairro;
    @NotNull
    private  String cidade;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente",referencedColumnName = "id")
    private Cliente cliente;


    public Endereco(String rua, String bairro, String cidade, Cliente cliente) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cliente = cliente;
    }
}
