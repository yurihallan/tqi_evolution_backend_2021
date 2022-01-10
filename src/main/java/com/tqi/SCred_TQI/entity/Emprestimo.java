package com.tqi.SCred_TQI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private Integer valor_emprestimo;
    @NotNull
    private LocalDate data_primeira_parcela;
    @NotNull
    private int  qtd_parcelas;

    @JsonDeserialize
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente clientes;

    public Emprestimo(Integer valor_emprestimo, LocalDate data_primeira_parcela, int qtd_parcelas, Cliente clientes) {
        this.valor_emprestimo = valor_emprestimo;
        this.data_primeira_parcela = data_primeira_parcela;
        this.qtd_parcelas = qtd_parcelas;
        this.clientes = clientes;
    }

    public Emprestimo() {
    }


}
