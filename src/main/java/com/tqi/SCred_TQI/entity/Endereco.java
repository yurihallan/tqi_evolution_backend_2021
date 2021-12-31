package com.tqi.SCred_TQI.entity;

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
//
//    @ManyToOne
//    @JoinColumn(name = "id_endereco")
//    private Cliente cliente;



}
