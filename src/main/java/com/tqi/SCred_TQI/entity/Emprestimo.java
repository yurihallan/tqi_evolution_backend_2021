package com.tqi.SCred_TQI.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Data
@Builder
@AllArgsConstructor
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



    public Emprestimo(Integer valor_emprestimo, LocalDate data_primeira_parcela, int qtd_parcelas) {
        this.valor_emprestimo = valor_emprestimo;
        this.data_primeira_parcela = data_primeira_parcela;
        this.qtd_parcelas = qtd_parcelas;

    }

    public Emprestimo() {
    }


}
