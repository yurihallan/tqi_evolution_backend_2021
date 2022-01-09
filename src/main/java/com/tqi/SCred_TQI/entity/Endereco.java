package com.tqi.SCred_TQI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

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

    @Type(type = "jsonb")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente clientes;


    public Endereco(String rua, String bairro, String cidade, Cliente clientes) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.clientes = clientes;
    }
}
